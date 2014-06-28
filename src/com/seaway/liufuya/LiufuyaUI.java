package com.seaway.liufuya;

import java.util.Locale;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.mvc.login.ui.UserLoginScreen;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@IocBean
@Title("留夫鸭核心后台管理系统")
@SuppressWarnings("serial")
@PreserveOnRefresh
// 支持F5刷新
// @Theme("liufuya")
@Theme("dawn")
public class LiufuyaUI extends UI {
	private static final Log log = Logs.get();
	/**
	 * 序列化序号
	 */
	private static final long serialVersionUID = -5948892618258879832L;

	@Override
	protected void init(VaadinRequest request) {
		// 在 Session 中，设置格式转换工厂
		//getSession().setConverterFactory(new LunaConverterFactory());
		// 在 Session 中，设置错误处理
		//getSession().setErrorHandler(new LunaErrorHandler());

		setLocale(Locale.CHINESE);//设置语言地理位置
		
		setContent(new UserLoginScreen());
	}

}