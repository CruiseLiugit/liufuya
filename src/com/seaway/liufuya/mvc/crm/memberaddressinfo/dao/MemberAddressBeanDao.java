package com.seaway.liufuya.mvc.crm.memberaddressinfo.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.BasicDao;
import com.seaway.liufuya.common.util.DateUtil;
import com.seaway.liufuya.mvc.crm.memberaddressinfo.pojo.MemberAddress;
import com.seaway.liufuya.mvc.crm.memberaddressinfo.pojo.MemberAddressBean;
import com.seaway.liufuya.mvc.crm.memberinfo.dao.MemberInfoManager;
import com.seaway.liufuya.mvc.crm.memberinfo.data.Citypart;
import com.seaway.liufuya.mvc.crm.memberinfo.data.Member;
import com.seaway.liufuya.mvc.crm.memberinfo.data.MemberBean;
import com.vaadin.data.util.BeanItemContainer;

@IocBean
public class MemberAddressBeanDao extends BasicDao implements Serializable {
	private static final Log log = Logs.get();
	private Dao dao = null;

	private static final long serialVersionUID = 1L;

	public MemberAddressBeanDao() {
		// TODO Auto-generated constructor stub
	}

	public MemberAddressBeanDao(Dao dao) {
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
	public int getMemberTotalCount() {
		Cnd condition = Cnd.where("status", "=", 1);
		return this.searchCount(Member.class, condition);
	}

	/**
	 * 分页查询所有 会员 信息
	 */
	public List<MemberBean> getMemberByPager(int startNum, int pageRows) {
		// select * from lfy_member_address where status='1'
		Cnd condition = Cnd.where("status", "=", 1); // 只查正常的会员
		Pager pager = dao.createPager(startNum, pageRows);
		// 设置可以查询的总条数
		pager.setRecordCount(dao.count(Member.class, condition));
		List<Member> menus = dao.query(Member.class, condition, pager);

		// 转换
		List<MemberBean> list = new LinkedList<MemberBean>();
		for (Member member : menus) {
			MemberBean menu = new MemberBean();
			menu.setLoginname(member.getLoginName()); // 手机号码
			menu.setRealname(member.getRealName()); // 真实名称
			menu.setUsersex(member.getSex().equals("1") ? "男" : "女"); // 性别
			String type = member.getUser_type();
			log.info("---------user_name =" + member.getRealName());
			log.info("---------user_type =" + type);
			int typevalue = 0;
			try {
				typevalue = Integer.parseInt(type.trim());
				switch (typevalue) {
				case 1:
					menu.setUsertype("实体卡"); // 类型
					break;
				case 2:
					menu.setUsertype("网站注册"); // 类型
					break;
				case 3:
					menu.setUsertype("微信注册"); // 类型
					break;
				case 4:
					menu.setUsertype("后台注册"); // 类型
					break;
				default:
					menu.setUsertype("其他注册"); // 类型
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				log.info("用户类型数据库存储值，无法转换为 int");
				menu.setUsertype(type);
			}

			menu.setCity(member.getCity()); // 城市
			menu.setCardid(member.getEntityCardNumber()); // 实体卡号
			list.add(menu);
		}
		return list;
	}

	/**
	 * 获取所有 会员 地址的数量
	 * 
	 * @return
	 */
	public int getMemberAddressTotalCount() {
		Cnd condition = Cnd.where("status", "=", 1);
		return this.searchCount(MemberAddress.class, condition);
	}

	/**
	 * 根据会员手机号码，查询完整信息
	 * 
	 * @param map
	 * @return
	 */
	public Member findMemberByLoginName(String loginname) {
		Cnd condition = Cnd.where("loginName", "=", loginname);
		return findByCondition(Member.class, condition);
	}

	/**
	 * 通过菜单名称查找菜单
	 */
	public List<MemberAddressBean> getMemberAddressByUserCode(String user_code) {
		// select * from lfy_member_address where status='1'
		log.info(">>>>>>>>>>>>>>>>>>> dao    user_code =" + user_code);
		Cnd condition = Cnd.where("status", "=", 1).and("user_code", "=",
				user_code);
		List<MemberAddress> menus = dao.query(MemberAddress.class, condition,
				null);

		log.info(">>>>>>>>>>>>>>>>>>> dao    该会员地址数目 =" + menus.size());

		List<MemberAddressBean> list = new ArrayList<MemberAddressBean>();
		for (MemberAddress address : menus) {
			MemberAddressBean menu = new MemberAddressBean();
			menu.setCity(address.getCity());
			menu.setArea(address.getArea());
			menu.setAddress_keywords(address.getAddress_keywords());
			menu.setGps_long(address.getGps_long());
			menu.setGps_lat(address.getGps_lat());
			menu.setIs_default(address.getIs_default().equals("0") ? "不是" : "是");
			menu.setIs_available(address.getIs_available().equals("0") ? "不能"
					: "能");
			menu.setCreate_date(DateUtil.getDate(address.getCreate_date()));

			list.add(menu);
		}

		return list;
	}

	// ---------------------------------------------------
	// 地址表单方法
	// ------------------------------
	// 2014-07-12 新增。查询数据库城市表格 lfy_citypart
	// 方法一 查询顶级城市
	public List<Citypart> getTopCityList() {
		// TODO Auto-generated method stub
		List<Citypart> citys = dao.query(Citypart.class,
				Cnd.where("address_parent", "=", "-1").and("status", "=", "1"));
		return citys;
	}

	// 方法二 根据顶级城市 id 查询二级区域
	public List<Citypart> getSecondCityList(int topid) {
		List<Citypart> citys = dao
				.query(Citypart.class, Cnd.where("address_parent", "=", topid)
						.and("status", "=", "1"));
		return citys;
	}

}
