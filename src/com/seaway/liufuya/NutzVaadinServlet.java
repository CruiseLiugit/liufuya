package com.seaway.liufuya;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.vaadin.server.CustomizedSystemMessages;
import com.vaadin.server.ServiceException;
import com.vaadin.server.SessionDestroyEvent;
import com.vaadin.server.SessionDestroyListener;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;
import com.vaadin.server.SystemMessages;
import com.vaadin.server.SystemMessagesInfo;
import com.vaadin.server.SystemMessagesProvider;
import com.vaadin.server.VaadinServlet;

public class NutzVaadinServlet extends VaadinServlet implements
		SessionInitListener, SessionDestroyListener {
	private static final Log log = Logs.get();
	
	public NutzVaadinServlet() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("serial")
	@Override
	protected void servletInitialized() throws ServletException {
		super.servletInitialized();
		getService().addSessionInitListener(this);
		getService().addSessionDestroyListener(this);
		log.info("----------->Servlet 系统启动<------------");
		// 自定义系统提示信息
		this.getService().setSystemMessagesProvider(
				new SystemMessagesProvider() {
					@Override
					public SystemMessages getSystemMessages(
							SystemMessagesInfo systemMessagesInfo) {
						CustomizedSystemMessages messages = new CustomizedSystemMessages();
						messages.setCommunicationErrorCaption("网络异常");// 标题
						messages.setCommunicationErrorMessage("与服务器通信异常，请确认服务器是否启动");
						messages.setCommunicationErrorNotificationEnabled(true);
						messages.setSessionExpiredCaption("登录超时");// 标题
						messages.setSessionExpiredMessage("如果有未保存的数据，请复制到外部（如记事本中）保存，然后点击此处重新登录。");
						messages.setCommunicationErrorURL("/");
						return messages;
					}
				});

	}

	// -------------------------------------------------
	// Session 生命周期 监听器
	@Override
	public void sessionInit(SessionInitEvent event) throws ServiceException {
		// Do session start stuff here
		log.info("----------->一个浏览器连接服务器<------------");
	}

	@Override
	public void sessionDestroy(SessionDestroyEvent event) {
		// Do session end stuff here
		log.info("===========>一个浏览器连接中断<=============");
	}

}
