package com.seaway.liufuya.mvc.weixinstore.generatingcoupon.layout;

import java.util.List;

import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.mvc.weixinstore.generatingcoupon.dao.CouponManager;
import com.seaway.liufuya.mvc.weixinstore.generatingcoupon.data.Coupon;
import com.seaway.liufuya.mvc.weixinstore.generatingcoupon.service.CouponService;
import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Reindeer;

/**
 * 微信模块 商品类目管理主界面
 * 
 * @author zg
 * **/
public class CouponListView extends VerticalLayout {

	private CouponManager manager = null;
	private CouponService service = null;

	// -----------------------------------------------定义布局组件
	// -----------标题
	HorizontalLayout navBar = new HorizontalLayout();
	Label lblNav = new Label("电子优惠券 /优惠券生成");
	Button addBtn = new Button("增加");
	Window window = new Window("增加");

	// -----------正文
	private HorizontalSplitPanel vsplit;
	// -----------左边table
	private Table table = new Table();
	private BeanItemContainer container;

	// -----------右边form
	private FormLayout form = new FormLayout();
	private FormLayout form1 = new FormLayout();
	private TextField couponCode;
	private NativeSelect couponType;
	private TextField couponName;
	private TextArea couponDesc;
	private PopupDateField startDate;
	private PopupDateField endDate;
	private TextField avtiveTime;
	private TextField couponTotals;
	private TextField couponExchanges;
	private TextField couponValue;
	private NativeSelect isNew;
	private NativeSelect status;
	private Button saveButton;
	private Button addBtn1;

