package com.seaway.liufuya.mvc.weixinstore.ordernew.layout;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.nutz.json.Json;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.mvc.crm.memberaddressinfo.pojo.MemberAddress;
import com.seaway.liufuya.mvc.crm.memberinfo.data.Member;
import com.seaway.liufuya.mvc.report.TemporaryFileDownloadResource;
import com.seaway.liufuya.mvc.weixinstore.ordernew.dao.JDBCDao;
import com.seaway.liufuya.mvc.weixinstore.ordernew.dao.OrderDao;
import com.seaway.liufuya.mvc.weixinstore.ordernew.data.Delivernotify;
import com.seaway.liufuya.mvc.weixinstore.ordernew.data.Order;
import com.seaway.liufuya.mvc.weixinstore.ordernew.data.OrderBean;
import com.seaway.liufuya.mvc.weixinstore.ordernew.data.OrderContent;
import com.seaway.liufuya.wx.AccessToken;
import com.seaway.liufuya.wx.GetAccessToken;
import com.seaway.liufuya.wx.HttpService;
import com.seaway.liufuya.wx.MyHttpRequest;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Reindeer;
import com.wxap.WXContent;
import com.wxap.client.TenpayHttpClient;
import com.wxap.entity.DelivernotifyJSON;
import com.wxap.entity.ReturnJSON;
import com.wxap.util.Sha1Util;
import com.wxap.util.TenpayUtil;

