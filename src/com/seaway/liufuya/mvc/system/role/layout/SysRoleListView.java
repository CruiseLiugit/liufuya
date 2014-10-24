package com.seaway.liufuya.mvc.system.role.layout;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.common.util.DateUtil;
import com.seaway.liufuya.common.uuid.RandomCode;
import com.seaway.liufuya.mvc.login.model.Role;
import com.seaway.liufuya.mvc.system.role.dao.RoleDaoImpl;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Reindeer;

@SuppressWarnings("serial")
public class SysRoleListView extends VerticalLayout implements ClickListener,
		ItemClickListener {

	private static final Log log = Logs.get();
	// -----------------------定义查询
	RoleDaoImpl roleDao = null;

	// ------------------------整个页面导航
	HorizontalLayout navBar = new HorizontalLayout();

	// ----------------------- 整个页面，上下分割的 垂直布局面板
	private final HorizontalSplitPanel vsplit = new HorizontalSplitPanel();

	// ------------------------ 底部
	private HorizontalLayout footer;

	// -----------------------定义表格需要的
	Table leftTable = null;
	// private LazyLoadStoreContainer container = null;
	// 暂时不分页
	private BeanItemContainer<Role> tableContainer = new BeanItemContainer<Role>(
			Role.class);
	// private BeanItemContainer< StoreBean> container = null;

	// ----------------------定义表单
	FormLayout addFormlayout = null; // 增加表单
	FormLayout rightFormlayout = null; // 编辑表单

	TextField roleCode = null; // 角色编号
	TextField roleName = null; // 角色名称
	TextArea description = null; // 角色描述
	NativeSelect type = null; // 角色的权限类型 两级权限 1 操作员 2 主管
	NativeSelect status = null; // 状态
	// is_system create_date

	Button saveButton = null;

	// ----------------------定义窗体
	Window addWindow = null;

	// ---------------------开始布局
	public SysRoleListView() {
		// TODO Auto-generated constructor stub
	}

	public SysRoleListView(RoleDaoImpl roleDao) {
		this.roleDao = roleDao;

		// -----------------------导航工具条
		navBar.setStyleName(Reindeer.LAYOUT_BLACK);
		navBar.setWidth(100, Unit.PERCENTAGE);
		navBar.setHeight(29, Unit.PIXELS);
		Label lblNav = new Label("权限管理 / 角色管理");
		Button btnAdd = new Button("新增"); // 增加 按钮
		btnAdd.setIcon(new ThemeResource("icons/16/add.png"));
		btnAdd.setDescription("增加角色");
		btnAdd.addClickListener(addButtonClickLister());
		navBar.addComponent(lblNav);
		navBar.addComponent(btnAdd);
		navBar.setComponentAlignment(btnAdd, Alignment.TOP_RIGHT);// 定义位置

		// --------------------------垂直页面布局
		initContainer();
		initLeftTable();
		vsplit.addComponent(leftTable);
		vsplit.setSplitPosition(70);
		vsplit.setStyleName(Reindeer.LAYOUT_WHITE); // 右侧样式
		vsplit.setHeight(Constants.PAGE_HEIGHT, Unit.PIXELS);

		// 整个布局完成
		this.addComponent(navBar);
		this.addComponent(vsplit);
		this.setDefaultComponentAlignment(ALIGNMENT_DEFAULT);
		this.setExpandRatio(vsplit, 1);

	}

	@Override
	public void itemClick(ItemClickEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void click(ClickEvent event) {
		// TODO Auto-generated method stub

	}

	/**
	 * 添加按钮单击事件
	 * 
	 * @author zg
	 * **/
	private Button.ClickListener addButtonClickLister() {
		Button.ClickListener listener = new Button.ClickListener() {
			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				addWindow = new Window("添加角色");
				addWindow.setHeight(500, Unit.PIXELS);
				addWindow.setWidth(430, Unit.PIXELS);
				addWindow.setModal(true);
				addForm();
				addWindow.setContent(addFormlayout);
				getUI().addWindow(addWindow);
			}
		};

		return listener;
	}

	// ----------------------------------------------------------------------
	/**
	 * 左边表格容器初始化
	 */
	private void initContainer() {
		// 分页版本
		// container = new LazyLoadStoreContainer(StoreBean.class,storeDao);
		// 不分页版本
		List<Role> list = roleDao.queryAllRoleList();
		for (Role storeBean : list) {
			tableContainer.addItem(storeBean);
		}
	}

	/**
	 * 左边表格初始化
	 * **/
	private void initLeftTable() {
		leftTable = new Table("角色明细表格");
		leftTable.setSizeFull();
		leftTable.setHeight(100, Unit.PERCENTAGE);
		leftTable.setContainerDataSource(tableContainer);
		leftTable.setVisibleColumns(Constants.SYSROLE_COL);
		leftTable.setColumnHeaders(Constants.SYSROLE_COL_HEADERS_CHINESE);
		leftTable.setPageLength(2);
		leftTable.setCacheRate(4);
		leftTable.setColumnCollapsingAllowed(true);
		leftTable.setColumnReorderingAllowed(true);
		leftTable.addItemClickListener(new ItemClickListener() {

			@Override
			public void itemClick(ItemClickEvent event) {
				if (vsplit.getComponentCount() == 2)
					vsplit.removeComponent(rightFormlayout);
				initRightForm(event.getItem());
				vsplit.addComponent(rightFormlayout);
			}
		});
	}

	/**
	 * 初始化右边form
	 */
	private void initRightForm(Item item) {
		rightFormlayout = new FormLayout();

		roleCode = new TextField("角色编号");
		roleName = new TextField("角色名称");
		description = new TextArea("角色描述");
		description.setRows(10);
		description.setImmediate(true);
		description.setSizeFull();

		type = new NativeSelect("权限类型");// 角色的权限类型 两级权限 1 操作员 2 主管
		type.addItems(0, 1);
		type.setItemCaption(0, "专员");
		type.setItemCaption(1, "主管");

		status = new NativeSelect("启用");
		status.addItems(0, 1);
		status.setItemCaption(0, "禁用");
		status.setItemCaption(1, "启用");

		saveButton = new Button("保存");
		saveButton.addClickListener(buttonLister());

		rightFormlayout.addComponents(roleCode, roleName, description, type,
				status, saveButton);

		if (item != null) {
			Property prop = item.getItemProperty("roleCode");
			String roleCodeStr = (String) prop.getValue();
			// 根据 role_code 查询一下 Role 对象
			Role role = this.roleDao.findRoleByCode(roleCodeStr);

			BeanFieldGroup<Role> bindingFiles = new BeanFieldGroup<Role>(
					Role.class);
			bindingFiles.setItemDataSource(role);
			bindingFiles.setBuffered(true);
			bindingFiles.bindMemberFields(this); // 绑定

			roleCode.setEnabled(false); // 编号

			// 经营类型
			if (role.getType().equals("0")) {
				type.select(0);
			} else if (role.getType().equals("1")) {
				type.select(1);
			}

			if (role.getStatus().equals("1")) {
				status.select(1);
			} else {
				status.select(0);
			}

		}
	}

	/**
	 * button 保存新增或者修改
	 * */
	private Button.ClickListener buttonLister() {
		Button.ClickListener lister = new Button.ClickListener() {
			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				Role roleBean = new Role();
				if (roleName.getValue().trim().equals("")) {
					Notification.show("警告", "角色名称必须填写",
							Notification.Type.WARNING_MESSAGE);
					roleName.focus();
				} else {
					roleBean.setRoleName(roleName.getValue());// 角色名称
					roleBean.setIsSystem("1"); // 1系统生成 0商铺生成
					roleBean.setDescription(description.getValue()); // 角色描述
					// 经营类型
					Integer typeid = (Integer) type.getValue();
					roleBean.setType("" + typeid);
					roleBean.setStatus("" + status.getValue());

					// -----------------------------------------------
					if (event.getButton().getCaption().equals("保存")) {
						// 更新
						roleBean.setRoleCode(roleCode.getValue());// 角色编码
						try {
							roleBean.setCreateDate(DateUtil
									.convertStringToDate(DateUtil
											.convertDateToString(new Date())));// 创建时间
						} catch (ParseException e) {
							e.printStackTrace();
						}

						roleDao.updateRole(roleBean);
						Notification.show("更新成功");
					} else if (event.getButton().getCaption().equals("添加")) {
						if (roleDao.checkRoleByName(roleName.getValue())) {
							// 增加
							roleBean.setRoleCode(RandomCode
									.generateNumberString("RL", 3));// 角色编码
							try {
								roleBean.setCreateDate(DateUtil.convertStringToDate(DateUtil
										.convertDateToString(new Date())));// 创建时间
							} catch (ParseException e) {
								e.printStackTrace();
							}

							roleDao.insertRole(roleBean);
							Notification.show("添加成功");

							addWindow.close();
						}else{
							Notification.show("该角色已经存在，请重新设置");
							roleName.focus();
						}

					}
					// -----------------------------------------------
				}

			}
		};
		return lister;
	}

	/**
	 * 初始化添加表格
	 */
	private void addForm() {
		addFormlayout = new FormLayout();

		// role_code = new TextField("角色编号");
		roleName = new TextField("角色名称");
		description = new TextArea("角色描述");
		description.setRows(10);
		description.setImmediate(true);
		description.setSizeFull();

		type = new NativeSelect("权限类型");// 角色的权限类型 两级权限 1 操作员 2 主管
		type.addItems(0, 1);
		type.setItemCaption(0, "专员");
		type.setItemCaption(1, "主管");
		type.select(0); // 默认选中

		status = new NativeSelect("启用");
		status.addItems(0, 1);
		status.setItemCaption(0, "否");
		status.setItemCaption(1, "是");
		status.select(0);

		saveButton = new Button("添加");
		saveButton.addClickListener(buttonLister());

		addFormlayout.addComponents(roleName, description, type, status,
				saveButton);
	}

	// ---------------------------------------------------------------

}