	// -----------------------------------------------构造 开始初始化布局
	public CouponListView(CouponManager manager) {

		this.manager = manager;
		service = new CouponService(manager);
		// ---------标题部分
		navBar.setStyleName(Reindeer.LAYOUT_BLACK);
		navBar.setWidth(100, Unit.PERCENTAGE);
		navBar.setHeight(29, Unit.PIXELS);
		addBtn.setIcon(new ThemeResource("icons/16/add.png"));
		addBtn.setDescription("增加");
		Label lblNav = new Label("微信系统 /商品类别");
		addBtn.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				createWindow();
			}
		});
		navBar.addComponent(lblNav);
		navBar.addComponent(addBtn);
		navBar.setComponentAlignment(addBtn, Alignment.TOP_RIGHT);// 定义位置

		// ---------正文部分
		vsplit = new HorizontalSplitPanel();
		initContainer();
		initTable();
		vsplit.addComponent(table);
		initForm(null);
		vsplit.addComponent(form);
		this.addComponent(navBar);
		this.addComponent(vsplit);
		vsplit.setSplitPosition(70F);
		vsplit.setStyleName(Reindeer.LAYOUT_WHITE);
	}

	/**
	 * 初始化表格容器
	 * 
	 * @author zg
	 * **/
	private void initContainer() {
		container = new BeanItemContainer<Coupon>(Coupon.class);
		List<Coupon> couponList = service.getAllCoupon();
		container.addAll(couponList);
	}

	/**
	 * 初始化表格
	 * 
	 * @author zg
	 * **/
	private void initTable() {
		// 初始换之前 必须要清除所有item

		table.removeAllItems();
		table.setSizeFull();
		table.setHeight(470, Unit.PIXELS);
		table.setContainerDataSource(container); // 这里数据源要切换

		table.setVisibleColumns(Constants.COUPON_COL);
		table.setColumnHeaders(Constants.COUPON_COL_HEADERS_CHINESE);

		table.setColumnCollapsingAllowed(true);
		table.setColumnReorderingAllowed(true);

		table.setSelectable(true);
		table.setImmediate(true);
		table.addItemClickListener(new ItemClickListener() {
			@Override
			public void itemClick(ItemClickEvent event) {
				initForm(event.getItem());
				vsplit.addComponent(form);
			}
		});
		table.setNullSelectionAllowed(false);
	}

	/**
	 * 初始化form
	 * 
	 * @author zg
	 * **/
	private void initForm(Item item) {
		form.removeAllComponents();
		couponCode = new TextField("优惠券代码");
		couponType = new NativeSelect("优惠券类型");
		couponName = new TextField("优惠券名");
		couponDesc = new TextArea("优惠券描述");
		startDate = new PopupDateField("开始时间");
		endDate = new PopupDateField("截止时间");
		avtiveTime = new TextField("有效期");
		couponTotals = new TextField("总数目");
		couponExchanges = new TextField("已兑换数目");
		isNew = new NativeSelect("新品");
		status = new NativeSelect("状态");
		saveButton = new Button("修改");
		couponValue = new TextField("单张金额");

		status.addItems(0, 1);
		status.setItemCaption(1, "启用");
		status.setItemCaption(0, "未启用");
		status.setRequired(true);
		isNew.addItems(0, 1);
		isNew.setItemCaption(1, "新品");
		isNew.setItemCaption(0, "非新品");
		isNew.setRequired(true);
		for (int i = 0; i < Constants.COUPON_TYPE_ID.length; i++) {
			couponType.addItem(i);
			couponType.setItemCaption(i, Constants.COUPON_TYPE_NAME[i]);
		}
		saveButton.addClickListener(initButtonClickLister());
		// 绑定数据
		if (item != null) {
			vsplit.removeComponent(form);
			BeanFieldGroup<Coupon> bindingFiles = new BeanFieldGroup<Coupon>(
					Coupon.class);
			bindingFiles.setItemDataSource(item);
			bindingFiles.setBuffered(true);
			bindingFiles.bindMemberFields(this);
			couponExchanges.setReadOnly(true);
			couponExchanges.setReadOnly(false);
			couponValue.setReadOnly(false);
			if (status.getValue().equals("启用")) {
				status.select(1);
			} else {
				status.select(0);
			}
			if (isNew.getValue().equals("新品")) {
				isNew.select(1);
			} else {
				isNew.select(0);
			}

			for (int i = 0; i < Constants.COUPON_TYPE_ID.length; i++) {
				if (couponType.getValue().equals(Constants.COUPON_TYPE_NAME[i])) {
					couponType.select(i);
				}
			}
			couponCode.setEnabled(false);
		}
		form.addComponents(couponCode, couponType, couponName, couponValue,
				couponDesc, startDate, endDate, avtiveTime, couponTotals,
				couponExchanges, isNew, status, saveButton);
	}

	/**
	 * 创建增加窗体
	 * 
	 * @author zg
	 * **/
	public void createWindow() {
		window.setHeight(500, Unit.PIXELS);
		window.setWidth(350, Unit.PIXELS);
		window.setModal(true);
		initForm();
		window.setContent(form1);
		// window.close();
		getUI().addWindow(window);
	}

	/**
	 * 初始化按钮事件
	 * 
	 * @author zg
	 * **/
	private Button.ClickListener initButtonClickLister() {
		Button.ClickListener cl = new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				Coupon coupon = new Coupon();
				coupon.setAvtiveTime(avtiveTime.getValue());
				coupon.setCouponCode(couponCode.getValue());
				coupon.setCouponDesc(couponDesc.getValue());
				coupon.setCouponExchanges(couponExchanges.getValue());
				coupon.setCouponName(couponName.getValue());
				coupon.setCouponTotals(couponTotals.getValue());
				coupon.setCouponType(couponType.getValue().toString());
				coupon.setStartDate(startDate.getValue());
				coupon.setCouponValue(couponValue.getValue());
				coupon.setEndDate(endDate.getValue());
				coupon.setAvtiveTime(avtiveTime.getValue());
				coupon.setIsNew(isNew.getValue().toString());
				coupon.setStatus(status.getValue().toString());
				if (event.getButton().getCaption().equals("修改")) {
					service.updateCoupon(coupon);
					Notification.show("修改完成");
				} else if (event.getButton().getCaption().equals("增加")) {
					service.addCoupon(coupon);
					Notification.show("增加完成");
					window.close();
				}
				// 刷新 tree和table
				initContainer();
				table.setContainerDataSource(container);
				table.setVisibleColumns(Constants.COUPON_COL);
				table.setColumnHeaders(Constants.COUPON_COL_HEADERS_CHINESE);
			};
		};
		return cl;
	}

	/**
	 * 初始化添加form
	 * 
	 * @author zg
	 * **/
	private void initForm() {
		form1.removeAllComponents();
		couponType = new NativeSelect("优惠券类型");
		couponName = new TextField("优惠券名");
		couponDesc = new TextArea("优惠券描述");
		startDate = new PopupDateField("开始时间");
		endDate = new PopupDateField("截止时间");
		avtiveTime = new TextField("有效期");
		couponTotals = new TextField("总数目");
		couponExchanges = new TextField("已兑换数目");
		isNew = new NativeSelect("新品");
		status = new NativeSelect("状态");
		addBtn1 = new Button("增加");
		form1.removeAllComponents();
		addBtn1.addClickListener(initButtonClickLister());
		couponValue = new TextField("单张金额");
		status.addItems(0, 1);
		status.setItemCaption(1, "启用");
		status.setItemCaption(0, "未启用");
		status.setRequired(true);
		isNew.addItems(0, 1);
		isNew.setItemCaption(1, "新品");
		isNew.setItemCaption(0, "非新品");
		isNew.setRequired(true);
		for (int i = 0; i < Constants.COUPON_TYPE_ID.length; i++) {
			couponType.addItem(i);
			couponType.setItemCaption(i, Constants.COUPON_TYPE_NAME[i]);
		}
		form1.addComponents(couponType, couponName, couponDesc, couponValue,
				startDate, endDate, avtiveTime, couponTotals, couponExchanges,
				isNew, status, addBtn1);

	}
}
