package com.seaway.liufuya.common.uuid;

import java.util.Date;

public class RandomCode {

	/**
	 * 生成 时间+3位随机数字的 
	 * @return
	 */
	public static String generateNumberString(){
		return new Date().getTime()+""+RandomUtils.generateSimpleNum(3);
	}

	
	/**
	 * 生成 时间+3位随机数字的 
	 * @param str     前缀 字符串
	 * @param length  后面数字的长度
	 * @return
	 */
	public static String generateNumberString(String str,int length){
		return str+(new Date().getTime())+""+RandomUtils.generateSimpleNum(length);
	}
	
}
