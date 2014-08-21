package com.seaway.liufuya.mvc.weixinstore.generatingcoupon.dao;

import java.io.Serializable;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;

import com.seaway.liufuya.BasicDao;
import com.seaway.liufuya.mvc.weixinstore.generatingcoupon.data.Coupon;

public class CouponManager extends BasicDao implements Serializable{
	private static final long serialVersionUID = 1L;
	private Dao dao = null;
	
	public CouponManager(Dao dao){
		this.dao = dao;
	}
	
	/**
	 * 获取所有的优惠券
	 * 
	 * @author zg
	 * **/
	public List<Coupon> getAllCoupon(){
		return this.dao.query(Coupon.class, null);
	}
	
	/**
	 * 通过优惠券编码获得优惠券
	 * 
	 * @author zg
	 * **/
	public List<Coupon> getCouponByCode(String code){
		Cnd cnd = Cnd.where("couponCode","=", code);
		return this.dao.query(Coupon.class, cnd);
	}
	
	/**
	 * 添加一个优惠券
	 * 
	 * @author zg
	 * **/
	public void addCoupon(Coupon coupon){
		this.dao.insert(coupon);
	}
	
	/**
	 * 更新一个优惠券
	 * 
	 * @author zg
	 * **/
	public void updateCoupon(Coupon coupon){
		this.dao.update(coupon);
	}
	
}
