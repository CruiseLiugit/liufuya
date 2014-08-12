package com.seaway.liufuya.mvc.login.ui.views;

import org.nutz.dao.Dao;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.common.base.MD5;
import com.seaway.liufuya.mvc.login.dao.SysUserDaoImpl;
import com.seaway.liufuya.mvc.login.model.SysUser;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

/**
 * 显示当前登录用户信息界面
 * 
 * @author lililiu
 * 
 */
@SuppressWarnings("serial")
public class LoginUserInfo extends Window {
	
	private static final Log log = Logs.get();
	
	private Dao dao = null;
	
	private SysUser sysUser =null ;   //当前登录的用户对象
	private final SysUserDaoImpl sysUserDao = null;  //访问数据库的类
	private Label userLab = new Label("");
	private PasswordField pwa = new PasswordField("新密码");
	private PasswordField pwb = new PasswordField("确认密码");

	//不带参数构造
	public LoginUserInfo(){}
	
	// final User user, final UserService us
	public LoginUserInfo(final SysUserDaoImpl dao) {
		/*
		 * Make the window modal, which will disable all other components while
		 * it is visible
		 */
		setModal(true);

		/* Make the sub window 50% the size of the browser window */
		setWidth("50%");
		this.setHeight(300, Unit.PIXELS);

		/*
		 * Center the window both horizontally and vertically in the browser
		 * window
		 */
		center();

		setCaption("当前用户信息");
		final FormLayout formLayout = new FormLayout();
		formLayout.setMargin(true);

		try {
			//从登录 LoginListener.java 获取当前登录用户对象
			Object userObj = UI.getCurrent().getSession().getAttribute("loginUser");
			if (userObj != null && (userObj instanceof SysUser)) {
				sysUser = (SysUser)userObj;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		//如果获取到当前登录用户对象，显示用户信息
		if (sysUser != null) {
			userLab.setCaption(sysUser.getUserName());
		}
		
		
		// 增加字段
		formLayout.addComponent(userLab);
		formLayout.addComponent(pwa);
		formLayout.addComponent(pwb);

		final Label error = new Label("", ContentMode.HTML);
		error.setVisible(false);
		formLayout.addComponent(error);

		// 处理保存事件
		Button saveButton = new Button("保存");
		saveButton.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(Button.ClickEvent event) {
				if (Strings.isEmpty(pwa.getValue()) || Strings.isEmpty(pwb.getValue())) {
					error.setValue("<div style='color:red'>密码不能为空</div>");
					error.setVisible(true);
				} else if (!pwa.getValue().equals(pwb.getValue())) {
					error.setValue("<div style='color:red'>两次输入不一致</div>");
					error.setVisible(true);
				} else {
					MD5 md5 = new MD5();
					sysUser.setLogPwd(md5.getMD5ofStr(pwa.getValue()));
					try {
						boolean flag = dao.updateLoginPwd(sysUser);
						if (flag) {
							error.setVisible(false);
							Notification.show("密码修改成功");
							LoginUserInfo.this.close();
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						Notification.show("密码修改失败，请重新修改");
						LoginUserInfo.this.close();
					}
					
				}
			}
		});

		HorizontalLayout buttons = new HorizontalLayout();
		buttons.setMargin(true);
		buttons.addComponent(saveButton);
		formLayout.addComponent(buttons);
		formLayout.setComponentAlignment(buttons, Alignment.MIDDLE_LEFT);
		setContent(formLayout);

	}

}
