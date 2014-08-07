package com.seaway.liufuya.mvc.crm.complain.layout;

import java.util.List;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.mvc.crm.complain.dao.ComplainManager;
import com.seaway.liufuya.mvc.crm.complain.data.ComplainBean;
import com.seaway.liufuya.mvc.crm.complaintype.dao.ComplainTypeManager;
import com.seaway.liufuya.mvc.crm.complaintype.date.ComplainTypeDtilBean;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.shared.MouseEventDetails.MouseButton;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.Reindeer;
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
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class ComplainListView extends VerticalLayout implements ClickListener {

	private static final Log log = Logs.get();

	// 查询Manager
	ComplainManager complainManager = null;
	// 定义表格
	private Table rightTable = new Table();
	// 定义表格容器
	BeanItemContainer<ComplainBean> container = new BeanItemContainer<ComplainBean>(
			ComplainBean.class);
	// 处理诉求表单组件
	TextField complainCode = null;// 诉求编码
	TextField typeName = null;// 诉求类型
	TextField complainContent = null;// 诉求内容
	TextField remark = null;// 诉求处理备注
	NativeSelect isOk = null; // 诉求处理状态 1已处理 0未启用
	Button saveButton = null;// 保存按钮

	// -----------------------------------------开始定义布局
	private HorizontalSplitPanel conentHSplit = null;// 用于分开tree 和table
	private Tree leftTree = new Tree();

	// 构造函数
	public ComplainListView(ComplainManager complainManager) {
		// ------------------------------------------加载dao
		this.complainManager = complainManager;

		// -------------------------------------------标题部分
		HorizontalLayout navBar = new HorizontalLayout();
		navBar.setStyleName(Reindeer.LAYOUT_BLACK);
		navBar.setWidth(100, Unit.PERCENTAGE);
		navBar.setHeight(29, Unit.PIXELS);
		Label lblNav = new Label("CRM系统 / 会员投诉");
		Button btnAdd = new Button("回复"); // 增加 按钮
		btnAdd.setIcon(new ThemeResource("icons/16/add.png"));
		btnAdd.setDescription("诉求回复");
		btnAdd.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				//createWindow(null);
			}
		});
		navBar.addComponent(lblNav);
		//navBar.addComponent(btnAdd);
		//navBar.setComponentAlignment(btnAdd, Alignment.TOP_RIGHT);// 定义位置

		// -------------------------------------------正文部分
		conentHSplit = new HorizontalSplitPanel();
		conentHSplit.setStyleName(Reindeer.LAYOUT_WHITE); // 右侧样式
		conentHSplit.setHeight(470, Unit.PIXELS);

		// -----------------------------------------左边 tree

		initTree();
		conentHSplit.setFirstComponent(leftTree);
		conentHSplit.setSecondComponent(rightTable);
		conentHSplit.setSplitPosition(15F);
		// -----------------------------------------右边 table 使用
		container = new BeanItemContainer<ComplainBean>(
				ComplainBean.class);
		initRightTable(rightTable, container);

		this.addComponent(navBar);
		this.addComponent(conentHSplit);
	}

	/**
	 * 1级树初始化
	 ***/
	private void initTree() {
		// 为了保证错误操作 我们不把原有的数据清除 每次删除之后 在重新登录之后才会删除
		leftTree = new Tree();
		List<String> itemNames = this.complainManager.getComplainTyep();
		for (String itemName : itemNames) {
			leftTree.addItem(itemName);
		}
		// treeItem 单击事件
		leftTree.addItemClickListener(new ItemClickEvent.ItemClickListener() {

			@Override
			public void itemClick(ItemClickEvent event) {
				if (event.getButtonName().equals(MouseButton.LEFT.getName())) {
					initContainer(container, event.getItemId().toString());
					rightTable.setContainerDataSource(container);
				}
			}
		});
		conentHSplit.setFirstComponent(leftTree);
	}

	/**
	 * 初始化表格容器
	 * **/
	private void initContainer(BeanItemContainer container, String itemName) {
		List<ComplainBean> complainList = this.complainManager.getComplains(itemName);
		container.removeAllItems();
		for (ComplainBean complain : complainList) {
			container.addItem(complain);
		}
	}

	/**
	 * 初始化表格
	 * **/
	private void initRightTable(Table table, Container container) {
		table.setSizeFull();
		table.setHeight(100, Unit.PERCENTAGE);
		table.setContainerDataSource(container);
		table.setVisibleColumns(Constants.COMPLAIN_COL);
		table.setColumnHeaders(Constants.COMPLAIN_COL_HEADERS_CHINESE);
        table.setColumnWidth(complainContent, 10);
		
		table.setColumnCollapsingAllowed(true);
		table.setColumnReorderingAllowed(true);
		table.addItemClickListener(new ItemClickListener() {

			@Override
			public void itemClick(ItemClickEvent event) {
				// MouseButton.LEFT 左键单击
				if (event.getButtonName().equals(MouseButton.LEFT.getName())) {
					createWindow(event.getItem());
				}
			}
		});
	}

	/**
	 * 单击表格 编辑或者删除
	 * 
	 * @return ItemClickListener
	 * **/
	private ItemClickListener itemClick() {
		ItemClickListener icLister = new ItemClickListener() {

			@Override
			public void itemClick(ItemClickEvent event) {
				// MouseButton.LEFT 左键单击
				if (event.getButtonName().equals(MouseButton.LEFT.getName())) {
					createWindow(event.getItem());
				}
			}
		};
		return icLister;
	}

	/**
	 * 增加 编辑 删除窗体初始化
	 * **/
	private void createWindow(Item item) {
		Window window = new Window();
		window.setHeight(280, Unit.PIXELS);
		window.setWidth(350, Unit.PIXELS);
		window.setModal(true);
		window.setContent(createForm(item, window));
		window.close();
		getUI().addWindow(window);

	}

	/**
	 * 回复窗体初始化
	 * **/
	private FormLayout createForm(Item item, Window window) {
		FormLayout form = new FormLayout();
		complainCode = new TextField("投诉编码");
		typeName = new TextField("投诉类型");
		complainContent = new TextField("投诉内容");
		remark = new TextField("处理意见");
		saveButton = new Button("回复");
		saveButton.addClickListener(createBTCL(window));
		isOk = new NativeSelect("状态");
		isOk.addItem(0);
		//isOk.setItemCaption(1, "未回复");
		//isOk.addItem(1);
		isOk.setItemCaption(0, "已回复");
		// 设置红色* 提醒
		complainCode.setRequired(true);
		typeName.setRequired(true);
		remark.setRequired(true);
		isOk.setRequired(true);
		
		//设置不可编辑
		complainCode.setEnabled(false);
		
		// 设置输入最大长度
		typeName.setMaxLength(8);
		remark.setMaxLength(100);
		form.addComponent(complainCode);
		form.addComponent(typeName);
		form.addComponent(complainContent);
		form.addComponent(remark);
		form.addComponent(isOk);
        form.addComponent(saveButton);
        

        
        //绑定数据
		BeanFieldGroup<ComplainBean> bindingFiles = new BeanFieldGroup<ComplainBean>(ComplainBean.class);
		bindingFiles.setItemDataSource(item);
		bindingFiles.setBuffered(true);
		bindingFiles.bindMemberFields(this); 
        //设置不可编辑
		complainCode.setEnabled(false);
		
		return form;
	}

	/**
	 * 保存编辑
	 * */
	private Button.ClickListener createBTCL(final Window window) {
		Button.ClickListener cl = new Button.ClickListener() {
			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				// 空校验
				if (typeName.getValue().trim().equals("")|| remark.getValue().trim().equals("")|| complainCode.getValue().equals("")|| isOk.getValue() == null) {
					Notification.show("带*的位必输值不能为空");
				} else {
					complainManager.isOk(new String[] {complainCode.getValue(),typeName.getValue(), remark.getValue(),isOk.getValue().toString() });
					Notification.show("回复成功");
					window.close();
					// 刷新 tree和table
					initTree();
					//conentHSplit.setFirstComponent(leftTree);
					initContainer(container, typeName.getValue());
					rightTable.setContainerDataSource(container);
					conentHSplit.setSecondComponent(rightTable);
				}

			}
		};
		return cl;
	}

	@Override
	public void buttonClick(ClickEvent event) {
	
	}
}