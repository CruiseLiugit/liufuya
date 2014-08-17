package com.seaway.liufuya.mvc.weixinstore.product.layout;

import java.util.List;

import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.mvc.weixinstore.product.dao.WXProductManager;
import com.seaway.liufuya.mvc.weixinstore.product.data.CategoryBean;
import com.seaway.liufuya.mvc.weixinstore.product.data.WXProduct;
import com.seaway.liufuya.mvc.weixinstore.product.services.WXProductService;
import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
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
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Reindeer;

/**
 * 微信模块 商品类目管理主界面
 * 
 * @author zg
 * **/
public class WXProductListView extends VerticalLayout {

	private WXProductManager manager = null;
	private WXProductService service = null;

	// -----------------------------------------------定义布局组件
	// -----------标题
	HorizontalLayout navBar = new HorizontalLayout();
	Label lblNav = new Label("微信系统 /商品资料管理");
	Button addBtn = new Button("增加");
	Window window = new Window("增加");

	// -----------正文
	private HorizontalSplitPanel vsplit;
	// -----------左边table
	private Table table = new Table();
	private BeanItemContainer  container;

	// -----------右边form
	private FormLayout form = new FormLayout();
	private FormLayout form1 = new FormLayout();
	private TextField productCode = new TextField("产品代码");
	private NativeSelect category_code = new NativeSelect("类别名");
	private TextField productName = new TextField("产品名");
	private TextArea productDesc = new TextArea("产品描述");
	private TextField pic = new TextField("产品图片路径");
	private TextField price = new TextField("价格");
	private TextField cheapPrice = new TextField("打折价格");
	private NativeSelect unit = new NativeSelect("单位");
	private TextField otherUnit = new TextField("其他单位");
	private NativeSelect package_type = new NativeSelect("包装类型呢");
	private NativeSelect taste = new NativeSelect("口味");
	private NativeSelect status = new NativeSelect("状态");
	private Button saveButton = new Button("修改");
	private Button addBtn1 = new Button("增加");