@SuppressWarnings("serial")
public class OrderNewListView extends VerticalLayout implements ClickListener,
		ItemClickListener {

	private static final Log log = Logs.get();
	// -----------------------定义查询
	OrderDao orderDao = null;

	// ------------------------整个页面导航
	HorizontalLayout navBar = new HorizontalLayout();

	// ----------------------- 整个页面，上下分割的 垂直布局面板
	//private final HorizontalSplitPanel vsplit = new HorizontalSplitPanel();
	private final  VerticalLayout vsplit = new VerticalLayout();
	
	// ------------------------ 底部
	private HorizontalLayout footer;

	// -----------------------定义表格需要的
	Table leftTable = null;
	// private LazyLoadStoreContainer container = null;
	// 暂时不分页
	private BeanItemContainer<OrderBean> tableContainer = new BeanItemContainer<OrderBean>(
			OrderBean.class);

	// ----------------------定义表单
	FormLayout rightFormlayout = null; // 编辑表单
	
	TextField orderNo = null; //订单编号
	//TextField orderMoney = null; //订单总价
	TextField orderTotalMoney = null;//订单实际购买价格
	//TextField couponMoney = null;//订单优惠价格
	//TextField delivery = null; // '2外送 1自取 3 顺丰',
	NativeSelect orderStatus;// '订单状态 1默认待支付 2已支付 3已关闭
	TextField create_date;// 创建时间
	Table product = null;//订单对应的产品列表
	TextField user_tel = null;//用户联系电话 当delivery为2时必填
	TextField user_name = null;//订单用户名
	TextArea user_address;//地址
	//TextField status = null;// '状态 1默认未付款 0删除 2已付款 3 外送超时 4 自取超时 5 外送退货

	Button saveButton = null;
	Button sendButton = null; //发货按钮
	

	// ----------------------定义窗体
	Window addWindow = null;

	// ---------------------开始布局
	public OrderNewListView() {
	}

	public OrderNewListView(OrderDao dao) {
		this.orderDao = dao;

		// -----------------------导航工具条
		navBar.setStyleName(Reindeer.LAYOUT_BLACK);
		navBar.setWidth(100, Unit.PERCENTAGE);
		navBar.setHeight(29, Unit.PIXELS);
		Label lblNav = new Label("订单管理 / 未处理订单");
		navBar.addComponent(lblNav);
		
		//---------------------------导出 Excel
		HorizontalLayout navBarButtons = new HorizontalLayout();
		Button btnExport = new Button("导出"); // 增加 按钮
		btnExport.setIcon(new ThemeResource("icons/16/disk-download.png"));
		btnExport.setDescription("导出列表");

		navBarButtons.addComponent(btnExport);
		btnExport.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				try {

					File tempFile = File.createTempFile("tmp", ".xls");

					HSSFWorkbook workbook = new HSSFWorkbook();
					HSSFSheet firstSheet = workbook.createSheet("sheet1");
					HSSFRow row1 = firstSheet.createRow(0);

					List<OrderBean> list = tableContainer.getItemIds();
					for (int i = 0; i < list.size() + 1; i++) {
						if (i == 0) {
							for (short j = 0; j < Constants.ORDER_COL_HEADERS_CHINESE.length; j++) {
								HSSFCell cellA = row1.createCell(j);
								cellA.setCellValue(Constants.ORDER_COL_HEADERS_CHINESE[j]);
							}
						} else {
							
							OrderBean m = list.get(i - 1);
							HSSFRow rowA = firstSheet.createRow(i);
							for (int j = 0; j < Constants.ORDER_COL.length; j++) {
								HSSFCell cell = rowA.createCell((short) j);
								if (Constants.ORDER_COL[j].equals("orderNo")) {
									cell.setCellValue(m.getOrderNo());
								}
								if (Constants.ORDER_COL[j].equals("orderTotalMoney")) {
									cell.setCellValue(m.getOrderTotalMoney());
								}
								if (Constants.ORDER_COL[j].equals("orderStatus")) {
									cell.setCellValue(m.getOrderStatus());
								}
								if (Constants.ORDER_COL[j].equals("create_date")) {
									cell.setCellValue(m.getCreate_date());
								}
								if (Constants.ORDER_COL[j].equals("user_name")) {
									cell.setCellValue(m.getUser_name());
								}
								if (Constants.ORDER_COL[j].equals("user_tel")) {
									cell.setCellValue(m.getUser_tel());
								}
								if (Constants.ORDER_COL[j].equals("city")) {
									cell.setCellValue(m.getCity());
								}
								if (Constants.ORDER_COL[j]
										.equals("area")) {
									cell.setCellValue(m.getArea());
								}
								if (Constants.ORDER_COL[j]
										.equals("user_address")) {
									cell.setCellValue(m.getUser_address());
								}
								if (Constants.ORDER_COL[j]
										.equals("productName")) {
									cell.setCellValue(m.getProductName());
								}

							}
						}
					}
					FileOutputStream fos = null;

					fos = new FileOutputStream(tempFile);
					workbook.write(fos);

					fos.flush();
					fos.close();

					// Create contents here, using POI, and write to tempFile
					TemporaryFileDownloadResource resource;

					resource = new TemporaryFileDownloadResource(
							"default-name-of-file.xls",
							"application/vnd.ms-excel", tempFile);
					UI.getCurrent().getPage().open(resource, "_self", false);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		navBar.addComponent(navBarButtons);
		navBar.setComponentAlignment(navBarButtons, Alignment.TOP_RIGHT);// 定义位置

		// --------------------------垂直页面布局
		initContainer();
		initLeftTable();
		vsplit.addComponent(leftTable);
		//vsplit.setSplitPosition(70);
		vsplit.setStyleName(Reindeer.LAYOUT_WHITE); // 右侧样式
		vsplit.setHeight(Constants.PAGE_HEIGHT, Unit.PIXELS);

		// 整个布局完成
		this.addComponent(navBar);
		this.addComponent(vsplit);
		this.setDefaultComponentAlignment(ALIGNMENT_DEFAULT);
		this.setExpandRatio(vsplit, 1);
	}

	// ---------------------------------------------------
	@Override
	public void itemClick(ItemClickEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void click(ClickEvent event) {
		// TODO Auto-generated method stub

	}

	// ----------------------------------------------------
	/**
	 * 导航栏，添加按钮单击事件
	 */
//	private Button.ClickListener addButtonClickLister() {
//		Button.ClickListener listener = new Button.ClickListener() {
//			@Override
//			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
//				addWindow = new Window("查询");
//				addWindow.setHeight(500, Unit.PIXELS);
//				addWindow.setWidth(430, Unit.PIXELS);
//				addWindow.setModal(true);
//				//addForm();
//				addWindow.setContent(addFormlayout);
//				getUI().addWindow(addWindow);
//			}
//		};
//
//		return listener;
//	}

	// ----------------------------------------------------------------------
	/**
	 * 左边表格容器初始化
	 */
	private void initContainer() {
		tableContainer.removeAllItems();
		// 分页版本
		// container = new LazyLoadStoreContainer(StoreBean.class,storeDao);
		// 不分页版本
		/* 微信功能 当日订单，传递参数 delivery=3,orderStatus=2,status=1 
	 *            历史订单，传递参数
	 *            delivery=3,orderStatus=3,status=1*/
		log.info("=====================>1 获取表格数据 3  2   1 ");
		List<OrderBean> list = this.orderDao.getAllOrder("3", "2", "1");
		log.info("=====================>6 获取表格数据结束.........");
		
		for (OrderBean orderBean : list) {
			tableContainer.addItem(orderBean);
		}
	}
	
	
	/**
	 * 左边表格初始化
	 * **/
	private void initLeftTable() {
		leftTable = new Table();
		leftTable.setSizeFull();
		leftTable.setHeight(50, Unit.PERCENTAGE);
		leftTable.setWidth(100, Unit.PERCENTAGE);
		leftTable.setContainerDataSource(tableContainer);
		leftTable.setVisibleColumns(Constants.ORDER_COL);
		leftTable.setColumnHeaders(Constants.ORDER_COL_HEADERS_CHINESE);
		//leftTable.setPageLength(2); //一页显示条数
		leftTable.setCacheRate(4);
		leftTable.setColumnCollapsingAllowed(true);
		leftTable.setColumnReorderingAllowed(true);
		leftTable.addItemClickListener(new ItemClickListener() {
			@Override
			public void itemClick(ItemClickEvent event) {
				//点击单元格，弹出 窗口，显示订单明细
				addWindow = new Window("查询");
				addWindow.setHeight(500, Unit.PIXELS);
				addWindow.setWidth(430, Unit.PIXELS);
				addWindow.setModal(true);
				initOrderForm(event.getItem());  //打开新窗口，显示明细
				addWindow.setContent(rightFormlayout);
				getUI().addWindow(addWindow);
			}
		});
	}
	
	
	/**
	 * 打开新窗口，显示明细
	 */
	public void initOrderForm(Item item) {
		rightFormlayout = new FormLayout();

		orderNo = new TextField("订单编号");
		//orderMoney = new TextField("订单总价");
		orderTotalMoney = new TextField("订单实际价格");
		//couponMoney = new TextField("订单优惠价格");
		//delivery = new TextField("订单配送方式");//2外送 1自取 3 顺丰
		orderStatus = new NativeSelect("订单状态");//订单状态 1默认待支付 2已支付 3已关闭
		orderStatus.addItems(0, 1);
		orderStatus.setItemCaption(0, "已支付");
		orderStatus.setItemCaption(1, "已关闭");
		
		create_date = new TextField("支付时间");
	
		product = new Table("订单明细列表");
		product.setSizeFull();
		product.setHeight(120, Unit.PIXELS);
		product.setWidth(300, Unit.PIXELS);
		BeanItemContainer<OrderContent> orderContentContainer = new BeanItemContainer<OrderContent>(
				OrderContent.class);
		if (item != null) {
			Property prop = item.getItemProperty("orderNo");
			String orderNo = (String) prop.getValue();
			List<OrderContent> list = this.orderDao.findAllOrderContentByOrderNum(orderNo);
			for (OrderContent orderBean : list) {
				orderContentContainer.addItem(orderBean);
			}
		}
		product.setContainerDataSource(orderContentContainer);
		product.setVisibleColumns(new Object[]{"productName","goodsBuyQrt","goodsBuyPrice"});
		product.setColumnHeaders(new String[] { "产品名称", "产品数量","价格" });
		product.setSelectable(false);
		product.setMultiSelect(false);
		product.setImmediate(true);

		user_name = new TextField("会员姓名");
		user_tel = new TextField("会员电话");
		user_address = new TextArea("收货地址");
		user_address.setRows(6);
		user_address.setImmediate(true);
		user_address.setSizeFull();
	
		saveButton = new Button("保存");
		saveButton.addClickListener(buttonLister());
		
		sendButton = new Button("发货");
		sendButton.addClickListener(buttonLister());
		
		rightFormlayout.addComponents(orderNo, orderTotalMoney,
				orderStatus, create_date, product, user_name,
				user_tel, user_address,saveButton,sendButton);
		if (item != null) {
			Property prop = item.getItemProperty("orderNo");
			String ordNo = (String) prop.getValue();
			//System.out.println("------>选中行的 orderNo ="+orderNo);
			Order order = this.orderDao.findStoreByOrderNo(ordNo);
			//System.out.println("------>选中的订单 order ＝"+order);
			OrderBean ordBean  = this.orderDao.ex(order);
			//System.out.println("------>转化后的  ordBean ="+ordBean);
			
			BeanFieldGroup<OrderBean> bindingFiles = new BeanFieldGroup<OrderBean>(
					OrderBean.class);
			bindingFiles.setItemDataSource(ordBean);
			bindingFiles.setBuffered(true);
			bindingFiles.bindMemberFields(this); // 绑定

			MemberAddress address = this.orderDao.getMemeberAddressByUserCode(order.getAddressCode(),order.getUserCode());
			StringBuffer sb = new StringBuffer("");
			sb.append(address.getCity()+","+address.getArea()+","+address.getAddress_keywords());
			user_address.setValue(sb.toString());
			//订单状态 1默认待支付 2已支付 3已关闭
			if (order.getOrderStatus().equals("2")) {
				orderStatus.select(0);
			} else if (order.getStatus().equals("3")){
				orderStatus.select(1);
			}

			orderNo.setEnabled(false); //禁用输入框
			//orderMoney.setEnabled(false); //禁用输入框
			orderTotalMoney.setEnabled(false); //禁用输入框
			//couponMoney.setEnabled(false); //禁用输入框
			//delivery.setEnabled(false); //禁用输入框
			create_date.setEnabled(false); //禁用输入框
			user_name.setEnabled(false); //禁用输入框
			user_tel.setEnabled(false); //禁用输入框
			user_address.setEnabled(false); //禁用输入框
			

		}
	}
	
	
	/**
	 * button 保存新增或者修改
	 * */
	private Button.ClickListener buttonLister() {
		Button.ClickListener lister = new Button.ClickListener() {
			
			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				
				if (event.getButton().getCaption().equals("保存")) {
					//获取订单 编码
					String order_No = orderNo.getValue();
					//获取订单状态
					Integer order_Status = (Integer) orderStatus.getValue();
					System.out.println("获取订单 编码 ="+order_No+"      ,order_Status ="+order_Status);
					if (order_Status == 0) {
						Notification.show("现在即是已支付状态，切换到 已关闭 状态才能完成订单");
					}else{
						//1 根据订单编号，查出对应订单全部信息
						Order odr =  orderDao.findStoreByOrderNo(order_No);
						odr.setOrderStatus("3"); //修改为  已关闭   状态
						
						//2 修改 orderStatus 然后更新
						orderDao.updateStore(odr);
						//3 刷新表格容器
						//tableContainer.removeItem(odr);
						initContainer();
						Notification.show("更新成功");
						addWindow.close();
					}
				} 
				
				if (event.getButton().getCaption().equals("发货")) {
					//获取订单 编码
					String order_No = orderNo.getValue();
					//获取订单状态
					Integer order_Status = (Integer) orderStatus.getValue();
					//System.out.println("获取订单 编码 ="+order_No+"      ,order_Status ="+order_Status);
					if (order_Status == 0) {
						Notification.show("现在即是已支付状态，切换到 已关闭 状态才能完成订单");
					}else{
						//1 根据订单编号，查出微信支付反馈数据，发送请求给腾讯
						JDBCDao dao = new JDBCDao();
						Delivernotify dil =  dao.findByOrderCode(order_No);
						System.out.println(".........................01 Delivernotify ="+dil);
						
						//2 获取 access_token
						AccessToken accessToken = null;
						try {
							accessToken = GetAccessToken.getToken();
							System.out.println(".........................02 accessToken ="+accessToken.getToken());
						} catch (Exception e) {
							Notification.show("腾讯服务器连接Token无法获取，请等待 2 小时后重新获取!");
							e.printStackTrace();
						}
						System.out.println(".........................1 accessToken ="+accessToken);
						
						Date  dt = new Date();
						long unixTime = TenpayUtil.getUnixTime(dt);
						//3 获取 sign
						//设置支付参数
						SortedMap<String, String> signParams = new TreeMap<String, String>();
						signParams.put("appid", dil.getAppid());
						signParams.put("appkey", WXContent.APP_KEY);
						signParams.put("openid", dil.getOpenid());
						signParams.put("transid", dil.getTransaction_id());
						signParams.put("out_trade_no", dil.getOut_trade_no());
						signParams.put("deliver_timestamp", ""+unixTime);
						signParams.put("deliver_status", "1");
						signParams.put("deliver_msg", "ok");	
						System.out.println(".........................2 signParams :"+signParams);
						
						//生成支付签名，要采用URLENCODER的原始值进行SHA1算法！
						try {
							String app_signature = Sha1Util.createSHA1Sign(signParams);
							System.out.println(".........................3 app_signature :"+app_signature);
							//4 生成 腾讯发货接口需要的 json 字符串
							DelivernotifyJSON jsonbean =  new DelivernotifyJSON();
							jsonbean.setAppid(WXContent.APP_ID);
							jsonbean.setOpenid(dil.getOpenid());
							jsonbean.setTransid(dil.getTransaction_id());
							jsonbean.setOut_trade_no(dil.getOut_trade_no());
							jsonbean.setDeliver_timestamp(""+unixTime);
							jsonbean.setDeliver_status("1");
							jsonbean.setDeliver_msg("ok");
							jsonbean.setApp_signature(app_signature);
							jsonbean.setSign_method("sha1");
							
							String jsonStr = Json.toJson(jsonbean);
							System.out.println(".........................4 jsonStr :"+jsonStr);
							
							
							
							if (accessToken == null) {
								System.out.println(".........................5 accessToken null");
								Notification.show("腾讯服务器连接Token无法获取，注意一天最多 2000 次请求!");
							}else{
								//String tempToken ="muIPuBedckISnwQ501W-X-SSpBC3r9D2U_tbsnVd6X5aOA6rkopKaG-idqN5A_aa0JdA2RqLT9yZsLKhIf6vFQ";
								String tempToken  = accessToken.getToken();
								//5 发送数据给发货接口
								HttpService httpService = new HttpService();
								String requestUrl= "https://api.weixin.qq.com/pay/delivernotify?access_token="+tempToken;
								System.out.println(".........................5 requestUrl :"+requestUrl);
								
								String returnStr = httpService.doPost(requestUrl, jsonStr);
								System.out.println(".........................6 returnStr :"+returnStr);
								
								//转换返回数据
								Gson gson = new Gson();
								Map<String, String> map2 = gson.fromJson(returnStr, new TypeToken<Map<String, String>>() {}.getType());
								ReturnJSON rJson = new ReturnJSON();
								rJson.setErrcode(map2.get("errcode"));
								rJson.setErrmsg(map2.get("errmsg"));
								
								System.out.println(".........................7 rJson:"+rJson);
								if (rJson.getErrcode().equals("0")) {
									//1 根据订单编号，查出对应订单全部信息
									Order odr =  orderDao.findStoreByOrderNo(order_No);
									odr.setOrderStatus("3"); //修改为  已关闭   状态
									//2 修改 orderStatus 然后更新
									orderDao.updateStore(odr);
									
									Notification.show("发货成功!");
								}else{
									Notification.show("发货失败!");
								}
							}	
							
						
						}catch (Exception e) {
							Notification.show("腾讯服务器发货接口请求失败，发货不成功!");
							e.printStackTrace();
						}
						
						initContainer();
						//leftTable.setContainerDataSource(tableContainer);
						
						addWindow.close();
					}
				} 
				
			}
		};
		return lister;
	}

}
