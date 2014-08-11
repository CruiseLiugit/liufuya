package com.seaway.liufuya.mvc.crm.exchangeproduct.layout;

import java.util.List;
import java.util.Map;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.mvc.crm.exchangeproduct.dao.EXProductManager;
import com.seaway.liufuya.mvc.crm.exchangeproduct.dao.EXRuleBean;
import com.seaway.liufuya.mvc.crm.exchangeproduct.dao.LazyLoadEXProductContainer;
import com.seaway.liufuya.mvc.crm.exchangeproduct.data.EXProduct;
import com.seaway.liufuya.mvc.crm.exchangeproduct.data.EXProductBean;
import com.seaway.liufuya.mvc.crm.exchangeproduct.service.EXProductService;
import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Reindeer;

@SuppressWarnings("serial")
public class EXProductListView extends VerticalLayout implements ClickListener,ItemClickListener {

	private static final Log log = Logs.get();
	//-----------------------定义查询
	EXProductManager manager = null;
	EXProductService service = null;
	
	//------------------------整个页面导航
	HorizontalLayout navBar = new HorizontalLayout();
	
	//----------------------- 整个页面，上下分割的 垂直布局面板
	private final HorizontalSplitPanel vsplit = new HorizontalSplitPanel();
	
	//------------------------ 底部
	private HorizontalLayout footer; 
	
	//-----------------------定义表格需要的
	Table leftTable = null;
	private LazyLoadEXProductContainer container = null;
//	private BeanItemContainer< EXProductBean> container = null;
	private static final int[] COLUMN_WIDTHS = { 80, 60, 60, 70, 70,70,70,70,70 };
	private static final int COLUMN_SPACE = 13;
	
	//----------------------定义表单
	FormLayout addFormlayout = null;
	FormLayout rightFormlayout = null;
	TextField productCode = null;
	NativeSelect exchangeRuleCode =  null;
	TextField productName =  null;
	TextArea productDesc =  null;
	TextField exchangeNumber =  null;
	TextField stockNumber =  null;
	NativeSelect isNew =  null;
	NativeSelect status = null;
	NativeSelect is_recommend = null;
	Button saveButton = null;
	
	//----------------------定义窗体
	Window addWindow = null;
	
	//---------------------开始布局
	public EXProductListView(EXProductManager manager){
		this.manager =  manager;
		service = new EXProductService(manager);
		
		// -----------------------导航工具条
		navBar.setStyleName(Reindeer.LAYOUT_BLACK);
		navBar.setWidth(100, Unit.PERCENTAGE);
		navBar.setHeight(29, Unit.PIXELS);
		Label lblNav = new Label("CRM系统 / 积分商品明细管理");
		Button btnAdd = new Button("新增"); // 增加 按钮
		btnAdd.setIcon(new ThemeResource("icons/16/add.png"));
		btnAdd.setDescription("增加类别");
		btnAdd.addClickListener(addButtonClickLister());
		navBar.addComponent(lblNav);
		navBar.addComponent(btnAdd);
		navBar.setComponentAlignment(btnAdd, Alignment.TOP_RIGHT);// 定义位置

		
		//--------------------------垂直页面布局
		initContainer();
		initLeftTable();
		vsplit.addComponent(leftTable);
		vsplit.setSplitPosition(70);
		vsplit.setStyleName(Reindeer.LAYOUT_WHITE); // 右侧样式
		vsplit.setHeight(470, Unit.PIXELS);
		
		//整个布局完成
		this.addComponent(navBar);
		this.addComponent(vsplit);
		this.setDefaultComponentAlignment(ALIGNMENT_DEFAULT);
		this.setExpandRatio(vsplit, 1);
				
	}
	@Override
	public void itemClick(ItemClickEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void click(ClickEvent event) {
		// TODO Auto-generated method stub

	}

	/**
	 * 添加按钮单击事件
	 * 
	 * @author zg
	 * **/
	private Button.ClickListener addButtonClickLister(){
		Button.ClickListener listener = new Button.ClickListener() {
			
			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				addWindow = new Window("添加产品");
				addWindow.setHeight(420, Unit.PIXELS);
				addWindow.setWidth(300, Unit.PIXELS);
				addWindow.setModal(true);
				addForm();
				addWindow.setContent(addFormlayout);
				getUI().addWindow(addWindow);
			}
		};
		
		return listener;
	}
	
	/**
	 * 左边表格容器初始化
	 * 
	 * @author zg
	 * **/
	private void initContainer(){
//		container = new BeanItemContainer<EXProductBean>(EXProductBean.class);
//	    List<EXProductBean>beans = manager.getAllProduct();
//		for(EXProductBean bean:beans){
//			container.addItem(bean);
//		}
		container = new LazyLoadEXProductContainer(EXProductBean.class, manager);
	}
	
	/**
	 * 左边表格初始化
	 * **/
	private void initLeftTable(){
		leftTable = new Table("详细资料表格");
		leftTable.setSizeFull();
		leftTable.setHeight(100, Unit.PERCENTAGE);
		leftTable.setContainerDataSource(container);
		leftTable.setVisibleColumns(Constants.EXPRODUCT_COL);
		leftTable.setColumnHeaders(Constants.EXPRODUCT_COL_HEADERS_CHINESE);
		leftTable.setPageLength(2);
		leftTable.setCacheRate(4);
		leftTable.setColumnCollapsingAllowed(true);
		leftTable.setColumnReorderingAllowed(true);
		leftTable.addItemClickListener(new ItemClickListener() {
			
			@Override
			public void itemClick(ItemClickEvent event) {
				if(vsplit.getComponentCount()==2)
				vsplit.removeComponent(rightFormlayout);
				initRightForm(event.getItem());
				vsplit.addComponent(rightFormlayout);
			}
		});
	}
	
