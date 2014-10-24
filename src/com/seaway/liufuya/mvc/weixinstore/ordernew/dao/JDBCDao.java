package com.seaway.liufuya.mvc.weixinstore.ordernew.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.seaway.liufuya.common.ConnectionPool;
import com.seaway.liufuya.mvc.weixinstore.ordernew.data.Delivernotify;
import com.seaway.liufuya.mvc.weixinstore.ordernew.data.Order;


public class JDBCDao {

	public JDBCDao() {

	}

	// --------------------------------------------------
	
	// 查询发货反馈数据
	public Delivernotify findByOrderCode(String out_trade_no) {
		Delivernotify deli = null;
		Connection conn = null;
		ConnectionPool pool = ConnectionPool.getInstance();
		
		String sql = "select * from lfy_delivernotify where out_trade_no like '%"
				+ out_trade_no + "'";
		try {
			conn = pool.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				deli = new Delivernotify();
				deli.setId(rs.getInt("id"));
				deli.setSign_type(rs.getString("sign_type"));
				deli.setInput_charset(rs.getString("input_charset"));
				deli.setSign(rs.getString("sign"));
				deli.setTrade_mode(rs.getInt("trade_mode"));
				deli.setTrade_state(rs.getInt("trade_state"));
				deli.setPartner(rs.getString("partner"));
				deli.setBank_type(rs.getString("bank_type"));
				deli.setBank_billno(rs.getString("bank_billno"));
				deli.setTotal_fee(rs.getInt("total_fee"));
				deli.setFee_type(rs.getInt("fee_type"));
				deli.setNotify_id(rs.getString("notify_id"));
				deli.setTransaction_id(rs.getString("transaction_id"));
				deli.setOut_trade_no(rs.getString("out_trade_no"));
				deli.setAttach(rs.getString("attach"));
				deli.setTime_end(rs.getString("time_end"));
				deli.setTransport_fee(rs.getInt("transport_fee"));
				deli.setProduct_fee(rs.getInt("product_fee"));
				deli.setDiscount(rs.getInt("discount"));
				deli.setAppid(rs.getString("appid"));
				deli.setOpenid(rs.getString("openid"));
				deli.setIssubscribe(rs.getString("issubscribe"));
				deli.setTime_stamp(rs.getString("time_stamp"));
				deli.setNonce_str(rs.getString("nonce_str"));
				deli.setApp_signature(rs.getString("app_signature"));
				deli.setSign_method(rs.getString("sign_method"));
				deli.setDeliver_timestamp(rs.getString("deliver_timestamp"));
				deli.setDeliver_status(rs.getString("deliver_status"));
				deli.setDeliver_msg(rs.getString("deliver_msg"));
			}

		} catch (SQLException ex1) {
			ex1.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			pool.returnConnection(conn);
		}
		
		
		return deli;
	}
	
	
	public static void main(String[] args) {
		Delivernotify del = new Delivernotify();
		del.setSign_type("MD5");
		del.setInput_charset("UTF-8");
		del.setSign("Signjkajsdkfjakfajfksdjfkasjhfkajshfajsfhakjsfhiwuiw787af");
		del.setTrade_mode(1);
		del.setTrade_state(0);
		del.setPartner("partnerjkjkjkj");
		del.setBank_type("Bank_typeWX");
		del.setBank_billno("Bank_billno787sdfd787sd8f7ds8f7fs");
		del.setTotal_fee(2300);
		del.setFee_type(1);
		del.setNotify_id("notifyididididididi");
		del.setTransaction_id("transactionid_jkjkjkjkjkjkjkjkj");
		del.setOut_trade_no("Out_trade_no787812722");
		del.setAttach("Attachjkjaskdfjkasjfkajdkjaskfjk");
		del.setTime_end("201409198092536");
		del.setTransport_fee(0);
		del.setProduct_fee(0);
		del.setDiscount(0);
		del.setAppid("Appidjkjkjkjkjkjkj");
		del.setOpenid("openididididi");
		del.setIssubscribe("Issubscribe1");
		del.setTime_stamp("Time_stampjkajsdkjaskfjdskf");
		del.setNonce_str("nocestrstr");
		del.setApp_signature("appsignature");
		del.setSign_method("Sign_methodSHA1");
		del.setDeliver_msg("Deliver_msg");
		del.setDeliver_status("1Deliver_status");
		del.setDeliver_timestamp("Deliver_timestamp201409198092536");
		
		JDBCDao dao = new JDBCDao();
		//dao.save(del);
		
	}

}
