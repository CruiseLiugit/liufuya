package com.seaway.liufuya.mvc.login.ui.views;

import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.mvc.crm.ui.CrmManageScreen;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

/**
 * CRM 会员管理的菜单
 * 
 * @author lililiu
 * 
 */
public class PanelCRM extends Panel implements ItemClickListener {

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
		
		tree2.addItemClickListener(new ItemClickListener() {
			@Override
			public void itemClick(ItemClickEvent event) {
				// System.out.println("tree1 itemClick button Name="+event.getButtonName());
				// System.out.println("tree1 itemClick item :"+event.getItem()+" , itemid :"+event.getItemId()+"  , PropertyId :"+event.getPropertyId());
				String id = (String) event.getItemId();
				if ("兑换奖品资料管理".equals(id)) {
					// 切换到新页面
					// UI.getCurrent().setContent(new LoginScreen());
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
			UI.getCurrent().setContent(new CrmManageScreen());
			
//			Object itemId = event.getItemId();
//			if (itemId != null) {
//				if ("会员资料".equals(itemId)) {
//					//getDataSource().refresh(PersonReferenceContainer.defaultQueryMetaData);
//					//showListView();
//					
////					Button btn = new Button("Go to MainView", new Button.ClickListener() {
////
////						@Override
////						public void buttonClick(ClickEvent event) {
////							// TODO Auto-generated method stub
////							navigator.navigateTo(mainview);  //传递名称
////						}
////					});
//					
//					//Notification.show("会员资料");
//					// 切换到新页面
//					UI.getCurrent().setContent(new CrmManageScreen());
//					//进入界面，需要传递信息，表示当前要看到的是    会员资料。进入后默认显示会员列表信息
//					
//				} else if ("扩展资料".equals(itemId)) {
//					//showSearchView();
//					Notification.show("扩展资料");
//				} else if ("会员等级".equals(itemId)) {
//					//search((SearchFilter) itemId);
//					Notification.show("会员等级");
//				}
//			}
		}
	}
	
}
