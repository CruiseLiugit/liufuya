package com.seaway.liufuya.mvc.crm.xchangerule.dao;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.BasicDao;
import com.seaway.liufuya.mvc.crm.xchangerule.pojo.CrmExchangeRule;

@IocBean
public class ExchangeRuleBeanDao extends BasicDao implements Serializable {
	private static final Log log = Logs.get();
	private Dao dao = null;

	private static final long serialVersionUID = 1L;

	public ExchangeRuleBeanDao() {
		// TODO Auto-generated constructor stub
	}

	public ExchangeRuleBeanDao(Dao dao) {
		this.dao = dao;
		super.dao = dao;
	}

	// ---------------------------------------------------
	// 查询方法
	/**
	 * 查询当前所有 正常会员的 用户数量
	 * 
	 * @return
	 */
	public int getTotalCount() {
		return this.searchCount(CrmExchangeRule.class, null);
	}

	/**
	 * 分页查询所有 会员 信息
	 */
	public List<CrmExchangeRule> getExchangeByPager(int startNum, int pageRows) {
		// select * from lfy_member_address where status='1'
		Pager pager = dao.createPager(startNum, pageRows);
		// 设置可以查询的总条数
		pager.setRecordCount(dao.count(CrmExchangeRule.class, null));
		List<CrmExchangeRule> list = dao.query(CrmExchangeRule.class, null, pager);
		return list;
	}
	/**
	 * 查询所有 会员 信息
	 */
	public List<CrmExchangeRule> getExchangeList(int startNum, int pageRows) {
		// select * from lfy_member_address where status='1'
//		Cnd condition = Cnd.where("status", "=", 1); // 只查正常的会员
		Pager pager = dao.createPager(startNum, pageRows);
		// 设置可以查询的总条数
		pager.setRecordCount(dao.count(CrmExchangeRule.class, null));
		List<CrmExchangeRule> exchangeList = dao.query(CrmExchangeRule.class, null, pager);
		return exchangeList;
	}

	/**
	 * 获取所有 会员 地址的数量
	 * 
	 * @return
	 */
	public int getExchangeTotalCount() {
		return this.searchCount(CrmExchangeRule.class, null);
	}

	public void saveExchange(CrmExchangeRule exchange) {
		dao.insert(exchange);
	}

	public List<CrmExchangeRule> getExchangeList() {
		return dao.query(CrmExchangeRule.class, null);
	}

	public CrmExchangeRule getExchangeById(Long id) {
		Cnd condition = Cnd.where("id", "=", id);
	    LinkedList<CrmExchangeRule> list=(LinkedList<CrmExchangeRule>) dao.query(CrmExchangeRule.class, condition);
		return list.get(0);
	}


}
