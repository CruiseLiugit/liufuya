package com.seaway.liufuya.mvc.crm.ui;

import java.io.Serializable;

import org.nutz.dao.Dao;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.LiufuyaUI;
import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.mvc.crm.complain.dao.ComplainManager;
import com.seaway.liufuya.mvc.crm.complain.dao.impl.ComplainManagerImpl;
import com.seaway.liufuya.mvc.crm.complain.layout.ComplainListView;
import com.seaway.liufuya.mvc.crm.complaintype.dao.ComplainTypeManager;
import com.seaway.liufuya.mvc.crm.complaintype.dao.impl.ComplainTypeManagerImpl;
import com.seaway.liufuya.mvc.crm.complaintype.layout.ComplainTypeListView;
import com.seaway.liufuya.mvc.crm.consumeexchange.dao.ConsumeExchangeManager;
import com.seaway.liufuya.mvc.crm.consumeexchange.layout.ConsumeExchangeListView;
import com.seaway.liufuya.mvc.crm.consumerule.dao.ConsumeRuleManager;
import com.seaway.liufuya.mvc.crm.consumerule.layout.ConsumeRuleListView;
import com.seaway.liufuya.mvc.crm.exchangeproduct.dao.EXProductManager;
import com.seaway.liufuya.mvc.crm.exchangeproduct.layout.EXProductListView;
import com.seaway.liufuya.mvc.crm.memberaddressinfo.dao.MemberAddressBeanDao;
import com.seaway.liufuya.mvc.crm.memberaddressinfo.layout.MemberAddressListLayout;
import com.seaway.liufuya.mvc.crm.memberdelete.dao.impl.MemberDeleteInfoManagerImpl;
import com.seaway.liufuya.mvc.crm.memberdelete.layout.MemberDeleteInfoListView;
import com.seaway.liufuya.mvc.crm.memberinfo.dao.impl.MemberInfoMemberBean;
import com.seaway.liufuya.mvc.crm.memberinfo.layout.MemberInfoListView;
import com.seaway.liufuya.mvc.crm.memberlevel.dao.MemberLevelDao;
import com.seaway.liufuya.mvc.crm.memberlevel.layout.MemberLevelListLayout;
import com.seaway.liufuya.mvc.crm.sms.dao.impl.SMSManagerImpl;
import com.seaway.liufuya.mvc.crm.sms.layout.SMSListView;
import com.seaway.liufuya.mvc.crm.ui.dao.PersonManager;
import com.seaway.liufuya.mvc.crm.ui.dao.impl.PersonManagerBean;
import com.seaway.liufuya.mvc.crm.ui.data.Person;
import com.seaway.liufuya.mvc.crm.ui.data.PersonReferenceContainer;
import com.seaway.liufuya.mvc.crm.ui.data.QueryMetaData;
import com.seaway.liufuya.mvc.crm.ui.data.SearchFilter;
import com.seaway.liufuya.mvc.crm.ui.layout.HelpWindow;
import com.seaway.liufuya.mvc.crm.ui.layout.ListView;
import com.seaway.liufuya.mvc.crm.ui.layout.NavigationTree;
import com.seaway.liufuya.mvc.crm.ui.layout.PersonForm;
import com.seaway.liufuya.mvc.crm.ui.layout.PersonList;
import com.seaway.liufuya.mvc.crm.ui.layout.SearchView;
import com.seaway.liufuya.mvc.crm.ui.layout.SharingOptions;
import com.seaway.liufuya.mvc.crm.xchangerule.dao.ExchangeRuleBeanDao;
import com.seaway.liufuya.mvc.crm.xchangerule.layout.ExchangeRuleListLayout;
import com.seaway.liufuya.mvc.login.dao.SysUserDaoImpl;
import com.seaway.liufuya.mvc.login.ui.LoginScreen;
import com.seaway.liufuya.mvc.login.ui.UserMenusScreen;
import com.seaway.liufuya.mvc.login.ui.views.LoginUserInfo;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.Reindeer;

/**
 * CRM 管理模块的整体界面
 * 
 * @author lililiu
 * 
 */
