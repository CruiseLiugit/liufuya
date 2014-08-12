package com.seaway.liufuya.mvc.crm.consumeexchange.layout;

import java.util.Iterator;
import java.util.List;

import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.mvc.crm.consumeexchange.dao.ConsumeExchangeManager;
import com.seaway.liufuya.mvc.crm.consumeexchange.data.ConsumeExchangeBean;
import com.seaway.liufuya.mvc.crm.consumeexchange.data.MemberBean;
import com.seaway.liufuya.mvc.crm.consumeexchange.service.ConsumeExchangeService;
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
import com.vaadin.ui.VerticalSplitPanel;

public class ConsumeExchangeListView extends VerticalLayout implements ClickListener {

	private ConsumeExchangeManager manager ;
	private ConsumeExchangeService service;
	
	//--------------------------------------开始定义布局需要组建
	private HorizontalSplitPanel vsplit;
	private Table rightTable = new Table();
	private BeanItemContainer<ConsumeExchangeBean> rightcontainer = new BeanItemContainer<ConsumeExchangeBean>(ConsumeExchangeBean.class);
	private Table leftTable = new Table();
	private BeanItemContainer<MemberBean> leftcontainer = new BeanItemContainer<MemberBean>(MemberBean.class);
	
	public ConsumeExchangeListView(ConsumeExchangeManager manager){
		this.manager = manager;
		this.service = new ConsumeExchangeService(manager);
		//---------------------导航部分
		HorizontalLayout navBar = new HorizontalLayout();
		navBar.setStyleName(Reindeer.LAYOUT_BLACK);
		navBar.setWidth(100, Unit.PERCENTAGE);
		navBar.setHeight(29, Unit.PIXELS);
	    Label lblNav = new Label("CRM系统 / 积分兑换明细");
	    
	    vsplit = new HorizontalSplitPanel();
	    initLeftContainer();
	    initLeftTable();
//	    initRightContainer(null);
//	    initRightTable();
	    vsplit.addComponent(leftTable);
	    vsplit.addComponent(rightTable);
		vsplit.setSplitPosition(60);
		vsplit.setStyleName(Reindeer.LAYOUT_WHITE); // 右侧样式
		vsplit.setHeight(470, Unit.PIXELS);
		
	    this.addComponent(navBar);
	    this.addComponent(vsplit);
		
	}

	private void  initLeftContainer(){
		leftcontainer.removeAllItems();
		List<MemberBean> itemBeans =this.service.getAllMember();
		for (Iterator iterator = itemBeans.iterator(); iterator.hasNext();) {
			MemberBean bean = (MemberBean) iterator.next();
			leftcontainer.addItem(bean);
			}
	}
	private void initLeftTable(){
		leftTable.removeAllItems();
		leftTable.setSizeFull();
		leftTable.setHeight(100, Unit.PERCENTAGE);
		leftTable.setContainerDataSource(leftcontainer); // 这里数据源要切换

		leftTable.setVisibleColumns(Constants.CONSUME_MEMBER_COL);
		leftTable.setColumnHeaders(Constants.CONSUME_MEMBER_COL_HEADERS);

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
					initRightContainer(event.getItem().toString().split(" ")[4]);
					rightTable.setContainerDataSource(rightcontainer);
				}
			}
		};
		return icLister;
    }
    
	private void  initRightContainer(String userCode){
		rightcontainer.removeAllItems();
		List<ConsumeExchangeBean> itemBeans =this.service.getAllConsumeExchangeByUserCode(userCode);
		
		for (ConsumeExchangeBean bean:itemBeans) {
			rightcontainer.addItem(bean);
		}

	}
	
	private void initRightTable(){
		rightTable.removeAllItems();
		rightTable.setSizeFull();
		rightTable.setHeight(100, Unit.PERCENTAGE);
		rightTable.setContainerDataSource(rightcontainer); // 这里数据源要切换

		rightTable.setVisibleColumns(Constants.CONSUME_COL);
		rightTable.setColumnHeaders(Constants.CONSUME_COL_HEADERS);

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
