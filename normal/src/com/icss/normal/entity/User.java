package com.icss.normal.entity;

/**
 * @Description
 * @author WANG
 * @createTime 2018��8��30������10:11:30 �û��ķ�װ��
 */
public class User {

	private String uname;// �û���
	private String upwd;// �û�����
	private int usex;// �û��Ա�1-�У�2-Ů
	private int uage;// �û�����
	private String uaddress;// ��ַ
	private String uphone;// �û��ֻ���
	private String uemail;// �û�����
	private int usid;// �û����

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
