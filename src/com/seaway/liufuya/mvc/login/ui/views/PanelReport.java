package com.seaway.liufuya.mvc.login.ui.views;

import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

/**
 * 报表系统
 * 
 * @author lililiu
 * 
 */
public class PanelReport extends Panel {

	public PanelReport() {
		// TODO Auto-generated constructor stub
	}

	public PanelReport(Component content) {
		super(content);
		// TODO Auto-generated constructor stub
	}

	public PanelReport(String caption) {
		super(caption);
		// TODO Auto-generated constructor stub
		// 这里创建 面板，设置标题
		this.setWidth("300px");

		this.setContent(new Label(
				"This is a Label inside a Panelkjasdkfjaslkfjalksjfasklfjaklsflaksfjkl;asjfl;asjfalsjfaslkfjalskfjlakjflaskdfjasdlkj."));

	}

	public PanelReport(String caption, Component content) {
		super(caption, content);
		// TODO Auto-generated constructor stub
	}

}
