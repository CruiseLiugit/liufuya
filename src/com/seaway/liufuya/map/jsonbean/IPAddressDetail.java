package com.seaway.liufuya.map.jsonbean;

/**
 * 百度 IP 地址定位
 * 
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
public class IPAddressDetail {
	private String district;
    private String street_number;
    private String province;
    private String city;
    private String city_code;
    private String street;
    
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getStreet_number() {
		return street_number;
	}
	public void setStreet_number(String street_number) {
		this.street_number = street_number;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCity_code() {
		return city_code;
	}
	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
    
    
    
}