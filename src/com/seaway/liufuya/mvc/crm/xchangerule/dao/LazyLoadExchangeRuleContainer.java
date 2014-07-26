package com.seaway.liufuya.mvc.crm.xchangerule.dao;

import java.util.List;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.mvc.crm.xchangerule.pojo.CrmExchangeRule;
import com.seaway.liufuya.mvc.crm.xchangerule.service.ExchangeRuleService;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItem;

public class LazyLoadExchangeRuleContainer extends BeanContainer {
	private static final long serialVersionUID = 1L;
	private static final Log log = Logs.get();

	private ExchangeRuleService service = null;//数据处理类

	public LazyLoadExchangeRuleContainer(Class type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	
	public LazyLoadExchangeRuleContainer(Class type,ExchangeRuleBeanDao exchangeDao ) {
		super(type);
		service = new ExchangeRuleService(exchangeDao);
	}
	
	@Override
    public int size() {
        return service.exchangeSize();
    }

    @Override
    public BeanItem getItem(Object itemId) {
        return new BeanItem((CrmExchangeRule) itemId);
    }

    @Override
    public List getItemIds(int startIndex, int numberOfIds) {
    		log.info("startIndex: " + startIndex + ", numberOfIds: " + numberOfIds);
        List<CrmExchangeRule> list = service.exchangeRuleList(startIndex, numberOfIds);
        return list;
    }
	
	
	

}
