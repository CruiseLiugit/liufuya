package com.seaway.liufuya.mvc.weixinstore.excoupon.service;

import java.util.List;

import org.nutz.dao.Cnd;

import com.seaway.liufuya.mvc.crm.memberinfo.data.Member;
import com.seaway.liufuya.mvc.weixinstore.excoupon.dao.ExcouponManager;
import com.seaway.liufuya.mvc.weixinstore.excoupon.data.Excoupon;

/**
 * 优惠兑换记录  service  业务处理
 * **/
public class ExcouponService {

	private ExcouponService service;
	private ExcouponManager manager;
	
	public ExcouponService(ExcouponManager manager){
		this.manager = manager;
	}
	
	/**
	 * 通过会员编码获取所有记录
	 * 
	 * @author zg
	 * **/
	public List<Excoupon> getExcouponByMemCode(String code){
		Excoupon excoupon = new Excoupon();
		excoupon.setUserCode(code);
		List<Excoupon> list = this.manager.getExcouponByMemCode(excoupon);
		for(Excoupon coupon:list){
			if(coupon.getStatus().equals("1")){
				coupon.setStatus("启用");
			}else{
				coupon.setStatus("未启用");
			}
		}
		return list;
	}
	
	/**
	 * 获得所有有效会员
	 * 
	 * @author zg
	 * **/
	public List<Member> getAllMember(){
		return this.manager.getAllMember();
	}
}
