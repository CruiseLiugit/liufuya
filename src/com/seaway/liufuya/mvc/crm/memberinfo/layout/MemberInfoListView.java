package com.seaway.liufuya.mvc.crm.memberinfo.layout;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.mvc.crm.memberinfo.dao.impl.MemberInfoMemberBean;
import com.seaway.liufuya.mvc.crm.memberinfo.data.Citypart;
import com.seaway.liufuya.mvc.crm.memberinfo.data.Member;
import com.seaway.liufuya.mvc.crm.memberinfo.data.MemberBean;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Container.Filter;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.filter.Compare.Greater;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Reindeer;

/**
 * 会员资料面板 把表格和表单合并在一个类中管理
 * 
 * @author lililiu
 * 
 */
@SuppressWarnings("serial")
public class MemberInfoListView extends VerticalLayout implements ClickListener {
	private static final Log log = Logs.get();

	// ---------表格需要的
	// 定义一个表格使用的容器对象
	private BeanItemContainer<MemberBean> container = new BeanItemContainer<MemberBean>(
			MemberBean.class);
	// 每列宽度
	private static final int[] COLUMN_WIDTHS = { 120, 60, 50, 90, 180, 120, 80,
			80, 120 };
	// 间隙
	private static final int COLUMN_SPACE = 13;
	// 查询会员数据的数据库对象
	private MemberInfoMemberBean memberManager = null;
	// 整个页面，上下分割的 垂直布局面板
	private final VerticalSplitPanel vsplit = new VerticalSplitPanel();
	private Table tb = null;   //页面显示数据表格
	// ---------下面表单 查询，修改需要
	private VerticalLayout buttonVLayout = new VerticalLayout();
	private Button save = new Button("保存", (ClickListener) this);
	private Button cancel = new Button("取消", (ClickListener) this);
	private Button edit = new Button("编辑", (ClickListener) this);

	private final NativeSelect cities = new NativeSelect("城市");
	private HorizontalLayout footer; // 底部
	// Member that will bind to the "name" property
	// TextField 对象名称与传递进来的 PropertyId 数据名称一致，就不用
	// @PropertyId("firstName")
	// 只有两者不一样的时候，才用 @PropertyId 进行统一
	// 1.实体卡 2.网站注册 3.微信注册 4.后台注册
	TextField telphone = null;// 整个作为登录账户
	TextField realName = null;// 真实姓名
	NativeSelect sex = null; // // 1.男 0女
	PopupDateField birthday = null; // 生日
	TextField card_number = null; // 身份证号
	TextField email = null;
	NativeSelect work_type = null; // 工作类型
	NativeSelect family_money = null; // 家庭收入
	NativeSelect age_area = null; // 年龄段
	TextField entityCardNumber = null; // 实体卡卡号
	// 1 已开卡 2 已使用 3 已作废
	NativeSelect entityCardStatus = null; // 实体卡状态
	// 余额、积分 实体卡从 crds 表获取，根据 关联 id 一一获取
	TextField memberCard_balance = null; // 会员卡余额
	TextField memberCard_score = null; // 会员卡积分

	// //////////////////////////////////////////////////////
	// 编辑的表单
	FormLayout btFormlayout = new FormLayout();
	FieldGroup btFormbinder = null;
	// 增加的表单
	FormLayout addFormlayout = new FormLayout();
	FieldGroup addFormbinder = null;

	// 为了美观，底部添加一个 TabSheet
	TabSheet tabsheet = new TabSheet();

