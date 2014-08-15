package com.seaway.liufuya.mvc.system.storeaddress.layout;

import java.text.ParseException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.nutz.json.Json;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.common.util.DateUtil;
import com.seaway.liufuya.map.BaiduMapBiz;
import com.seaway.liufuya.map.jsonbean.Geocoding;
import com.seaway.liufuya.mvc.system.storeaddress.dao.LazyLoadStoreContainer;
import com.seaway.liufuya.mvc.system.storeaddress.dao.StoreDaoImpl;
import com.seaway.liufuya.mvc.system.storeaddress.data.Citypart;
import com.seaway.liufuya.mvc.system.storeaddress.data.StoreAddress;
import com.seaway.liufuya.mvc.system.storeaddress.data.StoreBean;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Reindeer;

@SuppressWarnings("serial")
public class StoreAddressListView extends VerticalLayout implements
		ClickListener, ItemClickListener {

	private static final Log log = Logs.get();
	// -----------------------定义查询
	StoreDaoImpl storeDao = null;
	// EXProductService service = null;

	// ------------------------整个页面导航
	HorizontalLayout navBar = new HorizontalLayout();

	// ----------------------- 整个页面，上下分割的 垂直布局面板
	private final HorizontalSplitPanel vsplit = new HorizontalSplitPanel();

	// ------------------------ 底部
	private HorizontalLayout footer;

	// -----------------------定义表格需要的
	Table leftTable = null;
	// private LazyLoadStoreContainer container = null;
	// 暂时不分页
	private BeanItemContainer<StoreBean> tableContainer = new BeanItemContainer<StoreBean>(
			StoreBean.class);
	// private BeanItemContainer< StoreBean> container = null;
	// ------------------------百度地图工具类
	private BaiduMapBiz baidu;

	// ----------------------定义表单
	FormLayout addFormlayout = null; // 增加表单
	FormLayout rightFormlayout = null; // 编辑表单

	TextField store_code = null; // 门店编号
	TextField store_name = null; // 门店名称
	NativeSelect manage_type = null; // 经营类型
	NativeSelect store_type = null; // 门店类型

	NativeSelect area = null; // 大区
	NativeSelect province = null; // 省份
	NativeSelect city = null; // 城市
	TextField city_part = null; // 城区

	TextArea store_address = null; // 门店地址
	TextField store_director = null; // 主管姓名
	TextField store_directorphone = null; // 主管电话
	TextField store_assistant = null; // 店员姓名
	TextField store_assistantphone = null; // 店员电话
	NativeSelect status = null; // 状态

	TextField gps_lng = null; // 经度
	TextField gps_lat = null; // 纬度
	TextField create_date = null; // 创建时间
	DateField startDate = null;// 开店日期

	Button saveButton = null;

	// ----------------------定义窗体
	Window addWindow = null;

	// ---------------------开始布局
	public StoreAddressListView() {
		// TODO Auto-generated constructor stub
	}

	public StoreAddressListView(StoreDaoImpl manager) {
		storeDao = manager;
		// service = new EXProductService(manager);

		// -----------------------导航工具条
		navBar.setStyleName(Reindeer.LAYOUT_BLACK);
		navBar.setWidth(100, Unit.PERCENTAGE);
		navBar.setHeight(29, Unit.PIXELS);
		Label lblNav = new Label("系统管理 / 已开门店管理");
		Button btnAdd = new Button("新增"); // 增加 按钮
		btnAdd.setIcon(new ThemeResource("icons/16/add.png"));
		btnAdd.setDescription("增加门店");
		btnAdd.addClickListener(addButtonClickLister());
		navBar.addComponent(lblNav);
		navBar.addComponent(btnAdd);
		navBar.setComponentAlignment(btnAdd, Alignment.TOP_RIGHT);// 定义位置

		// --------------------------垂直页面布局
		initContainer();
		initLeftTable();
		vsplit.addComponent(leftTable);
		vsplit.setSplitPosition(70);
		vsplit.setStyleName(Reindeer.LAYOUT_WHITE); // 右侧样式
		vsplit.setHeight(470, Unit.PIXELS);

		// 整个布局完成
		this.addComponent(navBar);
		this.addComponent(vsplit);
		this.setDefaultComponentAlignment(ALIGNMENT_DEFAULT);
		this.setExpandRatio(vsplit, 1);

	}

	@Override
	public void itemClick(ItemClickEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void click(ClickEvent event) {
		// TODO Auto-generated method stub

	}

	/**
	 * 添加按钮单击事件
	 * 
	 * @author zg
	 * **/
	private Button.ClickListener addButtonClickLister() {
		Button.ClickListener listener = new Button.ClickListener() {
			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				addWindow = new Window("添加门店");
				addWindow.setHeight(500, Unit.PIXELS);
				addWindow.setWidth(430, Unit.PIXELS);
				addWindow.setModal(true);
				addForm();
				addWindow.setContent(addFormlayout);
				getUI().addWindow(addWindow);
			}
		};

		return listener;
	}

	// ----------------------------------------------------------------------
	/**
	 * 左边表格容器初始化
	 */
	private void initContainer() {
		// 分页版本
		// container = new LazyLoadStoreContainer(StoreBean.class,storeDao);
		// 不分页版本
		List<StoreBean> list = storeDao.getAllStore();
		for (StoreBean storeBean : list) {
			tableContainer.addItem(storeBean);
		}
	}

	/**
	 * 左边表格初始化
	 * **/
	private void initLeftTable() {
		leftTable = new Table("详细资料表格");
		leftTable.setSizeFull();
		leftTable.setHeight(100, Unit.PERCENTAGE);
		leftTable.setContainerDataSource(tableContainer);
		leftTable.setVisibleColumns(Constants.STOREADDRESS_COL);
		leftTable.setColumnHeaders(Constants.STOREADDRESS_COL_HEADERS_CHINESE);
		leftTable.setPageLength(2);
		leftTable.setCacheRate(4);
		leftTable.setColumnCollapsingAllowed(true);
		leftTable.setColumnReorderingAllowed(true);
		leftTable.addItemClickListener(new ItemClickListener() {

			@Override
			public void itemClick(ItemClickEvent event) {
				if (vsplit.getComponentCount() == 2)
					vsplit.removeComponent(rightFormlayout);
				initRightForm(event.getItem());
				vsplit.addComponent(rightFormlayout);
			}
		});
	}

	/**
	 * 初始化右边form
	 */
	private void initRightForm(Item item) {
		rightFormlayout = new FormLayout();

		store_code = new TextField("门店编号");
		store_name = new TextField("门店名称");
		manage_type = new NativeSelect("经营类型");
		manage_type.addItems(0, 1, 2, 3, 4, 5, 6);
		manage_type.setItemCaption(0, "直营");
		manage_type.setItemCaption(1, "加盟");
		manage_type.setItemCaption(2, "联营");
		manage_type.setItemCaption(3, "代销");
		manage_type.setItemCaption(4, "托管");
		manage_type.setItemCaption(5, "承包");
		manage_type.setItemCaption(6, "合作");

		store_type = new NativeSelect("门店类型");
		store_type.addItems(0, 1, 2, 3, 4, 5, 6);
		store_type.setItemCaption(0, "社区型");
		store_type.setItemCaption(1, "菜场型");
		store_type.setItemCaption(2, "商圈型");
		store_type.setItemCaption(3, "超市型");
		store_type.setItemCaption(4, "复合型");
		store_type.setItemCaption(5, "商社型");
		store_type.setItemCaption(6, "校区型");

		area = new NativeSelect("大区");
		area.addItems(0);
		area.setItemCaption(0, "华东");

		province = new NativeSelect("省份");
		province.addItems(0, 1, 2);
		province.setItemCaption(0, "上海市");
		province.setItemCaption(1, "浙江省");
		province.setItemCaption(2, "江苏省");

		city = new NativeSelect("城市");
		city.addItems(0, 1, 2, 3, 4, 5);
		city.setItemCaption(0, "上海市");
		city.setItemCaption(1, "杭州市");
		city.setItemCaption(2, "湖州市");
		city.setItemCaption(3, "无锡市");
		city.setItemCaption(4, "常州市");
		city.setItemCaption(5, "桐庐市");

		city_part = new TextField("城区");

		store_address = new TextArea("门店地址");
		store_address.setRows(10);
		store_address.setImmediate(true);
		store_address.setSizeFull();

		store_director = new TextField("主管姓名");
		store_directorphone = new TextField("主管电话");
		store_assistant = new TextField("店员姓名");
		store_assistantphone = new TextField("店员电话");

		gps_lng = new TextField("经度"); // 经度
		gps_lat = new TextField("纬度"); // 纬度
		create_date = new TextField("创建时间"); // 创建时间
		startDate = new DateField("开店日期");// 开店日期

		status = new NativeSelect("启用");
		status.addItems(0, 1);
		status.setItemCaption(0, "否");
		status.setItemCaption(1, "是");

		saveButton = new Button("保存");
		saveButton.addClickListener(buttonLister());

		rightFormlayout.addComponents(store_code, store_name, manage_type,
				store_type, area, province, city, city_part, store_address,
				store_director, store_directorphone, store_assistant,
				store_assistantphone, startDate, status, gps_lng, gps_lat,
				create_date, saveButton);
		if (item != null) {
			Property prop = item.getItemProperty("store_code");
			String stro_code = (String) prop.getValue();
			StoreAddress store = storeDao.findStoreByStoreCode(stro_code);

			BeanFieldGroup<StoreAddress> bindingFiles = new BeanFieldGroup<StoreAddress>(
					StoreAddress.class);
			bindingFiles.setItemDataSource(store);
			bindingFiles.setBuffered(true);
			bindingFiles.bindMemberFields(this); // 绑定

			store_code.setEnabled(false); // 门店编号
			gps_lng.setEnabled(false); // 经度
			gps_lat.setEnabled(false); // 纬度
			create_date.setEnabled(false); // 创建时间

			// 经营类型
			if (manage_type.getValue().equals("直营")) {
				manage_type.select(0);
			} else if (manage_type.getValue().equals("加盟")) {
				manage_type.select(1);
			} else if (manage_type.getValue().equals("联营")) {
				manage_type.select(2);
			} else if (manage_type.getValue().equals("代销")) {
				manage_type.select(3);
			} else if (manage_type.getValue().equals("托管")) {
				manage_type.select(4);
			} else if (manage_type.getValue().equals("承包")) {
				manage_type.select(5);
			} else if (manage_type.getValue().equals("合作")) {
				manage_type.select(6);
			}
			// 门店类型
			if (store_type.getValue().equals("社区型")) {
				store_type.select(0);
			} else if (store_type.getValue().equals("菜场型")) {
				store_type.select(1);
			} else if (store_type.getValue().equals("商圈型")) {
				store_type.select(2);
			} else if (store_type.getValue().equals("超市型")) {
				store_type.select(3);
			} else if (store_type.getValue().equals("复合型")) {
				store_type.select(4);
			} else if (store_type.getValue().equals("商社型")) {
				store_type.select(5);
			} else if (store_type.getValue().equals("校区型")) {
				store_type.select(6);
			}
			// 大区
			if (area.getValue().equals("华东")) {
				area.select(0);
			}
			// 省份
			if (province.getValue().equals("上海市")) {
				province.select(0);
			} else if (province.getValue().equals("浙江省")) {
				province.select(1);
			} else if (province.getValue().equals("江苏省")) {
				province.select(2);
			}
			
			// 城市
			if (city.getValue().equals("上海市")) {
				city.select(0);
			} else if (city.getValue().equals("杭州市")) {
				city.select(1);
			} else if (city.getValue().equals("湖州市")) {
				city.select(2);
			} else if (city.getValue().equals("无锡市")) {
				city.select(3);
			} else if (city.getValue().equals("常州市")) {
				city.select(4);
			} else if (city.getValue().equals("桐庐市")) {
				city.select(5);
			}

			if (status.getValue().equals("是")) {
				status.select(1);
			} else {
				status.select(0);
			}

		}
	}

	/**
	 * button 保存新增或者修改
	 * */
	private Button.ClickListener buttonLister() {
		Button.ClickListener lister = new Button.ClickListener() {
			/**
			 * 根据城市名称和详细地址，查询经纬度
			 * 
			 * @param address
			 *            详细地址
			 * @param city
			 *            城市
			 * @return
			 */
			private String search(String address, String city) {
				log.debug("-------------详细地址：" + address);
				log.debug("-------------城市：" + city);

				Geocoding ge = null;
				String gejson = ""; // 要返回的 json 字符串
				try {
					baidu = new BaiduMapBiz();
					ge = baidu.getMapByPost(address, city); // post 方法请求
					// 处理结果
					// 只返回 location 信息
					gejson = Json.toJson(ge.getResult().getLocation());
					// gejson = baidu.getMapJsonByPost(shopaddr, customeraddr);
					log.debug("-------------gejson  =" + gejson);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return gejson;
			}

			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				StoreAddress store = new StoreAddress();
				store.setStore_name(store_name.getValue());// 门店名称
				// 经营类型
				Integer manage_typeid = (Integer) manage_type.getValue();
				switch (manage_typeid) { 
				case 0:
					store.setManage_type("直营");
					break;
				case 1:
					store.setManage_type("加盟");
					break;
				case 2:
					store.setManage_type("联营");
					break;
				case 3:
					store.setManage_type("代销");
					break;
				case 4:
					store.setManage_type("托管");
					break;
				case 5:
					store.setManage_type("承包");
					break;
				case 6:
					store.setManage_type("合作");
					break;
				default:
					store.setManage_type("无");	
					break;
				}
				//店铺类型
				Integer store_typeid = (Integer) store_type.getValue();
				switch (store_typeid) {
				case 0:
					store.setStore_type("社区型");
					break;
				case 1:
					store.setStore_type("菜场型");
					break;
				case 2:
					store.setStore_type("商圈型");
					break;
				case 3:
					store.setStore_type("超市型");
					break;
				case 4:
					store.setStore_type("复合型");
					break;
				case 5:
					store.setStore_type("商社型");
					break;
				case 6:
					store.setStore_type("校区型");
					break;
				default:
					store.setStore_type("无");	
					break;
				}
				// 所属大区
				Integer areaid = (Integer)area.getValue();
				switch (areaid) {
				case 0:
					store.setArea("华东");
					break;
				default:
					store.setStore_type("无");	
					break;
				}
				
				//省份
				Integer provinceid = (Integer)province.getValue();	
				switch (provinceid) {
				case 0:
					store.setProvince("上海市");
					break;
				case 1:
					store.setProvince("浙江省");
					break;
				case 2:
					store.setProvince("江苏省");
					break;
				default:
					store.setProvince("未知");
					break;
				}
				
				// 城市
				Integer cityid = (Integer)city.getValue();
				switch (cityid) {
				case 0:
					store.setCity("上海市");
					break;
				case 1:
					store.setCity("杭州市");
					break;
				case 2:
					store.setCity("湖州市");
					break;
				case 3:
					store.setCity("无锡市");
					break;
				case 4:
					store.setCity("桐庐市");
					break;
				default:
					store.setProvince("未知");
					break;
				}
				
				
				store.setCity_part(city_part.getValue());// 城区
				store.setStore_address(store_address.getValue());// 门店地址
				store.setStore_director(store_director.getValue());// 主管姓名
				store.setStore_directorphone(store_directorphone.getValue());// 主管电话
				store.setStore_assistant(store_assistant.getValue());// 店员姓名
				store.setStore_assistantphone(store_assistantphone.getValue());// 店员电话
				store.setStatus("" + status.getValue());

				if (store_name.getValue().trim().equals("")) {
					Notification.show("警告", "门店名称必须填写",
							Notification.Type.WARNING_MESSAGE);
				}

				if (event.getButton().getCaption().equals("保存")) {
					// 更新
					store.setStore_code(store_code.getValue()); // 门店编码
					store.setGps_lng(gps_lng.getValue());// 经度
					store.setGps_lat(gps_lat.getValue());// 纬度
					try {
						store.setCreate_date(DateUtil
								.convertStringToDate(create_date.getValue()));// 创建时间
						store.setStartDate(startDate.getValue());// 开店时间
					} catch (ParseException e) {
						try {
							store.setCreate_date(DateUtil
									.convertStringToDate(DateUtil
											.convertDateToString(new Date())));
							store.setStartDate(DateUtil
									.convertStringToDate(DateUtil
											.convertDateToString(new Date())));
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						e.printStackTrace();
					}
					storeDao.updateStore(store);
					Notification.show("更新成功");
				} else if (event.getButton().getCaption().equals("添加")) {
					if (store_code.getValue().trim().equals("")) {
						Notification.show("警告", "门店编码必须填写",
								Notification.Type.WARNING_MESSAGE);
					} else if (storeDao.checkStoreByStoreCode(store_code
							.getValue())) {
						// 增加
						// 根据城市，地址，得到地理位置
						store.setStore_code(store_code.getValue()); // 门店编码
						String cityName = (String) city.getValue();
						String addressName = (String) store_address.getValue();
						// 如果地址有，那么查询经纬度
						if (!cityName.trim().equals("")
								&& !addressName.trim().equals("")) {
							String jsonGps = this.search(addressName, cityName);
							Object loca = Json.fromJson(jsonGps);
							log.info("-------loca =" + loca.getClass());
							LinkedHashMap map = (LinkedHashMap) loca;
							store.setGps_lng("" + map.get("lng")); // 经度
							store.setGps_lat("" + map.get("lat"));// 纬度
						} else {
							store.setGps_lng("");// 经度
							store.setGps_lat("");// 纬度
						}

						try {
							store.setCreate_date(DateUtil
									.convertStringToDate(DateUtil
											.convertDateToString(new Date())));// 创建时间
							store.setStartDate(startDate.getValue());// 开店时间
						} catch (ParseException e) {
							try {
								store.setCreate_date(DateUtil.convertStringToDate(DateUtil
										.convertDateToString(new Date())));
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							e.printStackTrace();
						}

					}
				}
				storeDao.saveStoreAddress(store);
				Notification.show("添加成功");
			}
		};
		return lister;
	}

	/**
	 * 初始化添加表格
	 */
	private void addForm() {
		addFormlayout = new FormLayout();
		store_code = new TextField("门店编号");
		store_name = new TextField("门店名称");
		manage_type = new NativeSelect("经营类型");
		manage_type.addItems(0, 1, 2, 3, 4, 5, 6);
		manage_type.setItemCaption(0, "直营");
		manage_type.setItemCaption(1, "加盟");
		manage_type.setItemCaption(2, "联营");
		manage_type.setItemCaption(3, "代销");
		manage_type.setItemCaption(4, "托管");
		manage_type.setItemCaption(5, "承包");
		manage_type.setItemCaption(6, "合作");
		manage_type.select(0); // 默认选中

		store_type = new NativeSelect("门店类型");
		store_type.addItems(0, 1, 2, 3, 4, 5, 6);
		store_type.setItemCaption(0, "社区型");
		store_type.setItemCaption(1, "菜场型");
		store_type.setItemCaption(2, "商圈型");
		store_type.setItemCaption(3, "超市型");
		store_type.setItemCaption(4, "复合型");
		store_type.setItemCaption(5, "商社型");
		store_type.setItemCaption(6, "校区型");
		store_type.select(0); // 默认选中

		area = new NativeSelect("大区");
		area.addItems(0);
		area.setItemCaption(0, "华东");
		area.select(0); // 默认选中

		province = new NativeSelect("省份");
		province.addItems(0, 1, 2);
		province.setItemCaption(0, "上海市");
		province.setItemCaption(1, "浙江省");
		province.setItemCaption(2, "江苏省");
		province.select(0);// 默认选中

		city = new NativeSelect("城市");
		city.addItems(0, 1, 2, 3, 4, 5);
		city.setItemCaption(0, "上海市");
		city.setItemCaption(1, "杭州市");
		city.setItemCaption(2, "湖州市");
		city.setItemCaption(3, "无锡市");
		city.setItemCaption(4, "常州市");
		city.setItemCaption(5, "桐庐市");
		city.select(0);// 默认选中

		city_part = new TextField("城区");

		store_address = new TextArea("门店地址");
		store_address.setRows(5);
		store_address.setImmediate(true);
		store_address.setSizeFull();

		store_director = new TextField("主管姓名");
		store_directorphone = new TextField("主管电话");
		store_assistant = new TextField("店员姓名");
		store_assistantphone = new TextField("店员电话");

		gps_lng = new TextField("经度"); // 经度
		gps_lat = new TextField("纬度"); // 纬度
		create_date = new TextField("创建时间"); // 创建时间
		startDate = new DateField("开店日期");// 开店日期

		status = new NativeSelect("启用");
		status.addItems(0, 1);
		status.setItemCaption(0, "否");
		status.setItemCaption(1, "是");
		status.select(0);// 默认选中

		// List<Citypart> citylist = this.storeDao.findAllCityCodeAndName();
		// for (Citypart bean : citylist) {
		// exchangeRuleCode.addItem(bean.getId());
		// exchangeRuleCode
		// .setItemCaption(bean.getId(), bean.getAddressName());
		// }

		saveButton = new Button("添加");
		saveButton.addClickListener(buttonLister());

		addFormlayout.addComponents(store_code, store_name, manage_type,
				store_type, area, province, city, city_part, store_address,
				store_director, store_directorphone, store_assistant,
				store_assistantphone, startDate, status, saveButton);
	}

	// ---------------------------------------------------------------

}
