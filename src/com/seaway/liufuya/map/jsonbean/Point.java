package com.seaway.liufuya.map.jsonbean;

/**
 * 百度 IP 地址定位
 * {
  "address" : "CN|吉林|长春|None|CERNET|1|None",
  "content" : {
    "address" : "吉林省长春市",
    "point" : {
      "x" : "125.31364243",
      "y" : "43.89833761"
    },
    "address_detail" : {
      "district" : "",
      "street_number" : "",
      "province" : "吉林省",
      "city" : "长春市",
      "city_code" : 53,
      "street" : ""
    }
  },
  "status" : 0
} 
 * @author lililiu
 *
 */
public class Point {
	private String x;
	private String y;
	
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	
	
	

}