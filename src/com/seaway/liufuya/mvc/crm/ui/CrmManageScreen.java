package com.seaway.liufuya.mvc.crm.ui;

import org.nutz.dao.Dao;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.BasicDao;
import com.seaway.liufuya.LiufuyaUI;
import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.mvc.crm.memberinfo.dao.impl.MemberInfoMemberBean;
import com.seaway.liufuya.mvc.crm.memberinfo.layout.MemberInfoForm;
import com.seaway.liufuya.mvc.crm.memberinfo.layout.MemberInfoListView;
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
import com.seaway.liufuya.mvc.login.ui.LoginScreen;
import com.seaway.liufuya.mvc.login.ui.UserMenusScreen;
import com.seaway.liufuya.mvc.login.ui.views.PanelCRM;
import com.seaway.liufuya.mvc.login.ui.views.PanelReport;
import com.seaway.liufuya.mvc.login.ui.views.PanelSale;
import com.seaway.liufuya.mvc.login.ui.views.PanelSystemManager;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
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
		ValueChangeListener, ItemClickListener, View {

	private static final Log log = Logs.get();
	public PersonManagerBean personManager;
	private PersonReferenceContainer dataSource;
	
	private BasicDao baseDao = null;
	private Dao nutzDao = null;

	// --------------顶部工具栏组件-----------------------------
	private Button backToMenu = new Button("首页");
	private Button search = new Button("搜索");
	private Button user = new Button("用户");
	private Button logout = new Button("退出");
	private NavigationTree tree = new NavigationTree(this,
			Constants.CRM_MENUS_TREE);

	// ----------------导航页面---------------------------------
	private Navigator navigator = null;
	private String toview = null;
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
	private MemberInfoListView memberListView = null;
	//private MemberInfoList memberList = null;
	private MemberInfoForm memberForm = null;
	public MemberInfoMemberBean memberManager;
	
	/**
	 * 构造函数，初始化界面
	 */
	public CrmManageScreen() {
		log.info("---------init()--------");
		try {
			this.nutzDao = LiufuyaUI.getCurrent().initNutzDao();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("-----------------nutzDao =" + nutzDao);
		//----------------------------------------------------------
		
		buildMainLayout();    //创建空白的启动页面
		//setMainComponent(this.getListView());  //往启动页面右侧添加默认会员管理页面列表
		setMainComponent(this.getMemberInfoListView());  //往启动页面右侧添加默认会员管理页面列表
	}

	/**
	 * 备用方法，用于导航 控制页面跳转
	 * 
	 * @param navigator
	 * @param toview
	 */
	public CrmManageScreen(Navigator navigator, String toview) {
//		this.navigator = navigator;
//		this.toview = toview;
		buildMainLayout();
		setMainComponent(getMemberInfoListView());
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

		if (source == search) {
			showSearchView();
		} else if (source == logout) {
			// showHelpWindow();
			UI.getCurrent().setContent(new LoginScreen());
		} else if (source == user) {
			showShareWindow(); // 当前用户信息页面
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

	
	//---------------------Demo------------------------------------
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
	 * 进入页面默认显示 会员资料界面，可以通过 左侧菜单控制
	 * 
	 * @return
	 */
	private MemberInfoListView getMemberInfoListView() {
		log.info(">>>>>>>>>>>>>>>创建会员列表");
		if (memberManager == null) {
			this.memberManager = new MemberInfoMemberBean(nutzDao);
		}
		
		if (memberListView == null) {
			//所有的表格和表单，都在一个类中控制
			memberListView = new MemberInfoListView(memberManager);
		}
		log.info("MemberInfoListView ="+memberListView);
		return memberListView;
	}

	// ----------------------------------------------------------------
	private SearchView getSearchView() {
		if (searchView == null) {
			searchView = new SearchView(this);
		}
		return searchView;
	}

	private HelpWindow getHelpWindow() {
		if (helpWindow == null) {
			helpWindow = new HelpWindow();
		}
		return helpWindow;
	}

	private SharingOptions getSharingOptions() {
		if (sharingOptions == null) {
			sharingOptions = new SharingOptions();
		}
		return sharingOptions;
	}

	//----------------------获取数据源------------------------------
	public PersonReferenceContainer getDataSource() {
		return dataSource;
	}

	public PersonManager getPersonManager() {
		return personManager;
	}
	

	public MemberInfoMemberBean getMemberManager() {
		return memberManager;
	}
	
	//----------------------获取数据源------------------------------


	private void showHelpWindow() {
		// getMainWindow().addWindow(getHelpWindow());
		UI.getCurrent().addWindow(getHelpWindow());
	}

	private void showShareWindow() {
		UI.getCurrent().addWindow(getSharingOptions());
	}

	//--------------------------Demo----------------------
	private void showListView() {
		setMainComponent(this.getListView());
	}
	//--------------------------会员页面--------------------
	private void showMemberListView() {
		setMainComponent(getMemberInfoListView());
	}

	private void showSearchView() {
		setMainComponent(getSearchView());
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
				for (int i = 0; i < Constants.CRM_MENUS_TREE1.length; i++) {
					String node = Constants.CRM_MENUS_TREE1[i];
					log.info(">>>>>>>>>>node = "+node);
					if (itemId.equals(node)) {
						switch (i) {
						case 0:
							log.info(">>>>>>>>>>>>> 会员界面");
							// 会员资料
							this.getMemberInfoListView();
							break;
						case 1:
							// 扩展资料
							log.info("扩展资料");
							this.getListView();
							break;
						case 2:
							// 会员等级
							log.info("会员等级");
							break;
						case 3:
							// 会员活动
							break;
						case 4:
							// 会员黑名单
							break;
						case 5:
							// 会员诉求
							break;
						case 6:
							// 诉求类别
							break;
						case 7:
							// 短信发送
							break;
						default:
							break;
						}
						if (i == 0) {

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

}
