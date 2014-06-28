package com.seaway.liufuya.mvc.login.ui;

import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.common.Constants;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

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

	// -------------------------------------------------------------
	// 界面组件创建原则：控件提前创建、窗口视图延迟创建
	// 布局
	// 1、CSS 根布局
	CssLayout root = new CssLayout(); // 根
	VerticalLayout loginLayout; // 登录

	// 组件
	private Button loginButton = new Button("登录");
	private TextField userNameField = new TextField(
			Strings.isBlank(Constants.lunaLoginUsername) ? "Username"
					: Constants.lunaLoginUsername);
	private PasswordField passwordField = new PasswordField(
			Strings.isBlank(Constants.lunaLoginPassword) ? "Password"
					: Constants.lunaLoginPassword);

	// -------------------------------------------------------
	// 窗口
	private MyLoignForm loginForm = null;
	// 其他界面
	private HelpManager helpManager; // 帮助页面

	/**
	 * 构造函数，初始化界面
	 */
	public UserLoginScreen() {
		helpManager = new HelpManager(UI.getCurrent());

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

	public UserLoginScreen(Component compositionRoot) {
		super(compositionRoot);
	}

	private void buildLoginView(boolean exit) {
		if (exit) {
			root.removeAllComponents(); // 清空所有组件
		}

//		helpManager.closeAll();	
//		HelpOverlay w = helpManager
//				.addOverlay(
//						"Welcome to the WoodShip Luna",
//						"<p>该程序是一个真实的，可以直接使用的程序, 基于 <a href=\"http://vaadin.com\">Vaadin framework</a>构建.</p><p>用户名:  admin密码:  111 </p><p>源代码地址 <a href=\"https://github.com/woodship/luna\">Luna</a>.</p>",
//						"login");
//		w.center();
//		UI.getCurrent().addWindow(w);
		
		//-----------------------------
		//放入一些 Label 组件，占一些控件
		//解决登录框靠顶部的问题
		Label lbl = new Label("");
		lbl.setHeight("200");
		root.addComponent(lbl);
		//-----------------------------
		
		addStyleName("login");

		// 建立一个垂直布局
		loginLayout = new VerticalLayout();
		loginLayout.setSizeFull();
		loginLayout.addStyleName("login-layout");
		root.addComponent(loginLayout);

		// 创建窗口对象
		loginForm = this.getMyLoignForm();

		// 设置各个输入组件的属性
		userNameField.setRequired(true);
		passwordField.setRequired(true);
		userNameField.focus(); // 获取鼠标焦点
		// loginButton.setClickShortcut(KeyCode.ENTER); // 对应键盘操作
		userNameField.setValue("");
		passwordField.setValue("");

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
					// buildLoginOKScreen(name);
				} else {
					Notification.show("用户名或密码错误，请重新输入.");
				}
			}
		});

	}

	// ------------------------------------------------------------
	// 界面创建方法，提前定义，延迟创建
	public MyLoignForm getMyLoignForm() {
		if (loginForm == null) {
			loginForm = new MyLoignForm();
		}
		return loginForm;
	}

}
