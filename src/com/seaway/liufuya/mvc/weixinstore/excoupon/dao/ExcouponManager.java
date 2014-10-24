package com.seaway.liufuya.mvc.weixinstore.excoupon.dao;

import java.io.Serializable;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

import com.seaway.liufuya.BasicDao;
import com.seaway.liufuya.mvc.crm.memberinfo.data.Member;
import com.seaway.liufuya.mvc.weixinstore.excoupon.data.Excoupon;

@IocBean
public class ExcouponManager extends BasicDao implements Serializable{

	private static final long serialVersionUID = 1L;
	private Dao dao = null;
	
	public  ExcouponManager(Dao dao){
		this.dao = dao;
	}
	
	/**
	 * 通过会员编码获取所有记录
	 * 
	 * @author zg
	 * **/
	public List<Excoupon> getExcouponByMemCode(Excoupon excoupon){
		Cnd cnd = Cnd.where("userCode", "=",excoupon.getUserCode() );	
		return this.dao.query(Excoupon.class, cnd);
	}
	
	/**
	 * 获得所有有效会员
	 * 
	 * @author zg
	 * **/
	public List<Member> getAllMember(){
		Cnd cnd = Cnd.where("status", "=","1" );
		return this.dao.query(Member.class, cnd);
	}
}
