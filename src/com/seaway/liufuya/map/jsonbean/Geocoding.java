package com.seaway.liufuya.map.jsonbean;

/**
 * 百度地图返回的经纬度坐标对象
 * 
 * { status: 0, result: { location: { lng: 116.30814954222, lat: 40.056885091681
 * }, precise: 1, confidence: 80, level: "商务大厦" } }
 * 
 * @author lililiu
 * 
 */
public class Geocoding {

	/**
	 * 0	正常
	   1	服务器内部错误
	   2	请求参数非法
	   3	权限校验失败
	   4	配额校验失败
	   5	ak不存在或者非法
	  101	服务禁用
	  102	不通过白名单或者安全码不对
	  2xx	无权限
	  3xx	配额错误
	 */
	private int status; //返回结果状态值， 成功返回0，其他值请查看附录。
	private Result result;
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	
	
	
	
	
}