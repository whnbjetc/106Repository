package com.icss.normal.entity;

/**
 * @Description
 * @author WANG
 * @createTime 2018年8月30日上午10:11:30 用户的封装类
 */
public class User {

	private String uname;// 用户名
	private String upwd;// 用户密码
	private int usex;// 用户性别：1-男，2-女
	private int uage;// 用户年龄
	private String uaddress;// 地址
	private String uphone;// 用户手机号
	private String uemail;// 用户邮箱
	private int usid;// 用户编号

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public int getUsex() {
		return usex;
	}

	public void setUsex(int usex) {
		this.usex = usex;
	}

	public int getUage() {
		return uage;
	}

	public void setUage(int uage) {
		this.uage = uage;
	}

	public String getUaddress() {
		return uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}

	public String getUphone() {
		return uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public int getUsid() {
		return usid;
	}

	public void setUsid(int usid) {
		this.usid = usid;
	}

	@Override
	public String toString() {
		return "Users [uname=" + uname + ", upwd=" + upwd + ", usex=" + usex
				+ ", uage=" + uage + ", uaddress=" + uaddress + ", uphone="
				+ uphone + ", uemail=" + uemail + ", usid=" + usid + "]";
	}

}
