package com.seaway.liufuya.mvc.login.ui.layouts;

import org.nutz.lang.Strings;

import com.seaway.liufuya.common.Constants;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

/**
 * 单独的登录界面，把外界创建的  组件，添加到布局中并排版好
 * 
 * @author lililiu
 *
 */
public class MyLoignForm {

	public MyLoignForm() {
		// TODO Auto-generated constructor stub
	}

	public CssLayout createContent(TextField userNameField,
			PasswordField passwordField, Button loginButton) {
		
	    CssLayout loginPanel = new CssLayout();
		loginPanel.addStyleName("login-panel");

		HorizontalLayout labels = new HorizontalLayout();
		labels.setWidth("100%");
		labels.setMargin(true);
		labels.addStyleName("labels");
		loginPanel.addComponent(labels);

		//欢迎文字
//		Label welcome = new Label("欢迎使用");
//		welcome.setSizeUndefined();
//		welcome.addStyleName("h4");
//		labels.addComponent(welcome);
//		labels.setComponentAlignment(welcome, Alignment.MIDDLE_LEFT);
		//欢迎Logo
		Embedded em = new Embedded("",new ThemeResource("img/logo.jpg"));
		labels.addComponent(em);
		labels.setComponentAlignment(em, Alignment.MIDDLE_LEFT);
		labels.setExpandRatio(em, 1);
		

		Label title = new Label(Constants.lunaLoginRight);
		title.setSizeUndefined();
		title.addStyleName("h2");
		title.addStyleName("light");
		labels.addComponent(title);
		labels.setComponentAlignment(title, Alignment.MIDDLE_RIGHT);

		HorizontalLayout fields = new HorizontalLayout();
		fields.setSpacing(true);
		fields.setMargin(true);
		fields.addStyleName("fields");

		fields.addComponent(userNameField);
		fields.addComponent(passwordField);
		fields.addComponent(loginButton);
		fields.setComponentAlignment(loginButton, Alignment.BOTTOM_LEFT);

		loginPanel.addComponent(fields);
		
		return loginPanel;
	}

}