	/**
	 * 初始化右边form
	 * 
	 * @author zg
	 * **/
	private void initRightForm(Item item){
		rightFormlayout = new FormLayout();
		productCode = new TextField("产品编号");
		exchangeRuleCode =  new NativeSelect("积分兑换规则");
		productName =  new TextField("产品名称");
		productDesc =  new TextArea("产品描述");
		exchangeNumber =  new TextField("兑换积分");
		stockNumber =  new TextField("库存数目");
	     isNew =  new NativeSelect("新品");
		isNew.addItems(0,1);
		isNew.setItemCaption(0, "否");
		isNew.setItemCaption(1, "是");
		status = new NativeSelect("启用");
		status.addItems(0,1);
		status.setItemCaption(0, "否");
		status.setItemCaption(1, "是");
		is_recommend = new NativeSelect("推荐");
		is_recommend.addItems(0,1);
		is_recommend.setItemCaption(0, "否");
		is_recommend.setItemCaption(1, "是");
		saveButton = new Button ("保存");
		saveButton.addClickListener(buttonLister());
		
		rightFormlayout.addComponents(productCode,exchangeRuleCode,productName,exchangeRuleCode,productName,productDesc,exchangeNumber
				,stockNumber,isNew,status,is_recommend,saveButton);
		if(item != null){
			BeanFieldGroup<EXProduct> bindingFiles = new BeanFieldGroup<EXProduct>(
					EXProduct.class);
			bindingFiles.setItemDataSource(item);
			bindingFiles.setBuffered(true);
			bindingFiles.bindMemberFields(this); // 绑定
			String code=manager.findAllExRuleCodeByName(exchangeRuleCode.getValue().toString()).get(0);
			exchangeRuleCode.addItem(code);
			exchangeRuleCode.setItemCaption(code, exchangeRuleCode.getValue().toString());
			exchangeRuleCode.select(code);
			if(isNew.getValue().equals("是")){
				isNew.select(1);
			}else{
				isNew.select(0);
			}
			if(status.getValue().equals("是")){
				status.select(1);
			}else{
				status.select(0);
			}
			if(is_recommend.getValue().equals("是")){
				is_recommend.select(1);
			}else{
				is_recommend.select(0);
			}
			productCode.setEnabled(false);
		}
	}
	
	/**
	 * button   保存新增或者修改
	 * */
	private Button.ClickListener buttonLister(){
		Button.ClickListener lister = new Button.ClickListener() {
			
			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				EXProduct product = new EXProduct();
				product.setExchangeNumber(exchangeNumber.getValue());
				product.setExchangeRuleCode(exchangeRuleCode.getValue().toString());
				product.setIs_recommend(is_recommend.getValue().toString());
				product.setIsNew(isNew.getValue().toString());
				product.setProductDesc(productDesc.getValue());
				product.setProductName(productName.getValue());
				product.setStatus(status.getValue().toString());
				product.setStockNumber(Integer.valueOf(stockNumber.getValue()));
				
				//产品编码为空则为新增  否则即为修改
				if(event.getButton().getCaption().equals("保存")){
					product.setProductCode(productCode.getValue());
					manager.updateEXProduct(product);
					Notification.show("成功");
				  }else if (event.getButton().getCaption().equals("添加")){
					  manager.addEXProduct(product);
					  Notification.show("新增数据成功");
					  if(addWindow != null)
						  addWindow.close();
					      
					  initContainer();
					  leftTable.setContainerDataSource(container);
					  vsplit.setFirstComponent(leftTable);
				  }
				}
		};
		return lister;
	}
	
	/**
	 * 初始化添加表格
	 * 
	 * @author zg
	 * **/
	private void addForm(){
        addFormlayout = new FormLayout();
		//productCode = new TextField("产品编号");
		productName =  new TextField("产品名称");
		productDesc =  new TextArea("产品描述");
		exchangeNumber =  new TextField("兑换积分");
		stockNumber =  new TextField("库存数目");
	     isNew =  new NativeSelect("新品");
		isNew.addItems(0,1);
		isNew.setItemCaption(0, "否");
		isNew.setItemCaption(1, "是");
		status = new NativeSelect("启用");
		status.addItems(0,1);
		status.setItemCaption(0, "否");
		status.setItemCaption(1, "是");
		is_recommend = new NativeSelect("推荐");
		is_recommend.addItems(0,1);
		is_recommend.setItemCaption(0, "否");
		is_recommend.setItemCaption(1, "是");
		exchangeRuleCode =  new NativeSelect("积分兑换规则");
		List<EXRuleBean> list = manager.findAllExRuleCodeAndName();
		for(EXRuleBean bean:list){
			exchangeRuleCode.addItem(bean.getCode());
			exchangeRuleCode.setItemCaption(bean.getCode(),bean.getName());
		}
		saveButton = new Button ("添加");
		saveButton.addClickListener(buttonLister());
		
		addFormlayout.addComponents(exchangeRuleCode,productName,exchangeRuleCode,productName,productDesc,exchangeNumber
				,stockNumber,isNew,status,is_recommend,saveButton);
		}
}
