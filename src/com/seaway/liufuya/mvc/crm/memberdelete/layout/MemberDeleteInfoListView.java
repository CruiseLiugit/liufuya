package com.seaway.liufuya.mvc.crm.memberdelete.layout;

import java.util.Iterator;
import java.util.List;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.mvc.crm.memberdelete.dao.impl.MemberDeleteInfoManagerImpl;
import com.seaway.liufuya.mvc.crm.memberdelete.data.MemberDeleteInfoBean;
import com.seaway.liufuya.mvc.crm.memberinfo.data.Member;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Container.Filter;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.filter.Compare.Greater;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.shared.MouseEventDetails.MouseButton;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.Reindeer;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.Window;

/**
 * 黑名单会员显示主界面
 * 
 * @author zg
 * **/
@SuppressWarnings("serial")
public class MemberDeleteInfoListView extends VerticalLayout implements
		ClickListener {
	private static final Log log = Logs.get();

	// ---------表格需要的
	// 定义一个表格使用的容器对象
	private BeanItemContainer<MemberDeleteInfoBean> container = new BeanItemContainer<MemberDeleteInfoBean>(
			MemberDeleteInfoBean.class);
	// 每列宽度
	private static final int[] COLUMN_WIDTHS = { 120, 60, 50, 90, 180, 120, 80,
			80, 120 };
	// 间隙
	private static final int COLUMN_SPACE = 13;

	// 查询Manager
	private MemberDeleteInfoManagerImpl mdInfoManager = null;

	// 开始定义布局对象
	private final VerticalSplitPanel vsplit = new VerticalSplitPanel();
	private Table tb = null;

	private HorizontalLayout footer; // 底部

	TextField telphone = null;// 整个作为登录账户
	TextField realName = null;// 真实姓名
	OptionGroup sex = null; // // 1.男 0女
	PopupDateField birthday = null; // 生日
	TextField card_number = null; // 身份证号
	TextField email = null;
	ComboBox work_type = null; // 工作类型
	ComboBox family_money = null; // 家庭收入
	ComboBox age_area = null; // 年龄段
	TextField entityCardNumber = null; // 实体卡卡号
	ComboBox entityCardStatus = null; // 实体卡状态 1 已开卡 2 已使用 3 已作废
	TextField memberCard_balance = null; // 会员卡余额 余额、积分 实体卡从 crds 表获取，根据 关联 id
											// 一一获取
	TextField memberCard_score = null; // 会员卡积分

	// 编辑的表单
	FormLayout btFormlayout = new FormLayout();
	FieldGroup btFormbinder = null;

	// 增加的表单
	FormLayout addFormlayout = new FormLayout();
	FieldGroup addFormbinder = null;

	// 为了美观，底部添加一个 TabSheet
	TabSheet tabsheet = new TabSheet();

	// 构造函数
	public MemberDeleteInfoListView(MemberDeleteInfoManagerImpl mdInfoManager) {
		// 传入由nutz管理注入的对象
		this.mdInfoManager = mdInfoManager;

		HorizontalLayout navBar = new HorizontalLayout();
		navBar.setStyleName(Reindeer.LAYOUT_BLACK);
		navBar.setWidth(100, Unit.PERCENTAGE);
		navBar.setHeight(29, Unit.PIXELS);
		Label lblNav = new Label("CRM系统 / 会员黑名单");

		// 导航栏标题
		navBar.addComponent(lblNav);

		vsplit.setStyleName(Reindeer.LAYOUT_WHITE); // 右侧样式
		vsplit.setHeight(Constants.PAGE_HEIGHT, Unit.PIXELS);

		// 创建表格使用的容器
		fillContainer(container);

		// 对表格进行改进，增加对每个字段的搜索过滤框
		VerticalLayout tablelayout = new VerticalLayout();
		tb = createTable(container);
		tablelayout.addComponent(createFilters(tb)); // 表格过滤框
		tablelayout.addComponent(tb); // 表格
		vsplit.setSplitPosition(100);

		this.addComponent(navBar); // 导航栏
		this.addComponent(tablelayout); // 上下分割面板

	}

	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub

	}

	/**
	 * 创建过滤器table
	 * **/
	private Table createTable(
			BeanItemContainer<MemberDeleteInfoBean> mdInfoBeanList) {
		final Table table = new Table(null, container);
		table.setSizeFull();
		table.setHeight(Constants.PAGE_HEIGHT, Unit.PIXELS);
		table.setContainerDataSource(container); // 这里数据源要切换

		table.setVisibleColumns(Constants.MEMEBER_DEL_COL_ORDER);
		table.setColumnHeaders(Constants.MEMEBER_DEL_COL_HEADERS_CHINESE);

		table.setColumnCollapsingAllowed(true);
		table.setColumnReorderingAllowed(true);

		table.setSelectable(true);
		table.setImmediate(true);
		table.setNullSelectionAllowed(false);
		table.addItemClickListener(itemClick());
		return table;
	}

	/**
	 * 单击表格 移除黑名单
	 * 
	 * @return ItemClickListener
	 * **/
	private ItemClickListener itemClick() {
		ItemClickListener icLister = new ItemClickListener() {

			@Override
			public void itemClick(ItemClickEvent event) {
				//MouseButton.LEFT 左键单击
				if (event.getButtonName().equals(MouseButton.LEFT.getName())) {
					// 创建移除提醒子窗体
					createWindow(event.getItem());
				}
			}
		};
		return icLister;
	}

	/**
	 * 移除提醒窗口
	 * **/
	private void createWindow(Item tiem) {
		Window window = new Window();
		window.setHeight(170, Unit.PIXELS);
		window.setWidth(200, Unit.PIXELS);
		window.setModal(true);

		window.setContent(createAddForm(tiem, window));
		getUI().addWindow(window);
	}

	/**
	 * 移除提醒表单
	 * **/
	private FormLayout createAddForm(final Item itemBean, final Window window) {
		FormLayout form = new FormLayout();
		Label label = new Label("是否确认恢复该账户？");
		HorizontalLayout hLayout = new HorizontalLayout();
		Button okButton = new Button("是");
		// 确认移除操作
		okButton.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				mdInfoManager.removeMemberDeleteInfoBean((String) itemBean
						.getItemProperty("realname").getValue(),
						(String) itemBean.getItemProperty("loginname")
								.getValue());
				container.removeAllItems();  //快速从当前表格 container 中移除被删除数据
				fillContainer(container);
				tb.setContainerDataSource(container); // 这里数据源要切换
				window.close();
			}
		});

		Button cancelButton = new Button("否");
		// 取消移除操作
		cancelButton.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				window.close();
			}
		});
		form.addComponent(label);
		hLayout.addComponent(okButton);
		hLayout.addComponent(cancelButton);
		form.addComponent(hLayout);
		return form;
	}

	/**
	 * 创建主窗体表格过滤器
	 * **/
	private HorizontalLayout createFilters(final Table tb) {
		HorizontalLayout filtersLayout = new HorizontalLayout();
		int i = 0;
		for (final Object columnID : Constants.MEMEBER_COL_ORDER) {
			int columnWidth = COLUMN_WIDTHS[i++]; // 列宽
			tb.setColumnWidth(columnID, columnWidth); // 设置列宽
			final TextField field = new TextField(); // 创建文本框跟列宽一致
			field.setWidth(columnWidth + COLUMN_SPACE, Unit.PIXELS);

			if ("cardscore".equals(columnID) || "cardbalance".equals(columnID)) {
				Label lb = new Label();
				lb.setWidth(columnWidth + COLUMN_SPACE, Unit.PIXELS);
				filtersLayout.addComponent(lb);
				field.setVisible(false); // 隐藏掉这两个输入框
			}
			field.addTextChangeListener(new TextChangeListener() {
				@Override
				public void textChange(TextChangeEvent event) {
					filterTable(tb, columnID, event.getText());
				}
			});

			filtersLayout.addComponent(field);
		}
		return filtersLayout;
	}

	/**
	 * 过滤查询
	 * 
	 **/
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

	private void fillContainer(Container container) {
		List<MemberDeleteInfoBean> list = mdInfoManager
				.getMemberDeleteInfoBeanList();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			MemberDeleteInfoBean mdInfo = (MemberDeleteInfoBean) iterator
					.next();
			container.addItem(mdInfo);
		}
	}
}
