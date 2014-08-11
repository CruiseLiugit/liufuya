package com.seaway.liufuya.mvc.crm.memberdelete.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.BasicDao;
import com.seaway.liufuya.common.util.DateUtil;
import com.seaway.liufuya.mvc.crm.memberdelete.dao.MemberDeleteInfoManager;
import com.seaway.liufuya.mvc.crm.memberdelete.data.MemberDeleteInfoBean;

/**
 * 会员管理
 * 
 * @author zhougang
 * **/

@IocBean
public class MemberDeleteInfoManagerImpl extends BasicDao implements Serializable,MemberDeleteInfoManager {

	private static final Log log = Logs.get();
	private Dao dao = null;

	private static final long serialVersionUID = 1L;


	public MemberDeleteInfoManagerImpl(Dao dao) {
		this.dao = dao;
		super.dao = dao;
	}
	
	@Override
	public List<MemberDeleteInfoBean> getMemberDeleteInfoBeanList() {
		Sql sql = Sqls
				.create("select m.id as mid,m.user_type as user_type,m.loginName as loginName,m.realName as realName,m.sex as sex,m.city as city,m.age_area as area ,m.regDate as regDate,m.memberCard_balance as memberCard_balance,m.memberCard_score as memberCard_score,m.entityCardNumber as entityCardNumber,m.create_date as create_date,m.status as status  "
						+"from lfy_member m  "
						+"where  m.status='2'  order by m.create_date desc");
		//设置回调函数  解析返回结果
		sql.setCallback(new SqlCallback() {
			@Override
			public Object invoke(Connection conn, ResultSet rs, Sql sql)throws SQLException {
				List<MemberDeleteInfoBean> memberDeleteInfoList = new LinkedList<MemberDeleteInfoBean>();
				
				while (rs.next()) {
					MemberDeleteInfoBean menu = new MemberDeleteInfoBean();
					menu.setId(rs.getInt("mid"));
					menu.setCardid(rs.getString("entityCardNumber")); // 实体卡号
					menu.setLoginname(rs.getString("loginName")); // 手机号码
					menu.setRealname(rs.getString("realName")); // 真实名称
					menu.setUsersex((rs.getString("sex")).equals("1") ? "男": "女"); // 性别
					menu.setStatus(rs.getString("status").equals("1")?"启用":"禁用");
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
					menu.setCity(rs.getString("city")); // 城市
					menu.setCardbalance(rs.getInt("memberCard_balance")); // 会员卡余额
					menu.setCardscore(rs.getInt("memberCard_score")); // 会员卡总积分

					memberDeleteInfoList.add(menu);
				}
				return memberDeleteInfoList;
			}
		});
		dao.execute(sql);
		return sql.getList(MemberDeleteInfoBean.class);
	}

	@Override
	public void removeMemberDeleteInfoBean(String realName,String longinName) {
		Sql sql = Sqls.create("Update lfy_member m set m.status=1 where m.realName = '"+realName +"' and m.loginName ='"+longinName+"'" );
		dao.execute(sql);
	}

	@Override
	public void addMemberDeleteInfoBeanList(MemberDeleteInfoBean memberDeleteInfo) {
		// TODO Auto-generated method stub
		
	}

}
