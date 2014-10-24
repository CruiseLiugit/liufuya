package com.seaway.liufuya.mvc.system.user.layout;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.common.util.DateUtil;
import com.seaway.liufuya.common.uuid.RandomCode;
import com.seaway.liufuya.mvc.login.dao.SysUserDaoImpl;
import com.seaway.liufuya.mvc.login.model.Role;
import com.seaway.liufuya.mvc.login.model.SysUser;
import com.seaway.liufuya.mvc.system.user.data.SysUserRole;
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
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Reindeer;
import com.seaway.liufuya.common.base.MD5;


@SuppressWarnings("serial")
public class SysUserListView extends VerticalLayout implements ClickListener,
		ItemClickListener {

	private static final Log log = Logs.get();
	// -----------------------定义查询
	SysUserDaoImpl userDao = null;

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
	private BeanItemContainer<SysUser> tableContainer = new BeanItemContainer<SysUser>(
			SysUser.class);

	// ----------------------定义表单
	FormLayout addFormlayout = null; // 增加表单
	FormLayout rightFormlayout = null; // 编辑表单

	TextField userCode = null; // 编号
	TextField loginName = null; // 登录名
	TextField userName = null;  //真是姓名
	TextField email = null; 
	TextField userPhone = null;
	NativeSelect userRoleType = null; // 从用户角色表读取的角色名称
	NativeSelect status = null; // 状态
	Label logPwd = null; //默认密码提示 888888
	//logPwd  ,sellerCode ,createDate,userType //用户类型,1：系统内部用户，2：商家用户，3：其他

	Button saveButton = null;

	// ----------------------定义窗体
	Window addWindow = null;

	// ---------------------开始布局
	public SysUserListView() {
		// TODO Auto-generated constructor stub
	}

	public SysUserListView(SysUserDaoImpl dao) {
		this.userDao = dao;

		// -----------------------导航工具条
		navBar.setStyleName(Reindeer.LAYOUT_BLACK);
		navBar.setWidth(100, Unit.PERCENTAGE);
		navBar.setHeight(29, Unit.PIXELS);
		Label lblNav = new Label("权限管理 / 用户管理");
		Button btnAdd = new Button("新增"); // 增加 按钮
		btnAdd.setIcon(new ThemeResource("icons/16/add.png"));
		btnAdd.setDescription("增加用户");
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
				addWindow = new Window("添加后台系统用户");
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
		List<SysUser> list = userDao.getAllSysUserList();
		for (SysUser userBean : list) {
			tableContainer.addItem(userBean);
		}
	}

	/**
	 * 左边表格初始化
	 * **/
	private void initLeftTable() {
		leftTable = new Table("用户明细表格");
		leftTable.setSizeFull();
		leftTable.setHeight(100, Unit.PERCENTAGE);
		leftTable.setContainerDataSource(tableContainer);
		leftTable.setVisibleColumns(Constants.SYSUSER_COL);
		leftTable.setColumnHeaders(Constants.SYSUSER_COL_HEADERS_CHINESE);
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
	
		userCode = new TextField("用户编号");
		loginName = new TextField("登录名称");
		logPwd  = new Label("默认密码 888888");
		userName = new TextField("真实姓名");
		email  = new TextField("用户邮箱");
		userPhone  = new TextField("用户手机号码");
		
		userRoleType = new NativeSelect("角色类型");// 从角色表读取数据
		List<Role> roleList =  this.userDao.getAllRoles();
		Collection<Integer> col = new ArrayList<Integer>();
		for (int i = 0; i < roleList.size(); i++) {
			col.add(i);
		}
		userRoleType.addItems(col);
		
		

		status = new NativeSelect("启用");
		status.addItems(0, 1);
		status.setItemCaption(0, "否");
		status.setItemCaption(1, "是");

		saveButton = new Button("保存");
		saveButton.addClickListener(buttonLister());

		rightFormlayout.addComponents(userCode, loginName,logPwd, userName,email,userPhone, userRoleType,
				status, saveButton);

		if (item != null) {
			Property prop = item.getItemProperty("userCode");
			String userCodeStr = (String) prop.getValue();
			
			for (int i = 0; i < roleList.size(); i++) {
				Role roleBean = roleList.get(i);
				userRoleType.setItemCaption(i, roleBean.getRoleName());
				String roleCode = this.userDao.findRoleCodeByUserCode(userCodeStr);
				if (roleCode!=null && roleCode.equals(roleBean.getRoleCode())) {
					userRoleType.select(i);
				}else{
					userRoleType.select(0);
				}
			}
			
			
			// 根据 role_code 查询一下 Role 对象
			SysUser userObj = this.userDao.findSysUserByCode(userCodeStr);

			BeanFieldGroup<SysUser> bindingFiles = new BeanFieldGroup<SysUser>(
					SysUser.class);
			bindingFiles.setItemDataSource(userObj);
			bindingFiles.setBuffered(true);
			bindingFiles.bindMemberFields(this); // 绑定

			userCode.setEnabled(false); // 编号

			//String usertypeCode =  userObj.getUserType();
			//log.info("====================> 用户类型 :"+usertypeCode);
			// 经营类型
			if (userObj.getUserType().equals("1")) {
				userRoleType.select(0);
			} 

			if (userObj.getStatus().equals("1")) {
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
				SysUser userBean = new SysUser();
				if (loginName.getValue().trim().equals("")) {
					Notification.show("警告", "登录名称必须填写",
							Notification.Type.WARNING_MESSAGE);
					loginName.focus();
				}if (userName.getValue().trim().equals("")) {
					Notification.show("警告", "真实姓名必须填写",
							Notification.Type.WARNING_MESSAGE);
					userName.focus();
				}  else {
					userBean.setLoginName(loginName.getValue());// 登录名
					userBean.setUserName(userName.getValue()); // 真是姓名
					userBean.setEmail(email.getValue().trim().equals("")?"":email.getValue()); 
					userBean.setUserPhone(userPhone.getValue().trim().equals("")?"":userPhone.getValue());
					// 用户类型，1系统用户 2 卖家用户
					Integer typeid = (Integer) userRoleType.getValue();
					System.out.println("............角色 obj ="+userRoleType);
					System.out.println("............角色 obj Caption ="+userRoleType.getCaption());
					System.out.println("............角色 obj Id ="+userRoleType.getId());
					System.out.println("............角色 obj Value="+userRoleType.getValue());
					
					userBean.setUserType("" + typeid);
					
					userBean.setStatus("" + status.getValue());
					MD5 md5 = new MD5();
					userBean.setLogPwd(md5.getMD5ofStr("888888")); //默认密码 888888
					userBean.setSellerCode(""); //卖家编码
		
					// -----------------------------------------------
					if (event.getButton().getCaption().equals("保存")) {
						// 更新
						userBean.setUserCode(userCode.getValue());//编码
						try {
							userBean.setCreateDate(DateUtil
									.convertStringToDate(DateUtil
											.convertDateToString(new Date())));// 创建时间
						} catch (ParseException e) {
							e.printStackTrace();
						}

						userDao.updateLoginPwd(userBean);
						Notification.show("更新成功");
					} else if (event.getButton().getCaption().equals("添加")) {
						if (userDao.checkSysUserByLoginName(loginName.getValue())) {
							// 增加
							userBean.setUserCode(RandomCode
									.generateNumberString("USR", 3));// 编码
							try {
								userBean.setCreateDate(DateUtil.convertStringToDate(DateUtil
										.convertDateToString(new Date())));// 创建时间
							} catch (ParseException e) {
								e.printStackTrace();
							}
							
							//往 sys_user 表插入数据
							userDao.saveSysUser(userBean);
							//往 sys_user_role 表插入数据
							SysUserRole sysUR = new SysUserRole();
							sysUR.setUser_code(userBean.getUserCode()); //用户编码
							sysUR.setRole_code(""); //角色编码
							sysUR.setStatus("1");
							try {
								sysUR.setCreate_date(DateUtil.convertStringToDate(DateUtil
										.convertDateToString(new Date())));// 创建时间
							} catch (ParseException e) {
								e.printStackTrace();
							}
							userDao.saveSysUserRole(sysUR);
							
							Notification.show("添加成功");

							addWindow.close();
						} else {
							Notification.show("该登录名已经存在，请重新设置");
							loginName.focus();
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
		
		loginName = new TextField("登录名称");
		logPwd  = new Label("默认密码 888888");
		userName = new TextField("真实姓名");
		email  = new TextField("用户邮箱");
		userPhone  = new TextField("用户手机号码");
		
		userRoleType = new NativeSelect("角色类型");// 从角色表读取数据
		List<Role> roleList =  this.userDao.getAllRoles();
		Collection<Integer> col = new ArrayList<Integer>();
		for (int i = 0; i < roleList.size(); i++) {
			col.add(i);
		}
		userRoleType.addItems(col);
		for (int i = 0; i < roleList.size(); i++) {
			Role roleBean = roleList.get(i);
			userRoleType.setItemCaption(i, roleBean.getRoleName());
		}
		userRoleType.select(0);

		status = new NativeSelect("启用");
		status.addItems(0, 1);
		status.setItemCaption(0, "禁用");
		status.setItemCaption(1, "启用");
		status.select(0);

		saveButton = new Button("添加");
		saveButton.addClickListener(buttonLister());

		addFormlayout.addComponents(loginName,logPwd, userName,email,userPhone, userRoleType,
				status, saveButton);
	}

	// ---------------------------------------------------------------

}
