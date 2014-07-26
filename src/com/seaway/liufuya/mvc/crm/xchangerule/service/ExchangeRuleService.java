package com.seaway.liufuya.mvc.crm.xchangerule.service;

import java.io.Serializable;
import java.util.List;

import com.seaway.liufuya.mvc.crm.xchangerule.dao.ExchangeRuleBeanDao;
import com.seaway.liufuya.mvc.crm.xchangerule.pojo.CrmExchangeRule;

/**
 * 服务层
 * @author lililiu
 *
 */
public class ExchangeRuleService implements Serializable {

    private ExchangeRuleBeanDao exchangeDao = null;
	
	public ExchangeRuleService() {
	}
	
	public ExchangeRuleService(ExchangeRuleBeanDao dao) {
		exchangeDao = dao;
	}
	/**
	 * 分页从数据库获取数据
	 * @param startIndex 开始记录索引
	 * @param pageRows   每页显示条数
	 * @return
	 */
    public List<CrmExchangeRule> getMemberByPager(int startIndex, int pageRows) {
        List<CrmExchangeRule> list = exchangeDao.getExchangeByPager(startIndex, pageRows);
        return list;
    }
	
    
    public int exchangeSize() {
        return exchangeDao.getTotalCount();
    }
	
	/**
	 * 分页从数据库获取数据
	 * @param startIndex 开始记录索引
	 * @param pageRows   每页显示条数
	 * @return
	 */
    public List<CrmExchangeRule> exchangeRuleList(int startIndex, int pageRows) {
        List<CrmExchangeRule> list = exchangeDao.getExchangeByPager(startIndex, pageRows);
        return list;
    }
    //-----------------------------------------------------
    //取出数据后，在页面表格中显示的数据转换
	
}
