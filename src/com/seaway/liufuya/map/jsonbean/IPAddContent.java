package com.seaway.liufuya.map.jsonbean;

/**
 * 百度 IP 地址定位 
 * { 
 * 	"address" : "CN|吉林|长春|None|CERNET|1|None", 
 * 	"content" : {
 * 		 "address" : "吉林省长春市",
 * 		 "point" : { "x" : "125.31364243", "y" : "43.89833761"}, 
 * 		 "address_detail" : { 
 * 				"district" : "", 
 * 				"street_number" : "", 
 * 				"province" :"吉林省", 
 * 				"city" : "长春市", 
 * 				"city_code" : 53, 
 * 				"street" : "" 
 *         } 
 *     }, 
 *  "status" : 0 
 * }
 * 
 * @author lililiu
 * 
 */
public class IPAddContent {
	private String address;
	private Point point;
	private IPAddressDetail address_detail;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public IPAddressDetail getAddress_detail() {
		return address_detail;
	}

	public void setAddress_detail(IPAddressDetail address_detail) {
		this.address_detail = address_detail;
	}

}
