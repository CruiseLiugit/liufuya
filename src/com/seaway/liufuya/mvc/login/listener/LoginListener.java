package com.seaway.liufuya.mvc.login.listener;

import org.nutz.dao.Dao;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.LiufuyaUI;
import com.seaway.liufuya.common.base.MD5;
import com.seaway.liufuya.mvc.login.dao.SysUserDaoImpl;
import com.seaway.liufuya.mvc.login.model.SysUser;
import com.seaway.liufuya.mvc.login.ui.UserMenusScreen;
import com.vaadin.data.Property;
import com.vaadin.server.VaadinSession;
import com.vaadin.server.WrappedSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

public class LoginListener implements Button.ClickListener {
	private static final Log log = Logs.get();

	// ------------------------------------------------
	// 登录，访问数据库
	private Dao nutzDao = null;

	// -------------------------------------------------
	private static final long serialVersionUID = 1L;
	private CustomComponent newScreen;
	private Property<String> loginNameHolder;
	private Property<String> loginPwdHolder;

	/**
	 * 登录界面监听器
	 * 
	 * @param newScreen
	 * @param nameHolder
	 * @param pwdHolder
	 */
	public LoginListener(Property<String> nameHolder, Property<String> pwdHolder) {
		log.info("---------init()--------");
		try {
			this.nutzDao = LiufuyaUI.getCurrent().initNutzDao();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.loginNameHolder = nameHolder;
		this.loginPwdHolder = pwdHolder;
	}

	/**
	 * 按钮点击后的 操作
	 */
	@Override
	public void buttonClick(Button.ClickEvent event) {
		// 获取登录文本框中的内容
		String name = loginNameHolder.getValue();
		String pwd = loginPwdHolder.getValue();

		SysUserDaoImpl userDao = new SysUserDaoImpl(this.nutzDao);
		MD5 md5 = new MD5();
		String mde5_pwd = md5.getMD5ofStr(pwd);
		SysUser sysUser = userDao.findSysUser(name, mde5_pwd);

		// if (name.equals("liu") && pwd.equals("liu")) {
		if (sysUser != null) {
			log.info("登录成功......... sysUser :" + sysUser);
			log.info("登录成功......... sysUser type :" + sysUser.getUserType());
			// 创建登录成功，选择菜单界面
			// 根据用户角色 显示不同的菜单项目
			Notification.show("欢迎你: " + sysUser.getUserName());

			// 当前登录用户数据保存到 session 对象中
			VaadinSession vsession = UI.getCurrent().getSession();
			
			vsession.setAttribute("loginUser", sysUser);
			// 把当前用户名，存入 session 中
			newScreen = new UserMenusScreen();
			UI.getCurrent().setContent(newScreen);
		} else {
			Notification.show("用户名或密码错误，请重新输入.");
		}

	}
}
