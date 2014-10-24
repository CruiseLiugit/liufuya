package com.seaway.liufuya.mvc.crm.sms.layout;

import java.util.List;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.mvc.crm.sms.dao.SMSManager;
import com.seaway.liufuya.mvc.crm.sms.date.SMSBean;
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
public class SMSListView extends VerticalLayout implements
		ClickListener {

	private static final Log log = Logs.get();

	// 查询Manager
	SMSManager smsManager = null;
	// 定义表格
	private Table rightTable = new Table();
	// 定义表格容器
	BeanItemContainer<SMSBean> container = new BeanItemContainer<SMSBean>(
			SMSBean.class);
	// 增加 编辑 删除表单组件
	NativeSelect smsType = null;// 短信类型
	TextField remark = null;// 备注
	TextField smsContent = null;// 短信内容
	TextField smsCode = null;// 短信编码
	NativeSelect smsFor = null;// 平台类型
	NativeSelect status = null; // 启用状态 1启用 0不启用
	
	Button saveButton = null;// 保存按钮
	Button eaditButton = null;// 删除按钮

	// -----------------------------------------开始定义布局
	private HorizontalSplitPanel conentHSplit = null;// 用于分开tree 和table
	private Tree leftTree = new Tree();

	@Override
	public void click(ClickEvent event) {

	}

	// 构造函数
	public SMSListView(SMSManager smsManager) {
		// ------------------------------------------加载dao
		this.smsManager = smsManager;

		// -------------------------------------------标题部分
		HorizontalLayout navBar = new HorizontalLayout();
		navBar.setStyleName(Reindeer.LAYOUT_BLACK);
		navBar.setWidth(100, Unit.PERCENTAGE);
		navBar.setHeight(29, Unit.PIXELS);
		Label lblNav = new Label("CRM系统 / 短信发送");
		Button btnAdd = new Button("新增"); // 增加 按钮
		btnAdd.setIcon(new ThemeResource("icons/16/add.png"));
		btnAdd.setDescription("增加短信");
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
		conentHSplit.setHeight(Constants.PAGE_HEIGHT, Unit.PIXELS);

		// -----------------------------------------左边 tree

		initTree();
		conentHSplit.setFirstComponent(leftTree);
		conentHSplit.setSecondComponent(rightTable);
		conentHSplit.setSplitPosition(15F);
		// -----------------------------------------右边 table 使用
		container = new BeanItemContainer<SMSBean>(SMSBean.class);
		initRightTable(rightTable, container);

		this.addComponent(navBar);
		this.addComponent(conentHSplit);
	}

	/**
	 * 1级树初始化
	 ***/
	private void initTree() {
		leftTree = new Tree();
		leftTree.addItem("注册短信");
		leftTree.addItem("密码找回");
		leftTree.addItem("订购成功");
		leftTree.addItem("付款成功/积分生成");
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
		List<SMSBean> smsBeanList = this.smsManager.getSMSByType(itemName);
		container.removeAllItems();
		for (SMSBean smsBean : smsBeanList) {
			container.addItem(smsBean);
		}
	}

	/**
	 * 初始化表格
	 * **/
	private void initRightTable(Table table, Container container) {
		table.setSizeFull();
		table.setHeight(100, Unit.PERCENTAGE);
		table.setContainerDataSource(container);
		table.setVisibleColumns(Constants.SMS_COL);
		table.setColumnHeaders(Constants.SMS_COL_HEADERS_CHINESE);
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
		Window window = new Window("编辑/添加");
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

        smsContent = new TextField("短信内容");
        smsCode = new TextField("短信编码");
        smsFor = new NativeSelect("平台类型");
        smsFor.addItem(0);
        smsFor.setItemCaption(1, "后台系统");
        smsFor.addItem(1);
        smsFor.setItemCaption(0, "订单系统");
        
		smsType = new NativeSelect("短信类型");
		smsType.addItem(0);
		smsType.setItemCaption(0, "注册短信");
		smsType.addItem(1);
		smsType.setItemCaption(1, "密码找回");
		smsType.addItem(2);
		smsType.setItemCaption(2, "订购成功");
		smsType.addItem(3);
		smsType.setItemCaption(3, "付款成功/积分生成");
		
		remark = new TextField("备注");
		saveButton = new Button("保存");
		eaditButton = new Button("OK");
		saveButton.addClickListener(createBTCL(window));
		eaditButton.addClickListener(createBTCL(window));
		status = new NativeSelect("状态");
		status.addItem(0);
		status.setItemCaption(1, "启用");
		status.addItem(1);
		status.setItemCaption(0, "未启用");
		// 设置红色* 提醒
		smsContent.setRequired(true);
		smsType.setRequired(true);
		smsCode.setRequired(true);
		smsFor.setRequired(true);
		remark.setRequired(true);
		status.setRequired(true);
		// 设置输入最大长度
		remark.setMaxLength(30);
		smsContent.setMaxLength(50);
		
		form.addComponent(smsCode);
		form.addComponent(smsType);
		form.addComponent(smsFor);
		form.addComponent(smsContent);
		form.addComponent(remark);
		form.addComponent(status);
		if (item != null) {
			// 无法修改诉求类型名		
		   // smsType.setVisible(false);
			
			form.addComponent(eaditButton);
			BeanFieldGroup<SMSBean> bindingFiles = new BeanFieldGroup<SMSBean>(SMSBean.class);
			bindingFiles.setItemDataSource(item);
			bindingFiles.setBuffered(true);
			bindingFiles.bindMemberFields(this); // 绑定
			smsCode.setEnabled(false);
			smsType.setVisible(false);
			//注意  绑定数据错误  需重新绑定
			if(smsFor.getValue().equals("后台系统")){
				smsFor.setValue(1);
				smsFor.select(1);
			}else{
				smsFor.setValue(0);
				smsFor.select(0);
			}
		} else {
			smsCode.setVisible(false);
			form.addComponent(saveButton);
		}
		// 由于绑定数据中 状态为数字所以 需重新设定
		status.select(0);
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
				if (smsCode.getValue().trim() ==null || smsType.getValue() == null || remark.getValue().trim().equals("") || status.getValue() == null || smsContent.getValue().trim().equals("") || smsFor.getValue()== null) {
					Notification.show("带*的位必输值不能为空");
				} else {
					String reback = null;
					if (event.getButton().getCaption().equals("OK")) {
						  reback =smsManager.updateSMSStatus(new String[] {smsCode.getValue(),String.valueOf(smsType.getValue()), remark.getValue(),status.getValue().toString(),smsContent.getValue(),String.valueOf(smsFor.getValue()) });
					} else {
				         reback = smsManager.addSMS(new String[] {smsCode.getValue(),String.valueOf(smsType.getValue()), remark.getValue(),status.getValue().toString(),smsContent.getValue(),String.valueOf(smsFor.getValue()) });
					}
					Notification.show(reback);
					if(reback.equals("添加成功")||reback.equals("修改成功")){
						window.close();
					}
					
					
					initContainer(container,String.valueOf( smsType.getValue()));
					rightTable.setContainerDataSource(container);
					conentHSplit.setSecondComponent(rightTable);
				}

			}
		};
		return cl;
	}
}
