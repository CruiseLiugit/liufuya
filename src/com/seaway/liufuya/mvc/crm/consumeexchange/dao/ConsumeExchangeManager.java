package com.seaway.liufuya.mvc.crm.consumeexchange.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;

import com.seaway.liufuya.BasicDao;
import com.seaway.liufuya.common.util.DateUtil;
import com.seaway.liufuya.mvc.crm.consumeexchange.data.ConsumeExchangeBean;
import com.seaway.liufuya.mvc.crm.memberinfo.data.MemberBean;

public class ConsumeExchangeManager extends BasicDao {

	private Dao dao = null;
	public ConsumeExchangeManager(Dao dao){
		this.dao =dao;
		super.dao = dao;
	}
	
	/**
	 * 获取所有会员
	 * 
	 * @author zg
	 * **/
	public List<MemberBean> getAllMember(){
		Sql sql = Sqls
				.create("select m.id as mid,m.user_code as user_code,m.user_type as user_type,m.loginName as loginName,m.realName as realName,m.sex as sex,m.entityCardNumber as entityCardNumber,m.memberCard_score as memberCard_score,m.create_date as create_date,m.memberCard_balance as memberCard_balance,m.regDate as regDate,m.status as status "
						+ "from lfy_member m "
						+ "where  m.status='1'  order by m.create_date desc");

		// dao.execute(sql) 执行前，编写回调函数，解析 查询结果
		sql.setCallback(new SqlCallback() {
			public Object invoke(Connection conn, ResultSet rs, Sql sql)
					throws SQLException {
				List<MemberBean> list = new LinkedList<MemberBean>();
				while (rs.next()) {
					MemberBean menu = new MemberBean();
					// menu.setId(rs.getInt("mid"));
					menu.setUsercode(rs.getString("user_code")); // 会员编码
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
	
	/**
	 * 获取会员所有积分交易记录 通过会员编码
	 * 
	 * @author zg
	 * **/
	public List<ConsumeExchangeBean> getConsumeExchangeByUserCode(String userCode){
		Sql sql = Sqls.create("select exchangeDate,productName,exchangeNumber,isSend,sendPerson,status from crm_consume_exchange where status='1' and userCode ='"+userCode+"'");
		sql.setCallback(new SqlCallback() {
			
			@Override
			public Object invoke(Connection conn, ResultSet rs, Sql sql)
					throws SQLException {
				List<ConsumeExchangeBean> list = new LinkedList<ConsumeExchangeBean>();
				while (rs.next()) {
					ConsumeExchangeBean bean = new ConsumeExchangeBean();
					//bean.setExchangeCode(rs.getString("exchangeCode"));
					bean.setExchangeDate(String.valueOf(rs.getDate("exchangeDate")));
					bean.setExchangeNumber(rs.getString("exchangeNumber"));
					bean.setIsSend(rs.getString("isSend").equals("1")?"已发货":"未发货");
					bean.setProductName(rs.getString("productName"));
					bean.setSendPerson(rs.getString("sendPerson"));
					list.add(bean);
				}
				return list;
			}
		});
		dao.execute(sql);
		return sql.getList(ConsumeExchangeBean.class);
	}
	
}
