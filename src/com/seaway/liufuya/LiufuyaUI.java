package com.seaway.liufuya;

import java.util.Locale;

import org.nutz.dao.Dao;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.ioc.loader.combo.ComboIocLoader;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.mvc.login.ui.LoginScreen;
import com.seaway.liufuya.util.LunaConverterFactory;
import com.seaway.liufuya.util.LunaErrorHandler;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.Reindeer;

@IocBean
@Title("留夫鸭核心后台管理系统")
@SuppressWarnings("serial")
@PreserveOnRefresh
// 支持F5刷新
@Theme("liufuya")
public class LiufuyaUI extends UI {
	private static final Log log = Logs.get();
	/**
	 * 序列化序号
	 */
	private static final long serialVersionUID = -5948892618258879832L;

	private BasicDao baseDao = null;
	private Dao nutzDao = null;

	// /////////////////////////////////////
	// 代码，这里再次初始化 Nutz IOC 并创建 dao 对象
	public Dao initNutzDao() throws Throwable {
		ComboIocLoader loader = new ComboIocLoader(new String[] {
				"*org.nutz.ioc.loader.json.JsonLoader", "ioc/",
				"*org.nutz.ioc.loader.annotation.AnnotationIocLoader",
				"com.vaadin.demo.tutorial.addressbook" });
		NutIoc ioc = new NutIoc(loader);
		nutzDao = ioc.get(Dao.class);
		return nutzDao;
	}

	// /////////////////////////////////////

	public static LiufuyaUI getCurrent() {
		return (LiufuyaUI) UI.getCurrent();
	}

	@Override
	protected void init(VaadinRequest request) {
		// 在 Session 中，设置格式转换工厂
		getSession().setConverterFactory(new LunaConverterFactory());
		// 在 Session 中，设置错误处理
		getSession().setErrorHandler(new LunaErrorHandler());

		setLocale(Locale.CHINESE);// 设置语言地理位置

		// 进入登录窗口
		setContent(new LoginScreen());
	}

	// -------------------------------------------------
	// 公用页面部分
	/**
	 * 页面底部版权 Bar
	 * 
	 * @return
	 */
	public HorizontalLayout getPageFooter() {
		// 底部公司介绍 水平布局
		HorizontalLayout footer = new HorizontalLayout();
		footer.setWidth(100, Unit.PERCENTAGE);
		footer.setMargin(true);
		footer.addStyleName(Reindeer.LAYOUT_BLACK);
		// -----------------------底部公司介绍-------------------------------
		Label lbcopyright = new Label("Copyright 2014");
		lbcopyright.setSizeUndefined();
		// lbcopyright.addStyleName(Reindeer.LABEL_H2);
		Label lbcompany = new Label("上海释伟科技有限公司");
		// lbcompany.addStyleName(Reindeer.LABEL_H2);
		Label lbdesc = new Label("留夫鸭电子商务O2O解决方案");
		// lbdesc.addStyleName(Reindeer.LABEL_H2);

		Label lbspace = new Label(); // 占位空间
		lbspace.setWidth(520, Unit.PIXELS);

		footer.setSpacing(true); // 设置间隙
		footer.addComponent(lbcopyright);
		footer.setComponentAlignment(lbcopyright, Alignment.MIDDLE_LEFT);

		// footer.addComponent(lbspace);
		footer.addComponent(lbdesc);
		footer.setComponentAlignment(lbdesc, Alignment.MIDDLE_LEFT);

		footer.addComponent(lbspace);
		footer.addComponent(lbcompany);
		footer.setComponentAlignment(lbcompany, Alignment.MIDDLE_LEFT);

		return footer;
	}

}