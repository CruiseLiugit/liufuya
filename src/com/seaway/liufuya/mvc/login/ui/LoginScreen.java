package com.seaway.liufuya.mvc.login.ui;

import static com.vaadin.server.Sizeable.Unit.PERCENTAGE;
import static com.vaadin.server.Sizeable.Unit.PIXELS;
import static com.vaadin.ui.Alignment.MIDDLE_CENTER;

import org.nutz.dao.Dao;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.LiufuyaUI;
import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.common.base.MD5;
import com.seaway.liufuya.mvc.login.dao.SysUserDaoImpl;
import com.seaway.liufuya.mvc.login.listener.LoginListener;
import com.seaway.liufuya.mvc.login.model.SysUser;
import com.vaadin.annotations.Theme;
import com.vaadin.data.Property;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.Sizeable;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinSession;
import com.vaadin.server.WrappedSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.Reindeer; //样式

import elemental.events.KeyboardEvent.KeyCode;

/**
 * 第一个页面 程序启动后，用户访问的登录页面
 * 
 * @author lililiu
 * 
 */
public class LoginScreen extends VerticalLayout {
	
	// ------------------------------------------------
	// 登录，访问数据库
	private Dao nutzDao = null;

	//--------------------------------------------------
	

	private static final Log log = Logs.get();
	private Button loginButton = new Button("登录");
	private TextField userNameField = new TextField(
			Strings.isBlank(Constants.lunaLoginUsername) ? "Username"
					: Constants.lunaLoginUsername);
	private PasswordField passwordField = new PasswordField(
			Strings.isBlank(Constants.lunaLoginPassword) ? "Password"
					: Constants.lunaLoginPassword);

	/**
	 * 创建登录页面
	 */
	public LoginScreen() {
		try {
			this.nutzDao = LiufuyaUI.getCurrent().initNutzDao();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 整体布局，上下结构
		//this.setStyleName(Reindeer.LAYOUT_BLUE);
		// 设置整个页面的 页面填充方式
		//this.setSizeFull();
		//this.setMargin(false);// an outer margin (akin to a CSS margin)
		//this.setSpacing(true);// an inner spacing (akin to a CSS padding)

		// ---------------------------------
		// 上面登录 垂直布局
		VerticalLayout main = new VerticalLayout();
		main.setSizeFull();
		main.setMargin(true);
		main.setSpacing(true);
		main.setStyleName(Reindeer.LAYOUT_WHITE);
		this.addComponent(main);

		// ---------------------------------
		// 底部公司介绍 水平布局
		HorizontalLayout footer = LiufuyaUI.getCurrent().getPageFooter();

		// ------上面的 "Logo 和标题布局"------
		HorizontalLayout logo = new HorizontalLayout();
		//logo.setWidth("100%");
		logo.setMargin(true);

		// 欢迎Logo
		Embedded em = new Embedded("", new ThemeResource("img/logo.png"));
		logo.addComponent(em);
		logo.setComponentAlignment(em, Alignment.MIDDLE_CENTER);
		//logo.setExpandRatio(em, 1);
		// 项目标题
		Label title = new Label(Constants.lunaLoginRight);
		title.setSizeUndefined();
		title.addStyleName(Reindeer.LABEL_H1);
		logo.addComponent(title);
		logo.setComponentAlignment(title, Alignment.MIDDLE_CENTER);

		// 相当于 html form 表单
		final FormLayout panelLayout = new FormLayout();
		panelLayout.setMargin(true);
		panelLayout.setSpacing(true);
		panelLayout.setSizeFull();
		//panelLayout.setSizeUndefined();   //按照里面的高宽收缩
		
		// 创建一个 面板
		Panel panel = new Panel();
		panel.setHeight(200, PIXELS); // PIXELS 像素
		panel.setWidth(300, PIXELS); // PIXELS 像素
		panel.setContent(panelLayout);

		
		// 组件
		// 项目标题
		Label captain = new Label("请输入登录账户和密码");
		captain.setSizeUndefined();
		captain.addStyleName(Reindeer.LABEL_H2);

		loginButton.setStyleName(Reindeer.BUTTON_DEFAULT);

		userNameField.setWidth(100, PERCENTAGE); // 按照百分比的设置宽高比例
		userNameField.setRequired(true);
		userNameField.setRequiredError("请输入登录账户名");
		userNameField.focus(); // 获取鼠标焦点

		passwordField.setWidth(100, Unit.PERCENTAGE); // 按照百分比的设置宽高比例
		passwordField.setRequired(true);
		passwordField.setRequiredError("请输入登录密码");

		//设置默认密码
		//userNameField.setValue("admin");
		//passwordField.setValue("admin");

		panelLayout.addComponent(captain);
		panelLayout.addComponent(userNameField);
		panelLayout.addComponent(passwordField);
		panelLayout.addComponent(loginButton);

		// ----------登录界面 end-------------------------
		// 键盘操作
//		final ShortcutListener enter = new ShortcutListener("Sign In",
//				KeyCode.ENTER, null) {
//			@Override
//			public void handleAction(Object sender, Object target) {
//				log.info("键盘回车-----");
//				loginButton.addClickListener(new LoginListener(
//						new UserMenusScreen(), userNameField, passwordField));
//			}
//		};
//		loginButton.addShortcutListener(enter);

		// 按钮点击，第一个参数的下一个新页面的 对象，第二个是 输入框对
		loginButton.addClickListener(new LoginListener(userNameField, passwordField));


		//**********************往 mainLayout 布局中放入上、中、下组件************************
		// -----------------------------
		// 放入一些 Label 组件，占一些控件
		// 解决登录框靠顶部的问题
		Label lbl1 = new Label("");
		lbl1.setHeight("80");
		main.addComponent(lbl1);
		// -----------------------------
		// 设置面板位置
		main.addComponent(logo);
		main.setComponentAlignment(logo, MIDDLE_CENTER);
		main.addComponent(panel);
		main.setComponentAlignment(panel, MIDDLE_CENTER);//
		// --------------------------
		// 下面的占位空间,控制 footer 与登录框之间的间距
		Label lbl2 = new Label("");
		lbl2.setHeight("300");
		main.addComponent(lbl2);
		// --------------------------
		//this.addComponent(footer);
		//this.setExpandRatio(footer, 1);
		main.addComponent(footer);
		// 让水平布局面板占满空间
		main.setExpandRatio(footer, 1);
		//**********************************************************
	}
}
