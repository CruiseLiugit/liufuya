package com.seaway.liufuya.map;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.lang.Lang;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.map.jsonbean.Geocoding;


/**
 * 访问百度 API 的类
 */
@IocBean
public class BaiduMapBiz {

	private static final Log log = Logs.get();

	/**
	 * 生成网络服务对象 注入 实例对象， 填写注入类的 名称，类名首字母小写
	 */
	@Inject("refer:httpService")
	HttpService httpService = new HttpService();

	// ------------------------------------------------------------------------------
	//百度地图Place API服务地址
	//http://developer.baidu.com/map/webservice-placeapi.htm
	//Place API 提供区域检索POI服务、POI详情服务与团购信息检索服务、商家团购详情查询。
	//1. 区域检索POI服务提供三种区域检索方法：
    //城市内检索（对应JavaScriptAPI的Search方法）
    //圆形区域检索（对应JavaScript的SearchNearBy方法）
	/**
	 * 
	 * @param query     搜索地名关键词
	 * @param lag  中心点坐标，经度，格式  location=39.915,116.404
	 * @param lat  中心点坐标，纬度，格式  location=39.915,116.404
	 * @return
	 * @throws Exception
	 */
	public String getMapJsonRadiusByPost(String query, String lng,String lat)
			throws Exception {
		String jsonStr = "";
		
		String url = Constants.RADIUSSEARCH_URL+"?&query="+query+"&location="+lng+","+lat+"&radius="+Constants.RADIUS+"&output=json&ak="+Constants.AK;
		log.info("查询的 URL 为 :"+url);
		
		try {
			jsonStr=httpService.doGet(url);
		} catch (Exception e) {
			throw new Exception("网络连接失败！获取结果 JSON 字符串失败");
		}

		return jsonStr;
	}
	

	// ------------------------------------------------------------------------------
	//IP定位 API是一个根据IP返回对应位置信息的http形式位置服务接口
	//1、根据 IP 地址，查询所在城市
	public String getMapJsonByIPAddress(String ipaddress)
			throws Exception {
		String jsonStr = "";

		////http://api.map.baidu.com/location/ip?ak=密钥&ip=202.198.16.3&coor=bd09ll
		// 解析地址,使用 get 方法提交请求
		String url = Constants.IPURL+ "?ak="+Constants.AK+"&ip=" + ipaddress + "&coor="+Constants.COOR;
		log.info("ip  url ="+url);
		try {
			jsonStr = httpService.doGet(url);
			log.debug("ip  json =" + jsonStr);
		} catch (Exception e) {
			throw new Exception("网络连接失败！");
		}
		
		return jsonStr;
	}

	// ------------------------------------------------------------------------------
	//Route Matrix API是一套以HTTP形式提供的批量线路查询接口，用于返回多个起点和多个终点间的线路距离和行驶时间。
	/**
	 * 一个起点，到多个终点的间距和时间
	 * 
	 * @param startAddress   起点地址名称 或者 经纬度坐标，以|分割，最多传5个点
	 * @param endAddresses   终点地址名称 或者 经纬度坐标，以|分割，最多传5个点 
	 *                       名称：百度大厦     
	 *                       经纬度：40.056878, 116.30815
     *                       坐标格式为：lat<纬度>,lng<经度> 
	 * @param mode           导航模式，包括：driving（驾车）、walking（步行）
	 * @return
	 * @throws Exception
	 */
	public String getMapJsonRouteMatrix(String startAddress, List<String> endAddresses,String mode)
			throws Exception {
		String jsonStr = "";
		
		StringBuffer sb = new StringBuffer("");
		if (endAddresses != null) {
			for (int a = 0;a<endAddresses.size();a++) {
				String end = endAddresses.get(a);
				if (a != endAddresses.size()-1) {
					sb.append(end+"|");
				}else{
					sb.append(end);
				}
				
			}
		}else
		{
			return jsonStr;
		}
		
		//+"&mode="+mode
		String url = Constants.RouteMatrixUrl+"&origins="+startAddress+"&destinations="+sb.toString()+"&ak="+Constants.AK;
		log.info("查询的 URL 为 :"+url);
		
		try {
			log.info("httpService ="+httpService);
			jsonStr=httpService.doGet(url);
			log.info("json  ="+jsonStr);
		} catch (Exception e) {
			throw new Exception("网络连接失败！获取结果 JSON 字符串失败");
		}

		return jsonStr;
	}
	
	
	// ------------------------------------------------------------------------------

