package com.seaway.liufuya.common.util;

import java.util.List;

import com.seaway.liufuya.common.Constants;

public class Page {

	// 当前页
	private int nowpage;
	// 总记录数
	private int countrecord;
	// 总页数
	private int countpage;
	// 当前页记录开始的位置
	private int pageindex;
	// 每页显示的记录数
	public static final int PAGESIZE = Constants.PAGE_SIZE;
	// 索引的sum值 代表的是 google页面中最大显示页数
//	private int sumindex = 6;
//	// 开始的索引值
//	private int startindex;
//	// 结束的索引值
//	private int endindex;
	// 当前页信息
	private List allentities;

	// 构造器
	public Page() {
	}

	/**
	 * 构造器
	 * 
	 * @param rows
	 *            总记录数
	 * @param startNum
	 *            每页开始的位置，推导出当前是第几页
	 */
	public Page(int rows, int startNum) {
		// 当前页面开始位置
		this.pageindex = startNum;
		// 计算当前页
		this.nowpage = pageindex / PAGESIZE + 1;
		// 计算出当前页开始的位置
		// this.pageindex = (nowpage - 1) * PAGESIZE;

		if (rows < 0) {
			countrecord = 0;
		} else {
			countrecord = rows;
		}

		// 计算总页数
		if (this.countrecord % this.PAGESIZE == 0) {
			this.countpage = this.countrecord / this.PAGESIZE;
		} else {
			this.countpage = this.countrecord / this.PAGESIZE + 1;
		}

		// 计算开始和结束的索引值
		// 当当前页小于等于四时开始的索引值等于一,而结束的索引值分两种情况
		// if (this.nowpage <= 4) {
		// this.startindex = 1;
		// if (this.endindex > this.countpage) {
		// this.endindex = this.countpage;
		// }
		// this.endindex = this.nowpage + 2;
		// }
		// 当当前页大于四时开始的索引值和结束的索引值均分三种情况
		// else if (this.nowpage > 4) {
		// if (this.endindex > this.countpage
		// && this.countpage < this.sumindex) {
		// this.startindex = 1;
		// this.endindex = this.countpage;
		// } else if (this.countpage > this.sumindex) {
		// this.startindex = this.countpage - 5;
		// this.endindex = this.countpage;
		// } else {
		// this.startindex = this.nowpage - 3;
		// this.endindex = this.nowpage + 2;
		// }
		// }
	}

	public int getNowpage() {
		return nowpage;
	}

	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}

	public int getCountrecord() {
		return countrecord;
	}

	public void setCountrecord(int countrecord) {
		this.countrecord = countrecord;
	}

	public int getCountpage() {
		return countpage;
	}

	public void setCountpage(int countpage) {
		this.countpage = countpage;
	}

	public int getPageindex() {
		return pageindex;
	}

	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}

	
	public List getAllentities() {
		return allentities;
	}

	public void setAllentities(List allentities) {
		this.allentities = allentities;
	}

}
