package com.seaway.liufuya.mvc.crm.complaintype.layout;

import java.util.List;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.mvc.crm.complaintype.dao.ComplainTypeManager;
import com.seaway.liufuya.mvc.crm.complaintype.date.ComplainTypeDtilBean;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.server.ThemeResource;
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
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Reindeer;

@SuppressWarnings("serial")
public class ComplainTypeListView extends VerticalLayout implements
		ClickListener {

	private static final Log log = Logs.get();

	// 查询Manager
	ComplainTypeManager complainTypeManager = null;
	// 定义表格
	private Table rightTable = new Table();
	// 定义表格容器
	BeanItemContainer<ComplainTypeDtilBean> container = new BeanItemContainer<ComplainTypeDtilBean>(
			ComplainTypeDtilBean.class);
	// 增加 编辑 删除表单组件
	TextField typeName = null;// 诉求类型
	TextField remark = null;// 诉求备注
	NativeSelect status = null; // 诉求状态 1启用 0不启用
	Button saveButton = null;// 保存按钮
	Button eaditButton = null;// 删除按钮

	// -----------------------------------------开始定义布局
	private HorizontalSplitPanel conentHSplit = null;// 用于分开tree 和table
	private Tree leftTree = new Tree();

	@Override
	public void click(ClickEvent event) {

	}

	// 构造函数
	public ComplainTypeListView(ComplainTypeManager complainTypeManager) {
		// ------------------------------------------加载dao
		this.complainTypeManager = complainTypeManager;

		// -------------------------------------------标题部分
		HorizontalLayout navBar = new HorizontalLayout();
		navBar.setStyleName(Reindeer.LAYOUT_BLACK);
		navBar.setWidth(100, Unit.PERCENTAGE);
		navBar.setHeight(29, Unit.PIXELS);
		Label lblNav = new Label("CRM系统 / 诉求类别");
		Button btnAdd = new Button("新增"); // 增加 按钮
		btnAdd.setIcon(new ThemeResource("icons/16/add.png"));
		btnAdd.setDescription("增加类别");
		btnAdd.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				createWindow(null);
			}
		});
		navBar.addComponent(lblNav);
		navBar.addComponent(btnAdd);
		navBar.setComponentAlignment(btnAdd, Alignment.TOP_RIGHT);// 定义位置

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
		container = new BeanItemContainer<ComplainTypeDtilBean>(
				ComplainTypeDtilBean.class);
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
		List<String> itemNames = this.complainTypeManager.getComplainType();
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
		List<ComplainTypeDtilBean> complainTypeDtilList = this.complainTypeManager.getComplainTypeDtil(itemName);
		container.removeAllItems();
		for (ComplainTypeDtilBean complainTypeDtil : complainTypeDtilList) {
			container.addItem(complainTypeDtil);
		}
	}

	/**
	 * 初始化表格
	 * **/
	private void initRightTable(Table table, Container container) {
		table.setSizeFull();
		table.setHeight(100, Unit.PERCENTAGE);
		table.setContainerDataSource(container);
		table.setVisibleColumns(Constants.COMPLAIN_TYPE_COL);
		table.setColumnHeaders(Constants.COMPLAIN_TYPE_COL_HEADERS_CHINESE);

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
		window.setHeight(250, Unit.PIXELS);
		window.setWidth(300, Unit.PIXELS);
		window.setModal(true);
		window.setContent(createForm(item, window));
		window.close();
		getUI().addWindow(window);

	}

	/**
	 * 增加 编辑删除船体初始化
	 * **/
	private FormLayout createForm(Item item, Window window) {
		FormLayout form = new FormLayout();

		typeName = new TextField("诉求类型");
		remark = new TextField("备注");
		saveButton = new Button("保存");
		eaditButton = new Button("OK");
		saveButton.addClickListener(createBTCL(window));
		eaditButton.addClickListener(createBTCL(window));
		status = new NativeSelect("状态");
		status.addItem(0);
		status.setItemCaption(1, "启用");
		status.addItem(1);
		status.setItemCaption(0, "删除");
		// 设置红色* 提醒
		typeName.setRequired(true);
		remark.setRequired(true);
		status.setRequired(true);
		// 设置输入最大长度
		typeName.setMaxLength(8);
		remark.setMaxLength(30);
		if (item != null) {
			Label elabel = new Label("编辑");
			form.addComponent(elabel);
		} else {
			Label slabel = new Label("新增");
			form.addComponent(slabel);
		}
		form.addComponent(typeName);
		form.addComponent(remark);
		form.addComponent(status);

		if (item != null) {
			form.addComponent(eaditButton);
			BeanFieldGroup<ComplainTypeDtilBean> bindingFiles = new BeanFieldGroup<ComplainTypeDtilBean>(
					ComplainTypeDtilBean.class);
			bindingFiles.setItemDataSource(item);
			bindingFiles.setBuffered(true);
			bindingFiles.bindMemberFields(this); // 绑定
			// 无法修改诉求类型名
			typeName.setEnabled(false);
		} else {
			form.addComponent(saveButton);
		}
		// 由于绑定数据中 状态为数字所以 需重新设定
		status.select(1);
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
				if (typeName.getValue().trim().equals("")
						|| remark.getValue().trim().equals("")
						|| status.getValue() == null) {
					Notification.show("带*的位必输值不能为空");
				} else {
					if (event.getButton().getCaption().equals("OK")) {
						complainTypeManager.update(new String[] {
								typeName.getValue(), remark.getValue(),
								status.getValue().toString() });
						Notification.show("编辑成功");
						window.close();
					} else {
						String reback = complainTypeManager.save(new String[] {
								typeName.getValue(), remark.getValue(),
								status.getValue().toString() });
						Notification.show(reback);
						window.close();
					}
					// 刷新 tree和table
					initTree();
					conentHSplit.setFirstComponent(leftTree);
					initContainer(container, typeName.getValue());
					rightTable.setContainerDataSource(container);
					conentHSplit.setSecondComponent(rightTable);
				}

			}
		};
		return cl;
	}
}
