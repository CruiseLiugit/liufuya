package com.seaway.liufuya.map.jsonbean;


/**
 * result 对
 * 
 * { status: 0, result: { location: { lng: 116.30814954222, lat: 40.056885091681
 * }, precise: 1, confidence: 80, level: "商务大厦" } }
 * 
 * @author lililiu
 * 
 */
public class Result {

	private int precise; // 位置的附加信息，是否精确查找。1为精确查找，0为不精确
	private int confidence; // 可信度
	private String level; // 地址类型

	private Location location;

	public int getPrecise() {
		return precise;
	}

	public void setPrecise(int precise) {
		this.precise = precise;
	}

	public int getConfidence() {
		return confidence;
	}

	public void setConfidence(int confidence) {
		this.confidence = confidence;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