	public MemberInfoListView(MemberInfoMemberBean memberManager) {
		this.memberManager = memberManager;
		this.init();

		// 右侧创建一个导航工具条,水平布局
		HorizontalLayout navBar = new HorizontalLayout();
		navBar.setStyleName(Reindeer.LAYOUT_BLACK);
		navBar.setWidth(100, Unit.PERCENTAGE);
		navBar.setHeight(29, Unit.PIXELS);
		Label lblNav = new Label("CRM系统 / 会员管理"); // 导航

		HorizontalLayout navBarButtons = new HorizontalLayout();
		Button btnAdd = new Button("新增"); // 增加 按钮
		btnAdd.setIcon(new ThemeResource("icons/16/add.png"));
		btnAdd.setDescription("增加会员");
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
				openProductWindow(new BeanItem<Member>(new Member()), "新增会员窗口");
			}
		});

		btnDownload.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// personForm.addContact(); // 增加
				Notification.show("报表功能正在完成中，请等待", Type.HUMANIZED_MESSAGE);

			}
		});

		vsplit.setStyleName(Reindeer.LAYOUT_WHITE); // 右侧样式
		vsplit.setHeight(470, Unit.PIXELS);
		// this.setStyleName(Reindeer.SPLITPANEL_SMALL); //分割线变细线
		// /////////////////////////////////////////////////////////////////
		fillContainer(container);

		// 对表格进行改进，增加对每个字段的搜索过滤框
		VerticalLayout tablelayout = new VerticalLayout();
		tb = createTable(container);
		tablelayout.addComponent(createFilters(tb)); // 表格过滤框
		tablelayout.addComponent(tb); // 表格
		vsplit.setFirstComponent(tablelayout);
		vsplit.setSecondComponent(createForm(null)); // 这里把创建表单的代码，放在表格点击事件中
		// /////////////////////////////////////////////////////////////////
		vsplit.setSplitPosition(40);

		this.addComponent(navBar); // 导航栏
		this.addComponent(vsplit); // 上下分割面板
		this.setExpandRatio(vsplit, 1);
	}

	// --------------------------------------------------------------
	// 初始化页面组件
	private void init() {
		telphone = new TextField("手机号码"); // 整个作为登录账户
		realName = new TextField("真实姓名");// 真实姓名
		sex = new NativeSelect("性别"); // // 1.男 0女
		birthday = new PopupDateField("会员生日"); // 生日
		card_number = new TextField("身份证号"); // 身份证号
		email = new TextField("邮箱");
		work_type = new NativeSelect("工作类型"); // 工作类型
		family_money = new NativeSelect("家庭收入"); // 家庭收入
		age_area = new NativeSelect("年龄段"); // 年龄段
		entityCardNumber = new TextField("实体卡卡号"); // 实体卡卡号
		// 1 已开卡 2 已使用 3 已作废
		entityCardStatus = new NativeSelect("实体卡状态"); // 实体卡状态
		// 余额、积分 实体卡从 crds 表获取，根据 关联 id 一一获取
		memberCard_balance = new TextField("会员卡余额"); // 会员卡余额
		memberCard_score = new TextField("会员卡积分"); // 会员卡积分

		
		// 允许用户输入新的城市
		// cities.setNewItemsAllowed(true);
		// 不允许输入空值
		cities.setNullSelectionAllowed(false);
		// 从数据库 获取所有的城市
		List<Citypart> citylist = memberManager.getTopCityList();
		for (int j = 0; j < citylist.size(); j++) {
			Citypart citypart = citylist.get(j);
			cities.addItem(j);
			cities.setItemCaption(j, citypart.getAddress_name());
		}
		cities.setNullSelectionAllowed(false); 
		cities.setValue(0);
		cities.setImmediate(true);
		
		// 性别
		sex.addItem(0);
        sex.setItemCaption(0, "男");
		sex.addItem(1);
		sex.setItemCaption(1,"女");
		sex.setValue(0);  //默认选择 男
		sex.setNullSelectionAllowed(false);
		sex.setImmediate(true);

		// 生日
		birthday.setImmediate(true);
		birthday.setTimeZone(TimeZone.getTimeZone("UTC"));
		birthday.setLocale(Locale.CHINA);
		birthday.setResolution(Resolution.DAY);
		// 工作类型
		for (int i = 0; i < Constants.MEMBER_WORK_TYPES.length; i++) {
			String type= Constants.MEMBER_WORK_TYPES[i];
			work_type.addItem(i);
			work_type.setItemCaption(i, type);
		}
		work_type.setNullSelectionAllowed(false); 
		work_type.setValue(0);
		work_type.setImmediate(true);
		
		// 家庭收入
		for (int i = 0; i < Constants.MEMBER_FAMILY_MONEY.length; i++) {
			String type= Constants.MEMBER_FAMILY_MONEY[i];
			family_money.addItem(i);
			family_money.setItemCaption(i, type);
		}
		family_money.setNullSelectionAllowed(false); 
		family_money.setValue(0);
		family_money.setImmediate(true);

		// 年龄段
		for (int i = 0; i < Constants.MEMBER_AGE_AREAS.length; i++) {
			String type= Constants.MEMBER_AGE_AREAS[i];
			age_area.addItem(i);
			age_area.setItemCaption(i, type);
		}
		age_area.setNullSelectionAllowed(false); 
		age_area.setValue(0);
		age_area.setImmediate(true);

		// 实体卡状态
		for (int i = 0; i < Constants.MEMBER_ENTITY_CARD_STATUS.length; i++) {
			String type= Constants.MEMBER_ENTITY_CARD_STATUS[i];
			entityCardStatus.addItem(i);
			entityCardStatus.setItemCaption(i, type);
		}
		entityCardStatus.setNullSelectionAllowed(false); 
		entityCardStatus.setValue(0);
		entityCardStatus.setImmediate(true);

		// 必填项
		telphone.setRequired(true);
		realName.setRequired(true);
		sex.setRequired(true);

		// placeHolder提示
		telphone.setInputPrompt("手机号码作为登录名");

		// 长度限制
		telphone.setMaxLength(11);
		card_number.setMaxLength(19);
		realName.setMaxLength(20);
		email.setMaxLength(25);

		// 输入校验
		// firstName.setNullRepresentation(""); // 为空是替换为""
		email.addValidator(new EmailValidator("请输入正确的邮箱地址，如xxx@163.com"));
		// 正则表达式验证
		telphone.addValidator(new RegexpValidator("[1-9][0-9]{10}", "请输入11位手机号码"));
//		memberCard_balance.addValidator(new RegexpValidator("[0-9]*",
//				"请输入数字"));
//		memberCard_score.addValidator(new RegexpValidator("[0-9]*",
//				"请输入数字"));
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
		table.setHeight(230, Unit.PIXELS);
		table.setContainerDataSource(container); // 这里数据源要切换

		table.setVisibleColumns(Constants.MEMEBER_COL_ORDER);
		table.setColumnHeaders(Constants.MEMEBER_COL_HEADERS_CHINESE);

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
				editContact((MemberBean) event.getItemId());
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
		for (final Object columnID : Constants.MEMEBER_COL_ORDER) {
			int columnWidth = COLUMN_WIDTHS[i++]; // 列宽
			table.setColumnWidth(columnID, columnWidth); // 设置列宽
			final TextField field = new TextField(); // 创建文本框跟列宽一致
			field.setWidth(columnWidth + COLUMN_SPACE, Unit.PIXELS);

			if ("cardscore".equals(columnID) || "cardbalance".equals(columnID)) {
				//field.setConverter(Integer.class);
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

		if ("cardscore".equals(columnID) || "cardbalance".equals(columnID)) {
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


	private Layout createAddForm(Item item, final Window window) {
		// 往 FormLayout 中添加组件
		addFormlayout.removeAllComponents();
		addFormlayout.setWidth(100, Unit.PERCENTAGE);
		addFormlayout.setSpacing(true);

		addFormlayout.addComponent(telphone);
		addFormlayout.addComponent(realName);
		//addFormlayout.addComponent(sex);
		addFormlayout.addComponent(birthday);
		addFormlayout.addComponent(card_number);
		addFormlayout.addComponent(email);
		addFormlayout.addComponent(cities);
		addFormlayout.addComponent(work_type);
		addFormlayout.addComponent(family_money);
		addFormlayout.addComponent(age_area);
		addFormlayout.addComponent(entityCardNumber);
		addFormlayout.addComponent(entityCardStatus);
		addFormlayout.addComponent(memberCard_balance);
		addFormlayout.addComponent(memberCard_score);
		
		addFormbinder = new BeanFieldGroup<Member>(Member.class);
		addFormbinder.setItemDataSource(item);
		addFormbinder.setBuffered(true);
		addFormbinder.bindMemberFields(this); // 绑定

		Button okButton = new Button("增加");
		okButton.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				try {
					//boolean flag = addFormbinder.isValid();
					boolean flag = false;
					log.info(">>>>>>>>>>>>>> 表单验证结果 :"+flag);
					if (flag) {
						Notification.show("带 * 字段不能为空，请填写完成再提交");
						//验证电话重复
						String loginname = telphone.getValue();
						Member mb = memberManager.getMemeberByLoginname(loginname);
						if (mb != null && !mb.getUser_code().equals("")) {
							Notification.show("该电话号码，已经被注册，请更换手机号码");
						}
					} else {
						addFormbinder.commit();
						// 提交到数据库
						Member ml = new Member();
						ml.setTelphone(telphone.getValue());  
						ml.setLoginName(telphone.getValue()); //登录名就是手机号码
						ml.setRealName(realName.getValue());
						ml.setBirthday(birthday.getValue());
						ml.setCard_number(card_number.getValue());
						ml.setEmail(email.getValue());
						ml.setEntityCardNumber(entityCardNumber.getValue());
						ml.setMemberCard_balance(new Integer(memberCard_balance.getValue()));
						ml.setMemberCard_score(new Integer(memberCard_score.getValue()));
												
						final String[] objs = new String[5]; 
//						sex.addValueChangeListener(new ValueChangeListener() {
//				            @Override
//				            public void valueChange(final ValueChangeEvent event) {
//				            		objs[0] = String.valueOf(event.getProperty()
//				                        .getValue());
//				            }
//				        });
						
						//获取 下拉选项框中的值
						cities.addValueChangeListener(new ValueChangeListener() {
							@Override
							public void valueChange(final ValueChangeEvent event) {
								final String valueString = String.valueOf(event.getProperty()
				                        .getValue());
								objs[1] = valueString;
				                Notification.show("城市:", valueString,
				                        Type.TRAY_NOTIFICATION);
							}
				        });
						log.info(">>>>>>>>>>>>>>>>>  选中性别 :"+objs[0]+"   ,  city :"+objs[1]);
						
						//memberManager.saveMember(ml);
						
						/*
	OptionGroup sex = null; // // 1.男 0女
	ComboBox work_type = null; // 工作类型
	ComboBox family_money = null; // 家庭收入
	ComboBox age_area = null; // 年龄段
	// 1 已开卡 2 已使用 3 已作废
	ComboBox entityCardStatus = null; // 实体卡状态
	
						 * */
//						service.saveMemberLevel(name, begin, end, createPerson);
						
						// /////////////////////////////////////////////////////////////////
						fillContainer(container);
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
		btFormlayout.removeAllComponents();
		btFormlayout.setWidth(100, Unit.PERCENTAGE);
		btFormlayout.setSpacing(true);

		btFormlayout.addComponent(telphone);
		btFormlayout.addComponent(realName);
		btFormlayout.addComponent(sex);
		btFormlayout.addComponent(birthday);
		btFormlayout.addComponent(card_number);
		btFormlayout.addComponent(email);
		btFormlayout.addComponent(work_type);
		btFormlayout.addComponent(family_money);
		btFormlayout.addComponent(age_area);
		btFormlayout.addComponent(entityCardNumber);
		btFormlayout.addComponent(entityCardStatus);
		btFormlayout.addComponent(memberCard_balance);
		btFormlayout.addComponent(memberCard_score);

		// ***** 默认不显示表单 *****
		btFormlayout.setVisible(false);

		// 默认显示图标
		tabsheet.addTab(btFormlayout, "会员管理", new ThemeResource(
				"icons/16/user-normal.png"));
		buttonVLayout.addComponent(tabsheet);

		return buttonVLayout;
	}

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
			btFormbinder.discard();
			setReadOnly(true);
		} else if (source == edit) {
			setReadOnly(false);
		}
	}

	/**
	 * 绑定表单中数据的
	 * 
	 * @param newDataSource
	 */
	public void setItemDataSource(Item newDataSource) {
		// 手动控制 Field 字段的生成顺序
		// Now create a binder that can also create the fields
		// using the default field factory
		// btFormbinder = new FieldGroup(newDataSource);
		btFormbinder = new BeanFieldGroup<Member>(Member.class);
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

	/**
	 * 表格选中某一行后，跳转过来到这里编辑
	 * 
	 * @param person
	 */
	public void editContact(MemberBean bean) {
		// log.info("点击    编辑   按钮...........name = "+bean.getRealname()+"  loginname ="+bean.getLoginname());
		Tab tab = tabsheet.getTab(btFormlayout);
		tab.setIcon(new ThemeResource("icons/16/user-edit.png"));
		// 这里根据登录名，查询出会员完整信息
		Member mb = this.memberManager.getMemeberByLoginname(bean
				.getLoginname());
		// 根据穿过来的 Bean 对象，创建表格输入框
		setItemDataSource(new BeanItem(mb));
		setReadOnly(true);
	}

	/**
	 * 获取表格的 容器对象
	 * 
	 * @param container
	 */
	private void fillContainer(Container container) {
		List<MemberBean> list = memberManager.getMemberBeanList();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			MemberBean memberBean = (MemberBean) iterator.next();
			container.addItem(memberBean);
		}
	}

}
