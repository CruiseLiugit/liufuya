package com.seaway.liufuya.mvc.login.ui;


import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.LiufuyaUI;
import com.seaway.liufuya.mvc.login.ui.views.PanelCRM;
import com.seaway.liufuya.mvc.login.ui.views.PanelReport;
import com.seaway.liufuya.mvc.login.ui.views.PanelSale;
import com.seaway.liufuya.mvc.login.ui.views.PanelSystemManager;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.Reindeer;


/**
 * 第二个页面 用户登录后，根据权限，显示不同菜单的页面
 * 
 * @author lililiu
 * CustomComponent
 */
public class UserMenusScreen extends CustomComponent implements ClickListener {

	private static final Log log = Logs.get();

	// --------------顶部工具栏组件-----------------------------
	private Button user = new Button("用户");
	private Button logout = new Button("退出");
	private Button help = new Button("帮助");
	
 	
	/**
	 * 构造函数，初始化界面
	 */
	public UserMenusScreen() {
		buildMenuView();
	}
	
	
	/**
	 * 登录成功后，显示的多系统菜单项目
	 */
	private void buildMenuView() {
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

		root.addComponent(createTopToolbar()); // 工具栏
		root.addComponent(createMiddleMenus()); // 下面的左右分割面板
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
		
		
		lo.addComponent(user);
		lo.addComponent(help);
		lo.addComponent(logout);
		lo.setComponentAlignment(user, Alignment.MIDDLE_RIGHT);
		lo.setComponentAlignment(help, Alignment.MIDDLE_RIGHT);
		lo.setComponentAlignment(logout, Alignment.MIDDLE_RIGHT);
		
		user.addClickListener(this);//.addListener((ClickListener) this);
		help.addClickListener(this);
		logout.addClickListener(this);
	
		user.setIcon(new ThemeResource("icons/19/my-account.png"));
		help.setIcon(new ThemeResource("icons/19/Info.png"));
		logout.setIcon(new ThemeResource("icons/19/logout.png"));

		//lo.setMargin(false);
		//lo.setSpacing(true);
		lo.setStyleName(Reindeer.LAYOUT_WHITE);
		lo.setWidth(100,Unit.PERCENTAGE);
		


		return lo;
	}

	
	
	/**
	 * 创建中间的 菜单区域
	 * 
	 * @return
	 */
	public HorizontalLayout createMiddleMenus() {
		HorizontalLayout middleLayout = new HorizontalLayout();
		
		middleLayout.setMargin(true); // Margin
		middleLayout.setSpacing(true); // Padding
		middleLayout.setWidth(100, Unit.PERCENTAGE);
		//vertical.setWidth(Sizeable.SIZE_UNDEFINED, 0);  
		middleLayout.setHeight(500, Unit.PIXELS);
		
		// -------------------------------------
		PanelCRM panel1 = new PanelCRM("CRM管理系统");
		middleLayout.addComponent(panel1);
		middleLayout.setComponentAlignment(panel1, Alignment.MIDDLE_RIGHT);

		PanelSale panel2 = new PanelSale("在线销售管理系统");
		middleLayout.addComponent(panel2);
		middleLayout.setComponentAlignment(panel2, Alignment.MIDDLE_RIGHT);

		PanelReport panel3 = new PanelReport("报表管理系统");
		middleLayout.addComponent(panel3);
		middleLayout.setComponentAlignment(panel3, Alignment.MIDDLE_RIGHT);

		PanelSystemManager panel4 = new PanelSystemManager("系统管理");
		middleLayout.addComponent(panel4);
		middleLayout.setComponentAlignment(panel4, Alignment.MIDDLE_RIGHT);

		return middleLayout;
	}

	

	public void buttonClick(ClickEvent event) {
		final Button source = event.getButton();

		if (source == user) {
			Notification.show("search 按钮");
			//showSearchView();
		} else if (source == help) {
			Notification.show("help 按钮");
			//showHelpWindow();
		} else if (source == logout) {
			Notification.show("您已安全退出系统!");
			UI.getCurrent().setContent(new LoginScreen());
			//showShareWindow();
		} 
	}
	

}
