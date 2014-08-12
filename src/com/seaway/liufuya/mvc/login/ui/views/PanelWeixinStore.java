package com.seaway.liufuya.mvc.login.ui.views;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.mvc.weixinstore.WeixinStoreScreen;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;
import com.vaadin.ui.UI;

/**
 * 微信销售系统管理系统
 * 
 * @author lililiu
 * 
 */
public class PanelWeixinStore extends Panel {
	private static final Log log = Logs.get();
	private Tree tree1 = null;  //商品管理
	private Tree tree2 = null;  //订单管理 
	private Tree tree3 = null;  //电子优惠券管理

	public PanelWeixinStore() {
		// TODO Auto-generated constructor stub
	}

	public PanelWeixinStore(Component content) {
		super(content);
		// TODO Auto-generated constructor stub
	}

	public PanelWeixinStore(String caption) {
		super(caption);
		// TODO Auto-generated constructor stub
		// 这里创建 面板，设置标题
		this.setWidth("200px");
		this.setHeight("380px");

		// 创建 Accordion
		Accordion accordion = new Accordion();
		// 设置在布局中所占空间
		accordion.setSizeFull();
		
		//----------------------------------
		tree1 = new Tree("商品管理");
		for (int i = 0; i < Constants.WEIXIN_MENUS_TREE1.length; i++) {
			tree1.addItem(Constants.WEIXIN_MENUS_TREE1[i]);
		}
		tree1.addItemClickListener(new ItemClickListener() {
			@Override
			public void itemClick(ItemClickEvent event) {
				String itemId = (String) event.getItemId();
				if (itemId != null) {
					// 切换到新页面
					UI.getCurrent().setContent(new WeixinStoreScreen(itemId));
				}
			}
		});

		tree2 = new Tree("订单管理");
		for (int i = 0; i < Constants.WEIXIN_MENUS_TREE2.length; i++) {
			tree2.addItem(Constants.WEIXIN_MENUS_TREE2[i]);
		}
		tree2.addItemClickListener(new ItemClickListener() {
			@Override
			public void itemClick(ItemClickEvent event) {
				String itemId = (String) event.getItemId();
				if (itemId != null) {
					// 切换到新页面
					UI.getCurrent().setContent(new WeixinStoreScreen(itemId));
				}
			}
		});
		
		tree3 = new Tree("电子优惠券管理");
		for (int i = 0; i < Constants.WEIXIN_MENUS_TREE3.length; i++) {
			tree3.addItem(Constants.WEIXIN_MENUS_TREE3[i]);
		}
		tree3.addItemClickListener(new ItemClickListener() {
			@Override
			public void itemClick(ItemClickEvent event) {
				String itemId = (String) event.getItemId();
				if (itemId != null) {
					// 切换到新页面
					UI.getCurrent().setContent(new WeixinStoreScreen(itemId));
				}
			}
		});

		/*
         * 允许选中，不允许取消
         */
		tree1.setSelectable(true);
		tree1.setNullSelectionAllowed(false);
		tree2.setSelectable(true);
		tree2.setNullSelectionAllowed(false);
		tree3.setSelectable(true);
		tree3.setNullSelectionAllowed(false);
		
		// 添加 手风琴 header 标题
		accordion.addTab(tree1, "商品管理", null);
		accordion.addTab(tree2, "订单管理", null);
		accordion.addTab(tree3, "电子优惠券管理", null);
		
		this.setContent(accordion);
	}

	public PanelWeixinStore(String caption, Component content) {
		super(caption, content);
		// TODO Auto-generated constructor stub
	}

}
