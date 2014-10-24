package com.seaway.liufuya.wx;

import java.util.Map;

import org.nutz.json.Json;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GetAccessToken {
	private static final Log log = Logs.get();
	
	private static String APP_ID = "wxe1049d8d4769daa4"; // appid
	private static String DEV_APP_SECRET = "e9e1bdec04327c75967fead398c8b6a8"; // 开发者模式下的密码，注意可以被重置
	private static HttpService httpService = new HttpService();
	public static AccessToken accessToken = null; // 直接获取的 Access_Token 对象
	
	public static AccessToken getToken() throws Exception {
		//如果有，不用重新获取
		if (accessToken != null) {
			if (accessToken.getToken()!=null && !("").equals(accessToken.getToken())) {
				return accessToken;
			}
			
		}
		
		// 准备发货接口需要的内容
		String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

		String requestUrl = access_token_url.replace("APPID", APP_ID).replace(
				"APPSECRET", DEV_APP_SECRET);
		Gson gson = new Gson();
		String jsonStr = "";
		System.out.println("获取 access_token 查询的 URL 为 :" + requestUrl);
		
		try {
			jsonStr = httpService.doGet(requestUrl);
			System.out.println("获取 access_token 查询的结果 : "+jsonStr);
		} catch (Exception e) {
			throw new Exception("网络连接失败！获取结果 JSON 字符串失败");
		}

		// 如果请求成功
		if (!"".equals(jsonStr.trim())) {
			try {
				System.out.println("--------请求成功");
				Map<String, String> map2 = gson.fromJson(jsonStr, new TypeToken<Map<String, String>>() {}.getType());
				accessToken = new AccessToken();
				if (map2.get("access_token")!= null) {
					accessToken.setToken(map2.get("access_token"));
					accessToken.setExpiresIn(map2.get("expires_in"));
				}else if(map2.get("errcode") != null){
					accessToken.setErrcode("errcode");
					accessToken.setErrmsg("errmsg");
				}
				System.out.println("--------转化后的 AccountToken 对象 :"+accessToken);
				//错误的 Json 返回示例:
				//{"errcode":40013,"errmsg":"invalid appid"}
			} catch (Exception e) {
				accessToken = null;
			}
		}
		
		return accessToken;
	}

}