	// ------------------------------------------------------------------------------
	//Geocoding API包括地址解析和逆地址解析功能。
    //地理编码：即地址解析，由详细到街道的结构化地址得到百度经纬度信息，且支持名胜古迹、标志性建筑名称直接解析返回百度经纬度。例如：“北京市海淀区中关村南大街27号”地址解析的结果是“lng:116.31985,lat:39.959836”，“百度大厦”地址解析的结果是“lng:116.30815,lat:40.056885”
    //逆地理编码，即逆地址解析，由百度经纬度信息得到结构化地址信息。例如：“lat:31.325152,lng:120.558957”逆地址解析的结果是“江苏省苏州市虎丘区塔园路318号”
	//http://developer.baidu.com/map/webservice-geocoding.htm
	
	/**
	 * 根据街道名称和城市名称，查询出结果 json 字符串
	 * @param address
	 * @param cityName
	 * @return
	 * @throws Exception
	 */
	public String getMapJsonByPost(String address, String cityName)
			throws Exception {
		String jsonStr = "";

		// http://api.map.baidu.com/geocoder/v2/?ak=您的密钥&callback=renderOption&output=json&address=百度大厦&city=北京市
		// 解析地址,使用 post 方法提交请求
		String url = Constants.GEBASEURL;
		// 参数值通过 Map 传输
		// 设置 IP 白名单为 0.0.0.0/0 所有 IP 都可以访问。
		// 可以不用传递 sn callback 参数
		Map<String, String> kvmap = new HashMap<String, String>();
		kvmap.put("ak", Constants.AK);
		kvmap.put("output", Constants.OUTPUT);
		kvmap.put("address", address);
		kvmap.put("city", cityName);

		try {
			jsonStr = httpService.doPost(url, kvmap);
		} catch (Exception e) {
			throw new Exception("网络连接失败！获取结果 JSON 字符串失败");
		}

		return jsonStr;
	}

	/**
	 * 根据街道名称和城市名称，查询出结果 包含经纬度坐标的地理位置对象
	 * @param address
	 * @param cityName
	 * @return
	 * @throws Exception
	 */
	public Geocoding getMapByPost(String address, String cityName)
			throws Exception {
		Geocoding gejson = null;
		try {
			String jsonStr = this.getMapJsonByPost(address, cityName);
			// log.debug("json ="+jsonStr);

			// 解析json数据
			gejson = Json.fromJson(Geocoding.class, Lang.inr(jsonStr));

		} catch (Exception e) {
			throw new Exception("网络连接失败！获取结果对象失败");
		}

		return gejson;
	}

	/**
	 * 使用 Get 方法，通过 URL 组合传递参数的方式
	 * @return
	 * @throws Exception
	 */
	public Geocoding getMapByGet(String address, String cityName)
			throws Exception {
		Geocoding gejson = null;

		// http://api.map.baidu.com/geocoder/v2/?ak=您的密钥&callback=renderOption&output=json&address=百度大厦&city=北京市
		// 解析地址,使用 get 方法提交请求
		String url = Constants.GEURL + "address=" + address + "&city="
				+ cityName;
		log.info("baidu  url ="+url);
		
		// 这里不需要转码，也可以访问后台的
		// String covUrl = URLEncoder.encode(url, "UTF-8");
		// log.debug("url ="+covUrl);

		try {
			String jsonStr = httpService.doGet(url);
			log.debug("baidu json =" + jsonStr);

			// 解析json数据
			gejson = Json.fromJson(Geocoding.class, Lang.inr(jsonStr));

		} catch (Exception e) {
			throw new Exception("网络连接失败！");
		}

		return gejson;
	}

}