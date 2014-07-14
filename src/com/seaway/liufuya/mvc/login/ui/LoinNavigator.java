package com.seaway.liufuya.mvc.login.ui;

import com.seaway.liufuya.LiufuyaUI;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;

public class LoinNavigator extends VerticalLayout {

	// 导航组件
	Navigator navigator;
	public static final String MAINVIEW = "main";

	public LoinNavigator() {
		// 创建导航对象，并把所有  需要被导航管理的 视图注册到导航中
		navigator = new Navigator(LiufuyaUI.getCurrent(), this); // UI,Layout
		// Create and register the views
		navigator.addView("", new UserMenusScreen(navigator, MAINVIEW));// 跟 ios 导航控制器类似，后进先出
		//navigator.addView(MAINVIEW, new MainView(navigator));
		//..........每个 View 一个名称
	}

	public LoinNavigator(Component compositionRoot) {
		super(compositionRoot);
		// TODO Auto-generated constructor stub
	}

}
