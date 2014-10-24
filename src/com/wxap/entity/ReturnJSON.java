package com.wxap.entity;

import java.io.Serializable;

/**
 * 微信发货返回数据验证
 * 
 * @author lililiu
 * 
 */
public class ReturnJSON  implements Serializable {

	private static final long serialVersionUID = 1L;

	private String errcode;
	private String errmsg;

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

}
