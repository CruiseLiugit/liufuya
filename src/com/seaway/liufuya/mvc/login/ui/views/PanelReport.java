package com.seaway.liufuya.mvc.login.ui.views;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;

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
		this.setWidth("200px");
		this.setHeight("380px");

		// 创建 Accordion
				Accordion accordion = new Accordion();
				// 设置在布局中所占空间
				accordion.setSizeFull();
				// 添加 内容 文本组件，这里用 link 组件
				Tree tree1 = new Tree("门店报表");
				tree1.addItem("门店统计报表");
				tree1.addItem("门店配送报表");
				tree1.addItem("门店销量报表");
				
				tree1.addItemClickListener(new ItemClickListener() {
					@Override
					public void itemClick(ItemClickEvent event) {
						// System.out.println("tree1 itemClick button Name="+event.getButtonName());
						// System.out.println("tree1 itemClick item :"+event.getItem()+" , itemid :"+event.getItemId()+"  , PropertyId :"+event.getPropertyId());
						String id = (String) event.getItemId();
						if ("门店统计报表".equals(id)) {
							// 切换到新页面
							// UI.getCurrent().setContent(new LoginScreen());
						}
					}
				});

				Tree tree2 = new Tree("销售报表");
				tree2.addItem("当天销售情况报表");
				tree2.addItem("历史销售情况报表");
				tree2.addItem("自定义格式报表");
				tree2.addItemClickListener(new ItemClickListener() {
					@Override
					public void itemClick(ItemClickEvent event) {
						// System.out.println("tree1 itemClick button Name="+event.getButtonName());
						// System.out.println("tree1 itemClick item :"+event.getItem()+" , itemid :"+event.getItemId()+"  , PropertyId :"+event.getPropertyId());
						String id = (String) event.getItemId();
						if ("当天销售情况报表".equals(id)) {
							// 切换到新页面
							// UI.getCurrent().setContent(new LoginScreen());
						}
					}
				});

				Tree tree3 = new Tree("会员报表");
				String planet = "会员诉求报表";
				tree3.addItem(planet);
				String t1[] = { "会员诉求情况查询报表", "会员诉求情况汇总查询(类别)报表", "会员诉求情况汇总查询(项目)报表" };
				for (String moon : t1) {
					tree3.addItem(moon);
					// Set it to be a child.
					tree3.setParent(moon, planet);
					// Make the moons look like leaves.
					tree3.setChildrenAllowed(moon, false);
				}

				String p2 = "会员积分报表";
				tree3.addItem(p2);
				String t2[] = { "会员积分查询报表", "会员积分兑奖汇总查询报表", "会员积分兑奖明晰查询报表" };
				for (String moon : t2) {
					tree3.addItem(moon);
					// Set it to be a child.
					tree3.setParent(moon, p2);
					// Make the moons look like leaves.
					tree3.setChildrenAllowed(moon, false);
				}
				
				String p3 = "会员查询报表";
				tree3.addItem(p3);
				String t3[] = { "会员积分报表", "会员清单报表", "会员消费报表","会员月消费报表","会员积分兑奖详情报表","会员消费汇总查询报表","会员消耗积分分析报表","会员卡总积分分析报表","会员来源情况分析报表","消费会员数情况分析","会员每日卡内总积分分析","会员年龄端消费情况分析","会员消费单数情况分析","会员消费金额情况分析","会员分时段消费情况分析","会员来源区域消费情况分析"};
				for (String moon : t3) {
					tree3.addItem(moon);
					// Set it to be a child.
					tree3.setParent(moon, p3);
					// Make the moons look like leaves.
					tree3.setChildrenAllowed(moon, false);
				}

				
				tree3.addItemClickListener(new ItemClickListener() {
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

				// 添加 手风琴 header 标题
				accordion.addTab(tree3, "会员报表", null);
				accordion.addTab(tree1, "门店报表", null);
				accordion.addTab(tree2, "销售报表", null);

				this.setContent(accordion);
	}

	public PanelReport(String caption, Component content) {
		super(caption, content);
		// TODO Auto-generated constructor stub
	}

}
