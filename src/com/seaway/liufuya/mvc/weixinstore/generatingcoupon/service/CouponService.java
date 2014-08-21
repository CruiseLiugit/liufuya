package com.seaway.liufuya.mvc.weixinstore.generatingcoupon.service;

import java.util.List;

import org.nutz.dao.Cnd;

import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.common.uuid.RandomCode;
import com.seaway.liufuya.mvc.login.model.SysUser;
import com.seaway.liufuya.mvc.weixinstore.generatingcoupon.dao.CouponManager;
import com.seaway.liufuya.mvc.weixinstore.generatingcoupon.data.Coupon;
import com.vaadin.ui.UI;

/**
 * 优惠券 service
 * 
 * @author zg
 * **/
public class CouponService {

	private CouponManager manager;
	
	public CouponService(CouponManager manager){
		this.manager = manager;
	}
	
	/**
	 * 获取所有的优惠券
	 * 
	 * @author zg
	 * **/
	public List<Coupon> getAllCoupon(){
		List<Coupon> couponList = this.manager.getAllCoupon();
		for(Coupon coupon:couponList){
			if(coupon.getStatus().equals("1")){
				coupon.setStatus("启用");
			}else{
				coupon.setStatus("未启用");
			}
			if(coupon.getIsNew().equals("1")){
				coupon.setIsNew("新品");
			}else{
				coupon.setIsNew("非新品");
			}
			for(int i=0;i<Constants.COUPON_TYPE_ID.length;i++){
				if(coupon.getCouponType().equals(Constants.COUPON_TYPE_ID[i])){
					coupon.setCouponType(Constants.COUPON_TYPE_NAME[i]);
				}
			}
		}
		return couponList;
	}
	
	/**
	 * 通过优惠券编码获得优惠券
	 * 
	 * @author zg
	 * **/
	public List<Coupon> getCouponByCode(String code){
		return this.manager.getCouponByCode(code);
	}
	
	/**
	 * 添加一个优惠券
	 * 
	 * @author zg
	 * **/
	public void addCoupon(Coupon coupon){
		coupon.setCouponCode(new RandomCode().generateNumberString("CP", 4));
		coupon.setCreatePerson(((SysUser) UI.getCurrent().getSession().getAttribute("loginUser")).getUserName());
		this.manager.addCoupon(coupon);
	}
	
	/**
	 * 更新一个优惠券
	 * 
	 * @author zg
	 * **/
	public void updateCoupon(Coupon coupon){
		Coupon cn=this.manager.getCouponByCode(coupon.getCouponCode()).get(0);
		cn.setAvtiveTime(coupon.getAvtiveTime());
		cn.setCouponDesc(coupon.getCouponDesc());
		cn.setCouponExchanges(coupon.getCouponExchanges());
		cn.setCouponName(coupon.getCouponName());
		cn.setCouponTotals(coupon.getCouponTotals());
		cn.setCouponType(coupon.getCouponType());
		cn.setEndDate(coupon.getEndDate());
		cn.setIsNew(coupon.getIsNew());
		cn.setStartDate(coupon.getStartDate());
		cn.setStatus(coupon.getStatus());
		cn.setCouponValue(coupon.getCouponValue());
		this.manager.updateCoupon(cn);
	}
	
}
