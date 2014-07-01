package com.seaway.liufuya.mvc.login.ui;

import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.mvc.login.ui.layouts.MyLoignForm;
import com.seaway.liufuya.mvc.login.ui.views.PanelCRM;
import com.seaway.liufuya.mvc.login.ui.views.PanelReport;
import com.seaway.liufuya.mvc.login.ui.views.PanelSale;
import com.seaway.liufuya.mvc.login.ui.views.PanelSystemManager;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;

import elemental.events.KeyboardEvent.KeyCode;

/**
 * 启动后，调用登录界面的类
 * 
 * @author lililiu
 * 
 */
public class UserLoginScreen extends CustomComponent {

	private static final Log log = Logs.get();
	private static final long serialVersionUID = -4835992723502900986L;

	// -----------------------------登录窗口--------------------------------
	// 界面组件创建原则：控件提前创建、窗口视图延迟创建
	// 布局
	// 1、CSS 根布局
	private CssLayout root = new CssLayout(); // 根布局
	private VerticalLayout loginLayout; // 登录页面布局
	private VerticalLayout menusLayout = null; // 菜单页面布局

	// 组件
	private Button loginButton = new Button("登录");
	private TextField userNameField = new TextField(
			Strings.isBlank(Constants.lunaLoginUsername) ? "Username"
					: Constants.lunaLoginUsername);
	private PasswordField passwordField = new PasswordField(
			Strings.isBlank(Constants.lunaLoginPassword) ? "Password"
					: Constants.lunaLoginPassword);

	// --------------顶部工具栏组件-----------------------------
	private Button newContact = new Button("Add contact");
	private Button search = new Button("Search");
	private Button share = new Button("Share");
	private Button help = new Button("帮助");

	// -------------------------------------------------------
	// 窗口
	private MyLoignForm loginForm = null;

	// ------------------------菜单窗口-------------------------
	//
	private HorizontalLayout middleLayout = null;

	/**
	 * 构造函数，初始化界面
	 */
	public UserLoginScreen() {
		// 把 根放入当前 UI 界面中
		setCompositionRoot(root);
		root.addStyleName("root"); // 添加根的样式
		root.setSizeFull(); // 设置满屏

		// Unfortunate to use an actual widget here, but since CSS generated
		// elements can't be transitioned yet, we must
		Label bg = new Label();
		bg.setSizeUndefined();
		bg.addStyleName("login-bg");
		root.addComponent(bg);

		buildLoginView(false);

	}

