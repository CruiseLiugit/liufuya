package com.seaway.liufuya.mvc.weixinstore.ordernew.layout;

import java.text.ParseException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.nutz.dao.entity.annotation.Column;
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
import com.seaway.liufuya.mvc.weixinstore.ordernew.dao.OrderDao;
import com.seaway.liufuya.mvc.weixinstore.ordernew.data.Order;
import com.seaway.liufuya.mvc.weixinstore.ordernew.data.OrderBean;
import com.seaway.liufuya.mvc.weixinstore.ordernew.data.OrderContent;
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
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Reindeer;

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
	
	
//	private String city = "";// 城市
//	private String area = "";// 城区
//	private String productName = "";// 产品名称
//	private String goodsBuyQrt = "";// 产品数量
	
	
	TextField orderNo = null; //订单编号
	TextField orderMoney = null; //订单总价
	TextField orderTotalMoney = null;//订单实际购买价格
	TextField couponMoney = null;//订单优惠价格
	TextField delivery = null; // '2外送 1自取 3 顺丰',
	TextField orderStatus;// '订单状态 1默认待支付 2已支付 3已关闭
	TextField create_date;// 创建时间
	Table product = null;//订单对应的产品列表
	TextField user_tel = null;//用户联系电话 当delivery为2时必填
	TextField user_name = null;//订单用户名
	TextArea user_address;//地址
	NativeSelect status = null;// '状态 1默认未付款 0删除 2已付款 3 外送超时 4 自取超时 5 外送退货

	Button saveButton = null;

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
		Label lblNav = new Label("订单管理 / 当天订单管理");
		navBar.addComponent(lblNav);
		
//		Button btnAdd = new Button("查询"); // 增加 按钮
//		btnAdd.setIcon(new ThemeResource("icons/16/add.png"));
//		btnAdd.setDescription("增加门店");
//		btnAdd.addClickListener(addButtonClickLister());
//		navBar.addComponent(lblNav);
//		navBar.addComponent(btnAdd);
//		navBar.setComponentAlignment(btnAdd, Alignment.TOP_RIGHT);// 定义位置

		// --------------------------垂直页面布局
		initContainer();
		initLeftTable();
		vsplit.addComponent(leftTable);
		//vsplit.setSplitPosition(70);
		vsplit.setStyleName(Reindeer.LAYOUT_WHITE); // 右侧样式
		vsplit.setHeight(470, Unit.PIXELS);

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
		// 分页版本
		// container = new LazyLoadStoreContainer(StoreBean.class,storeDao);
		// 不分页版本
		List<OrderBean> list = this.orderDao.getAllOrder("3", "2", "2");
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
		leftTable.setHeight(100, Unit.PERCENTAGE);
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
		orderMoney = new TextField("订单总价");
		orderTotalMoney = new TextField("订单实际价格");
		couponMoney = new TextField("订单优惠价格");
		delivery = new TextField("订单配送方式");//2外送 1自取 3 顺丰
		orderStatus = new TextField("订单状态");//订单状态 1默认待支付 2已支付 3已关闭
		create_date = new TextField("支付时间");
		
		orderNo.setEnabled(false); //禁用输入框
		orderMoney.setEnabled(false); //禁用输入框
		orderTotalMoney.setEnabled(false); //禁用输入框
		couponMoney.setEnabled(false); //禁用输入框
		delivery.setEnabled(false); //禁用输入框
		orderStatus.setEnabled(false); //禁用输入框
		create_date.setEnabled(false); //禁用输入框
		
		product = new Table("订单明细列表");
		product.setSizeFull();
		product.setHeight(200, Unit.PIXELS);
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
		user_address.setRows(10);
		user_address.setImmediate(true);
		user_address.setSizeFull();
		
		user_name.setEnabled(false); //禁用输入框
		user_tel.setEnabled(false); //禁用输入框
		user_address.setEnabled(false); //禁用输入框
		
		// '状态 1默认未付款 0删除 2已付款 3 外送超时 4 自取超时 5 外送退货
		status = new NativeSelect("启用");
		status.addItems(0, 1);
		status.setItemCaption(0, "否");
		status.setItemCaption(1, "是");

		saveButton = new Button("保存");
		saveButton.addClickListener(buttonLister());

//		orderNo.setEnabled(false); //禁用输入框
//		orderMoney.setEnabled(false); //禁用输入框
//		.setEnabled(false); //禁用输入框
//		.setEnabled(false); //禁用输入框
//		.setEnabled(false); //禁用输入框
//		.setEnabled(false); //禁用输入框
//		.setEnabled(false); //禁用输入框
//		 = new Table("订单产品列表");
//		 = new TextField("会员姓名");
//		 = new TextField("会员电话");
//		 = new TextArea("收货地址");
//		.addItems(0, 1);
//		
		
		rightFormlayout.addComponents(orderNo, orderMoney, orderTotalMoney,
				couponMoney, delivery, orderStatus, create_date, product, user_name,
				user_tel, user_address, status,saveButton);
		if (item != null) {
			Property prop = item.getItemProperty("orderNo");
			String orderNo = (String) prop.getValue();
			Order order = this.orderDao.findStoreByOrderNo(orderNo);
			OrderBean ordBean  = this.orderDao.ex(order);
			
			BeanFieldGroup<OrderBean> bindingFiles = new BeanFieldGroup<OrderBean>(
					OrderBean.class);
			bindingFiles.setItemDataSource(ordBean);
			bindingFiles.setBuffered(true);
			bindingFiles.bindMemberFields(this); // 绑定

			
//			TextField orderTotalMoney = null;//订单实际购买价格
//			TextField couponMoney = null;//订单优惠价格
			
			// 门店类型
//			if (store_type.getValue().equals("社区型")) {
//				store_type.select(0);
//			} else if (store_type.getValue().equals("菜场型")) {
//				store_type.select(1);
//			} 
			
//			if (status.getValue().equals("是")) {
//				status.select(1);
//			} else {
//				status.select(0);
//			}

		}
	}
	
	
	/**
	 * button 保存新增或者修改
	 * */
	private Button.ClickListener buttonLister() {
		Button.ClickListener lister = new Button.ClickListener() {
			
			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
//				StoreAddress store = new StoreAddress();
//				store.setStore_name(store_name.getValue());// 门店名称
//				store.setStatus("" + status.getValue());

				if (event.getButton().getCaption().equals("保存")) {
//					// 更新
//					store.setCreate_date(DateUtil
//							.convertStringToDate(DateUtil
//									.convertDateToString(new Date())));
//					storeDao.updateStore(store);
//					Notification.show("更新成功");
				} 
			}
		};
		return lister;
	}

}
