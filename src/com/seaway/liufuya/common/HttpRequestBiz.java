package com.seaway.liufuya.common;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.lang.Lang;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.mvc.crm.memberinfo.module.Ovip;

/**
 * 访问 POS API 接口的类
 */
public class HttpRequestBiz {

	private static final Log log = Logs.get();

	HttpService httpService = null;

	public HttpRequestBiz() {
		// TODO Auto-generated constructor stub
	}

	// ------------------------------------------------------------------------------
	/**
	 * 获取POS数据库会员总条数
	 * @return
	 * @throws Exception
	 */
	public String getPOSVipMemberCountJsonByGet()
			throws Exception {
		String jsonStr = "";

		String url = Constants.POSOUT_BASEURL + Constants.VIP_COUNT_URL;
		log.info("查询的 URL 为 :" + url);
		try {
			httpService = new HttpService();
			jsonStr = httpService.doGet(url);
		} catch (Exception e) {
			throw new Exception("网络连接失败！获取结果 JSON 字符串失败");
		}

		return jsonStr;
		
	}
	
	
	/**
	 * 获取 POS 系统会员信息方法
	 * @param query
	 *            搜索地名关键词
	 * @param lag
	 *            中心点坐标，经度，格式 location=39.915,116.404
	 * @param lat
	 *            中心点坐标，纬度，格式 location=39.915,116.404
	 * @return
	 * @throws Exception
	 */
	public List<Ovip> getPOSVipMemberJsonByGet()
			throws Exception {
		List<Ovip> list = new ArrayList<Ovip>();
		String jsonStr = "";

		String url = Constants.POSOUT_BASEURL + Constants.VIP_LIST_URL;
		log.info("查询的 URL 为 :" + url);

		try {
			httpService = new HttpService();
			jsonStr = httpService.doGet(url);
			list = (List<Ovip>) Json.fromJson(jsonStr);
			log.info("从POS 系统获取的数据个数为 :"+list.size());
		} catch (Exception e) {
			throw new Exception("网络连接失败！获取结果 JSON 字符串失败");
		}

		return list;
	}

}
