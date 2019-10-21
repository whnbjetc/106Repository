package com.icss.normal.entity;

import java.sql.Timestamp;

/**
 * @author whn
 * ��Ʒ��װ��
 */
public class Menu {

	private int mid;// ��Ʒ���
	private String mname;// ��Ʒ����
	private double mprice;// ��Ʒ�۸�
	private String minstroduce;// ��Ʒ����
	private int ftno;// ��ϵ���
	//private Timestamp mdate;// ��Ʒ�ϼ�ʱ��
	private String mimg;// ��ƷͼƬ
	
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
