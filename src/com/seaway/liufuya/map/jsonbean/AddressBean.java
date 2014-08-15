package com.seaway.liufuya.map.jsonbean;

import java.util.List;

/**
 * 封装以门店为中心，查询客户地址返回的结果
 * 
 * 
 * { "status":0, "message":"ok", "results":[ { "name":"快乐家苑", "location":{
 * "lat":31.276384, "lng":121.457852 }, "address":"延长中路519弄1～8号",
 * "street_id":"925c550f521f3db35a3ac8fe", "uid":"925c550f521f3db35a3ac8fe" } ]
 * }
 * 
 * @author lililiu
 * 
 */
public class AddressBean {
	private String status;
	private String message;
	private List<MemberAddressBean> results;

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

	public List<MemberAddressBean> getResults() {
		return results;
	}

	public void setResults(List<MemberAddressBean> results) {
		this.results = results;
	}

}