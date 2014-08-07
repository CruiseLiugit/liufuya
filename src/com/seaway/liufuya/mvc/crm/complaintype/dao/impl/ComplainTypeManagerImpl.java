package com.seaway.liufuya.mvc.crm.complaintype.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.BasicDao;
import com.seaway.liufuya.mvc.crm.complaintype.dao.ComplainTypeManager;
import com.seaway.liufuya.mvc.crm.complaintype.date.ComplainTypeDtilBean;

@IocBean
public class ComplainTypeManagerImpl extends BasicDao implements Serializable,ComplainTypeManager {

	private static final Log log = Logs.get();
	private Dao dao = null;

	private static final long serialVersionUID = 1L;
	
	public ComplainTypeManagerImpl(Dao dao){
		this.dao =dao;
		super.dao = dao;
	}
	
	
	@Override
	public List<String> getComplainType() {
		Sql sqls = Sqls.create("select ct.typeName as typeName from lfy_member_complain_type ct");
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
	public List<ComplainTypeDtilBean> getComplainTypeDtil(String complainType) {
		Sql sqls = Sqls.create("SELECT ct.createDate AS createDate,ct.createPerson AS createPerson,ct.typeName AS typeName,ct.remark AS remark,ct.status as status "
				                       +"from lfy_member_complain_type  ct "
				                       +"where ct.typeName='"+complainType+"'  ");//不加状态为1   为了使刚改变状态的在页面没刷新的状态下可以重新修改过来
		sqls.setCallback(new SqlCallback() {
			
			@Override
			public Object invoke(Connection conn, ResultSet rs, Sql sql)throws SQLException {
				List<ComplainTypeDtilBean> list = new LinkedList<ComplainTypeDtilBean>();
	            while (rs.next()){
	            	ComplainTypeDtilBean bean = new ComplainTypeDtilBean();
	            	bean.setCreateDate(rs.getDate("createDate"));
	            	bean.setCreatePerson(rs.getString("createPerson"));
	            	bean.setTypeName(rs.getString("typeName"));
	            	if("0".equals(rs.getString("status"))){
	            		bean.setStatus("删除");
	            	}else{
	            		bean.setStatus("启用");
	            	}
	            	bean.setRemark(rs.getString("remark"));
	            	
	            	list.add(bean);
	            }
	            return list;
			}
		});
		dao.execute(sqls);
		return sqls.getList(ComplainTypeDtilBean.class);
	}


	@Override
	public String save(String[] args) {
		String reback = null;
		//先验证  是否存在相同诉求类型名
		Sql sql = Sqls.create("select ct.typeName from lfy_member_complain_type ct "+"where ct.typeName= '"+args[0]+"'");
		sql.setCallback(new SqlCallback() {
			
			@Override
			public Object invoke(Connection conn, ResultSet rs, Sql sql)
					throws SQLException {
				List<String> list = new LinkedList<String>();
	            while (rs.next())
	                list.add(rs.getString("typeName"));
	            return list;
			}
		});
		dao.execute(sql);
		//保存新增
		if(sql.getList(String.class).size() !=0){
			reback="保存失败   诉求类型名称已经存在！";
		}else{
			String uuid = "CPT"+UUID.randomUUID().toString();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			Sql sql2 = Sqls.create("insert into lfy_member_complain_type (typecode,typename,remark,createdate,createperson,status) values( '"
			+uuid+"','"+args[0]+"','"+args[1]+"','"+sdf.format(new Date())+"','"+"admin"+"',"+"'1')");
			dao.execute(sql2);
			reback="保存成功！";
		}
		return reback;
	}


	@Override
	public void update(String[] args) {
		//保存修改
		Sql sql = Sqls.create("update lfy_member_complain_type set remark='"+args[1]+"',status='"+args[2]+"' where typename='"+args[0]+"'");
		dao.execute(sql);
	}


	@Override
	public void delete(String[] args) {
		//删除   修改状态  状态为0  未启用  1启用
		
	}

}
