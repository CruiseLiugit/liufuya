package com.seaway.liufuya.mvc.login.listener;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.vaadin.data.Property;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

public class LoginListener implements Button.ClickListener{
	private static final Log log = Logs.get();

	private static final long serialVersionUID = 1L;
	private CustomComponent newScreen;
    private Property<String> loginNameHolder;
    private Property<String> loginPwdHolder;
    
    public LoginListener(CustomComponent newScreen, Property<String> nameHolder, Property<String> pwdHolder) {

        this.loginNameHolder = nameHolder;
        this.loginPwdHolder = pwdHolder;
        this.newScreen = newScreen;
    }

    /**
     * 按钮点击后的  操作
     */
    @Override
    public void buttonClick(Button.ClickEvent event) {
    		//获取登录文本框中的内容
        String name = loginNameHolder.getValue();
        String pwd = loginPwdHolder.getValue();
        
        if (name.equals("liu") && pwd.equals("liu")) {
			
			log.info("登录成功.........");
			// 创建登录成功，选择菜单界面
			// 根据用户角色 显示不同的菜单项目
			//通知
	        Notification.show("欢迎你: " + name);
	        //吧当前用户名，存入  session 中
	       // VaadinSession.getCurrent().setAttribute(String.class, name);
	        //创建一个新的 屏幕对象,new ChatScreen()
	        //当前UI 对象只有一个，显示什么内容，要看往里面放入什么内容
	        //可以放入的有 Layout
	        UI.getCurrent().setContent(newScreen);
		} else {
			Notification.show("用户名或密码错误，请重新输入.");
		}
        
        
    }
}
