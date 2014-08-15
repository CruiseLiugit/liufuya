package com.seaway.liufuya.map;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao; //配置好的 基础 Dao
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.lang.Lang;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Attr;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.annotation.Ok;

import com.seaway.liufuya.map.jsonbean.Geocoding;

/**
 * 作为接受页面请求的控制器
 * @author lililiu
 *
 */
@IocBean
public class MapModule {

	private static final Log log = Logs.get();
	
	//ioc 注入
	// 填写注入类的 名称，类名首字母小写  
	@Inject("refer:baiduMapBiz")
	private BaiduMapBiz baidu;
	
	//@Inject
	//private Dao dao;
	
	@At("/map")
	@Ok("jsp:map.geocoding1")
	public void index(){
	}
	
	/**
	 * Demo 1 案例一，输入地址，直接搜索一个经纬度
	 * 	      默认返回 json 字符串
	 * @param shopaddr
	 * @param customeraddr
	 * @param request
	 * @return
	 */
	@At("/map_search")
	public String search(@Param("address")String shopaddr,@Param("city")String customeraddr,HttpServletRequest request){
		//Strings 专门处理 web 项目字符串的方法
		if (Strings.isBlank(shopaddr) || Strings.isBlank(customeraddr)) {
			return "地址为空，请重新输入";
		}
		
		shopaddr = shopaddr.trim().intern();
		customeraddr = customeraddr.trim().intern();
		log.debug("详细地址："+shopaddr);
		log.debug("城市："+customeraddr);
		
		Geocoding ge = null;
		String gejson = "";   //要返回的 json 字符串
		
		try {
			ge = baidu.getMapByPost(shopaddr, customeraddr);            //post 方法请求
			//Geocoding ge = baidu.getMapByGet(shopaddr, customeraddr); //get 方法请求
			
			//处理结果
			//只返回 location 信息
			gejson = Json.toJson(ge.getResult().getLocation()); 
			//gejson = baidu.getMapJsonByPost(shopaddr, customeraddr);
			//log.debug(gejson);
			
			request.setAttribute("ge", ge);
			//log.debug("查询的地址对象 :"+ge);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gejson;
	}
	
	/**
	 * Demo2  根据中心点，搜索指定半径的 圆形，看是否在范围内
	 *        搜索关键词只能是被百度收录过的
	 * 
	 * @param shopaddr
	 * @param customeraddr
	 * @param request
	 * @return
	 */
	@At("/map_searchRoundArea")
	@Ok("json")
	public String searchRoundArea(@Param("shopaddr")String shopaddr,@Param("customeraddr")String customeraddr,HttpServletRequest request){
		//Strings 专门处理 web 项目字符串的方法
		if (Strings.isBlank(shopaddr) || Strings.isBlank(customeraddr)) {
			return "地址为空，请重新输入";
		}
		
		shopaddr = shopaddr.trim().intern();
		customeraddr = customeraddr.trim().intern();
		
		String gejson = "";   //要返回的 json 字符串
		
		try {
			//1 查询出中心点坐标 上海东方明珠
			Geocoding ge = baidu.getMapByGet("上海", "东方明珠");
			
			log.info("中心点，东方明珠坐标  经度:"+ge.getResult().getLocation().getLng()+"  ,纬度:"+ge.getResult().getLocation().getLat());
			
			//2 根据地址关键字，查询是否在中心点 3 公里范围内
			gejson = baidu.getMapJsonRadiusByPost(shopaddr, ""+ge.getResult().getLocation().getLat(),""+ge.getResult().getLocation().getLng());
			log.info("json 结果 ="+gejson);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gejson;
	}
	
	
	
	/**
	 * 求两个地点间距
	 * @param shopaddr
	 * @param customeraddr
	 * @param request
	 * @return
	 */
	@At("/map_searchDistance")
	@Ok("json")
	public String searchDistance(@Param("startaddr")String startaddr,@Param("endaddr1")String endaddr1,@Param("endaddr2")String endaddr2,@Param("endaddr3")String endaddr3,@Param("endaddr4")String endaddr4,@Param("endaddr5")String endaddr5){
		
		startaddr = startaddr.trim().intern();
		endaddr1 = endaddr1.trim().intern();
		endaddr2 = endaddr2.trim().intern();
		endaddr3 = endaddr3.trim().intern();
		endaddr4 = endaddr4.trim().intern();
		endaddr5 = endaddr5.trim().intern();
		
		List<String> endList = new ArrayList<String>();
		if (!"".equals(endaddr1)) {
			endList.add(endaddr1);
		}
		if (!"".equals(endaddr2)) {
			endList.add(endaddr2);
		}
		if (!"".equals(endaddr3)) {
			endList.add(endaddr3);
		}
		if (!"".equals(endaddr4)) {
			endList.add(endaddr4);
		}
		if (!"".equals(endaddr5)) {
			endList.add(endaddr5);
		}
		
		String gejson = "";   //要返回的 json 字符串
		
		try {
			//导航模式，包括：driving（驾车）、walking（步行）
			String mode = "walking";
			gejson = baidu.getMapJsonRouteMatrix(startaddr, endList, mode);
			//log.info("查询得到的 结果 :"+gejson);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gejson;
	}
	
	/////////////Demo3 根据IP定位城市//////////////////
	@At("/map_searchByIP")
	@Ok("json")
	public String searchByIP(@Param("ip")String ipaddress){
		//log.info("request ="+request);
		//log.info("add  ="+request.getRemoteAddr());
		//log.info("uri  ="+request.getRequestURI());
		//log.info("LocalAddr ="+request.getLocalAddr());
		//log.info("ServletPath ="+request.getServletPath());
		
		//Strings 专门处理 web 项目字符串的方法
		//String ip = IPAddressUtil.getRemoteAddress(request);
		//log.info("客户端 IP 地址 :"+ip);
		//String ip="202.198.16.3";
		
		String jsonResult = "";   //要返回的 json 字符串
		
		try {
			jsonResult = baidu.getMapJsonByIPAddress(ipaddress);            //get 方法请求
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonResult;
	}
	
	
	
	
}