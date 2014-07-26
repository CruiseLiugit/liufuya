package com.seaway.liufuya.mvc.login.ui.views;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.mvc.crm.ui.CrmManageScreen;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;
import com.vaadin.ui.UI;

/**
 * CRM 会员管理的菜单
 * 
 * @author lililiu
 * 
 */
public class PanelCRM extends Panel implements ItemClickListener {
	private static final Log log = Logs.get();
	private Tree tree1 = null;
	private Tree tree2 = null;
	
	public PanelCRM() {
		// TODO Auto-generated constructor stub
	}

	public PanelCRM(Component content) {
		super(content);
	}

	public PanelCRM(String caption) {
		super(caption);
		// 这里创建 面板，设置标题
		this.setWidth("200px");
		this.setHeight("380px");
		// this.setContent(new
		// Label("This is a Label inside a Panelkjasdkfjaslkfjalksjfasklfjaklsflaksfjkl;asjfl;asjfalsjfaslkfjalskfjlakjflaskdfjasdlkj."));

		// 创建 Accordion
		Accordion accordion = new Accordion();
		// 设置在布局中所占空间
		accordion.setSizeFull();
		// 添加 内容 文本组件，这里用 link 组件
		tree1 = new Tree("会员管理");
		for (int i = 0; i < Constants.CRM_MENUS_TREE1.length; i++) {
			tree1.addItem(Constants.CRM_MENUS_TREE1[i]);
		}
		tree1.addItemClickListener(this);
		
		tree2 = new Tree("积分管理");
		for (int i = 0; i < Constants.CRM_MENUS_TREE2.length; i++) {
			tree2.addItem(Constants.CRM_MENUS_TREE2[i]);
		}
		//tree2.addItemClickListener(this); 
		//这里两个 Tree 公用一个 Listener 无效。所以只能再单独调用一个
		tree2.addItemClickListener(new ItemClickListener() {
			@Override
			public void itemClick(ItemClickEvent event) {
				String itemId = (String) event.getItemId();
				if (itemId != null) {
					//在 CrmManageScreen 类中，根据 itemId 进行判断显示哪个模块
					UI.getCurrent().setContent(new CrmManageScreen(itemId));
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
		

		// 添加 手风琴 header 标题
		accordion.addTab(tree1, "会员管理", null);
		accordion.addTab(tree2, "积分管理", null);
		
		this.setContent(accordion);
	}

	/**
	 * 这里可以多传有个 nav 对象
	 * 
	 * @param caption
	 * @param content
	 */
	public PanelCRM(String caption, Component content) {
		super(caption, content);
		// TODO Auto-generated constructor stub
	}

	
	public void itemClick(ItemClickEvent event) {
		if (event.getSource() == tree1) {
			String itemId = (String)event.getItemId();
			log.info("PanelCrm 面板中，用户选择菜单名称 :"+itemId);
			if (itemId != null) {
				//在 CrmManageScreen 类中，根据 itemId 进行判断显示哪个模块
				UI.getCurrent().setContent(new CrmManageScreen(itemId));
			}
		}
	}
	
}
