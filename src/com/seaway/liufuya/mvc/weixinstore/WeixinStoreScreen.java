package com.seaway.liufuya.mvc.weixinstore;

import java.io.Serializable;

import org.nutz.dao.Dao;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.LiufuyaUI;
import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.mvc.crm.memberinfo.dao.impl.MemberInfoMemberBean;
import com.seaway.liufuya.mvc.crm.ui.layout.NavigationTree;
import com.seaway.liufuya.mvc.login.dao.SysUserDaoImpl;
import com.seaway.liufuya.mvc.login.ui.LoginScreen;
import com.seaway.liufuya.mvc.login.ui.UserMenusScreen;
import com.seaway.liufuya.mvc.login.ui.views.LoginUserInfo;
import com.seaway.liufuya.mvc.weixinstore.category.dao.CategoryManager;
import com.seaway.liufuya.mvc.weixinstore.category.layout.CategoryListView;
import com.seaway.liufuya.mvc.weixinstore.ordernew.dao.OrderDao;
import com.seaway.liufuya.mvc.weixinstore.ordernew.layout.OrderNewListView;
import com.seaway.liufuya.mvc.weixinstore.orderold.layout.OrdderOldListView;
import com.seaway.liufuya.mvc.weixinstore.product.dao.WXProductManager;
import com.seaway.liufuya.mvc.weixinstore.product.layout.WXProductListView;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.Reindeer;

