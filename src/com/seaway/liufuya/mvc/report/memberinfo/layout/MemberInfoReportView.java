package com.seaway.liufuya.mvc.report.memberinfo.layout;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang.time.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.mvc.crm.memberinfo.dao.impl.MemberInfoMemberBean;
import com.seaway.liufuya.mvc.crm.memberinfo.data.Citypart;
import com.seaway.liufuya.mvc.crm.memberinfo.data.Member;
import com.seaway.liufuya.mvc.report.TemporaryFileDownloadResource;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

/**
 * 会员资料面板 把表格和表单合并在一个类中管理
 * 
 * @author lililiu
 * 
 */
@SuppressWarnings("serial")
public class MemberInfoReportView extends VerticalLayout implements
		ClickListener {
	private static final Log log = Logs.get();
	/**
	 * Natural property order for Person bean. Used in tables and forms.
	 */
	public String[] MEMEBER_COL_REPORT = new String[] { "realName",
			"user_type", "loginName", "sex", "birthday", "work_type", "city",
			"entityCardNumber", "memberCard_score", "memberCard_balance",
			"create_date", "status" };
	/**
	 * "表头列名" captions for properties in same order as in NATURAL_COL_ORDER.
	 */
	public String[] MEMEBER_COL_REPORT_CHINESE = new String[] { "用户名", "用户类型",
			"手机号", "性别", "生日", "工作", "城市", "实体卡号", "积分", "余额", "注册日期", "状态" };

	// ---------表格需要的
	// 定义一个表格使用的容器对象
	private BeanItemContainer<Member> container = new BeanItemContainer<Member>(
			Member.class);

	// 查询会员数据的数据库对象
	private MemberInfoMemberBean memberManager = null;
	// 整个页面，上下分割的 垂直布局面板
	// private final VerticalSplitPanel vsplit = new VerticalSplitPanel();
	private final HorizontalSplitPanel hsPanel = new HorizontalSplitPanel();

	private Table tb = null; // 页面显示数据表格

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

	public MemberInfoReportView(MemberInfoMemberBean memberManager) {
		this.memberManager = memberManager;
		this.init();

		// -----------------------------------------------------------------------
		// 右侧，导航栏下方 工具栏
		HorizontalLayout topLayOut = new HorizontalLayout();
		topLayOut.setStyleName(Reindeer.LAYOUT_BLUE);
		topLayOut.setWidth(100, Unit.PERCENTAGE);
		topLayOut.setHeight(35, Unit.PIXELS);
		HorizontalLayout searchBar = new HorizontalLayout();
		final TextField searchText = new TextField();
		searchText.setStyleName(Reindeer.LAYOUT_WHITE);
		Button search = new Button("用户名、手机号查询"); // 增加 按钮
		search.setIcon(new ThemeResource("icons/16/search.png"));
		search.setDescription("根据用户名和手机查询");
		searchBar.addComponent(searchText);
		searchBar.addComponent(search);

		HorizontalLayout timeBar = new HorizontalLayout();
		Label fromText = new Label();
		final DateField from = new DateField();
		from.setDateFormat("yyyy-MM-dd");
		// from.setReadOnly(true);
		Label toText = new Label("--");
		final DateField to = new DateField();
		to.setDateFormat("yyyy-MM-dd");
		// to.setReadOnly(true);
		Button timeSearch = new Button("注册时间查询"); // 增加 按钮
		timeSearch.setIcon(new ThemeResource("icons/16/search.png"));

		timeBar.addComponent(fromText);
		timeBar.addComponent(from);
		timeBar.addComponent(toText);
		timeBar.addComponent(to);
		timeBar.addComponent(timeSearch);

		timeSearch.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Date fromDate = from.getValue();
				Date toDate = to.getValue();
				fillContainer(container, fromDate, toDate);
				VerticalLayout tablelayout = new VerticalLayout();
				tablelayout.setStyleName(Reindeer.LAYOUT_WHITE); // 右侧样式
				tablelayout.setHeight(436, Unit.PIXELS);
				tablelayout.setWidth(100,Unit.PERCENTAGE);
				tb = createTable(container);
				tablelayout.addComponent(tb); // 表格
				hsPanel.setSecondComponent(tablelayout);
			}
		});

		search.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				String value = searchText.getValue();
				fillContainer(container, value);
				VerticalLayout tablelayout = new VerticalLayout();
				tablelayout.setStyleName(Reindeer.LAYOUT_WHITE); // 右侧样式
				tablelayout.setHeight(436, Unit.PIXELS);
				tablelayout.setWidth(100, Unit.PERCENTAGE);
				tb = createTable(container);
				tablelayout.addComponent(tb); // 表格
				hsPanel.setSecondComponent(tablelayout);
			}
		});

		topLayOut.addComponent(searchBar);
		topLayOut.setComponentAlignment(searchBar, Alignment.MIDDLE_LEFT);
		topLayOut.addComponent(timeBar);
		topLayOut.setComponentAlignment(timeBar, Alignment.MIDDLE_RIGHT);

		// -----------------------------------------------------------------------
		// 右侧，最顶部导航栏
		// 右侧创建一个导航工具条,水平布局
		HorizontalLayout navBar = new HorizontalLayout();
		navBar.setStyleName(Reindeer.LAYOUT_BLACK);
		navBar.setWidth(100, Unit.PERCENTAGE);
		navBar.setHeight(29, Unit.PIXELS);
		Label lblNav = new Label("CRM系统 / 会员查询报表"); // 导航

		HorizontalLayout navBarButtons = new HorizontalLayout();
		Button btnExport = new Button("导出"); // 增加 按钮
		btnExport.setIcon(new ThemeResource("icons/16/disk-download.png"));
		btnExport.setDescription("导出列表");

		navBarButtons.addComponent(btnExport);

		btnExport.addClickListener(new Button.ClickListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void buttonClick(ClickEvent event) {
				try {

					File tempFile = File.createTempFile("tmp", ".xls");

					HSSFWorkbook workbook = new HSSFWorkbook();
					HSSFSheet firstSheet = workbook.createSheet("sheet1");
					HSSFRow row1 = firstSheet.createRow(0);

					List<Member> list = container.getItemIds();
					for (int i = 0; i < list.size() + 1; i++) {
						if (i == 0) {
							for (short j = 0; j < MEMEBER_COL_REPORT_CHINESE.length; j++) {
								HSSFCell cellA = row1.createCell(j);
								cellA.setCellValue(MEMEBER_COL_REPORT_CHINESE[j]);
							}
						} else {
							Member m = list.get(i - 1);
							HSSFRow rowA = firstSheet.createRow(i);
							for (int j = 0; j < MEMEBER_COL_REPORT.length; j++) {
								HSSFCell cell = rowA.createCell((short) j);
								if (MEMEBER_COL_REPORT[j].equals("realName")) {
									cell.setCellValue(m.getRealName());
								}
								if (MEMEBER_COL_REPORT[j].equals("loginName")) {
									cell.setCellValue(m.getLoginName());
								}
								if (MEMEBER_COL_REPORT[j].equals("user_type")) {
									cell.setCellValue(m.getUser_type());
								}
								if (MEMEBER_COL_REPORT[j].equals("sex")) {
									cell.setCellValue(m.getSex());
								}
								if (MEMEBER_COL_REPORT[j].equals("birthday")) {
									cell.setCellValue(m.getBirthday());
								}
								if (MEMEBER_COL_REPORT[j].equals("work_type")) {
									cell.setCellValue(m.getWork_type());
								}
								if (MEMEBER_COL_REPORT[j].equals("city")) {
									cell.setCellValue(m.getCity());
								}
								if (MEMEBER_COL_REPORT[j]
										.equals("entityCardNumber")) {
									cell.setCellValue(m.getCard_number());
								}
								if (MEMEBER_COL_REPORT[j]
										.equals("memberCard_score")) {
									cell.setCellValue(m.getMemberCard_score());
								}
								if (MEMEBER_COL_REPORT[j]
										.equals("memberCard_balance")) {
									cell.setCellValue(m.getMemberCard_balance());
								}
								if (MEMEBER_COL_REPORT[j].equals("create_date")) {
									cell.setCellValue(m.getCreate_date());
								}
								if (MEMEBER_COL_REPORT[j].equals("status")) {
									cell.setCellValue(m.getStatus());
								}
							}
						}
					}
					FileOutputStream fos = null;

					fos = new FileOutputStream(tempFile);
					workbook.write(fos);

					fos.flush();
					fos.close();

					// Create contents here, using POI, and write to tempFile
					TemporaryFileDownloadResource resource;

					resource = new TemporaryFileDownloadResource(
							"default-name-of-file.xls",
							"application/vnd.ms-excel", tempFile);
					UI.getCurrent().getPage().open(resource, "_self", false);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

		navBar.addComponent(lblNav);
		navBar.addComponent(navBarButtons);

		navBar.setComponentAlignment(lblNav, Alignment.MIDDLE_LEFT);
		navBar.setComponentAlignment(navBarButtons, Alignment.MIDDLE_RIGHT);

		// /////////////////////////////////////////////////////////////////
		//fillContainer(container);

		// 对表格进行改进，增加对每个字段的搜索过滤框
		VerticalLayout tablelayout = new VerticalLayout();
		tablelayout.setStyleName(Reindeer.LAYOUT_WHITE); // 右侧样式
		tablelayout.setHeight(436, Unit.PIXELS);
		tablelayout.setWidth("100%");
		tb = createTable(container);
		// tablelayout.addComponent(createFilters(tb)); // 表格过滤框
		tablelayout.addComponent(tb); // 表格

		hsPanel.setStyleName(Reindeer.LAYOUT_WHITE); // 右侧样式
		hsPanel.setHeight(500, Unit.PIXELS);
		hsPanel.setFirstComponent(createLayout());
		hsPanel.setSecondComponent(tablelayout);
		hsPanel.setSizeFull();
		hsPanel.setSplitPosition(10, Unit.PERCENTAGE);

		// /////////////////////////////////////////////////////////////////
		this.addComponent(topLayOut);
		this.addComponent(navBar); // 导航栏
		this.addComponent(hsPanel); // 上下分割面板
	}

	private Layout createLayout() {
		VerticalLayout vertical = new VerticalLayout();
		vertical.setHeight(500, Unit.PIXELS);
		vertical.setSizeFull();
		final CheckBox username = new CheckBox("用户名", true);
		username.setEnabled(false);
		final CheckBox type = new CheckBox("类型", true);
		type.setEnabled(false);
		final CheckBox phoneNo = new CheckBox("手机号", true);
		phoneNo.setEnabled(false);

		final CheckBox gender = new CheckBox("性别", true);
		final CheckBox birthday = new CheckBox("生日", true);
		final CheckBox work = new CheckBox("工作", true);
		final CheckBox city = new CheckBox("城市", true);
		final CheckBox entityCardNumber = new CheckBox("实体卡号", true);
		final CheckBox memberCard_score = new CheckBox("积分", true);
		final CheckBox memberCard_balance = new CheckBox("余额", true);
		final CheckBox create_date = new CheckBox("注册日期", true);
		final CheckBox status = new CheckBox("状态", true);

		vertical.addComponent(username);
		vertical.addComponent(type);
		vertical.addComponent(phoneNo);
		vertical.addComponent(gender);
		vertical.addComponent(birthday);
		vertical.addComponent(work);
		vertical.addComponent(city);
		vertical.addComponent(entityCardNumber);
		vertical.addComponent(memberCard_score);
		vertical.addComponent(memberCard_balance);
		vertical.addComponent(create_date);
		vertical.addComponent(status);

		Button button1 = new Button("生成报表");
		Button button2 = new Button("生成图形");

		button1.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {

				MEMEBER_COL_REPORT = new String[] { "realName", "user_type",
						"loginName" };
				MEMEBER_COL_REPORT_CHINESE = new String[] { "用户名", "用户类型",
						"手机号" };

				List<String> report = new ArrayList<String>();
				List<String> chinese = new ArrayList<String>();
				Collections.addAll(report, MEMEBER_COL_REPORT);
				Collections.addAll(chinese, MEMEBER_COL_REPORT_CHINESE);

				if (gender.getValue()) {
					report.add("sex");
					chinese.add("性别");
				}
				if (birthday.getValue()) {
					report.add("birthday");
					chinese.add("生日");
				}
				if (work.getValue()) {
					report.add("work_type");
					chinese.add("工作");
				}
				if (city.getValue()) {
					report.add("city");
					chinese.add("城市");
				}
				if (entityCardNumber.getValue()) {
					report.add("entityCardNumber");
					chinese.add("实体卡号");
				}
				if (memberCard_score.getValue()) {
					report.add("memberCard_score");
					chinese.add("积分");
				}
				if (memberCard_balance.getValue()) {
					report.add("memberCard_balance");
					chinese.add("余额");
				}
				if (create_date.getValue()) {
					report.add("create_date");
					chinese.add("注册日期");
				}
				if (status.getValue()) {
					report.add("status");
					chinese.add("状态");
				}
				MEMEBER_COL_REPORT = report.toArray(MEMEBER_COL_REPORT);
				MEMEBER_COL_REPORT_CHINESE = (String[]) chinese
						.toArray(MEMEBER_COL_REPORT_CHINESE);

				VerticalLayout tablelayout = new VerticalLayout();
				tablelayout.setStyleName(Reindeer.LAYOUT_WHITE); // 右侧样式
				tablelayout.setHeight(470, Unit.PIXELS);
				tablelayout.setWidth("100%");
				// tablelayout.setHeight("100%");
				tb = createTable(container);
				tablelayout.addComponent(tb); // 表格
				hsPanel.setSecondComponent(tablelayout);
			}
		});

		vertical.addComponent(button1);
		vertical.addComponent(button2);
		return vertical;
	}

	// --------------------------------------------------------------
	// 初始化页面组件
	private void init() {
		fillContainer(container);
		
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
		sex.setItemCaption(1, "女");
		sex.setValue(0); // 默认选择 男
		sex.setNullSelectionAllowed(false);
		sex.setImmediate(true);

		// 生日
		birthday.setImmediate(true);
		birthday.setTimeZone(TimeZone.getTimeZone("UTC"));
		birthday.setLocale(Locale.CHINA);
		birthday.setResolution(Resolution.DAY);
		// 工作类型
		for (int i = 0; i < Constants.MEMBER_WORK_TYPES.length; i++) {
			String type = Constants.MEMBER_WORK_TYPES[i];
			work_type.addItem(i);
			work_type.setItemCaption(i, type);
		}
		work_type.setNullSelectionAllowed(false);
		work_type.setValue(0);
		work_type.setImmediate(true);

		// 家庭收入
		for (int i = 0; i < Constants.MEMBER_FAMILY_MONEY.length; i++) {
			String type = Constants.MEMBER_FAMILY_MONEY[i];
			family_money.addItem(i);
			family_money.setItemCaption(i, type);
		}
		family_money.setNullSelectionAllowed(false);
		family_money.setValue(0);
		family_money.setImmediate(true);

		// 年龄段
		for (int i = 0; i < Constants.MEMBER_AGE_AREAS.length; i++) {
			String type = Constants.MEMBER_AGE_AREAS[i];
			age_area.addItem(i);
			age_area.setItemCaption(i, type);
		}
		age_area.setNullSelectionAllowed(false);
		age_area.setValue(0);
		age_area.setImmediate(true);

		// 实体卡状态
		for (int i = 0; i < Constants.MEMBER_ENTITY_CARD_STATUS.length; i++) {
			String type = Constants.MEMBER_ENTITY_CARD_STATUS[i];
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
		telphone.addValidator(new RegexpValidator("[1-9][0-9]{10}",
				"请输入11位手机号码"));

	}

	/**
	 * 在一个页面创建表格
	 * 
	 * @param container
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private Table createTable(final Container container) {
		final Table table = new Table(null, container);
		table.setSizeFull();
		table.setContainerDataSource(container); // 这里数据源要切换
		table.setVisibleColumns(MEMEBER_COL_REPORT);
		table.setColumnHeaders(MEMEBER_COL_REPORT_CHINESE);

		table.setColumnCollapsingAllowed(true);
		table.setColumnReorderingAllowed(true);
		/*
		 * Make table selectable, react immediatedly to user events, and pass
		 * events to the controller (our main application)
		 */
		table.setSelectable(true);
		table.setImmediate(true);
		/* We don't want to allow users to de-select a row */
		table.setNullSelectionAllowed(true);
		// table.setMultiSelect(true);

		table.addListener(new ItemClickListener() {
			@Override
			public void itemClick(ItemClickEvent event) {
				VerticalLayout tablelayout = new VerticalLayout();
				Member member = (Member) event.getItemId();
				if ("user_type".equals(event.getPropertyId())) {
					String value = member.getUser_typeCode();
					fillContainerByUserType(container, value);
				} else if ("sex".equals(event.getPropertyId())) {
					String value = member.getSexCode();
					fillContainerBySex(container, value);
				} else if ("work_type".equals(event.getPropertyId())) {
					String value = member.getWork_type();
					fillContainerByWork(container, value);
				} else if ("status".equals(event.getPropertyId())) {
					String value = member.getStatusCode();
					fillContainerByStatus(container, value);
				} else if ("city".equals(event.getPropertyId())) {

					String value = member.getCity();
					fillContainerByCity(container, value);
				} else if ("birthday".equals(event.getPropertyId())) {
					Date value = DateUtils.truncate(member.getCreate_date(),
							Calendar.DATE);
					fillContainer(container, value);
				} else {
					fillContainer(container);
				}
				tb = createTable(container);
				tablelayout.addComponent(tb); // 表格
				tablelayout.setStyleName(Reindeer.LAYOUT_WHITE); // 右侧样式
				tablelayout.setHeight(470, Unit.PIXELS);
				tablelayout.setWidth(100,Unit.PERCENTAGE);
				hsPanel.setSecondComponent(tablelayout);
			}
		});

		return table;
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

	/**
	 * 获取表格的 容器对象
	 * 
	 * @param container
	 */
	private void fillContainer(Container container) {
		container.removeAllItems();
		List<Member> list = memberManager.getMemberList();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Member member = (Member) iterator.next();
			container.addItem(member);
		}
	}

	/**
	 * 获取表格的 容器对象
	 * 
	 * @param container
	 */
	private void fillContainer(Container container, String value) {
		container.removeAllItems();
		List<Member> list = memberManager.getMemberByNameOrPhoneNo(value);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Member member = (Member) iterator.next();
			container.addItem(member);
		}
	}

	/**
	 * 获取表格的 容器对象
	 * 
	 * @param container
	 */
	private void fillContainer(Container container, Date value) {
		container.removeAllItems();
		List<Member> list = memberManager.getMemberByCreateDate(value);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Member member = (Member) iterator.next();
			container.addItem(member);
		}
	}

	/**
	 * 获取表格的 容器对象
	 * 
	 * @param container
	 */
	private void fillContainer(Container container, Date from, Date to) {
		container.removeAllItems();
		List<Member> list = memberManager.getMemberByCreateDate(from, to);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Member member = (Member) iterator.next();
			container.addItem(member);
		}
	}

	/**
	 * 获取表格的 容器对象
	 * 
	 * @param container
	 */
	private void fillContainerByUserType(Container container, String value) {
		container.removeAllItems();
		List<Member> list = memberManager.getMemberByUserType(value);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Member member = (Member) iterator.next();
			container.addItem(member);
		}
	}

	/**
	 * 获取表格的 容器对象
	 * 
	 * @param container
	 */
	private void fillContainerBySex(Container container, String value) {
		container.removeAllItems();
		List<Member> list = memberManager.getMemberBySex(value);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Member member = (Member) iterator.next();
			container.addItem(member);
		}
	}

	/**
	 * 获取表格的 容器对象
	 * 
	 * @param container
	 */
	private void fillContainerByStatus(Container container, String value) {
		container.removeAllItems();
		List<Member> list = memberManager.getMemberByStatus(value);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Member member = (Member) iterator.next();
			container.addItem(member);
		}
	}

	/**
	 * 获取表格的 容器对象
	 * 
	 * @param container
	 */
	private void fillContainerByCity(Container container, String value) {
		container.removeAllItems();
		List<Member> list = memberManager.getMemberByCity(value);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Member member = (Member) iterator.next();
			container.addItem(member);
		}
	}

	/**
	 * 获取表格的 容器对象
	 * 
	 * @param container
	 */
	private void fillContainerByWork(Container container, String value) {
		container.removeAllItems();
		List<Member> list = memberManager.getMemberByWork(value);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Member member = (Member) iterator.next();
			container.addItem(member);
		}
	}

	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub

	}

}