	// -----------------------------------------------构造 开始初始化布局
	public WXProductListView(WXProductManager manager){
		
		this.manager = manager;
		service = new WXProductService(manager);
		//---------标题部分
		navBar.setStyleName(Reindeer.LAYOUT_BLACK);
		navBar.setWidth(100, Unit.PERCENTAGE);
		navBar.setHeight(29, Unit.PIXELS);
		addBtn.setIcon(new ThemeResource("icons/16/add.png"));
		addBtn.setDescription("增加");
		Label lblNav = new Label("微信系统 /商品类别");
		addBtn.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				createWindow();
			}
	  });
		navBar.addComponent(lblNav);
		navBar.addComponent(addBtn);
		navBar.setComponentAlignment(addBtn, Alignment.TOP_RIGHT);// 定义位置
		
		
		//---------正文部分
		vsplit = new HorizontalSplitPanel();
		initContainer();
		initTable();
		vsplit.addComponent(table);
		initForm(null);
		vsplit.addComponent(form);
		this.addComponent(navBar);
		this.addComponent(vsplit);
		vsplit.setSplitPosition(70F);
		vsplit.setStyleName(Reindeer.LAYOUT_WHITE);
	}
	/**
	 * 初始化表格容器
	 * 
	 * @author zg
	 * **/
	private void initContainer(){
		container = new BeanItemContainer<WXProduct>(WXProduct.class);
		List<WXProduct> productList=manager.getAllProduct();
		for(WXProduct product:productList){
			product.setCategory_code(service.getCategoryName(product.getCategory_code()));
		}
		container.addAll(productList);
	}
	/**
	 * 初始化表格
	 * 
	 * @author zg
	 * **/
	private void initTable(){
	   //初始换之前 必须要清除所有item
		
		table.removeAllItems();
		table.setSizeFull();
		table.setHeight(470, Unit.PIXELS);
		table.setContainerDataSource(container); // 这里数据源要切换

		table.setVisibleColumns(Constants.WX_PRODUCT_COL);
		table.setColumnHeaders(Constants.WX_PRODUCT_COL_HEADERS);

		table.setColumnCollapsingAllowed(true);
		table.setColumnReorderingAllowed(true);
		
		table.setSelectable(true);
		table.setImmediate(true);
		table.addItemClickListener(new ItemClickListener() {
			@Override
			public void itemClick(ItemClickEvent event) {
				initForm(event.getItem());
				vsplit.addComponent(form);
			}
		});
		table.setNullSelectionAllowed(false);
	}
	/**
	 * 初始化form
	 * 
	 * @author zg
	 * **/
	private void initForm(Item item){
		//form = new FormLayout();
		//form.removeAllComponents();
		//form.removeComponent(addBtn1);
		status.addItems(0,1);
		status.setItemCaption(1, "启用");
		status.setItemCaption(0, "未启用");
		status.setRequired(true);
		saveButton.addClickListener(initButtonClickLister());
		// 单位 0无 1份 2普通装 3标准杯 4盒 5其他
		unit.addItems(0,1,2,3,4,5);
		unit.setItemCaption(0, "无");
		unit.setItemCaption(1, "份");
		unit.setItemCaption(2, "普通装");
		unit.setItemCaption(3, "标准杯");
		unit.setItemCaption(4, "盒");
		unit.setItemCaption(5, "其他");
		//产品类别
		for(CategoryBean categoryBean:service.getAllCategory()){
			category_code.addItem(categoryBean.getCode());
			category_code.setItemCaption(categoryBean.getCode(), categoryBean.getName());
		}
		// 包装，目前只有一种包装类型，后面可能多种，表单中用下拉框
		package_type.addItems(0);
		package_type.setItemCaption(0, "普通");
		//口味
		taste.addItems(0);
		taste.setItemCaption(0, "微辣");
		  //绑定数据
		if(item != null){
			vsplit.removeComponent(form);
			BeanFieldGroup<WXProduct> bindingFiles = new BeanFieldGroup<WXProduct>(WXProduct.class);
			bindingFiles.setItemDataSource(item);
			bindingFiles.setBuffered(true);
			bindingFiles.bindMemberFields(this); 
			if(status.getValue().equals("启用")){
				status.isSelected(1);
			}else{
				status.isSelected(2);
			}
			if(!unit.getValue().equals("其他")){
				otherUnit.setEnabled(false);
			}
			form.addComponents(productCode,category_code,productName,productDesc,pic,pic,price,cheapPrice,unit,otherUnit,package_type,taste,status,saveButton);
		}
	
		
	}
	
	/**
	 * 创建增加窗体
	 * 
	 * @author zg
	 * **/
	public void createWindow(){
		window.setHeight(600, Unit.PIXELS);
		window.setWidth(350, Unit.PIXELS);
		window.setModal(true);
		initForm();
		window.setContent(form1);
		//window.close();
		getUI().addWindow(window);
	}
	
	/**
	 * 初始化按钮事件 
	 * 
	 * @author zg
	 * **/
	private Button.ClickListener   initButtonClickLister(){
		Button.ClickListener cl = new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) { 
				 WXProduct product = new WXProduct();
				   
				if(event.getButton().getCaption().equals("修改")){
				   service.updateProduct(product);
				   Notification.show("修改完成");
				}else if(event.getButton().getCaption().equals("增加")) {
					service.addProduct(product);
					Notification.show("增加完成");
					window.close();
				}
				// 刷新 tree和table
				initContainer();
				table.setContainerDataSource(container);
				table.setVisibleColumns(Constants.WX_PRODUCT_COL);
				table.setColumnHeaders(Constants.WX_PRODUCT_COL_HEADERS);
			};
		};
		return cl;
	}
	
	
	/**
	 * 初始化添加form
	 * 
	 * @author zg
	 * **/
	private void initForm(){
		form1.removeAllComponents();
		TextField productCode = new TextField("产品代码");
		NativeSelect category_code = new NativeSelect("类别名");
		TextField productName = new TextField("产品名");
		TextArea productDesc = new TextArea("产品描述");
		TextField pic = new TextField("产品图片路径");
		TextField price = new TextField("价格");
		TextField cheapPrice = new TextField("打折价格");
		NativeSelect unit = new NativeSelect("单位");
	    TextField otherUnit = new TextField("其他单位");
		NativeSelect package_type = new NativeSelect("包装类型呢");
		NativeSelect taste = new NativeSelect("口味");
		NativeSelect status = new NativeSelect("状态");
		Button saveButton = new Button("修改");
		Button addBtn1 = new Button("增加");
		addBtn1.addClickListener(initButtonClickLister());
		
		status.addItems(0,1);
		status.setItemCaption(1, "启用");
		status.setItemCaption(0, "未启用");
		status.setRequired(true);
		// 单位 0无 1份 2普通装 3标准杯 4盒 5其他
				unit.addItems(0,1,2,3,4,5);
				unit.setItemCaption(0, "无");
				unit.setItemCaption(1, "份");
				unit.setItemCaption(2, "普通装");
				unit.setItemCaption(3, "标准杯");
				unit.setItemCaption(4, "盒");
				unit.setItemCaption(5, "其他");
				//产品类别
				for(CategoryBean categoryBean:service.getAllCategory()){
					category_code.addItem(categoryBean.getCode());
					category_code.setItemCaption(categoryBean.getCode(), categoryBean.getName());
				}
				// 包装，目前只有一种包装类型，后面可能多种，表单中用下拉框
				package_type.addItems(0);
				package_type.setItemCaption(0, "普通");
				//口味
				taste.addItems(0);
				taste.setItemCaption(0, "微辣");
		form1.addComponents(productName,productDesc,category_code,pic,pic,price,cheapPrice,unit,otherUnit,package_type,taste,status,addBtn1);
		
	}
}
