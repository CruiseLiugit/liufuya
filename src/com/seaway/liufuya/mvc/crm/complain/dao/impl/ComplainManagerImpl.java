package com.seaway.liufuya.mvc.crm.complain.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.BasicDao;
import com.seaway.liufuya.mvc.crm.complain.dao.ComplainManager;
import com.seaway.liufuya.mvc.crm.complain.data.ComplainBean;
import com.seaway.liufuya.mvc.login.model.SysUser;
import com.vaadin.ui.UI;

public class ComplainManagerImpl extends BasicDao implements ComplainManager {
	
	private static final Log log = Logs.get();
	private Dao dao = null;

	private static final long serialVersionUID = 1L;
	
	public ComplainManagerImpl(Dao dao){
		this.dao =dao;
		super.dao = dao;
	}

	@Override
	public List<String> getComplainTyep() {
		Sql sqls = Sqls.create("select ct.typeName as typeName from lfy_member_complain_type ct where ct.status = '1'");
		sqls.setCallback(new SqlCallback() {
			@Override
			public Object invoke(Connection conn, ResultSet rs, Sql sql)throws SQLException {
				List<String> list = new LinkedList<String>();
	            while (rs.next())
	                list.add(rs.getString("typeName"));
	            return list;
			}
		});
		dao.execute(sqls);
		return sqls.getList(String.class);
	}

	@Override
	public List<ComplainBean> getComplains(String typecode) {
		Sql sql = Sqls.create("SELECT mc.complainCode as complaincode,mc.isOk as isok,mc.remark as remark,mc.complainContent as complaincontent ,mc.adminPerson as adminperson,mc.createDate as createDate,ct.typeName as typeName,lm.realName as realName,lm.telphone as telphone,mc.updatedate as updatedate"
	     +" FROM lfy_member_complain mc "
         +" LEFT JOIN lfy_member_complain_type ct  "
         +" ON ct.typeCode = mc.typeCode "
         +" LEFT JOIN lfy_member lm  "
         +" ON lm.user_code = mc.userCode "
         +" WHERE ct.typename = '"+typecode+"'");
		
		sql.setCallback(new SqlCallback() {
			
			@Override
			public Object invoke(Connection conn, ResultSet rs, Sql sql)throws SQLException {
				List<ComplainBean> list = new LinkedList<ComplainBean>();
				while(rs.next()){
					ComplainBean bean = new ComplainBean();
					bean.setComplainCode(rs.getString("complaincode"));
					if(rs.getString("isOk").equals("0")){
						bean.setIsOk("已回复");
					}else{
						bean.setIsOk("待回复");
					}
					bean.setRemark(rs.getString("remark"));
					if(rs.getString("complaincontent").length()>15){
						bean.setComplainContent(rs.getString("complaincontent").substring(0, 15));	
					}else{
						bean.setComplainContent(rs.getString("complaincontent"));	
					}
					
					bean.setAdminPerson(rs.getString("adminperson"));
					bean.setCreateTime(rs.getDate("createDate"));
					bean.setTypeName(rs.getString("typeName"));
					bean.setRelName(rs.getString("realName"));
					bean.setTelPhone(rs.getString("telphone"));
					bean.setUpdateDate(rs.getDate("updatedate"));
					list.add(bean);
				}
				return list;
			}
		});
		dao.execute(sql);
		return sql.getList(ComplainBean.class);
	}

	@Override
	public void isOk(String[] args) {
		SysUser user=(SysUser) UI.getCurrent().getSession().getAttribute("loginUser");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		sdf.format(new Date());
		Sql sql = Sqls.create("UPDATE lfy_member_complain SET isOk='0'"+",remark='"+args[3]+"',adminPerson='"+user.getUserName()+"',updateDate='"+sdf.format(new Date())+"' where complainCode='"+args[0]+"'");
		dao.execute(sql);
	}

}
