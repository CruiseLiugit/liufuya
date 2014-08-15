package com.seaway.liufuya.mvc.crm.consumerule.dao;

import java.io.Serializable;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.loader.annotation.IocBean;

import com.seaway.liufuya.BasicDao;
import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.common.util.Page;
import com.seaway.liufuya.mvc.crm.consumerule.data.ConsumeRule;
import com.seaway.liufuya.mvc.system.storeaddress.data.StoreAddress;

/**
 * 积分兑换规则 manager
 * 
 * @author zg
 * **/
@IocBean
public class ConsumeRuleManager extends BasicDao implements Serializable {
	private static final long serialVersionUID = 1L;
	private Dao dao = null;

	public ConsumeRuleManager(Dao dao) {
		this.dao = dao;
		super.dao = dao;
	}

	/**
	 * 获取所有规则条数
	 * 
	 * @author zg
	 * **/
	public int getTotalCount() {
		return this.searchCount(ConsumeRule.class);
	}

	/**
	 * 获取积分兑换所有规则
	 * 
	 * @author zg
	 * **/
	public List<ConsumeRule> getAllRule() {
		return this.dao.query(ConsumeRule.class, null);
	}

	/**
	 * 分页获取兑换规则
	 */
	public List<ConsumeRule> getAllRuleByPagr(int startNum, int pageRows) {
		Cnd condition = null; // 查询所有
		// 根据条件 查询出总共条数 并且赋值给Pager
		int totalCount = this.dao.count(StoreAddress.class);
		// 根据 startNum 判断出当前是第几页
		Page pageTool = new Page(totalCount, startNum);
		int pageNumber = pageTool.getNowpage();
		
		Pager pager = dao.createPager(pageNumber, Constants.PAGE_SIZE);
		pager.setRecordCount(dao.count(ConsumeRule.class, condition));
		List<ConsumeRule> menus = dao
				.query(ConsumeRule.class, condition, pager);
		return menus;
	}

	/**
	 * 新增积分对话规则
	 * 
	 * @author zg
	 * **/
	public ConsumeRule addRule(ConsumeRule rule) {
		return this.dao.insert(rule);
	}

	/**
	 * 更新积分兑换规则
	 * 
	 * @author zg
	 * **/
	public void updateRule(ConsumeRule rule) {
		Sql sql = Sqls.create("update crm_consume_rule set ruleName='"
				+ rule.getRuleName() + "',ruleType ='" + rule.getRuleType()
				+ "', rulePercent='" + rule.getRulePercent() + "', remark='"
				+ rule.getRemark() + "',status ='" + rule.getStatus()
				+ "' where ruleCode='" + rule.getRuleCode() + "'");
		dao.execute(sql);
	}

}
