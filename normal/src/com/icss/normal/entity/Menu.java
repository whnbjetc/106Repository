package com.icss.normal.entity;

import java.sql.Timestamp;

/**
 * @author whn
 * 菜品封装类
 */
public class Menu {

	private int mid;// 菜品编号
	private String mname;// 菜品名称
	private double mprice;// 菜品价格
	private String minstroduce;// 菜品介绍
	private int ftno;// 菜系编号
	//private Timestamp mdate;// 菜品上架时间
	private String mimg;// 菜品图片
	
	public Menu(){}
	public Menu(int mid, String mname, double mprice, String minstroduce,
			int ftno, String mimg) {
		this.mid = mid;
		this.mname = mname;
		this.mprice = mprice;
		this.minstroduce = minstroduce;
		this.ftno = ftno;
//		this.mdate = mdate;
		this.mimg = mimg;
	}
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public double getMprice() {
		return mprice;
	}
	public void setMprice(double mprice) {
		this.mprice = mprice;
	}
	public String getMinstroduce() {
		return minstroduce;
	}
	public void setMinstroduce(String minstroduce) {
		this.minstroduce = minstroduce;
	}
	public int getFtno() {
		return ftno;
	}
	public void setFtno(int ftno) {
		this.ftno = ftno;
	}

//	public String getMdate() {
//		return mdate;
//	}
//	public void setMdate(String mdate) {
//		this.mdate = mdate;
//	}
	public String getMimg() {
		return mimg;
	}
	public void setMimg(String mimg) {
		this.mimg = mimg;
	}

	@Override
	public String toString() {
		return "Menu [mid=" + mid + ", mname=" + mname + ", mprice=" + mprice
				+ ", minstroduce=" + minstroduce + ", ftno=" + ftno
				+ ",mimg=" + mimg
				+ ", ftname=" + "]";
	}
	
	
}
