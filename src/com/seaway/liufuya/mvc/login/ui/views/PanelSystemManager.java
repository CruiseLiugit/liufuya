package com.seaway.liufuya.mvc.login.ui.views;

import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

/**
 * 系统管理面板
 * 
 * @author lililiu
 * 
 */
public class PanelSystemManager extends Panel {

	public PanelSystemManager() {
		// TODO Auto-generated constructor stub
	}

	public PanelSystemManager(Component content) {
		super(content);
		// TODO Auto-generated constructor stub
	}

	public PanelSystemManager(String caption) {
		super(caption);
		// TODO Auto-generated constructor stub
		// 这里创建 面板，设置标题
		this.setWidth("300px");

		this.setContent(new Label(
				"This is a Label inside a Panelkjasdkfjaslkfjalksjfasklfjaklsflaksfjkl;asjfl;asjfalsjfaslkfjalskfjlakjflaskdfjasdlkj."));

	}

	public PanelSystemManager(String caption, Component content) {
		super(caption, content);
		// TODO Auto-generated constructor stub
	}

}
