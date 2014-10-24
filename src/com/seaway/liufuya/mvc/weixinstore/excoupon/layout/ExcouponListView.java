package com.seaway.liufuya.mvc.weixinstore.excoupon.layout;

import java.util.Iterator;
import java.util.List;

import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.mvc.crm.consumeexchange.data.ConsumeExchangeBean;
import com.seaway.liufuya.mvc.crm.memberinfo.data.Member;
import com.seaway.liufuya.mvc.weixinstore.excoupon.dao.ExcouponManager;
import com.seaway.liufuya.mvc.weixinstore.excoupon.data.Excoupon;
import com.seaway.liufuya.mvc.weixinstore.excoupon.service.ExcouponService;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.shared.MouseEventDetails.MouseButton;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.Reindeer;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class ExcouponListView extends VerticalLayout implements ClickListener {

	private ExcouponManager manager ;
	private ExcouponService service;
	
	//--------------------------------------开始定义布局需要组建
	private HorizontalSplitPanel vsplit;
	private Table rightTable = new Table();
	private BeanItemContainer<Excoupon> rightcontainer = new BeanItemContainer<Excoupon>(Excoupon.class);
	private Table leftTable = new Table();
	private BeanItemContainer<Member> leftcontainer = new BeanItemContainer<Member>(Member.class);
	
	public ExcouponListView(ExcouponManager manager){
		this.manager = manager;
		this.service = new ExcouponService(manager);
		//---------------------导航部分
		HorizontalLayout navBar = new HorizontalLayout();
		navBar.setStyleName(Reindeer.LAYOUT_BLACK);
		navBar.setWidth(100, Unit.PERCENTAGE);
		navBar.setHeight(29, Unit.PIXELS);
	    Label lblNav = new Label("微信系统 / 优惠券兑换明细");
	    navBar.addComponent(lblNav);
	    vsplit = new HorizontalSplitPanel();
	    initLeftContainer();
	    initLeftTable();
//	    initRightContainer(null);
//	    initRightTable();
	    vsplit.addComponent(leftTable);
	    vsplit.addComponent(rightTable);
		//vsplit.setSplitPosition(60);
	    vsplit.setSplitPosition(90);
		vsplit.setStyleName(Reindeer.LAYOUT_WHITE); // 右侧样式
		vsplit.setHeight(Constants.PAGE_HEIGHT, Unit.PIXELS);  //470
		
	    this.addComponent(navBar);
	    this.addComponent(vsplit);
		
	}

	private void  initLeftContainer(){
		leftcontainer.removeAllItems();
		List<Member> itemBeans =this.service.getAllMember();
		for (Iterator iterator = itemBeans.iterator(); iterator.hasNext();) {
			Member bean = (Member) iterator.next();
			leftcontainer.addItem(bean);
			}
	}
	private void initLeftTable(){
		leftTable.removeAllItems();
		leftTable.setSizeFull();
		leftTable.setHeight(Constants.PAGE_HEIGHT, Unit.PERCENTAGE);
		leftTable.setContainerDataSource(leftcontainer); // 这里数据源要切换

		leftTable.setVisibleColumns(Constants.EXCOUPON_MEMBER_COL);
		leftTable.setColumnHeaders(Constants.EXCOUPON_MEMBER_COL_HEADERS);

		leftTable.setColumnCollapsingAllowed(true);
		leftTable.setColumnReorderingAllowed(true);

		leftTable.setSelectable(true);
		leftTable.setImmediate(true);
		leftTable.setNullSelectionAllowed(false);
		leftTable.addItemClickListener(itemClick());
	}
	  /**
     * item 单击更新时间
     * 
     * @author zg
     * **/
    private ItemClickListener itemClick(){
    	ItemClickListener icLister = new ItemClickListener() {

			@Override
			public void itemClick(ItemClickEvent event) {
				if (event.getButtonName().equals(MouseButton.LEFT.getName())) {
					System.out.println("*****************event.getItem()  :"+event.getItem().toString());
					
//					initRightContainer(event.getItem().toString().split(" ")[39]);
//					initRightTable();
//					rightTable.setContainerDataSource(rightcontainer);
				}
			}
		};
		return icLister;
    }
    
	private void  initRightContainer(String userCode){
		rightcontainer.removeAllItems();
		List<Excoupon> itemBeans =this.service.getExcouponByMemCode(userCode);
		
		for (Excoupon bean:itemBeans) {
			rightcontainer.addItem(bean);
		}

	}
	
	private void initRightTable(){
		//rightTable.removeAllItems();
		rightTable.setSizeFull();
		rightTable.setHeight(100, Unit.PERCENTAGE);
		rightTable.setContainerDataSource(rightcontainer); // 这里数据源要切换
		
		rightTable.setVisibleColumns(Constants.EXCOUPON_COL);
		rightTable.setColumnHeaders(Constants.EXCOUPON_COL_HEADERS_CHINESE);
		
		rightTable.setColumnCollapsingAllowed(true);
		rightTable.setColumnReorderingAllowed(true);

		rightTable.setSelectable(true);
		rightTable.setImmediate(true);
		rightTable.setNullSelectionAllowed(false);
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
	
	}

}