	// -----------------------------------------------------------------
	// 创建登录窗口界面
	private void buildLoginView(boolean exit) {
		if (exit) {
			root.removeAllComponents(); // 清空所有组件
		}

		// -----------------------------
		// 放入一些 Label 组件，占一些控件
		// 解决登录框靠顶部的问题
		Label lbl = new Label("");
		lbl.setHeight("170");
		root.addComponent(lbl);
		// -----------------------------

		addStyleName("login"); // 添加登录样式

		// 建立一个垂直布局
		loginLayout = new VerticalLayout();
		loginLayout.setSizeFull();
		loginLayout.addStyleName("login-layout"); // 登录界面布局样式
		root.addComponent(loginLayout);

		// 创建窗口对象
		loginForm = this.getMyLoignForm();

		// 设置各个输入组件的属性
		userNameField.setRequired(true);
		passwordField.setRequired(true);
		userNameField.focus(); // 获取鼠标焦点
		// loginButton.setClickShortcut(KeyCode.ENTER); // 对应键盘操作
		userNameField.setValue("liu");
		passwordField.setValue("liu");

		// 键盘操作
		final ShortcutListener enter = new ShortcutListener("Sign In",
				KeyCode.ENTER, null) {
			@Override
			public void handleAction(Object sender, Object target) {
				log.info("键盘回车-----");
				loginButton.click();
			}
		};
		loginButton.addShortcutListener(enter);

		// 组装 登录界面中的各个组件
		CssLayout loginPanel = loginForm.createContent(userNameField,
				passwordField, loginButton);
		loginLayout.addComponent(loginPanel);
		loginLayout.setComponentAlignment(loginPanel, Alignment.MIDDLE_CENTER);

		// 处理 登录按钮操作
		loginButton.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				String name = userNameField.getValue();
				String pwd = passwordField.getValue();

				if (name.equals("liu") && pwd.equals("liu")) {
					root.removeAllComponents(); // 清除当前布局容器中所有组件
					log.info("登录成功.........");
					// 创建登录成功，选择菜单界面
					// 根据用户角色 显示不同的菜单项目
					buildMenuView();
				} else {
					Notification.show("用户名或密码错误，请重新输入.");
				}
			}
		});

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

		removeStyleName("login");
		root.removeComponent(loginLayout);

		// 开始构建视图
		menusLayout = new VerticalLayout();
		menusLayout.setSizeFull(); // 满屏

		menusLayout.addComponent(createTopToolbar()); // 工具栏
		menusLayout.addComponent(createMiddleMenus()); // 下面的左右分割面板
		menusLayout.addComponent(createBottomFooter()); // 底部公司版权说明

		// 让水平布局面板占满空间
		menusLayout.setExpandRatio(middleLayout, 1);

		// 把默认得 垂直布局添加到当前 UI 中
		root.addComponent(menusLayout);
	}

	/**
	 * 创建简单的工具栏
	 * 
	 * @return
	 */
	public HorizontalLayout createTopToolbar() {
		HorizontalLayout lo = new HorizontalLayout();

		lo.setMargin(true); // Margin
		lo.setSpacing(true); // Padding
		lo.setStyleName("toolbar");
		lo.setWidth(100, Unit.PERCENTAGE);

		lo.addComponent(newContact);
		lo.addComponent(search);
		lo.addComponent(share);
		lo.addComponent(help);
		// 美化按钮
		search.setIcon(new ThemeResource("icons/32/folder-add.png"));
		share.setIcon(new ThemeResource("icons/32/users.png"));
		help.setIcon(new ThemeResource("icons/32/help.png"));
		newContact.setIcon(new ThemeResource("icons/32/document-add.png"));

		Embedded em = new Embedded("", new ThemeResource("images/logo.png"));
		lo.addComponent(em);
		lo.setComponentAlignment(em, Alignment.MIDDLE_RIGHT);
		lo.setExpandRatio(em, 1);

		return lo;
	}

	/**
	 * 创建中间的 菜单区域
	 * 
	 * @return
	 */
	public HorizontalLayout createMiddleMenus() {
		middleLayout = new HorizontalLayout();

		middleLayout.setMargin(true); // Margin
		middleLayout.setSpacing(true); // Padding
		middleLayout.setWidth(100, Unit.PERCENTAGE);

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

	/**
	 * 创建页面底部版权说明
	 * 
	 * @return
	 */
	public HorizontalLayout createBottomFooter() {
		HorizontalLayout lo = new HorizontalLayout();
		lo.setWidth("100%");
		lo.setMargin(true);
		lo.addStyleName("labels");

		Label lbcopyright = new Label("Copyright &copy; 2014");
		lbcopyright.setSizeUndefined();
		lbcopyright.addStyleName("h2");
		lbcopyright.addStyleName("light");

		Label lbcompany = new Label("上海释伟科技有限公司");

		Label lbdesc = new Label("留夫鸭电子商务O2O解决方案");

		lo.addComponent(lbcopyright);
		lo.setComponentAlignment(lbcopyright, Alignment.MIDDLE_LEFT);
		lo.addComponent(lbcompany);
		lo.addComponent(lbdesc);

		return lo;
	}

	// ------------------------------------------------------------
	// 界面创建方法，提前定义，延迟创建
	private MyLoignForm getMyLoignForm() {
		if (loginForm == null) {
			loginForm = new MyLoignForm();
		}
		return loginForm;
	}

}
