package com.seaway.liufuya.mvc.crm.memberinfo.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.BasicDao;
import com.seaway.liufuya.common.util.DateUtil;
import com.seaway.liufuya.mvc.crm.memberinfo.dao.MemberInfoManager;
import com.seaway.liufuya.mvc.crm.memberinfo.data.Citypart;
import com.seaway.liufuya.mvc.crm.memberinfo.data.Member;
import com.seaway.liufuya.mvc.crm.memberinfo.data.MemberBean;
import com.vaadin.data.util.BeanItemContainer;

@IocBean
public class MemberInfoMemberBean extends BasicDao implements
		MemberInfoManager, Serializable {
	private static final Log log = Logs.get();
	private Dao dao = null;

	private static final long serialVersionUID = 1L;

	public MemberInfoMemberBean() {
		// TODO Auto-generated constructor stub
	}

	public MemberInfoMemberBean(Dao dao) {
		this.dao = dao;
		super.dao = dao;
	}

	/**
	 * 被 PersonReferenceContainer.java 容器调用的方法。 容器能被 Table Form
	 * 公用，所以有可能每次查询字段不同，那么需要动态变化的字段，组合不同的 SQL 语句
	 * 
	 * @param queryMetaData
	 *            查询的参数 where 后使用
	 * @param propertyNames
	 *            要查询的列名 from 前使用
	 * 
	 */
	@Override
	public List<MemberBean> getMemberBeanList() {
		Sql sql = Sqls
				.create("select m.id as mid,m.user_code as user_code,m.user_type as user_type,m.loginName as loginName,m.realName as realName,m.sex as sex,m.entityCardNumber as entityCardNumber,m.memberCard_score as memberCard_score,m.create_date as create_date,m.memberCard_balance as memberCard_balance,m.regDate as regDate,m.status as status,a.city as city,a.area as area,a.address_keywords as address_keywords,a.available_shops as available_shops,a.is_available as is_available  "
						+ "from lfy_member m,lfy_member_address a  "
						+ "where m.user_code=a.user_code and m.status='1' and a.is_default='1' and a.status='1' order by m.create_date desc");

		// dao.execute(sql) 执行前，编写回调函数，解析 查询结果
		sql.setCallback(new SqlCallback() {
			public Object invoke(Connection conn, ResultSet rs, Sql sql)
					throws SQLException {
				List<MemberBean> list = new LinkedList<MemberBean>();
				while (rs.next()) {
					MemberBean menu = new MemberBean();
					// menu.setId(rs.getInt("mid"));
					// menu.setUsercode(rs.getString("user_code")); // 会员编码
					menu.setLoginname(rs.getString("loginName")); // 手机号码
					menu.setRealname(rs.getString("realName")); // 真实名称
					menu.setUsersex((rs.getString("sex")).equals("1") ? "男"
							: "女"); // 性别
					String type = rs.getString("user_type");
					switch (Integer.parseInt(type.trim())) {
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

					String time = "";
					if (rs.getDate("regDate") == null) {
						time = DateUtil.getDate(rs.getDate("create_date"));
					} else {
						time = DateUtil.getDate(rs.getDate("regDate"));
					}
					menu.setCreatedate(time);// 注册日期
					String city = rs.getString("city");
					String area = rs.getString("area");
					StringBuffer sb = new StringBuffer("");
					if (city != null) {
						sb.append(city);
					}
					if (area != null) {
						sb.append(area);
					}
					menu.setCity(sb.toString()); // 城市
					menu.setCardid(rs.getString("entityCardNumber")); // 实体卡号
					menu.setCardbalance(rs.getInt("memberCard_balance")); // 会员卡余额
					menu.setCardscore(rs.getInt("memberCard_score")); // 会员卡总积分

					list.add(menu);
				}

				return list;
			}
		});

		dao.execute(sql);
		return sql.getList(MemberBean.class);
	}


	// ------------------------------
	// 2014-07-12 新增。查询数据库城市表格 lfy_citypart
	// 方法一 查询顶级城市
	@Override
	public List<Citypart> getTopCityList() {
		// TODO Auto-generated method stub
		List<Citypart> citys = dao.query(Citypart.class,
				Cnd.where("address_parent", "=", "-1").and("status", "=", "1"));
		return citys;
	}

	// 方法二 根据顶级城市 id 查询二级区域
	@Override
	public List<Citypart> getSecondCityList(int topid) {
		List<Citypart> citys = dao.query(Citypart.class,
				Cnd.where("address_parent", "=", topid).and("status", "=", "1"));
		return citys;
	}

	
	//根据会员登录名(手机号码)查询所有信息
	@Override
	public Member getMemeberByLoginname(String loginname) {
		Cnd condition = Cnd.where("loginName", "=", loginname)
				.and("status", "=", "1");
		return findByCondition(Member.class, condition);
	}
	
	
	
	public void saveMember(Member ml){
		
		String uuid = UUID.randomUUID().toString();
		ml.setUser_code(uuid);
		ml.setUser_type("4");
		ml.setCreate_date(new Date());
		ml.setRegDate(new Date());
		ml.setStatus("1");
	
		this.save(ml);
	}

	@Override
	public List<Member> getMemberList() {
		List<Member> list=this.dao.query(Member.class, null);
		return list;
	}

	public List<Member> getMemberByNameOrPhoneNo(String value) {
		Cnd condition = Cnd.where("realName", "like", "%"+value+"%")
				.or("loginName", "like", "%"+value+"%" );
		List<Member> list=this.dao.query(Member.class, condition);
		return list;
	}


	public List<Member> getMemberByUserType(String value) {
		Cnd condition = Cnd.where("user_type", "=", value);
		List<Member> list=this.dao.query(Member.class, condition);
		return list;
	}

	public List<Member> getMemberBySex(String value) {
		Cnd condition = Cnd.where("sex", "=", value);
		List<Member> list=this.dao.query(Member.class, condition);
		return list;
	}

	public List<Member> getMemberByStatus(String value) {
		Cnd condition = Cnd.where("status", "=", value);
		List<Member> list=this.dao.query(Member.class, condition);
		return list;
	}

	public List<Member> getMemberByCity(String value) {
		Cnd condition = Cnd.where("city", "=", value);
		List<Member> list=this.dao.query(Member.class, condition);
		return list;
	}

	public List<Member> getMemberByWork(String value) {
		Cnd condition = Cnd.where("work_type", "=", value);
		List<Member> list=this.dao.query(Member.class, condition);
		return list;
	}

	public List<Member> getMemberByCreateDate(Date value) {
		Cnd condition = Cnd.where("create_date", "=", value);
		List<Member> list=this.dao.query(Member.class, condition);
		return list;
	}
}
