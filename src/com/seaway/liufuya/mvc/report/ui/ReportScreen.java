package com.seaway.liufuya.mvc.report.ui;

import org.nutz.dao.Dao;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.LiufuyaUI;
import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.mvc.crm.memberinfo.dao.impl.MemberInfoMemberBean;
import com.seaway.liufuya.mvc.crm.memberinfo.layout.MemberInfoListView;
import com.seaway.liufuya.mvc.crm.ui.layout.HelpWindow;
import com.seaway.liufuya.mvc.crm.ui.layout.NavigationTree;
import com.seaway.liufuya.mvc.crm.ui.layout.PersonForm;
import com.seaway.liufuya.mvc.crm.ui.layout.PersonList;
import com.seaway.liufuya.mvc.crm.ui.layout.SearchView;
import com.seaway.liufuya.mvc.crm.ui.layout.SharingOptions;
import com.seaway.liufuya.mvc.login.ui.LoginScreen;
import com.seaway.liufuya.mvc.login.ui.UserMenusScreen;
import com.seaway.liufuya.mvc.report.memberinfo.layout.MemberInfoReportView;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

/**
 * CRM 管理模块的整体界面
 * 
 * @author lililiu
 * 
 */
public class ReportScreen extends CustomComponent implements ClickListener,
		ValueChangeListener, ItemClickListener {

	private static final Log log = Logs.get();

	private Dao nutzDao = null;
	
	private SearchView searchView = null;  //顶部搜索按钮对应窗口
	private HelpWindow helpWindow = null;  //帮助界面按钮对应窗口
	private SharingOptions sharingOptions = null; //

	// --------------顶部工具栏组件-----------------------------
	private Button backToMenu = new Button("首页");
	private Button search = new Button("搜索");
	private Button user = new Button("用户");
	private Button logout = new Button("退出");
	private NavigationTree tree = new NavigationTree(this,
			Constants.CRM_REPORT_TREE);

	// 会员资料组件
	private MemberInfoReportView memberInfoReportView = null;

	// 数据库对象
	public MemberInfoMemberBean memberManager; // 会员管理

	// ----------------主界面内容-------------------------------
	private HorizontalSplitPanel horizontalSplit = new HorizontalSplitPanel();

	/**
	 * 构造函数，初始化界面
	 */
	public ReportScreen() {
	}

	public ReportScreen(String itemId) {
		log.info("---------init()--------");
		try {
			this.nutzDao = LiufuyaUI.getCurrent().initNutzDao();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ----------------------------------------------------------

		buildMainLayout(); // 创建空白的启动页面

		if ("会员查询报表".equals(itemId)) {
			Notification.show("会员查询报表");
			setMainComponent(this.getMemberReportView()); // 往启动页面右侧添加默认会员管理页面列表
		}

	}

	private void setMainComponent(Component c) {
		horizontalSplit.setSecondComponent(c); // 添加到第二个分割面板中
	}

	/**
	 * 进入页面默认显示 会员资料界面，可以通过 左侧菜单控制 会员资料页面
	 * 
	 * @return
	 */
	private MemberInfoReportView getMemberReportView() {
		log.info(">>>>>>>>>>>>>>>创建会员列表");
		if (memberManager == null) {
			this.memberManager = new MemberInfoMemberBean(nutzDao);
		}

		if (memberInfoReportView == null) {
			// 所有的表格和表单，都在一个类中控制
			memberInfoReportView = new MemberInfoReportView(memberManager);
		}
		log.info("MemberInfoListView =" + memberInfoReportView);
		return memberInfoReportView;
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
		horizontalSplit.setStyleName(Reindeer.SPLITPANEL_SMALL); // 分割线变细线
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
			//showSearchView();
		} else if (source == logout) {
			// showHelpWindow();
			UI.getCurrent().setContent(new LoginScreen());
		} else if (source == user) {
			//showShareWindow(); // 当前用户信息页面
		} else if (source == backToMenu) {
			// addNewContanct();
			UI.getCurrent().setContent(new UserMenusScreen());
		}
	}


	/**
	 * 当前页面，左侧菜单，点击后的 事件响应
	 */
	@Override
	public void itemClick(ItemClickEvent event) {
		if (event.getSource() == tree) {
			Object itemId = event.getItemId();
			log.info(">>>>>>>>>>>>>> 所选中的菜单 :" + itemId);
			if (itemId != null) {
				for (int i = 0; i < Constants.CRM_REPORT_ITEMCLICK.length; i++) {
					String node = Constants.CRM_REPORT_ITEMCLICK[i];
					if (itemId.equals(node)) {
						switch (i) {
						case 0:
							log.info(">>>>>>>>>>>>> 会员查询报表");
							Notification.show("会员查询报表");
							setMainComponent(this.getMemberReportView());
							break;
						case 1:
							log.info(">>>>>>>>>>>>>  会员诉求报表");
							Notification.show("会员诉求报表");
							//setMainComponent(this.getMemberAddressListView());
							break;
						case 2:
							log.info(">>>>>>>>>>>>>  门店统计报表");
							Notification.show("门店统计报表");
							//setMainComponent(this.getMemberLevelListLayout());
							break;
						case 3:
							log.info(">>>>>>>>>>>>>  当天销售情况报表");
							Notification.show("当天销售情况报表");
							break;
						case 4:
							log.info(">>>>>>>>>>>>>  历史销售情况报表");
							Notification.show("历史销售情况报表");
							//setMainComponent(this.getmdInfoListView());
							break;
						case 5:
							log.info(">>>>>>>>>>>>>  自定义格式报表");
							Notification.show("自定义格式报表");
							//setMainComponent(this.getcomplainTypeListView());
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

	@Override
	public void valueChange(ValueChangeEvent event) {
		// TODO Auto-generated method stub

	}

	// --------------------------------------------------------
//	private void showSearchView() {
//		setMainComponent(getSearchView());
//	}

	// ----------------------------------------------------------------
//	private SearchView getSearchView() {
//		if (searchView == null) {
//			searchView = new SearchView(this);
//		}
//		return searchView;
//	}

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

}
