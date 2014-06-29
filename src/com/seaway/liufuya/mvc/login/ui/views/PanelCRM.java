package com.seaway.liufuya.mvc.login.ui.views;

import com.vaadin.ui.Accordion;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

/**
 * CRM 会员管理的菜单
 * @author lililiu
 *
 */
public class PanelCRM extends Panel {

	public PanelCRM() {
		// TODO Auto-generated constructor stub
	}

	public PanelCRM(Component content) {
		super(content);
	}

	public PanelCRM(String caption) {
		super(caption);
		//这里创建 面板，设置标题
		this.setWidth("300px");
		this.setHeight("350px");
		//this.setContent(new Label("This is a Label inside a Panelkjasdkfjaslkfjalksjfasklfjaklsflaksfjkl;asjfl;asjfalsjfaslkfjalskfjlakjflaskdfjasdlkj."));
		
		//创建 Accordion
		Accordion accordion = new Accordion();
		//设置在布局中所占空间
		accordion.setSizeFull();
		//添加 内容  文本组件，这里用 link 组件
		Label l1 = new Label("会员管理");
		Label l2 = new Label("积分管理");
		Label l3 = new Label("门店管理");
		//添加 手风琴 header 标题
		accordion.addTab(l1,"会员管理",null);
		accordion.addTab(l2,"积分管理",null);
		accordion.addTab(l3,"门店管理",null);
		
		
		this.setContent(accordion);
	}

	/**
	 * 这里可以多传有个  nav 对象
	 * @param caption
	 * @param content
	 */
	public PanelCRM(String caption, Component content) {
		super(caption, content);
		// TODO Auto-generated constructor stub
	}

}
