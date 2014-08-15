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
public class Location {

	private float lng; // 经度: 116.30814954222,
	private float lat; // 纬度: 40.056885091681

	public float getLng() {
		return lng;
	}

	public void setLng(float lng) {
		this.lng = lng;
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

}