public class WeixinStoreScreen extends CustomComponent implements
		ClickListener, ValueChangeListener, ItemClickListener, Serializable {
	private static final long serialVersionUID = 1L;
	private static final Log log = Logs.get();
	private Dao nutzDao = null;

	// --------------顶部工具栏组件-----------------------------
	private Button backToMenu = new Button("首页");
	//private Button search = new Button("搜索");
	private Button user = new Button("用户");
	private Button logout = new Button("退出");
	// 顶部 菜单，查看用户信息窗口
	private LoginUserInfo loginUser = null;
	private SysUserDaoImpl sysUserDao = null; // 访问用户登录表的数据库操作类

	private NavigationTree tree = new NavigationTree(this,
			Constants.WEIXIN_MENUS_TREE);

	// ----------------主界面内容-------------------------------
	private HorizontalSplitPanel horizontalSplit = new HorizontalSplitPanel();

	// -----------------根据模块动态增加--------------------------
	// 会员资料组件

	// 数据库对象
	// public MemberInfoMemberBean memberManager; // 会员管理
	private CategoryManager categoryManager = null;// 商品类目管理
	private WXProductManager wxproductManager = null;// 商品资料管理
	private OrderDao orderdao = null; // 订单管理

	private CategoryListView categoryListView = null;// 商品类目管理
	private WXProductListView wxproductListView = null;// 商品资料管理
	private OrderNewListView orderNewListView = null;// 今日订单管理
	private OrdderOldListView orderOldListView = null;// 历史订单查询

	public WeixinStoreScreen() {
	}

	/**
	 * 根据 登录后的 界面菜单 PanelWeixinStore.java 选中的菜单项进入不同的界面
	 * 
	 * @param itemId
	 */
	public WeixinStoreScreen(String itemId) {
		log.info("---------init()--------");
		try {
			this.nutzDao = LiufuyaUI.getCurrent().initNutzDao();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		buildMainLayout(); // 创建空白的启动页面

		if ("商品类目管理".equals(itemId)) {
			Notification.show("商品类目管理");
			setMainComponent(this.getCategoryListView());
		} else if ("商品资料管理".equals(itemId)) {
			Notification.show("商品资料管理");
			setMainComponent(this.getWXProductListView());
		} else if ("当天订单管理".equals(itemId)) {
			Notification.show("当天订单管理");
			setMainComponent(this.getWXOrderNewListView());
		} else if ("历史订单查询".equals(itemId)) {
			Notification.show("历史订单查询");
			setMainComponent(this.getWXOrderOldListView());
		} else if ("优惠券生成".equals(itemId)) {
			Notification.show("优惠券生成");
			// setMainComponent(this.getMemberAddressListView());
		} else if ("会员优惠券查询".equals(itemId)) {
			Notification.show("会员优惠券查询");
			// setMainComponent(this.getMemberAddressListView());
		} else if ("历史优惠券核实".equals(itemId)) {
			Notification.show("历史优惠券核实");
			// setMainComponent(this.getMemberAddressListView());
		}

	}

	// --------------------------所有页面公共的部分----------------------------------------
	/**
	 * 登录成功后，显示的多系统菜单项目
	 */
	private void buildMainLayout() {
		// 默认创建垂直布局,上中下 三行
		// 公司图标 系统名称 用户名称 角色
		// -------------------------------
		// 中间是该用户所能操作的后台系统菜单
		// -------------------------------
		// 底部公司版权说明

		// 开始构建视图
		VerticalLayout root = new VerticalLayout();
		root.setStyleName(Reindeer.LAYOUT_BLUE);
		root.setSizeFull(); // 满屏

		// 头部
		root.addComponent(createTopToolbar()); // 工具栏
		root.addComponent(horizontalSplit); // 中间为左右分割
		root.setExpandRatio(horizontalSplit, 1);
		horizontalSplit.setHeight(500, Unit.PIXELS);
		horizontalSplit.setSplitPosition(200, Unit.PIXELS);
		// horizontalSplit.setStyleName(Reindeer.SPLITPANEL_SMALL); //分割线变细线
		horizontalSplit.setFirstComponent(tree);

		// 底部
		root.addComponent(LiufuyaUI.getCurrent().getPageFooter()); // 底部公司版权说明

		this.setCompositionRoot(root);
	}

	/**
	 * 创建简单的工具栏
	 * 
	 * @return
	 */
	public HorizontalLayout createTopToolbar() {
		HorizontalLayout lo = new HorizontalLayout();
		Embedded em = new Embedded("", new ThemeResource("img/logo_sm.png"));
		lo.addComponent(em);
		lo.setComponentAlignment(em, Alignment.MIDDLE_LEFT);
		lo.setExpandRatio(em, 1);

		backToMenu.setDescription("返回系统管理菜单");
		//search.setDescription("全局搜索");
		user.setDescription("当前用户信息");
		logout.setDescription("退出系统");

		lo.addComponent(backToMenu);
		//lo.addComponent(search);
		lo.addComponent(user);
		lo.addComponent(logout);
		lo.setComponentAlignment(backToMenu, Alignment.MIDDLE_RIGHT);
		//lo.setComponentAlignment(search, Alignment.MIDDLE_RIGHT);
		lo.setComponentAlignment(user, Alignment.MIDDLE_RIGHT);
		lo.setComponentAlignment(logout, Alignment.MIDDLE_RIGHT);

		backToMenu.addClickListener(this);
		//search.addClickListener(this);// .addListener((ClickListener) this);
		user.addClickListener(this);
		logout.addClickListener(this);

		backToMenu.setIcon(new ThemeResource("icons/19/home.png"));
		//search.setIcon(new ThemeResource("icons/19/Search.png"));
		user.setIcon(new ThemeResource("icons/19/my-account.png"));
		logout.setIcon(new ThemeResource("icons/19/logout.png"));

		// lo.setMargin(false);
		// lo.setSpacing(true);
		lo.setStyleName(Reindeer.LAYOUT_WHITE);
		lo.setWidth(100, Unit.PERCENTAGE);

		return lo;
	}

	// --顶部，公共界面部分，事件处理----
	public void buttonClick(ClickEvent event) {
		final Button source = event.getButton();

		if (source == user) {
			showLoginUserInfoWindow();
		} else if (source == logout) {
			Notification.show("您已安全退出系统!");
			UI.getCurrent().setContent(new LoginScreen());
			// showShareWindow();
			UI.getCurrent().getSession().close();
		} else if (source == backToMenu) {
			// addNewContanct();
			UI.getCurrent().setContent(new UserMenusScreen());
		}
	}

	// 所有子界面，添加到当前界面中的方法
	private void setMainComponent(Component c) {
		horizontalSplit.setSecondComponent(c); // 添加到第二个分割面板中
	}

	// --------------------------各个子菜单对应的方法----------------------------------------

	// ------------------------------------------------------------------

	// ------------------------------------------------------------------
	@Override
	public void itemClick(ItemClickEvent event) {
		if (event.getSource() == tree) {
			Object itemId = event.getItemId();
			log.info(">>>>>>>>>>>>>> 所选中的菜单 :" + itemId);
			if (itemId != null) {
				for (int i = 0; i < Constants.WEIXIN_MENUS_ITEMCLICK.length; i++) {
					String node = Constants.WEIXIN_MENUS_ITEMCLICK[i];
					if (itemId.equals(node)) {
						switch (i) {
						case 0:
							Notification.show("商品类目管理");
							setMainComponent(this.getCategoryListView());
							break;
						case 1:
							Notification.show("商品资料管理");
							setMainComponent(this.getWXProductListView());
							break;
						case 2:
							Notification.show("当天订单管理");
							setMainComponent(this.getWXOrderNewListView());
							break;
						case 3:
							Notification.show("历史订单查询");
							setMainComponent(this.getWXOrderOldListView());
							break;
						case 4:
							Notification.show("优惠券生成");
							//
							break;
						case 5:
							Notification.show("会员优惠券查询");
							//
							break;
						case 6:
							Notification.show("历史优惠券核实");
							//
							break;
						default:
							break;
						}
					}
				}
			}
		}
	}

	@Override
	public void valueChange(ValueChangeEvent event) {
		// TODO Auto-generated method stub

	}

	// ---------------------------------------------
	// 懒加载，创建新的窗口对象
	private LoginUserInfo getLoginUserInfoWindow() {
		if (loginUser == null) {
			sysUserDao = new SysUserDaoImpl(nutzDao);
			loginUser = new LoginUserInfo(sysUserDao);
		}
		return loginUser;
	}

	// 显示窗口
	private void showLoginUserInfoWindow() {
		UI.getCurrent().addWindow(getLoginUserInfoWindow());
	}

	// ---------------------------------------------------商品类目管理
	private CategoryListView getCategoryListView() {
		if (this.categoryManager == null) {
			categoryManager = new CategoryManager(nutzDao);
		}
		if (this.categoryListView == null) {
			categoryListView = new CategoryListView(categoryManager);
		}
		return categoryListView;
	}

	// ---------------------------------------------------商品资料管理
	private WXProductListView getWXProductListView() {
		if (this.wxproductManager == null) {
			wxproductManager = new WXProductManager(nutzDao);
		}
		if (this.wxproductListView == null) {
			wxproductListView = new WXProductListView(wxproductManager);
		}
		return wxproductListView;
	}

	// ---------------------------------------------------今日订单管理
	private OrderNewListView getWXOrderNewListView() {
		if (this.orderdao == null) {
			orderdao = new OrderDao(nutzDao);
		}
		if (this.orderNewListView == null) {
			orderNewListView = new OrderNewListView(orderdao);
		}
		return orderNewListView;
	}

	// ---------------------------------------------------历史订单管理
	private OrdderOldListView getWXOrderOldListView() {
		if (this.orderdao == null) {
			orderdao = new OrderDao(nutzDao);
		}
		if (this.orderOldListView == null) {
			orderOldListView = new OrdderOldListView(orderdao);
		}
		return orderOldListView;
	}

}
