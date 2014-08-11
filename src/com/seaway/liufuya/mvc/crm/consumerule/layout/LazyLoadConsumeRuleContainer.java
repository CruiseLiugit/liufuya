package com.seaway.liufuya.mvc.crm.consumerule.layout;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.vaadin.data.util.BeanContainer;

public class LazyLoadConsumeRuleContainer extends BeanContainer{

	private static final long serialVersionUID = 1L;
	private static final Log log = Logs.get();
	
	public LazyLoadConsumeRuleContainer(Class type) {
		super(type);
	}

}
