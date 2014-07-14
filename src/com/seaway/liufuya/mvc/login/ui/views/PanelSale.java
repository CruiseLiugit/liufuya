package com.seaway.liufuya.mvc.login.ui.views;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;

/**
 * 在线销售系统管理系统
 * 
 * @author lililiu
 * 
 */
public class PanelSale extends Panel {

	public PanelSale() {
		// TODO Auto-generated constructor stub
	}

	public PanelSale(Component content) {
		super(content);
		// TODO Auto-generated constructor stub
	}

	public PanelSale(String caption) {
		super(caption);
		// TODO Auto-generated constructor stub
		// 这里创建 面板，设置标题
		this.setWidth("200px");
		this.setHeight("380px");

		// 创建 Accordion
		Accordion accordion = new Accordion();
		// 设置在布局中所占空间
		accordion.setSizeFull();
		// 添加 内容 文本组件，这里用 link 组件
		Tree tree1 = new Tree("门店管理");
		tree1.addItem("门店所在城市");
		tree1.addItem("已开门店管理");
		tree1.addItemClickListener(new ItemClickListener() {
			@Override
			public void itemClick(ItemClickEvent event) {
				// System.out.println("tree1 itemClick button Name="+event.getButtonName());
				// System.out.println("tree1 itemClick item :"+event.getItem()+" , itemid :"+event.getItemId()+"  , PropertyId :"+event.getPropertyId());
				String id = (String) event.getItemId();
				if ("门店所在城市".equals(id)) {
					// 切换到新页面
					// UI.getCurrent().setContent(new LoginScreen());
				}
			}
		});

		Tree tree2 = new Tree("商品管理");
		tree2.addItem("商品类目管理");
		tree2.addItem("商品属性管理");
		tree2.addItem("商品资料管理");
		tree2.addItem("优惠直通车管理");
		tree2.addItemClickListener(new ItemClickListener() {
			@Override
			public void itemClick(ItemClickEvent event) {
				// System.out.println("tree1 itemClick button Name="+event.getButtonName());
				// System.out.println("tree1 itemClick item :"+event.getItem()+" , itemid :"+event.getItemId()+"  , PropertyId :"+event.getPropertyId());
				String id = (String) event.getItemId();
				if ("商品类目管理".equals(id)) {
					// 切换到新页面
					// UI.getCurrent().setContent(new LoginScreen());
				}
			}
		});

		Tree tree3 = new Tree("订单管理");
		tree3.addItem("当天订单管理");
		tree3.addItem("订单历史查询");
		tree3.addItem("订单投诉管理");
		tree3.addItemClickListener(new ItemClickListener() {
			@Override
			public void itemClick(ItemClickEvent event) {
				// System.out.println("tree1 itemClick button Name="+event.getButtonName());
				// System.out.println("tree1 itemClick item :"+event.getItem()+" , itemid :"+event.getItemId()+"  , PropertyId :"+event.getPropertyId());
				String id = (String) event.getItemId();
				if ("当天订单管理".equals(id)) {
					// 切换到新页面
					// UI.getCurrent().setContent(new LoginScreen());
				}
			}
		});

		// 添加 手风琴 header 标题
		accordion.addTab(tree1, "门店管理", null);
		accordion.addTab(tree2, "商品管理", null);
		accordion.addTab(tree3, "订单管理", null);
		//accordion.addTab(tree3, "优惠券管理", null);

		this.setContent(accordion);
	}

	public PanelSale(String caption, Component content) {
		super(caption, content);
		// TODO Auto-generated constructor stub
	}

}
