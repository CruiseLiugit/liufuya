package com.seaway.liufuya;

import org.nutz.dao.Dao;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;
import org.nutz.resource.Scans;

/**
 * 初试执行的方法
 * 这样的类，都需要在 MainModule 中进行配置
 * 
 * @author lililiu
 *
 */
public class CoreSetup implements Setup {

	private static final Log log = Logs.get();
	
	public void init(NutConfig config) {
		//验证启动时是否能够拿到 ioc 容器对象
		log.debug("====>ioc ="+config.getIoc());
	}

	public void destroy(NutConfig config) {
		// TODO Auto-generated method stub

	}

}