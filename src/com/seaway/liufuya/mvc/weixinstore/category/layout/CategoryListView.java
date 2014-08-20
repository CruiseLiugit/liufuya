package com.seaway.liufuya.mvc.weixinstore.category.layout;

import java.util.List;

import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.mvc.crm.complain.data.ComplainBean;
import com.seaway.liufuya.mvc.crm.xchangerule.pojo.CrmExchangeRule;
import com.seaway.liufuya.mvc.weixinstore.category.dao.CategoryManager;
import com.seaway.liufuya.mvc.weixinstore.category.dao.LazyLoadCategoryContainer;
import com.seaway.liufuya.mvc.weixinstore.category.data.Category;
import com.seaway.liufuya.mvc.weixinstore.category.data.CategoryBean;
import com.seaway.liufuya.mvc.weixinstore.category.service.CategoryService;
import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.shared.MouseEventDetails.MouseButton;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
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
public class CategoryListView extends VerticalLayout {

	private CategoryManager manager = null;
	private CategoryService service = null;

	// -----------------------------------------------定义布局组件
	// -----------标题
	HorizontalLayout navBar = new HorizontalLayout();
	Label lblNav = new Label("微信系统 /商品类目管理");
	Button addBtn = new Button("增加");
	Window window = new Window();

	// -----------正文
	private HorizontalSplitPanel vsplit;
	// -----------左边table
	private Table table = new Table();
	private BeanItemContainer  container;

	// -----------右边form
	private FormLayout form = new FormLayout();
	private FormLayout form1 = new FormLayout();
	private TextField category_code = new TextField("类别代码");
	private TextField category_name = new TextField("类别名");
	private TextField show_name = new TextField("子标题名称");
	private NativeSelect status = new NativeSelect("状态");
	private Button saveButton = new Button("修改");
	private Button addBtn1 = new Button("增加");

	// -----------------------------------------------构造 开始初始化布局
	public CategoryListView(CategoryManager manager){
		this.manager = manager;
		service = new CategoryService(manager);
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
		vsplit.setSplitPosition(70);
		vsplit.setStyleName(Reindeer.LAYOUT_WHITE); // 右侧样式
		vsplit.setHeight(470, Unit.PIXELS);
	}
	/**
	 * 初始化表格容器
	 * 
	 * @author zg
	 * **/
	private void initContainer(){
		container = new BeanItemContainer<Category>(Category.class);
		List<Category> categoryList=manager.getAllCategory();
		container.addAll(categoryList);
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

		table.setVisibleColumns(Constants.WX_CATEGORY_COL);
		table.setColumnHeaders(Constants.WX_CATEGORY_COL_HEADERS);

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
		  //绑定数据
		if(item != null){
			vsplit.removeComponent(form);
			BeanFieldGroup<Category> bindingFiles = new BeanFieldGroup<Category>(Category.class);
			bindingFiles.setItemDataSource(item);
			bindingFiles.setBuffered(true);
			bindingFiles.bindMemberFields(this); 
			if(status.getValue().equals("启用")){
				status.select(1);
			}else{
				status.select(0);
			}
			form.addComponents(category_code,category_name,show_name,status,saveButton);
			category_code.setEnabled(false);
		}
	
		
	}
	
	/**
	 * 创建增加窗体
	 * 
	 * @author zg
	 * **/
	public void createWindow(){
		window.setHeight(250, Unit.PIXELS);
		window.setWidth(300, Unit.PIXELS);
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
				 Category category = new Category();
				    category.setCategory_code(category_code.getValue());
				    category.setCategory_name(category_name.getValue());
				    category.setShow_name(show_name.getValue());
				    category.setStatus(status.getValue().toString());
				if(event.getButton().getCaption().equals("修改")){
				   service.updateCategroy(category);
				   Notification.show("修改完成");
				}else if(event.getButton().getCaption().equals("增加")) {
					service.addCategroy(category);
					Notification.show("增加完成");
					window.close();
				}
				// 刷新 tree和table
				initContainer();
				table.setContainerDataSource(container);
				table.setVisibleColumns(Constants.WX_CATEGORY_COL);
				table.setColumnHeaders(Constants.WX_CATEGORY_COL_HEADERS);
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
		 //form = new FormLayout();;
        TextField category_code = new TextField("类别代码");
        TextField category_name = new TextField("类别名");
        TextField show_name = new TextField("子标题名称");
       Button saveButton = new Button("修改");
		status.addItems(0,1);
		status.setItemCaption(1, "启用");
		status.setItemCaption(0, "未启用");
		status.setRequired(true);
		status.isSelected(1);
		saveButton.addClickListener(initButtonClickLister());
		Button addBtn1 = new Button("增加");
		addBtn1.addClickListener(initButtonClickLister());
		form1.addComponents(category_name,show_name,status,addBtn1);
		category_code.setEnabled(false);
		
	}
}
