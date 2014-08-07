package com.seaway.liufuya.mvc.crm.xchangerule.layout;

import java.util.Collection;
import java.util.Iterator;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.mvc.crm.memberinfo.data.Member;
import com.seaway.liufuya.mvc.crm.memberinfo.data.MemberBean;
import com.seaway.liufuya.mvc.crm.xchangerule.dao.ExchangeRuleBeanDao;
import com.seaway.liufuya.mvc.crm.xchangerule.dao.LazyLoadExchangeRuleContainer;
import com.seaway.liufuya.mvc.crm.xchangerule.pojo.CrmExchangeRule;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Reindeer;

/**
 * 会员扩展资料面板
 * 
 * @author lililiu
 */
@SuppressWarnings("serial")
public class ExchangeRuleListLayout extends VerticalLayout implements
		ClickListener,ItemClickListener {

	private static final Log log = Logs.get();

//	// ---------表格需要的


	private LazyLoadExchangeRuleContainer exchangeRuleContainer;
	

	// 查询会员地址数据 的数据库对象
	private ExchangeRuleBeanDao exchangeManager = null;
	// ---------弹出新增窗口需要

	// 为了美观，底部添加一个 TabSheet
	TabSheet tabsheet = new TabSheet();
	private Table tb = null;   //页面显示数据表格
	// 整个页面，左右分割面板
	private final HorizontalSplitPanel mainSplit = new HorizontalSplitPanel();
	private VerticalLayout rightLayout = new VerticalLayout();
	
	private HorizontalLayout footer; // 底部
	
	private Button save = new Button("保存", (ClickListener) this);
	private Button cancel = new Button("取消", (ClickListener) this);
	private Button edit = new Button("编辑", (ClickListener) this);

	// 后侧上下分割的 垂直布局面板
	FieldGroup addFormbinder = null;

	TextField ruleCode=null;
	TextField ruleName=null;
	TextField ruleNumberBegin=null;
	TextField ruleNumberEnd=null;
	TextArea remark=null;
	DateField startDate=null;
	TextField status=null;
	
	// 对表格进行改进，增加对每个字段的搜索过滤框
	VerticalLayout tablelayout=null;

	

	FormLayout btFormlayout = new FormLayout();
	// Now use a binder to bind the members
	FieldGroup btFormbinder = null;

	// ----------------------------------------
	public ExchangeRuleListLayout() {
		// TODO Auto-generated constructor stub
	}

	public ExchangeRuleListLayout(ExchangeRuleBeanDao exchangeManager) {
		this.exchangeManager = exchangeManager;
		this.init();
		
		// 主界面mainSplit
		// 右侧创建一个导航工具条,水平布局
		HorizontalLayout navBar = new HorizontalLayout();
		navBar.setStyleName(Reindeer.LAYOUT_BLACK);
		navBar.setWidth(100, Unit.PERCENTAGE);
		navBar.setHeight(29, Unit.PIXELS);
		Label lblNav = new Label("CRM系统 / 积分商品类别管理"); // 导航

		HorizontalLayout navBarButtons = new HorizontalLayout();
		Button btnAdd = new Button("新增"); // 增加 按钮
		btnAdd.setIcon(new ThemeResource("icons/16/add.png"));
		btnAdd.setDescription("增加兑奖规则");
		Button btnDownload = new Button("列表"); // 增加 按钮
		btnDownload.setIcon(new ThemeResource("icons/16/database-cloud.png"));
		btnDownload.setDescription("选择显示数据库中数据");
		navBarButtons.addComponent(btnAdd);
		navBarButtons.addComponent(btnDownload);

		navBar.addComponent(lblNav);
		navBar.addComponent(navBarButtons);

		navBar.setComponentAlignment(lblNav, Alignment.MIDDLE_LEFT);
		navBar.setComponentAlignment(navBarButtons, Alignment.MIDDLE_RIGHT);

		btnAdd.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				 openProductWindow(new BeanItem<CrmExchangeRule>(new CrmExchangeRule()), "新增兑奖规则信息管理窗口");
			}
		});

		btnDownload.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Notification.show("正在从POS系统下载数据，请等待", Type.HUMANIZED_MESSAGE);
			}
		});

		mainSplit.setStyleName(Reindeer.LAYOUT_WHITE); // 右侧样式
		mainSplit.setHeight(470, Unit.PIXELS);
		mainSplit.setStyleName(Reindeer.SPLITPANEL_SMALL); // 分割线变细线
		// /////////////////////////////////////////////////////////////////
		// 获取所有会员的 数据模型,懒加载分页
		fillContainer(exchangeManager);

		// 对表格进行改进，增加对每个字段的搜索过滤框
		VerticalLayout tablelayout = new VerticalLayout();
		
		rightLayout.setSizeFull();
		tb = createTable(exchangeRuleContainer);
		// tablelayout.addComponent(createFilters(tb)); // 表格过滤框
		tablelayout.addComponent(tb); // 表格
		mainSplit.setFirstComponent(tablelayout);
		mainSplit.setSecondComponent(createForm(null));
		// 这里把创建表单的代码，放在表格点击事件中
		// /////////////////////////////////////////////////////////////////
		mainSplit.setSplitPosition(70);

		this.addComponent(navBar); // 导航栏
		this.addComponent(mainSplit); // 左右分割面板
		this.setExpandRatio(mainSplit, 1);
	}
	
	private void init() {
		
		ruleCode=new TextField("*规则代码");
		ruleName=new TextField("*规则名称");
		ruleNumberBegin=new TextField("*规则开始数字");
		ruleNumberEnd=new TextField("*规则结束数字");
		remark=new TextArea("备注");
		startDate=new DateField("*开始时间");
		//TODO  Select
		ruleCode=new TextField("*规则代码");
		status=new TextField("状态");
		
		ruleCode.setRequired(true);
		ruleName.setRequired(true);
		ruleNumberBegin.setRequired(true);
		ruleNumberEnd.setRequired(true);
		startDate.setRequired(true);
		
		ruleCode.setValue("");
		ruleName.setValue("");
		ruleNumberBegin.setValue("");
		ruleNumberEnd.setValue("");
		startDate.setReadOnly(true);
		status.setValue("");
	}

	/**
	 * 在一个页面创建表格
	 * 
	 * @param container
	 * @return
	 */
	private Table createTable(Container container) {
		final Table table = new Table(null, container);
		table.setSizeFull();
		table.setHeight(470, Unit.PIXELS);
		table.setContainerDataSource(container); // 这里数据源要切换

		table.setVisibleColumns(Constants.EXCHANGE_RULE_TABLE_COL);
		table.setColumnHeaders(Constants.EXCHANGE_RULE_TABLE_COL_HEADERS_CHINESE);

		table.setColumnCollapsingAllowed(true);
		table.setColumnReorderingAllowed(true);
		/*
		 * Make table selectable, react immediatedly to user events, and pass
		 * events to the controller (our main application)
		 */
		table.setSelectable(true);
		table.setImmediate(true);
		/* We don't want to allow users to de-select a row */
		table.addItemClickListener(new ItemClickListener() {
			@Override
			public void itemClick(ItemClickEvent event) {
				log.info("选中一行,显示编辑用户表单 :" + event.getItemId());
				editContact((CrmExchangeRule) event.getItemId());
			}
		});
		table.setNullSelectionAllowed(false);

		return table;
	}
	// ------------------------------------------
	@Override
	public void buttonClick(ClickEvent event) {
		Button source = event.getButton();
		if (source == save) {
			/* If the given input is not valid there is no point in continuing */
			if (!this.btFormbinder.isValid()) {
				log.info("保存时，没有通过验证");
				Notification.show("带 * 字段不能为空，请填写完成再提交");
				return;
			}
			try {
				log.info("保存时，通过验证，提交.....");
				this.btFormbinder.commit();
				footer.setVisible(false); // 隐藏掉底部按钮布局
				// 新增
				log.info("保存，更新数据库数据，更新 app 中的数据源");
				

			} catch (CommitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			setReadOnly(true);
		} else if (source == cancel) {
			/* Clear the form and make it invisible */
			// setItemDataSource(null);
			btFormbinder.discard();
			setReadOnly(true);
		} else if (source == edit) {
			setReadOnly(false);
		}
	}

	// ----------------------------------------------------------------------
	/**
	 * 获取会员表格的 容器对象 懒加载的方式
	 * 
	 * @param container
	 */
	private void fillContainer(ExchangeRuleBeanDao exchangeManager) {
		exchangeRuleContainer = new LazyLoadExchangeRuleContainer(CrmExchangeRule.class,
				exchangeManager);
	}

	

	@Override
	public void itemClick(ItemClickEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 表格选中某一行后，跳转过来到这里编辑
	 * 
	 * @param person
	 */
	public void editContact(CrmExchangeRule exchange) {
		Tab tab = tabsheet.getTab(btFormlayout);
		tab.setIcon(new ThemeResource("icons/16/user-edit.png"));
		// 这里根据登录名，查询出会员完整信息
		CrmExchangeRule ex = this.exchangeManager.getExchangeById(exchange.getId());
		// 根据穿过来的 Bean 对象，创建表格输入框
		setItemDataSource(new BeanItem(ex));
		setReadOnly(true);
	}
	
	/**
	 * 新增弹出窗口
	 * 
	 * @param beanItem
	 * @param caption
	 */
	private void openProductWindow(Item beanItem, String caption) {
		Window window = new Window(caption);
		window.setWidth(400, Unit.PIXELS);
		window.setModal(true);
		
		window.setContent(createAddForm(beanItem, window));
		getUI().addWindow(window);
	}
	private Layout createForm(Item item) {
		footer = new HorizontalLayout();
		footer.setSpacing(true);
		footer.addComponent(save);
		footer.addComponent(cancel);
		footer.addComponent(edit);
		footer.setVisible(false);
		
		// 往 FormLayout 中添加组件
		btFormlayout.removeAllComponents();
		btFormlayout.setWidth(100, Unit.PERCENTAGE);
		btFormlayout.setSpacing(true);

		btFormlayout.addComponent(ruleCode);
		btFormlayout.addComponent(ruleName);
		btFormlayout.addComponent(ruleNumberBegin);
		btFormlayout.addComponent(ruleNumberEnd);
		btFormlayout.addComponent(remark);
		btFormlayout.addComponent(startDate);
		btFormlayout.addComponent(ruleCode);
		btFormlayout.addComponent(status);

		// ***** 默认不显示表单 *****
		btFormlayout.setVisible(false);

		// 默认显示图标
		tabsheet.addTab(btFormlayout, "积分兑换规则管理", new ThemeResource(
				"icons/16/user-normal.png"));
		rightLayout.addComponent(tabsheet);
		return rightLayout;
	}
	
	private Layout createAddForm(Item item, final Window window) {
		
		// 增加的表单
		FormLayout addFormlayout = new FormLayout();
		// 往 FormLayout 中添加组件
		addFormlayout.removeAllComponents();
		addFormlayout.setWidth(100, Unit.PERCENTAGE);
		addFormlayout.setSpacing(true);

		addFormlayout.addComponent(ruleCode);
		addFormlayout.addComponent(ruleName);
		addFormlayout.addComponent(ruleNumberBegin);
		addFormlayout.addComponent(ruleNumberEnd);
		addFormlayout.addComponent(remark);
		addFormlayout.addComponent(startDate);
		addFormlayout.addComponent(status);
		
		Button okButton = new Button("增加");
		addFormbinder =new BeanFieldGroup<CrmExchangeRule>(CrmExchangeRule.class);
		addFormbinder.setItemDataSource(item);
		addFormbinder.setBuffered(true);
		addFormbinder.bindMemberFields(this); // 绑定
		okButton.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				boolean flag = addFormbinder.isValid();
				log.info(">>>>>>>>>>>>>> 验证结果 :"+flag);
				if (!flag) {
					Notification.show("带 * 字段不能为空，请填写完成再提交");
				}else {
					try {
						addFormbinder.commit();
						CrmExchangeRule exchange=new CrmExchangeRule();
						exchange.setRuleCode(Long.parseLong(ruleCode.getValue()));
						exchange.setRuleName(ruleName.getValue());
						exchange.setRuleNumberBegin(Long.parseLong(ruleNumberBegin.getValue()));
						exchange.setRuleNumberEnd(Long.parseLong(ruleNumberEnd.getValue()));
						exchange.setStartDate(startDate.getValue());
						exchange.setRemark(remark.getValue());
						exchange.setStatus(status.getValue());
						
						exchangeManager.saveExchange(exchange);
						
						fillContainer(exchangeManager);
						tb.setContainerDataSource(exchangeRuleContainer); // 这里数据源要切换
					} catch (CommitException e) {
						e.printStackTrace();
					}
					window.close();
				}
				
			}
		});
		addFormlayout.addComponent(okButton);
		return addFormlayout;
	}
	
	/**
	 * 绑定表单中数据的
	 * 
	 * @param newDataSource
	 */
	public void setItemDataSource(Item newDataSource) {
		btFormbinder = new BeanFieldGroup<CrmExchangeRule>(CrmExchangeRule.class);
		btFormbinder.setItemDataSource(newDataSource);
		btFormbinder.setBuffered(true);
		btFormbinder.bindMemberFields(this); // 绑定

		btFormlayout.setVisible(true); // 控制表单显示
		btFormlayout.addComponent(footer);
		footer.setVisible(true);
	}
	
	@Override
	public void setReadOnly(boolean readOnly) {
		// super.setReadOnly(readOnly);
		// 设置文本框为不可编辑模式
		if (btFormlayout != null && btFormbinder != null) {
			Collection<Object> propertyIds = btFormbinder.getBoundPropertyIds();
			for (Iterator iterator = propertyIds.iterator(); iterator.hasNext();) {
				String propertyId = (String) iterator.next();
				com.vaadin.ui.Field fid = btFormbinder.getField(propertyId);
				if (fid instanceof TextField) {
					// 变成不可编辑状态
					fid.setReadOnly(readOnly);
				}
			}
		}
		save.setVisible(!readOnly);
		cancel.setVisible(!readOnly);
		edit.setVisible(readOnly);
	}
		
}
