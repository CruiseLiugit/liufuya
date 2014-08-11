package com.seaway.liufuya.mvc.crm.consumerule.layout;

import java.util.Iterator;
import java.util.List;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.mvc.crm.complaintype.date.ComplainTypeDtilBean;
import com.seaway.liufuya.mvc.crm.consumerule.dao.ConsumeRuleManager;
import com.seaway.liufuya.mvc.crm.consumerule.data.ConsumeRuleBean;
import com.seaway.liufuya.mvc.crm.consumerule.service.ConsumeRuleService;
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
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class ConsumeRuleListView extends VerticalLayout implements
		ClickListener {

	private static final Log log = Logs.get();
	private ConsumeRuleManager manager = null;
	private ConsumeRuleService services = null;

	// --------------------------开始定义布局需要的组件
	// --------------------------导航
	private HorizontalLayout navBar = null;

	// --------------------------table
	private BeanItemContainer<ConsumeRuleBean> container = null;
	private Table table = null;

	// ---------------------------窗体
	private Window window = null;

	// ---------------------------表单
	private FormLayout form = null;
	private NativeSelect ruleType = null;// 兑换规则类型
	private TextField ruleCode = null;// 对话规则代码
	private TextField ruleName = null;// 兑换规则名
	private TextField rulePercent = null;// 百分比
	private TextArea remark = null;//备注
	private DateField startDate= null;//创建时间
	private TextField createPerson = null;//创建人
	private NativeSelect status = null; // 启用状态 1启用 0不启用
	Button saveButton = null;// 保存按钮
	Button eaditButton = null;// 编辑按钮

	public ConsumeRuleListView(ConsumeRuleManager manager) {
		this.manager = manager;
		services = new ConsumeRuleService(manager);

		// 导航栏标题
		// -------------------------------------------标题部分
		HorizontalLayout navBar = new HorizontalLayout();
		navBar.setStyleName(Reindeer.LAYOUT_BLACK);
		navBar.setWidth(100, Unit.PERCENTAGE);
		navBar.setHeight(29, Unit.PIXELS);
	    Label lblNav = new Label("CRM系统 / 积分兑换比例");
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
		
		//-----------------------------正文部分
		container = new BeanItemContainer<ConsumeRuleBean>(ConsumeRuleBean.class);
		table = new Table();
		initContainer();
		initTable();
		this.addComponent(navBar);
		this.addComponent(table);

	}
	
	/***
	 * table 容器初始化
	 * */
	private void initContainer(){
		container.removeAllItems();
		List<ConsumeRuleBean> itemBeans =this.services.getAllItemBean();
		for (Iterator iterator = itemBeans.iterator(); iterator.hasNext();) {
			ConsumeRuleBean ruleBean = (ConsumeRuleBean) iterator.next();
			container.addItem(ruleBean);
		}
	}
	
	/**
	 * table 初始化
	 * **/
    private void initTable(){
    	table.setSizeFull();
		table.setHeight(100, Unit.PERCENTAGE);
		table.setContainerDataSource(container); // 这里数据源要切换

		table.setVisibleColumns(Constants.CONSUMERULE_COL);
		table.setColumnHeaders(Constants.CONSUMERULE_COL_HEADERS);

		table.setColumnCollapsingAllowed(true);
		table.setColumnReorderingAllowed(true);

		table.setSelectable(true);
		table.setImmediate(true);
		table.setNullSelectionAllowed(false);
		table.addItemClickListener(itemClick());
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
					createWindow(event.getItem());
				}
			}
		};
		return icLister;
    }
    
    /**
     * 弹出窗体初始化
     * 
     * @author zg
     * **/
    private void createWindow(Item item){
    	window = new Window("编辑/添加");
		window.setHeight(400, Unit.PIXELS);
		window.setWidth(300, Unit.PIXELS);
		window.setModal(true);
		initForm(item);
		window.setContent(form);
		getUI().addWindow(window);
    }
    
    /**
     * 表单初始化
     * 
     * @author zg
     * **/
    private void initForm(Item item){
    	form = new FormLayout();
    	ruleType = new NativeSelect("积分类型");// 兑换规则类型
    	ruleType.addItems(1,2);
    	ruleType.setItemCaption(2, "活动积分");
    	ruleType.setItemCaption(1, "消费积分");
    	ruleType.setRequired(true);
    	//ruleType.setNullSelectionAllowed(false);
    	ruleCode = new TextField("规则代码");// 对话规则代码
    	ruleCode.setNullSettingAllowed(false);
    	ruleCode.setRequired(true);
    	ruleName = new TextField("规则名称");// 兑换规则名
    	//ruleName.setNullSettingAllowed(false);
    	ruleName.setRequired(true);
    	rulePercent = new TextField("兑换比例");// 百分比
    	rulePercent.setNullSettingAllowed(true);
    	rulePercent.setRequired(true);
    	remark = new TextArea("备注");//备注
    	startDate= new DateField("创建时间");//创建时间
    	createPerson = new TextField("创建人");//创建人
    	status = new NativeSelect("状态"); // 启用状态 1启用 0不启用
    	//status.setNullSelectionAllowed(false);
    	status.setRequired(true);
    	status.addItems(0,1);
    	status.setItemCaption(0, "未启用");
    	status.setItemCaption(1, "启用");
    	form.addComponents(ruleCode,ruleName,ruleType,rulePercent,startDate,remark,createPerson,status);	
    	if(item != null){
    		saveButton = new Button("保存");
    		//绑定数据
			BeanFieldGroup<ComplainTypeDtilBean> bindingFiles = new BeanFieldGroup<ComplainTypeDtilBean>(
					ComplainTypeDtilBean.class);
			bindingFiles.setItemDataSource(item);
			bindingFiles.setBuffered(true);
			bindingFiles.bindMemberFields(this); // 绑定
			//无法修改
			ruleCode.setEnabled(false);
			createPerson.setEnabled(false);
			startDate.setEnabled(false);
    	}else{
    		//移除相关创建无需组件
    		form.removeComponent(ruleCode);
    		form.removeComponent(createPerson);
    		form.removeComponent(startDate);
    		saveButton = new Button("新增");
    	}
    	saveButton.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				if (Double.valueOf(rulePercent.getValue().toString())<0 || Double.valueOf(rulePercent.getValue().toString())>1 ){
					Notification.show("比例必须在0-1之间   可输入 0.1");
				}else{
				ConsumeRuleBean bean = new ConsumeRuleBean();
				//bean.setCreatePerson(createPerson.getValue());
				bean.setRemark(remark.getValue());
				bean.setRuleCode(ruleCode.getValue());
				bean.setRuleName(ruleName.getValue());
				bean.setRulePercent(rulePercent.getValue());
				bean.setRuleType(ruleType.getValue().toString());
				//bean.setStartDate(startDate.getValue().toString());
				bean.setStatus(status.getValue().toString());
				if(saveButton.getCaption().equals("新增")){
					services.addRule(bean);
					Notification.show("新增完成");
				}else{
					services.updateRule(bean);
					Notification.show("编辑完成");
				}
				initContainer();
				table.setContainerDataSource(container);
				window.close();
			}
		}});
    	form.addComponent(saveButton);
    	window.setContent(form);
    	
    }
	
	@Override
	public void buttonClick(ClickEvent event) {

	}

}
