package com.seaway.liufuya.mvc.crm.consumerule.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.seaway.liufuya.common.uuid.RandomCode;
import com.seaway.liufuya.mvc.crm.consumerule.dao.ConsumeRuleManager;
import com.seaway.liufuya.mvc.crm.consumerule.data.ConsumeRule;
import com.seaway.liufuya.mvc.crm.consumerule.data.ConsumeRuleBean;
import com.seaway.liufuya.mvc.login.model.SysUser;
import com.vaadin.ui.UI;

public class ConsumeRuleService {

	private ConsumeRuleManager manager = null;

	public ConsumeRuleService(ConsumeRuleManager manager) {
		this.manager = manager;
	}

	public int ruleSize() {
        return manager.getTotalCount();
    }
	/**
	 * 获得显示itemBean
	 * 
	 * @author zg
	 * **/
	public List<ConsumeRuleBean> getAllItemBean() {
		List<ConsumeRuleBean> bean = new LinkedList<ConsumeRuleBean>();
		for (ConsumeRule rule : manager.getAllRule()) {
			bean.add(exRuleBean(rule));
		}
		return bean;
	}
	
	/**
	 * 分页获取显示itemBean
	 * 
	 * @author zg
	 * **/
	public List<ConsumeRuleBean> getAllItemBeanByPage(int startIndex, int pageRows,String user_code) {
		List<ConsumeRuleBean> bean = new LinkedList<ConsumeRuleBean>();
		for (ConsumeRule rule : manager.getAllRuleByPagr(startIndex, pageRows)) {
			bean.add(exRuleBean(rule));
		}
		return bean;
	}

	/**
	 * 添加一个规则
	 * **/
	public ConsumeRule addRule(ConsumeRuleBean bean) {
		SysUser user=(SysUser) UI.getCurrent().getSession().getAttribute("loginUser");
		ConsumeRule rule=exRule(bean);
		rule.setRuleCode(new RandomCode().generateNumberString("CL", 4));//规则编码
		rule.setStartDate(new Date());//创建时间
		rule.setCreatePerson(user.getUserName());
		return manager.addRule(rule);
	}
	
	/**
	 * 更新兑换规则
	 * 
	 * @author zg
	 * **/
	public void updateRule(ConsumeRuleBean bean){
		ConsumeRule bean1=exRule(bean);
		bean1.setRuleCode(bean.getRuleCode());
		 manager.updateRule(bean1);
	}

	/**
	 * 实体bean和itembean之间的转换
	 * 
	 * @author zg
	 * **/
	private ConsumeRuleBean exRuleBean(ConsumeRule rule) {
		ConsumeRuleBean bean = new ConsumeRuleBean();
		bean.setCreatePerson(rule.getCreatePerson());
		bean.setRemark(rule.getRemark());
		bean.setRuleCode(rule.getRuleCode());
		bean.setRuleName(rule.getRuleName());
		bean.setRulePercent(String.valueOf(rule.getRulePercent()));
		bean.setRuleType(rule.getRuleType() == 1 ? "消费积分" : "活动积分");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		bean.setStartDate(sdf.format(rule.getStartDate()));
		bean.setStatus(rule.getStatus().equals("1") ? "有效" : "无效");
		return bean;
	}

	/**
	 * itembean转换为 实体bean
	 * 
	 * @author zg
	 * **/
	public ConsumeRule exRule(ConsumeRuleBean bean) {
		ConsumeRule rule = new ConsumeRule();
		rule.setCreatePerson(bean.getCreatePerson());
		if (bean.getRemark() != null)
			rule.setRemark(bean.getRemark());
		rule.setRuleName(bean.getRuleName());
		rule.setRulePercent(Double.valueOf(bean.getRulePercent()));
		rule.setRuleType(Integer.valueOf(bean.getRuleType()));
		rule.setStatus(bean.getStatus());
		return rule;
	}
}
