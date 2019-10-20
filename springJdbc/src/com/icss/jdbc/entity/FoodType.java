package com.icss.jdbc.entity;
/**
 * 菜系的实体类
 * @author Administrator
 *
 */
public class FoodType {
	
	private int ftno;//编号
	private String ftname;//名称
	
	public int getFtno() {
		return ftno;
	}
	public void setFtno(int ftno) {
		this.ftno = ftno;
	}
	public String getFtname() {
		return ftname;
	}
	public void setFtname(String ftname) {
		this.ftname = ftname;
	}
	
}
