package com.seaway.liufuya.mvc.crm.ui.layout;

import com.seaway.liufuya.mvc.crm.ui.CrmManageScreen;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.Reindeer;

@SuppressWarnings("serial")
public class ListView extends VerticalLayout {

	public ListView(PersonList personList, final PersonForm personForm) {
		// 右侧创建一个导航工具条,水平布局
		HorizontalLayout navBar = new HorizontalLayout();
		navBar.setStyleName(Reindeer.LAYOUT_BLACK);
		navBar.setWidth(100, Unit.PERCENTAGE);
		navBar.setHeight(29, Unit.PIXELS);
		Label lblNav = new Label("CRM系统 / 会员管理"); // 导航
		Button btnAdd = new Button(); // 增加 按钮
		btnAdd.setIcon(new ThemeResource("icons/19/Add.png"));
		navBar.addComponent(lblNav);
		navBar.addComponent(btnAdd);
		navBar.setComponentAlignment(lblNav, Alignment.MIDDLE_LEFT);
		navBar.setComponentAlignment(btnAdd, Alignment.MIDDLE_RIGHT);
		btnAdd.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				personForm.addContact(); // 增加
			}
		});

		VerticalSplitPanel vsplit = new VerticalSplitPanel();
		vsplit.setStyleName(Reindeer.LAYOUT_WHITE); // 右侧样式
		vsplit.setHeight(470, Unit.PIXELS);
		// this.setStyleName(Reindeer.SPLITPANEL_SMALL); //分割线变细线
		vsplit.setFirstComponent(personList);
		vsplit.setSecondComponent(personForm);
		vsplit.setSplitPosition(40);

		this.addComponent(navBar); // 导航栏
		this.addComponent(vsplit); // 上下分割面板
		this.setExpandRatio(vsplit, 1);
	}
}
