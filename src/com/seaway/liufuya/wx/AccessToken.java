package com.seaway.liufuya.wx;

/**
 * access_token 对应于公众号是全局唯一的票据,每天有获取次数限制,所有 API 公用, 正常情况下 access_token 有效期为 7200
 * 秒,重复获取将导致上次获取的 access_token 失效。 2 小时内有效 1天 2000 次
 * 
 * @author lililiu
 * 
 */
public class AccessToken {
	private String token; // 获取到的凭证(最大长度为 512 字节)
	private String expiresIn;// 凭证有效时间,单位:秒。正常情况下 access_token 有效期为 7200 秒
	private String errcode;
	private String errmsg;

	// {"errcode":40013,"errmsg":"invalid appid"}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}

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
