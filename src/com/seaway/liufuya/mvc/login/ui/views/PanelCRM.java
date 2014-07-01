package com.seaway.liufuya.mvc.login.ui.views;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;
import com.vaadin.ui.UI;

/**
 * CRM 会员管理的菜单
 * 
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
		// 这里创建 面板，设置标题
		this.setWidth("260px");
		this.setHeight("380px");
		// this.setContent(new
		// Label("This is a Label inside a Panelkjasdkfjaslkfjalksjfasklfjaklsflaksfjkl;asjfl;asjfalsjfaslkfjalskfjlakjflaskdfjasdlkj."));

		// 创建 Accordion
		Accordion accordion = new Accordion();
		// 设置在布局中所占空间
		accordion.setSizeFull();
		// 添加 内容 文本组件，这里用 link 组件
		Tree tree1 = new Tree("会员管理");
		tree1.addItem("会员资料");
		tree1.addItem("扩展资料");
		tree1.addItem("会员等级");
		tree1.addItem("会员活动");
		tree1.addItem("会员黑名单");
		tree1.addItem("会员诉求");
		tree1.addItem("诉求类别");
		tree1.addItem("短信发送");
		tree1.addItemClickListener(new ItemClickListener() {
			@Override
			public void itemClick(ItemClickEvent event) {
				// System.out.println("tree1 itemClick button Name="+event.getButtonName());
				// System.out.println("tree1 itemClick item :"+event.getItem()+" , itemid :"+event.getItemId()+"  , PropertyId :"+event.getPropertyId());
				String id = (String) event.getItemId();
				if ("会员资料".equals(id)) {
					// 切换到新页面
					// UI.getCurrent().setContent(new LoginScreen());
				}
			}
		});

		Tree tree2 = new Tree("积分管理");
		tree2.addItem("兑换奖品资料管理");
		tree2.addItem("消费积分规则管理");
		tree2.addItem("兑奖规则信息管理");
		tree2.addItem("会员积分兑换管理");
		tree2.addItem("会员积分调整");
		tree2.addItem("会员积分清除");
		tree2.addItem("会员积分补录");
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

}
