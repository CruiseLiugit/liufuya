package com.seaway.liufuya.mvc.crm.consumeexchange.service;

import java.util.ArrayList;
import java.util.List;

import com.seaway.liufuya.mvc.crm.consumeexchange.dao.ConsumeExchangeManager;
import com.seaway.liufuya.mvc.crm.consumeexchange.data.ConsumeExchangeBean;
import com.seaway.liufuya.mvc.crm.consumeexchange.data.MemberBean;

public class ConsumeExchangeService {
	
    private ConsumeExchangeManager manager;
	public ConsumeExchangeService(ConsumeExchangeManager manager){
		this.manager =manager;
	}
	
	/**
	 * 获得所有会员 显示
	 * 
	 * @author zg
	 * **/
	public List<MemberBean> getAllMember(){
		List<com.seaway.liufuya.mvc.crm.memberinfo.data.MemberBean> beanList =manager.getAllMember();
		List<MemberBean> bean1List =new ArrayList<MemberBean>();
		for(com.seaway.liufuya.mvc.crm.memberinfo.data.MemberBean bean:beanList){
			MemberBean bean1 = new MemberBean();
			bean1.setCardbalance(bean.getCardbalance());
			bean1.setCardid(bean.getCardid());
			bean1.setCardscore(bean.getCardscore());
			bean1.setRealname(bean.getRealname());
			bean1.setUserCode(bean.getUsercode());
			bean1List.add(bean1);
		}
		return bean1List;
	}
	
	/**
	 * 通过UserCode获得所有积分
	 * 
	 * @author zg
	 * **/
	public List<ConsumeExchangeBean> getAllConsumeExchangeByUserCode(String userCode){
		return manager.getConsumeExchangeByUserCode(userCode);
	}
}
