package com.seaway.liufuya.map.jsonbean;

/**
 * 百度  IP 地址定位
 *
 * 两种结果
 * (1)ip 错误
 * {"status":2,"message":"Request Parameter Error:ip illegal"}
 * 
 * (2)正确获取
 * 无法获取城市的 ，动态 ip 地址
 * {
  "address" : "CN|浙江|None|None|OTHER|None|None",
  "content" : {
    "address" : "浙江省",
    "point" : {
      "x" : "119.95720242",
      "y" : "29.15949412"
    },
    "address_detail" : {
      "district" : "",
      "street_number" : "",
      "province" : "浙江省",
      "city" : "",
      "city_code" : 29,
      "street" : ""
    }
  },
  "status" : 0
}

能够获取城市的 ip 地址
{
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
 * 
 * @author lililiu
 *
 */
public class IPAddress {
	private String address;      //地址缩写 CN|吉林|长春|None|CERNET|1|None
	private IPAddContent content; //地址坐标信息
	private String status;   //状态 0 正常；2 IP错误
	private String message;  //错误的提升信息
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public IPAddContent getContent() {
		return content;
	}
	public void setContent(IPAddContent content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}