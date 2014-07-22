package com.seaway.liufuya.mvc.crm.memberaddressinfo.layout;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.mvc.crm.memberaddressinfo.dao.LazyLoadMemberAddressContainer;
import com.seaway.liufuya.mvc.crm.memberaddressinfo.dao.LazyLoadMemberContainer;
import com.seaway.liufuya.mvc.crm.memberaddressinfo.dao.MemberAddressBeanDao;
import com.seaway.liufuya.mvc.crm.memberaddressinfo.pojo.MemberAddress;
import com.seaway.liufuya.mvc.crm.memberaddressinfo.pojo.MemberAddressBean;
import com.seaway.liufuya.mvc.crm.memberinfo.dao.impl.MemberInfoMemberBean;
import com.seaway.liufuya.mvc.crm.memberinfo.data.Citypart;
import com.seaway.liufuya.mvc.crm.memberinfo.data.Member;
import com.seaway.liufuya.mvc.crm.memberinfo.data.MemberBean;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Container.Filter;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.filter.Compare.Greater;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.event.Action;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.FieldEvents.BlurEvent;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.ClientConnector.AttachEvent;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.themes.Reindeer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;

/**
 * 会员扩展资料面板
 * 
 * @author lililiu
 */
@SuppressWarnings("serial")
public class MemberAddressListLayout extends VerticalLayout implements
		ClickListener,ItemClickListener {

	private static final Log log = Logs.get();

	// ---------表格需要的
	// 定义一个表格使用的容器对象
	private BeanItemContainer<MemberAddressBean> memberAddressContainer = new BeanItemContainer<MemberAddressBean>(
			MemberAddressBean.class);
	private LazyLoadMemberContainer memberContainer = null;
	// private LazyLoadMemberAddressContainer memberAddressContainer = null;

	// 每列宽度
	private static final int[] COLUMN_WIDTHS = { 80, 45, 20, 50, 40, 65 };
	// 间隙
	private static final int COLUMN_SPACE = 13;
	// 查询会员地址数据 的数据库对象
	private MemberAddressBeanDao memberManager = null;
	// ---------弹出新增窗口需要
	// 弹出窗口需要组件，表单相关，新增会员
	private FieldGroup fieldGroup;

	// 整个页面，左右分割面板
	private final HorizontalSplitPanel mainSplit = new HorizontalSplitPanel();
	// 后侧上下分割的 垂直布局面板
	private final VerticalSplitPanel rightSplit = new VerticalSplitPanel();
	// ---------下面表单 查询，修改需要
	private VerticalLayout buttonVLayout = new VerticalLayout();
	private Button save = new Button("保存", (ClickListener) this);
	private Button cancel = new Button("取消", (ClickListener) this);
	private Button edit = new Button("编辑", (ClickListener) this);
	// -------------------------------
	private HorizontalLayout footer; // 底部
	// Member that will bind to the "name" property
	// TextField 对象名称与传递进来的 PropertyId 数据名称一致，就不用
	// @PropertyId("firstName")
	private final ComboBox city = new ComboBox("城市");  //城市
	private final ComboBox area = new ComboBox("区域"); // 整个作为登录账户
	private TextField address_keywords = new TextField("地址");//
	private TextField gps_long = new TextField("经度"); // 经度
	private TextField gps_lat = new TextField("纬度");  //纬度
	private final ComboBox is_default = new ComboBox("默认地址"); // 默认地址 0 不是 1 是
	private final TextField is_available = new TextField("能否配送"); // 能否配送 1可以 0不可以
	

	FormLayout btFormlayout = new FormLayout();
	// Now use a binder to bind the members
	FieldGroup btFormbinder = null;

	// ----------------------------------------
	public MemberAddressListLayout() {
		// TODO Auto-generated constructor stub
	}

	public MemberAddressListLayout(MemberAddressBeanDao memberManager) {
		this.memberManager = memberManager;

		// 主界面mainSplit
		// 右侧创建一个导航工具条,水平布局
		HorizontalLayout navBar = new HorizontalLayout();
		navBar.setStyleName(Reindeer.LAYOUT_BLACK);
		navBar.setWidth(100, Unit.PERCENTAGE);
		navBar.setHeight(29, Unit.PIXELS);
		Label lblNav = new Label("CRM系统 / 扩展资料"); // 导航

		HorizontalLayout navBarButtons = new HorizontalLayout();
		Button btnAdd = new Button("新增"); // 增加 按钮
		btnAdd.setIcon(new ThemeResource("icons/16/add.png"));
		btnAdd.setDescription("增加会员扩展资料");
		Button btnDownload = new Button("列表"); // 增加 按钮
		btnDownload.setIcon(new ThemeResource("icons/16/database-cloud.png"));
		btnDownload.setDescription("选择显示数据库中数据");
		navBarButtons.addComponent(btnAdd);
		navBarButtons.addComponent(btnDownload);

		navBar.addComponent(lblNav);
		navBar.addComponent(navBarButtons);

		navBar.setComponentAlignment(lblNav, Alignment.MIDDLE_LEFT);
		navBar.setComponentAlignment(navBarButtons, Alignment.MIDDLE_RIGHT);

		btnAdd.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// personForm.addContact(); // 增加
				// openProductWindow(new BeanItem<Member>(new Member()),
				// "新增会员窗口");
			}
		});

		btnDownload.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// personForm.addContact(); // 增加
				Notification.show("正在从POS系统下载数据，请等待", Type.HUMANIZED_MESSAGE);
			}
		});

		mainSplit.setStyleName(Reindeer.LAYOUT_WHITE); // 右侧样式
		mainSplit.setHeight(470, Unit.PIXELS);
		mainSplit.setStyleName(Reindeer.SPLITPANEL_SMALL); // 分割线变细线
		// /////////////////////////////////////////////////////////////////
		// 获取所有会员的 数据模型,懒加载分页
		fillContainer(memberManager);

		// 对表格进行改进，增加对每个字段的搜索过滤框
		VerticalLayout tablelayout = new VerticalLayout();
		Table tb = createMemberTable(memberContainer);
		// tablelayout.addComponent(createFilters(tb)); // 表格过滤框
		tablelayout.addComponent(tb); // 表格
		mainSplit.setFirstComponent(tablelayout);
		mainSplit.setSecondComponent(rightSplit); // 把右侧布局添加到页面中
		// 这里把创建表单的代码，放在表格点击事件中
		// /////////////////////////////////////////////////////////////////
		mainSplit.setSplitPosition(40);

		this.addComponent(navBar); // 导航栏
		this.addComponent(mainSplit); // 左右分割面板
		this.setExpandRatio(mainSplit, 1);
	}

	/**
	 * 在一个页面创建表格
	 * 
	 * @param container
	 * @return
	 */
	private Table createMemberTable(Container container) {
		final Table table = new Table(null, container);
		table.setSizeFull();
		table.setHeight(470, Unit.PIXELS);
		table.setContainerDataSource(container); // 这里数据源要切换

		table.setVisibleColumns(Constants.MEMEBER_ADD_COL_ORDER);
		table.setColumnHeaders(Constants.MEMEBER_ADD_COL_HEADERS_CHINESE);

		table.setColumnCollapsingAllowed(true);
		table.setColumnReorderingAllowed(true);
		/*
		 * Make table selectable, react immediatedly to user events, and pass
		 * events to the controller (our main application)
		 */
		table.setSelectable(true);
		table.setImmediate(true);
		table.addItemClickListener(new ItemClickListener() {
			@Override
			public void itemClick(ItemClickEvent event) {
				log.info("选中一行,查询用户地址表单 :" + event.getItemId());
				MemberBean bean = (MemberBean) event.getItemId();
				Member mb = memberManager.findMemberByLoginName(bean
						.getLoginname());
				// 到数据库查询会员信息
				fillAddressContainer(memberManager, mb.getUser_code());
				rightSplit
						.setFirstComponent(createMemberAddressTable(memberAddressContainer));
			}
		});
		/* We don't want to allow users to de-select a row */
		table.setNullSelectionAllowed(false);

		return table;
	}

	/**
	 * 选择一个会员，查询这个会员所有的地址信息，显示在一个表格中
	 * 
	 * @param container
	 * @return
	 */
	private Table createMemberAddressTable(Container container) {
		final Table table = new Table(null, container);
		table.setSizeFull();
		table.setHeight(190, Unit.PIXELS);
		table.setContainerDataSource(container); // 这里数据源要切换

		table.setVisibleColumns(Constants.MEMEBER_ADDRESS_COL_ORDER);
		table.setColumnHeaders(Constants.MEMEBER_ADDRESS_COL_HEADERS_CHINESE);

		table.setColumnCollapsingAllowed(true);
		table.setColumnReorderingAllowed(true);
		/*
		 * Make table selectable, react immediatedly to user events, and pass
		 * events to the controller (our main application)
		 */
		table.setSelectable(true);
		table.setImmediate(true);
		table.addItemClickListener(new ItemClickListener() {
			@Override
			public void itemClick(ItemClickEvent event) {
				log.info("选中一行,显示编辑用户表单 :" + event.getItemId());
				// MemberAddress madd = (MemberAddress)event.getItemId();
				editContact((MemberAddressBean) event.getItemId());
			}
		});
		/* We don't want to allow users to de-select a row */
		table.setNullSelectionAllowed(false);

		return table;
	}
	//------------------------------------------
	// ------------------------------------------------------
		// 底部 TabSheet 和 表单
	/*
		private Layout createForm(Item item) {
			footer = new HorizontalLayout();
			footer.setSpacing(true);
			footer.addComponent(save);
			footer.addComponent(cancel);
			footer.addComponent(edit);
			footer.setVisible(false);
			
			// 允许用户输入新的城市
			// 不允许输入空值
			city.setNullSelectionAllowed(false);
			// 从数据库 获取所有的城市
			List<Citypart> citylist = memberManager.getTopCityList(); //城市列表
			final List<Citypart> arealist = null;   //区域列表
			for (Citypart citypart : citylist) {
				city.addItem(citypart.getAddress_name());
			}
			city.addAttachListener(new AttachListener() {
				
				@Override
				public void attach(AttachEvent event) {
					// TODO Auto-generated method stub
					log.info("Attach  city......."+event.getSource());
				}
			});
			city.addValueChangeListener(new ValueChangeListener() {
				
				@Override
				public void valueChange(ValueChangeEvent event) {
					log.info("ValueChangeListener  city......."+event.getProperty().getValue());
					//arealist = memberManager.getSecondCityList(id);
				}
			});
			
			area.setNullSelectionAllowed(false);
			// 从数据库 获取所有的城市
			if (arealist != null) {
				for (Citypart citypart : arealist) {
					area.addItem(citypart.getAddress_name());
				}
			}
			
			
			// 生日
			

			// 家庭收入
			address_keywords

			// 实体卡状态
			for (String statu : Constants.MEMBER_ENTITY_CARD_STATUS) {
				entityCardStatus.addItem(statu);
			}

			// 必填项
			telphone.setRequired(true);
			realName.setRequired(true);
			telphone.setImmediate(true);
			realName.setImmediate(true);

			// placeHolder提示
			telphone.setInputPrompt("手机号码作为登录名");

			// 长度限制
			telphone.setMaxLength(11);
			card_number.setMaxLength(19);
			realName.setMaxLength(20);
			email.setMaxLength(25);

			// 输入校验
			// firstName.setNullRepresentation(""); // 为空是替换为""
			email.addValidator(new EmailValidator("请输入正确的邮箱地址，如xxx@163.com"));
			// 正则表达式验证
			telphone.addValidator(new RegexpValidator("[1-9][0-9]{9}", "请输入11位手机号码"));
			memberCard_balance.addValidator(new RegexpValidator("[1-9][0-9]*",
					"请输入数字"));
			memberCard_score.addValidator(new RegexpValidator("[1-9][0-9]*",
					"请输入数字"));

			// 往 FormLayout 中添加组件
			btFormlayout.setWidth(100, Unit.PERCENTAGE);
			btFormlayout.setSpacing(true);

			btFormlayout.addComponent(telphone);
			btFormlayout.addComponent(realName);
			btFormlayout.addComponent(sex);
			btFormlayout.addComponent(birthday);
			btFormlayout.addComponent(card_number);
			btFormlayout.addComponent(email);
			btFormlayout.addComponent(work_type);
			btFormlayout.addComponent(family_money);
			btFormlayout.addComponent(age_area);
			btFormlayout.addComponent(entityCardNumber);
			btFormlayout.addComponent(entityCardStatus);
			btFormlayout.addComponent(memberCard_balance);
			btFormlayout.addComponent(memberCard_score);

			// ***** 默认不显示表单 *****
			btFormlayout.setVisible(false);

			// 默认显示图标
			tabsheet.addTab(btFormlayout, "会员管理", new ThemeResource(
					"icons/16/user-normal.png"));
			buttonVLayout.addComponent(tabsheet);

			
			return buttonVLayout;
		}
		*/
	
	
	// ------------------------------------------

	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub

	}

	// ----------------------------------------------------------------------
	/**
	 * 表格选中某一行后，跳转过来到这里编辑
	 * 
	 * @param person
	 */
	public void editContact(MemberAddressBean bean) {
		// log.info("点击    编辑   按钮...........name = "+bean.getRealname()+"  loginname ="+bean.getLoginname());
		// 这里根据登录名，查询出会员完整信息
		// Member mb = this.memberManager.getMemeberByLoginname(bean
		// .getLoginname());
		// // 根据穿过来的 Bean 对象，创建表格输入框
		// setItemDataSource(new BeanItem(mb));
		// setReadOnly(true);
	}

	// ----------------------------------------------------------------------
	/**
	 * 获取会员表格的 容器对象 懒加载的方式
	 * 
	 * @param container
	 */
	private void fillContainer(MemberAddressBeanDao memberManager) {
		memberContainer = new LazyLoadMemberContainer(MemberBean.class,
				memberManager);
	}

	private void fillAddressContainer(MemberAddressBeanDao memeberManager,
			String user_code) {
		memberAddressContainer.removeAllItems();
		List<MemberAddressBean> list = memberManager
				.getMemberAddressByUserCode(user_code);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			MemberAddressBean memberBean = (MemberAddressBean) iterator.next();
			memberAddressContainer.addItem(memberBean);
		}
	}

	@Override
	public void itemClick(ItemClickEvent event) {
		// TODO Auto-generated method stub
		
	}

}
