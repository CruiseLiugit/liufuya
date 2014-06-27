package com.seaway.liufuya.demo;


import java.util.Date;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;



/**
 * 作为接受页面请求的控制器
 * 测试框架时建立的简单  登录测试类
 * @author lililiu
 *
 */
@IocBean
public class TestNutzModule {

	private static final Log log = Logs.get();
	
	public TestNutzModule() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 项目启动时的验证，搭建项目框架使用，返回当前系统时间
	 * @return
	 */
	@At("/ping") 
	public Object ping(){
		//log.debug("====>dao ="+dao);
		return new Date();
	}

}
