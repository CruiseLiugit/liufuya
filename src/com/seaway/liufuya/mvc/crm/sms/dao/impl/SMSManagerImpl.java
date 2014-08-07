package com.seaway.liufuya.mvc.crm.sms.dao.impl;

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
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.BasicDao;
import com.seaway.liufuya.mvc.crm.sms.dao.SMSManager;
import com.seaway.liufuya.mvc.crm.sms.date.SMSBean;

public class SMSManagerImpl extends BasicDao implements SMSManager {
	
	private static final Log log = Logs.get();
	private Dao dao = null;

	private static final long serialVersionUID = 1L;
	
	public SMSManagerImpl(Dao dao){
		this.dao =dao;
		super.dao = dao;
	}

	@Override
	public List<SMSBean> getSMSByType(String smsType) {
		//0表示 注册时发送的短信、1 表示找回密码时发送的短信、2表示订购成功时发送的短信、3表示付款成功，积分生成时发送的短信'
		int type= 0;
		if(smsType.equals("注册短信")){
			type =0;
		}else if(smsType.equals("密码找回")){
			type =1;
		}else if(smsType.equals("订购成功")){
			type =2;
		}else if(smsType.equals("付款成功/积分生成")){
			type =3;
		}
		
	   Sql sql = Sqls.create("SELECT sms.smsCode AS smsCode,sms.smsType AS smsType,sms.smsContent AS smsContent,sms.createDate AS createDate,sms.createPerson AS createPerson,sms.remark AS remark,sms.status AS STATUS,sms.smsFor as smsFor "
                                       +"FROM lfy_member_sms sms "
                                       +"WHERE sms.smsType = "+type);
	   sql.setCallback(new SqlCallback() {
		
		@Override
		public Object invoke(Connection conn, ResultSet rs, Sql sql)
				throws SQLException {
			List<SMSBean> smsList = new LinkedList<SMSBean>();
			while(rs.next()){
				SMSBean smsBean = new SMSBean();
				smsBean.setCreateDate(rs.getDate("createDate"));
				smsBean.setCreatePerson(rs.getString("createPerson"));
				smsBean.setRemark(rs.getString("remark"));
				smsBean.setSmsCode(rs.getString("smsCode"));
				String content = null;
				if(rs.getString("smsContent").length() >15){
					content=rs.getString("smsContent").substring(0,15);
				}else{
					content=rs.getString("smsContent");
				}
				smsBean.setSmsContent(content);
				String smstype = null;
				//0表示 注册时发送的短信、1 表示找回密码时发送的短信、2表示订购成功时发送的短信、3表示付款成功，积分生成时发送的短信'
				switch((int)rs.getInt("smsType")){
				case 0:
					smstype=" 注册短信";
					break;
				case 1:
					smstype = "密码找回";
					break;
				case 2:
					smstype = "订购成功";
					break;
				case 3:
					smstype = "付款成功/积分生成";
					break;
				}
				smsBean.setSmsType(smstype);
				// 0表示 为订单系统、1 表示为后台管理系统 不同类型用户使用的短信'
				String smsFor = null;
				if(rs.getString("smsFor").equals("0")){
					smsFor = "订单系统";
				}else{
					smsFor = "后台系统";
				}
				smsBean.setSmsFor(smsFor);
				String status = null;
				if(rs.getInt("status")== 0){
					status = "未启用";
				}else{
					status = "启用";
				}
				smsBean.setStatus(status);
				smsList.add(smsBean);
			}
			return smsList;
		}
	});
	   dao.execute(sql);
		return sql.getList(SMSBean.class);
	}

	@Override
	public String updateSMSStatus(String[] args) {
        String back ="修改成功";     
		if(args[3].equals("1") &&  !checkStatusByTypeAndStat(args[1]) ){
			back = "修改失败 同类型已有启用短信";
			return back;
		}
		Sql sqls = Sqls.create("UPDATE lfy_member_sms SET STATUS = '"+args[3]+"',remark ='"+args[2]+"',smsContent ='"+args[4]+"',smsFor = '"+args[5]+"'  WHERE smsCode = '"+args[0]+"'");
		dao.execute(sqls);
		return back;
	}

	@Override
	public String addSMS(String [] args) {
		String back = "添加成功";
		
		if(args[3].equals("1") && !checkStatusByTypeAndStat(args[1])){
			back = "添加失败 同类型已有启用短信";
			return back;
		}
		String uuid = "SMS"+UUID.randomUUID().toString();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Sql sqls = Sqls.create("INSERT INTO lfy_member_sms (smsCode,smsType,smsFor,smsContent,createDate,createPerson,remark,status) VALUES "
                +"('"+uuid+"','"+args[1]+"','"+args[5]+"','"+args[4]+"','"+sdf.format(new Date())+"','"+"管理员"+"','"+args[2]+"','"+args[3]+"')" );
        dao.execute(sqls);
		return back;
	}

	@Override
	public boolean delSMS() {
		return false;
	}
	
	public boolean checkStatusByTypeAndStat(String smsType){
		boolean back = false;
		Sql sqls = Sqls.create("SELECT sms.smsCode AS smsCode "
                                          +"FROM lfy_member_sms sms "
                                          +"WHERE sms.smsType = '"+tranSmsType(smsType)+"' and status = '1' ");
		sqls.setCallback(new SqlCallback() {
			@Override
			public Object invoke(Connection conn, ResultSet rs, Sql sql)throws SQLException {
				List <String> list = new LinkedList<String>();
				while(rs.next()){
					list.add(rs.getString("smsCode"));
				}
				return list;
			}
		});
		dao.execute(sqls);
		if(sqls.getList(String.class) == null || sqls.getList(String.class) .size() == 0){
			back = true;
		}
		return back;
	}

	//短信类型转换
	private int tranSmsType (String smsType){
		int type = 0; 
		if(smsType.equals("注册短信")){
			type =0;
		}else if(smsType.equals("密码找回")){
			type =1;
		}else if(smsType.equals("订购成功")){
			type =2;
		}else if(smsType.equals("付款成功/积分生成")){
			type =3;
		}
		return type;
	}

}