public class CrmManageScreen extends CustomComponent implements ClickListener,
		ValueChangeListener, ItemClickListener, View,Serializable {
	private static final long serialVersionUID = 1L;
	private static final Log log = Logs.get();
	public PersonManagerBean personManager;
	private PersonReferenceContainer dataSource;

	private Dao nutzDao = null;

	// --------------顶部工具栏组件-----------------------------
	private Button backToMenu = new Button("首页");
	private Button search = new Button("搜索");
	private Button user = new Button("用户");
	private Button logout = new Button("退出");
	private NavigationTree tree = new NavigationTree(this,
			Constants.CRM_MENUS_TREE);
	// 查询当前用户信息
	private LoginUserInfo loginUser = null;
	private SysUserDaoImpl sysUserDao = null; // 访问用户登录表的数据库操作类

	// ----------------主界面内容-------------------------------
	private HorizontalSplitPanel horizontalSplit = new HorizontalSplitPanel();
	// Lazyly created ui references
	// Demo 需要的组件
	private ListView listView = null;
	private SearchView searchView = null;
	private PersonList personList = null;
	private PersonForm personForm = null;
	private HelpWindow helpWindow = null;
	private SharingOptions sharingOptions = null;

	// 会员资料组件
	private MemberInfoListView memberListView = null; // 会员资料
	private MemberAddressListLayout memberAddressListView = null; // 会员扩展资料
	public MemberLevelListLayout memberLevelView = null; // 会员等级管理
	private MemberDeleteInfoListView mdInfoListView = null; // 会员黑名单
	private ExchangeRuleListLayout exchangeRuleListView = null; // 兑奖规则信息管理
	private ComplainTypeListView complainTypeListView = null; // 诉求类别
	private ComplainListView complainListView = null;// 诉求管理
	private SMSListView smsListView = null; // 短信设置
	private EXProductListView exProductListView = null; // 兑换奖品资料管理
	private ConsumeRuleListView consumeRuleListView = null;// 积分兑换比例规则
	private ConsumeExchangeListView consumeExchangeListView = null;// 积分兑换交易记录

	// 数据库对象
	public MemberInfoMemberBean memberManager; // 会员管理
	public MemberAddressBeanDao memberAddressDao; // 会员扩展资料
	private MemberLevelDao memberLevelManager; // 会员等级
	private MemberDeleteInfoManagerImpl mdInfoManager;// 会员黑名单
	private ExchangeRuleBeanDao exchangeRuleDao; // 兑奖规则信息管理
	private ComplainTypeManager complainTypeManager;// 诉求类别
	private ComplainManager complainManager;// 诉求管理
	private SMSManagerImpl smsManager = null; // 短信设置
	private EXProductManager exproductManager; // 兑换奖品资料管理
	private ConsumeRuleManager consumeRuleManager = null;// 积分兑换比例规则
	private ConsumeExchangeManager consumeExchangeManager = null; // 会员兑换交易记录

	/**
	 * 构造函数，初始化界面
	 */
	public CrmManageScreen() {
	}

	public CrmManageScreen(String itemId) {
		log.info("---------init()--------");
		try {
			this.nutzDao = LiufuyaUI.getCurrent().initNutzDao();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("-----------------nutzDao =" + nutzDao);
		// ----------------------------------------------------------

		buildMainLayout(); // 创建空白的启动页面
		// 这个是 用 Person 对象做增删改查的 Demo getListView()
		// setMainComponent(this.getListView()); //往启动页面右侧添加默认会员管理页面列表

		if ("会员资料".equals(itemId)) {
			Notification.show("会员资料");
			setMainComponent(this.getMemberInfoListView()); // 往启动页面右侧添加默认会员管理页面列表
		} else if ("扩展资料".equals(itemId)) {
			Notification.show("扩展资料");
			setMainComponent(this.getMemberAddressListView());
		} else if ("会员等级".equals(itemId)) {
			Notification.show("会员等级");
			setMainComponent(this.getMemberLevelListLayout());
		} else if ("会员黑名单".equals(itemId)) {
			Notification.show("会员黑名单");
			setMainComponent(this.getmdInfoListView());
		} else if ("诉求类别".equals(itemId)) {
			Notification.show("诉求类别");
			setMainComponent(this.getcomplainTypeListView());
		} else if ("会员诉求".equals(itemId)) {
			Notification.show("会员诉求");
			setMainComponent(this.getComplainListView());
		} else if ("短信发送".equals(itemId)) {
			Notification.show("短信发送");
			setMainComponent(this.getSMSListView());
		} else if ("积分商品类别管理".equals(itemId)) {
			Notification.show("积分商品类别管理");
			setMainComponent(this.getExchangeRuleListView());
		} else if ("积分商品明细管理".equals(itemId)) {
			Notification.show("积分商品明细管理");
			setMainComponent(this.getEXProductListView());
		} else if ("积分兑换比例管理".equals(itemId)) {
			Notification.show("积分兑换比例管理");
			setMainComponent(this.getconsumeRuleListView());
		} else if ("会员积分兑换明细".equals(itemId)) {
			Notification.show("会员积分兑换明细");
			setMainComponent(this.getconsumeExchange());
		}

	}

	/**
	 * 登录成功后，显示的多系统菜单项目
	 */
	private void buildMainLayout() {
		// 默认创建垂直布局,上中下 三行
		// 公司图标 系统名称 用户名称 角色
		// -------------------------------
		// 中间是该用户所能操作的后台系统菜单
		// -------------------------------
		// 底部公司版权说明

		// 开始构建视图
		VerticalLayout root = new VerticalLayout();
		root.setStyleName(Reindeer.LAYOUT_BLUE);
		root.setSizeFull(); // 满屏

		// 头部
		root.addComponent(createTopToolbar()); // 工具栏
		root.addComponent(horizontalSplit); // 中间为左右分割
		root.setExpandRatio(horizontalSplit, 1);
		horizontalSplit.setHeight(500, Unit.PIXELS);
		horizontalSplit.setSplitPosition(200, Unit.PIXELS);
		// horizontalSplit.setStyleName(Reindeer.SPLITPANEL_SMALL); //分割线变细线
		horizontalSplit.setFirstComponent(tree);

		// 底部
		root.addComponent(LiufuyaUI.getCurrent().getPageFooter()); // 底部公司版权说明

		this.setCompositionRoot(root);
	}

	/**
	 * 创建简单的工具栏
	 * 
	 * @return
	 */
	public HorizontalLayout createTopToolbar() {
		HorizontalLayout lo = new HorizontalLayout();
		Embedded em = new Embedded("", new ThemeResource("img/logo_sm.png"));
		lo.addComponent(em);
		lo.setComponentAlignment(em, Alignment.MIDDLE_LEFT);
		lo.setExpandRatio(em, 1);

		backToMenu.setDescription("返回系统管理菜单");
		search.setDescription("全局搜索");
		user.setDescription("当前用户信息");
		logout.setDescription("退出系统");

		lo.addComponent(backToMenu);
		lo.addComponent(search);
		lo.addComponent(user);
		lo.addComponent(logout);
		lo.setComponentAlignment(backToMenu, Alignment.MIDDLE_RIGHT);
		lo.setComponentAlignment(search, Alignment.MIDDLE_RIGHT);
		lo.setComponentAlignment(user, Alignment.MIDDLE_RIGHT);
		lo.setComponentAlignment(logout, Alignment.MIDDLE_RIGHT);

		backToMenu.addClickListener(this);
		search.addClickListener(this);// .addListener((ClickListener) this);
		user.addClickListener(this);
		logout.addClickListener(this);

		backToMenu.setIcon(new ThemeResource("icons/19/home.png"));
		search.setIcon(new ThemeResource("icons/19/Search.png"));
		user.setIcon(new ThemeResource("icons/19/my-account.png"));
		logout.setIcon(new ThemeResource("icons/19/logout.png"));

		// lo.setMargin(false);
		// lo.setSpacing(true);
		lo.setStyleName(Reindeer.LAYOUT_WHITE);
		lo.setWidth(100, Unit.PERCENTAGE);

		return lo;
	}

	// -------------------事件处理-------------------------
	public void buttonClick(ClickEvent event) {
		final Button source = event.getButton();

		if (source == user) {
			showLoginUserInfoWindow();
		} else if (source == logout) {
			Notification.show("您已安全退出系统!");
			UI.getCurrent().setContent(new LoginScreen());
			// showShareWindow();
			UI.getCurrent().getSession().close();
		} else if (source == backToMenu) {
			// addNewContanct();
			UI.getCurrent().setContent(new UserMenusScreen());
		}
	}

	/**
	 * View 接口方法,进入导航控制器时的操作。 备选页面跳转方案
	 */
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		Notification.show("欢迎你使用留夫鸭 O2O 核心管理后台");
	}

	private void setMainComponent(Component c) {
		horizontalSplit.setSecondComponent(c); // 添加到第二个分割面板中
	}

	// ---------------------Demo------------------------------------
	/*
	 * 这个是获取案例的的两个视图组件 Table 和 From
	 */
	private ListView getListView() {
		if (personManager == null) {
			this.personManager = new PersonManagerBean(nutzDao);
		}
		dataSource = new PersonReferenceContainer(personManager);
		dataSource.refresh(); // Load initial data

		if (listView == null) {
			personList = new PersonList(this);
			personForm = new PersonForm(this);
			// personList = new PersonList();
			// personForm = new PersonForm();
			listView = new ListView(personList, personForm);
		}
		return listView;
	}

	// --------------------------------------------------------------
	/**
	 * 进入页面默认显示 会员资料界面，可以通过 左侧菜单控制 会员资料页面
	 * 
	 * @return
	 */
	private MemberInfoListView getMemberInfoListView() {
		log.info(">>>>>>>>>>>>>>>创建会员列表");
		if (memberManager == null) {
			this.memberManager = new MemberInfoMemberBean(nutzDao);
		}

		if (memberListView == null) {
			// 所有的表格和表单，都在一个类中控制
			memberListView = new MemberInfoListView(memberManager);
		}
		log.info("MemberInfoListView =" + memberListView);
		return memberListView;
	}

	// --------------------------------------------------------------
	/**
	 * 会员扩展信息列表
	 * 
	 * @return
	 */
	private MemberAddressListLayout getMemberAddressListView() {
		log.info(">>>>>>>>>>>>>>>创建会员扩展信息列表");
		if (memberAddressDao == null) {
			this.memberAddressDao = new MemberAddressBeanDao(nutzDao);
		}

		if (memberAddressListView == null) {
			// 所有的表格和表单，都在一个类中控制
			memberAddressListView = new MemberAddressListLayout(
					memberAddressDao);
		}
		return memberAddressListView;
	}

	// --------------------------------------------------------------
	/**
	 * 会员等级管理列表
	 * 
	 * @return
	 */
	private MemberLevelListLayout getMemberLevelListLayout() {
		log.info(">>>>>>>>>>>>>>>创建会员等级 扩展信息列表");
		if (memberLevelManager == null) {
			this.memberLevelManager = new MemberLevelDao(nutzDao);
		}

		if (memberLevelView == null) {
			// 所有的表格和表单，都在一个类中控制
			memberLevelView = new MemberLevelListLayout(memberLevelManager);
		}
		return memberLevelView;
	}

	// --------------------------------------------------------------
	/**
	 * 会员黑名单管理信息列表
	 * 
	 * @return
	 */
	private MemberDeleteInfoListView getmdInfoListView() {
		log.info(">>>>>>>>>>>>>>>会员黑名单管理");
		if (mdInfoManager == null) {
			this.mdInfoManager = new MemberDeleteInfoManagerImpl(nutzDao);
		}

		if (mdInfoListView == null) {
			// 所有的表格和表单，都在一个类中控制
			mdInfoListView = new MemberDeleteInfoListView(mdInfoManager);
		}
		return mdInfoListView;
	}

	// ----------------------------------------------------------------
	/**
	 * 会员诉求类别管理
	 * **/
	private ComplainTypeListView getcomplainTypeListView() {
		if (complainTypeManager == null) {
			this.complainTypeManager = new ComplainTypeManagerImpl(nutzDao);
		}

		if (complainTypeListView == null) {
			// 所有的表格和表单，都在一个类中控制
			complainTypeListView = new ComplainTypeListView(complainTypeManager);
		}
		return complainTypeListView;
	}

	// ---------------------------------------------会员诉求
	/**
	 * 会员诉求管理
	 * 
	 * @author zg
	 * **/
	private ComplainListView getComplainListView() {
		if (complainManager == null) {
			this.complainManager = new ComplainManagerImpl(nutzDao);
		}

		if (complainListView == null) {
			// 所有的表格和表单，都在一个类中控制
			complainListView = new ComplainListView(complainManager);
		}
		return complainListView;
	}

	// -------------------------------------------
	/**
	 * 短信发送管理
	 * 
	 * @author zg
	 * **/
	private SMSListView getSMSListView() {
		if (smsManager == null) {
			this.smsManager = new SMSManagerImpl(nutzDao);
		}

		if (smsListView == null) {
			// 所有的表格和表单，都在一个类中控制
			smsListView = new SMSListView(smsManager);
		}
		return smsListView;
	}

	// --------------------------------------------------------------
	/**
	 * 兑奖规则信息管理
	 * 
	 * @return
	 */
	private ExchangeRuleListLayout getExchangeRuleListView() {
		if (exchangeRuleDao == null) {
			this.exchangeRuleDao = new ExchangeRuleBeanDao(nutzDao);
		}

		if (exchangeRuleListView == null) {
			// 所有的表格和表单，都在一个类中控制
			exchangeRuleListView = new ExchangeRuleListLayout(exchangeRuleDao);
		}
		return exchangeRuleListView;
	}

	// ---------------------------------------------兑换奖品资料管理
	/**
	 * 兑换奖品资料管理
	 * 
	 * @author zg
	 * **/
	private EXProductListView getEXProductListView() {
		if (exproductManager == null) {
			this.exproductManager = new EXProductManager(nutzDao);
		}

		if (exProductListView == null) {
			// 所有的表格和表单，都在一个类中控制
			exProductListView = new EXProductListView(exproductManager);
		}
		return exProductListView;
	}

	// ---------------------------------------------积分兑换比例管理
	/**
	 * 积分兑换比例管理
	 * 
	 * @author zg
	 * **/
	private ConsumeRuleListView getconsumeRuleListView() {
		if (consumeRuleManager == null) {
			this.consumeRuleManager = new ConsumeRuleManager(nutzDao);
		}

		if (consumeRuleListView == null) {
			// 所有的表格和表单，都在一个类中控制
			consumeRuleListView = new ConsumeRuleListView(consumeRuleManager);
		}
		return consumeRuleListView;
	}

	// ---------------------------------------------积分兑换交易记录
	/**
	 * 积分兑换交易记录
	 * 
	 * @author zg
	 * **/
	private ConsumeExchangeListView getconsumeExchange() {
		if (consumeExchangeManager == null) {
			this.consumeExchangeManager = new ConsumeExchangeManager(nutzDao);
		}

		if (consumeExchangeListView == null) {
			// 所有的表格和表单，都在一个类中控制
			consumeExchangeListView = new ConsumeExchangeListView(
					consumeExchangeManager);
		}
		return consumeExchangeListView;
	}

	

	// ----------------------获取数据源------------------------------
	public PersonReferenceContainer getDataSource() {
		return dataSource;
	}

	public PersonManager getPersonManager() {
		return personManager;
	}

	public MemberInfoMemberBean getMemberManager() {
		return memberManager;
	}
	// --------------------------Demo----------------------
	private void showListView() {
		setMainComponent(this.getListView());
	}

	// --------------------------会员页面--------------------
	private void showMemberListView() {
		setMainComponent(getMemberInfoListView());
	}


	/**
	 * 表格中选中某一行后，跳转到 personForm 表单
	 */
	public void valueChange(ValueChangeEvent event) {
		Property property = event.getProperty();
		// 1 判断是否是对 personList 表格的操作
		if (property == personList) {
			// 2 获取选中那一行的数据 item
			Person person = personManager.getPerson((Integer) personList
					.getValue());
			// 3 跳转到 personForm 并传递数据
			personForm.editContact(person);
		}
	}

	public void itemClick(ItemClickEvent event) {
		if (event.getSource() == tree) {
			Object itemId = event.getItemId();
			log.info(">>>>>>>>>>>>>> 所选中的菜单 :" + itemId);
			if (itemId != null) {
				for (int i = 0; i < Constants.CRM_MENUS_ITEMCLICK.length; i++) {
					String node = Constants.CRM_MENUS_ITEMCLICK[i];
					if (itemId.equals(node)) {
						switch (i) {
						case 0:
							log.info(">>>>>>>>>>>>> 会员资料");
							Notification.show("会员资料");
							setMainComponent(this.getMemberInfoListView());
							break;
						case 1:
							log.info(">>>>>>>>>>>>>  扩展资料");
							Notification.show("扩展资料");
							setMainComponent(this.getMemberAddressListView());
							break;
						case 2:
							log.info(">>>>>>>>>>>>>  会员等级");
							Notification.show("会员等级");
							setMainComponent(this.getMemberLevelListLayout());
							break;
						// case 3:
						// log.info(">>>>>>>>>>>>>  会员活动");
						// Notification.show("会员活动");
						// break;
						case 3:
							log.info(">>>>>>>>>>>>>  会员黑名单");
							Notification.show("会员黑名单");
							setMainComponent(this.getmdInfoListView());
							break;
						case 4:
							log.info(">>>>>>>>>>>>>  诉求类别");
							Notification.show("诉求类别");
							setMainComponent(this.getcomplainTypeListView());
							break;
						case 5:
							log.info(">>>>>>>>>>>>>  会员诉求");
							Notification.show("会员诉求");
							setMainComponent(this.getComplainListView());
							break;
						case 6:
							log.info(">>>>>>>>>>>>>  短信发送");
							Notification.show("短信发送");
							setMainComponent(this.getSMSListView());
							break;
						case 7:
							log.info(">>>>>>>>>>>>> 积分商品类别管理");
							Notification.show("积分商品类别管理");
							setMainComponent(this.getExchangeRuleListView());
							break;
						case 8:
							log.info(">>>>>>>>>>>>>  积分商品明细管理");
							Notification.show("积分商品明细管理");
							setMainComponent(this.getEXProductListView());
							break;
						case 9:
							log.info(">>>>>>>>>>>>>  积分兑换比例管理");
							Notification.show("积分兑换比例管理");
							setMainComponent(this.getconsumeRuleListView());
							break;
						case 10:
							log.info(">>>>>>>>>>>>>  会员积分兑换明细");
							Notification.show("会员积分兑换明细");
							setMainComponent(this.getconsumeExchange());
							break;
						/*
						 * case 12: log.info(">>>>>>>>>>>>>  会员积分调整");
						 * Notification.show("会员积分调整"); break; case 13:
						 * log.info(">>>>>>>>>>>>>  会员积分清除");
						 * Notification.show("会员积分清除"); break; case 14:
						 * log.info(">>>>>>>>>>>>>  会员积分补录");
						 * Notification.show("会员积分补录"); break;
						 */
						default:
							break;
						}
					}
				}
			}
		}
	}

	// 在当前页面，显示表格和表单
	private void addNewContanct() {
		showListView();
		personForm.addContact();
	}

	public void search(SearchFilter searchFilter) {
		QueryMetaData qmd = new QueryMetaData(
				(String) searchFilter.getPropertyId(), searchFilter.getTerm(),
				getDataSource().getQueryMetaData().getOrderBy(),
				getDataSource().getQueryMetaData().getAscending());
		getDataSource().refresh(qmd);
		showListView();

		Notification.show("Searched for " + searchFilter.getPropertyId() + "="
				+ searchFilter.getTerm() + ", found " + getDataSource().size()
				+ " item(s).");
	}

	public void saveSearch(SearchFilter searchFilter) {
		tree.addItem(searchFilter);
		// tree.setParent(searchFilter, NavigationTree.SEARCH);
		// mark the saved search as a leaf (cannot have children)
		tree.setChildrenAllowed(searchFilter, false);
		// make sure "Search" is expanded
		// tree.expandItem(NavigationTree.SEARCH);
		// select the saved search
		tree.setValue(searchFilter);
	}

	// ---------------------------------------------
	// 懒加载，创建新的窗口对象
	private LoginUserInfo getLoginUserInfoWindow() {
		if (loginUser == null) {
			sysUserDao = new SysUserDaoImpl(nutzDao);
			loginUser = new LoginUserInfo(sysUserDao);
		}
		return loginUser;
	}

	// 显示窗口
	private void showLoginUserInfoWindow() {
		UI.getCurrent().addWindow(getLoginUserInfoWindow());
	}
}
