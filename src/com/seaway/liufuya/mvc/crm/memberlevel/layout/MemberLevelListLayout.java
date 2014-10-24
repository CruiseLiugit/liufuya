package com.seaway.liufuya.mvc.crm.memberlevel.layout;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.common.util.DateUtil;
import com.seaway.liufuya.mvc.crm.memberlevel.dao.MemberLevelDao;
import com.seaway.liufuya.mvc.crm.memberlevel.pojo.MemberLevel;
import com.seaway.liufuya.mvc.crm.memberlevel.pojo.MemberLevelBean;
import com.seaway.liufuya.mvc.crm.memberlevel.service.MemberLevelService;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Container.Filter;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.filter.Compare.Greater;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.themes.Reindeer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * 会员等级面板
 * 
 * @author lililiu
 */
@SuppressWarnings("serial")
public class MemberLevelListLayout extends VerticalLayout implements
		ClickListener, ItemClickListener {

	private static final Log log = Logs.get();

	// ---------表格需要的
	// 定义一个表格使用的容器对象
	private BeanItemContainer<MemberLevelBean> container = new BeanItemContainer<MemberLevelBean>(
			MemberLevelBean.class);
	// 每列宽度
	private static final int[] COLUMN_WIDTHS = { 80, 60, 60, 70, 70 };
	// 间隙
	private static final int COLUMN_SPACE = 13;

	// 查询会员等级数据的数据库对象
	private MemberLevelDao memberLevelManager = null;
	private MemberLevelService service = null;

	// 整个页面，上下分割的 垂直布局面板
	private final HorizontalSplitPanel vsplit = new HorizontalSplitPanel();

	// ---------下面表单 查询，修改需要
	private Table tb = null;
	private VerticalLayout buttonVLayout = new VerticalLayout();
	private Button save = new Button("保存", (ClickListener) this);
	private Button cancel = new Button("取消", (ClickListener) this);
	private Button edit = new Button("编辑", (ClickListener) this);

	private HorizontalLayout footer; // 底部

	TextField levelName = new TextField("等级名称");
	TextField levelBegin = new TextField("积分范围起始值");
	TextField levelEnd = new TextField("积分范围终止值");

	FormLayout editFormlayout = new FormLayout();
	FieldGroup editFormbinder = null;
	// 为了美观，底部添加一个 TabSheet
	TabSheet tabsheet = new TabSheet();
	// 增加的表单布局
	FormLayout addFormlayout = new FormLayout();
	FieldGroup addFormbinder = null;

	public MemberLevelListLayout() {
	}

	public MemberLevelListLayout(MemberLevelDao memberLevelManager) {
		this.memberLevelManager = memberLevelManager;
		service = new MemberLevelService(memberLevelManager);

		// 右侧创建一个导航工具条,水平布局
		HorizontalLayout navBar = new HorizontalLayout();
		navBar.setStyleName(Reindeer.LAYOUT_BLACK);
		navBar.setWidth(100, Unit.PERCENTAGE);
		navBar.setHeight(29, Unit.PIXELS);
		Label lblNav = new Label("CRM系统 / 会员等级管理"); // 导航

		HorizontalLayout navBarButtons = new HorizontalLayout();
		Button btnAdd = new Button("新增"); // 增加 按钮
		btnAdd.setIcon(new ThemeResource("icons/16/add.png"));
		btnAdd.setDescription("增加会员等级");

		navBarButtons.addComponent(btnAdd);

		navBar.addComponent(lblNav);
		navBar.addComponent(navBarButtons);

		navBar.setComponentAlignment(lblNav, Alignment.MIDDLE_LEFT);
		navBar.setComponentAlignment(navBarButtons, Alignment.MIDDLE_RIGHT);

		btnAdd.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				openProductWindow(new BeanItem<MemberLevelBean>(
						new MemberLevelBean()), "新增会员等级");
			}
		});

		vsplit.setStyleName(Reindeer.LAYOUT_WHITE); // 右侧样式
		vsplit.setHeight(Constants.PAGE_HEIGHT, Unit.PIXELS);
		// this.setStyleName(Reindeer.SPLITPANEL_SMALL); //分割线变细线
		// /////////////////////////////////////////////////////////////////
		fillContainer(container);
		this.init();
		// /////////////////////////////////////////////////////////////////

		// 对表格进行改进，增加对每个字段的搜索过滤框
		VerticalLayout tablelayout = new VerticalLayout();
		tb = createTable(container);
		tablelayout.addComponent(createFilters(tb)); // 表格过滤框
		tablelayout.addComponent(tb); // 表格
		vsplit.setFirstComponent(tablelayout);
		vsplit.setSecondComponent(createForm(null)); // 这里把创建表单的代码，放在表格点击事件中
		// /////////////////////////////////////////////////////////////////
		vsplit.setSplitPosition(50);

		this.addComponent(navBar); // 导航栏
		this.addComponent(vsplit); // 上下分割面板
		this.setExpandRatio(vsplit, 1);
	}

	// --------------------------------------------------------------
	// 初始化页面组件
	private void init() {
		// 必填项
		levelName.setRequired(true);
		levelBegin.setRequired(true);
		levelEnd.setRequired(true);
		levelName.setImmediate(true);
		levelBegin.setImmediate(true);
		levelEnd.setImmediate(true);

		// placeHolder提示
		levelName.setInputPrompt("请输入中文名称");
		levelBegin.setInputPrompt("积分请输入正整数,起始值小于结束值");
		levelEnd.setInputPrompt("积分请输入正整数,起始值小于结束值");

		// 长度限制
		levelName.setMaxLength(20);
		levelBegin.setMaxLength(10); // 单位 亿
		levelEnd.setMaxLength(10); // 单位 亿

		// 输入校验
		// 正则表达式验证
		levelBegin.addValidator(new RegexpValidator("[0-9]*", "请输入数字"));
		levelEnd.addValidator(new RegexpValidator("[1-9][0-9]*", "请输入数字"));
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
		table.setHeight(Constants.PAGE_HEIGHT, Unit.PIXELS);
		table.setContainerDataSource(container); // 这里数据源要切换

		table.setVisibleColumns(Constants.MEMEBER_LEVEL_ORDER);
		table.setColumnHeaders(Constants.MEMEBER_LEVEL_CHINESE);

		table.setColumnCollapsingAllowed(true);
		table.setColumnReorderingAllowed(true);
		/*
		 * Make table selectable, react immediatedly to user events, and pass
		 * events to the controller (our main application)
		 */
		table.setSelectable(true);
		table.setImmediate(true);
		table.addItemClickListener(new ItemClickListener() {
			@Override
			public void itemClick(ItemClickEvent event) {
				log.info("选中一行,显示编辑用户表单 :" + event.getItemId());
				editContact((MemberLevelBean) event.getItemId());
			}
		});
		/* We don't want to allow users to de-select a row */
		table.setNullSelectionAllowed(false);

		return table;
	}

	/**
	 * 创建查询过滤 输入框
	 * 
	 * @param table
	 * @return
	 */
	private HorizontalLayout createFilters(final Table table) {
		HorizontalLayout filtersLayout = new HorizontalLayout();
		int i = 0;
		for (final Object columnID : Constants.MEMEBER_LEVEL_ORDER) {
			int columnWidth = COLUMN_WIDTHS[i++]; // 列宽
			table.setColumnWidth(columnID, columnWidth); // 设置列宽
			final TextField field = new TextField(); // 创建文本框跟列宽一致
			field.setWidth(columnWidth + COLUMN_SPACE, Unit.PIXELS);

			if ("levelBegin".equals(columnID) || "levelEnd".equals(columnID)) {
				// field.setConverter(Integer.class);
				Label lb = new Label();
				lb.setWidth(columnWidth + COLUMN_SPACE, Unit.PIXELS);
				filtersLayout.addComponent(lb);
				field.setVisible(false); // 隐藏掉这两个输入框
			}
			field.addTextChangeListener(new TextChangeListener() {
				@Override
				public void textChange(TextChangeEvent event) {
					filterTable(table, columnID, event.getText());
				}
			});

			filtersLayout.addComponent(field);
		}
		return filtersLayout;
	}

	/**
	 * 过滤查询
	 * 
	 * @param table
	 * @param columnID
	 * @param value
	 */
	private void filterTable(Table table, Object columnID, String value) {
		container.removeContainerFilters(columnID);

		if ("levelBegin".equals(columnID) || "levelEnd".equals(columnID)) {
			try {
				Filter greater = new Greater(columnID, new Integer(value));
				container.addContainerFilter(greater);
			} catch (NumberFormatException e) {
				if (!value.isEmpty()) {
					Notification.show("无法根据: " + value + " 进行查找....");
				}
			}
		} else {
			container.addContainerFilter(columnID, value, true, false);
		}
	}

	// -----------------------------------
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

	// ------------------------------------------------------
	// 底部 TabSheet 和 表单
	private Layout createForm(Item item) {
		footer = new HorizontalLayout();
		footer.setSpacing(true);
		footer.addComponent(save);
		footer.addComponent(cancel);
		footer.addComponent(edit);
		footer.setVisible(false);

		// 往 FormLayout 中添加组件
		editFormlayout.removeAllComponents();
		editFormlayout.setWidth(100, Unit.PERCENTAGE);
		editFormlayout.setSpacing(true);

		editFormlayout.addComponent(levelName);
		editFormlayout.addComponent(levelBegin);
		editFormlayout.addComponent(levelEnd);

		// ***** 默认不显示表单 *****
		editFormlayout.setVisible(false);

		// 默认显示图标
		tabsheet.addTab(editFormlayout, "会员等级管理", new ThemeResource(
				"icons/16/user-normal.png"));
		buttonVLayout.addComponent(tabsheet);

		return buttonVLayout;
	}

	private Layout createAddForm(Item item, final Window window) {
		// 往 FormLayout 中添加组件
		addFormlayout.removeAllComponents();
		addFormlayout.setWidth(100, Unit.PERCENTAGE);
		addFormlayout.setSpacing(true);

		addFormlayout.addComponent(levelName);
		addFormlayout.addComponent(levelBegin);
		addFormlayout.addComponent(levelEnd);

		addFormbinder = new BeanFieldGroup<MemberLevel>(MemberLevel.class);
		addFormbinder.setItemDataSource(item);
		addFormbinder.setBuffered(true);
		addFormbinder.bindMemberFields(this); // 绑定

		Button okButton = new Button("增加");
		okButton.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				try {
					boolean flag = addFormbinder.isValid();
					log.info(">>>>>>>>>>>>>> 验证结果 :"+flag);
					if (!flag) {
						Notification.show("带 * 字段不能为空，请填写完成再提交");
					} else {
						addFormbinder.commit();
						// 提交到数据库
						MemberLevel ml = new MemberLevel();
						ml.setLevelName(levelName.getValue());
						ml.setLevelBegin(new Integer(levelBegin.getValue()));
						ml.setLevelEnd(new Integer(levelEnd.getValue()));
						ml.setCreatePerson("刘立立");
						service.saveMemberLevel(ml); //更新数据库
						
						// /////////////////////////////////////////////////////////////////
						//container.removeAllItems();
						//fillContainer(container);
						//往容器中新增一条
						MemberLevelBean mlb = new MemberLevelBean();
						mlb.setLevelName(ml.getLevelName());
						mlb.setLevelBegin(""+ml.getLevelBegin());
						mlb.setLevelEnd(""+ml.getLevelEnd());
						mlb.setCreateTime(DateUtil.convertDateToString(new Date()));
						mlb.setCreatePerson(ml.getCreatePerson());
						container.addItem(mlb);
						tb.setContainerDataSource(container); // 这里数据源要切换
						window.close();
					}
				} catch (Exception e) {
					Notification.show(e.getMessage(), Type.ERROR_MESSAGE);
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
		// 手动控制 Field 字段的生成顺序
		editFormbinder = new BeanFieldGroup<MemberLevel>(MemberLevel.class);
		editFormbinder.setItemDataSource(newDataSource);
		editFormbinder.setBuffered(true);
		editFormbinder.bindMemberFields(this); // 绑定

		editFormlayout.setVisible(true); // 控制表单显示
		editFormlayout.addComponent(footer);
		footer.setVisible(true);
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		// super.setReadOnly(readOnly);
		// 设置文本框为不可编辑模式
		if (editFormlayout != null && editFormbinder != null) {
			Collection<Object> propertyIds = editFormbinder
					.getBoundPropertyIds();
			for (Iterator iterator = propertyIds.iterator(); iterator.hasNext();) {
				String propertyId = (String) iterator.next();
				com.vaadin.ui.Field fid = editFormbinder.getField(propertyId);
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

	// --------------------------------------------------------------

	@Override
	public void itemClick(ItemClickEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void buttonClick(ClickEvent event) {
		Button source = event.getButton();
		if (source == save) {
			/* If the given input is not valid there is no point in continuing */
			if (!this.editFormbinder.isValid()) {
				log.info("保存时，没有通过验证");
				Notification.show("带 * 字段不能为空，请填写完成再提交");
				return;
			}
			try {
				log.info("保存时，通过验证，提交.....");
				this.editFormbinder.commit();
				footer.setVisible(false); // 隐藏掉底部按钮布局
				// 新增
				log.info("保存，更新数据库数据，更新 app 中的数据源");
				// person = app.getPersonManager().savePerson(person);
				// setItemDataSource(new BeanItem(person));
				// app.getDataSource().refresh();

			} catch (CommitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			setReadOnly(true);
		} else if (source == cancel) {
			/* Clear the form and make it invisible */
			// setItemDataSource(null);
			editFormbinder.discard();
			setReadOnly(true);
		} else if (source == edit) {
			setReadOnly(false);
		}
	}

	// -------------------------------------------------------------
	/**
	 * 表格选中某一行后，跳转过来到这里编辑
	 * 
	 * @param person
	 */
	public void editContact(MemberLevelBean bean) {
		log.info("点击    编辑   按钮...........levelName = " + bean.getLevelName()
				+ "  createPerson =" + bean.getCreatePerson());
		Tab tab = tabsheet.getTab(editFormlayout);
		tab.setIcon(new ThemeResource("icons/16/user-edit.png"));

		// 从数据库取出完整的数据
		MemberLevel lbean = this.memberLevelManager.findByLevelName(bean
				.getLevelName());
		// 直接传给页面显示
		setItemDataSource(new BeanItem(lbean));
		setReadOnly(true);
	}

	/**
	 * 获取表格的 容器对象
	 * 
	 * @param container
	 */
	private void fillContainer(Container container) {
		List<MemberLevelBean> list = service.getMemberLevelBean(); // 模拟数据
		for (MemberLevelBean memberLevelBean : list) {
			container.addItem(memberLevelBean);
		}
	}

}
