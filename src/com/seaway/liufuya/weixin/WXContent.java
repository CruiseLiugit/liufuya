package com.seaway.liufuya.weixin;

/**
 * 微信发货接口常数
 * @author lililiu
 *
 */
public class WXContent {

	//微信开发者模式下面的 信息
	public static final String APP_ID = "wxe1049d8d4769daa4";
	//密码，可能会被重置
	public static final String APP_SECRET = "e9e1bdec04327c75967fead398c8b6a8";
	
	
	//1 获取 access_token
	public static final String ACC_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+APP_ID+"&secret="+APP_SECRET;
	
	//2 发货接口  delivernotify
	public static final String DELIVER_NOTIFY = "https://api.weixin.qq.com/pay/delivernotify?access_token=";
	//发货接口中，会用到 post 发送 JSON 参数
	
	
}
