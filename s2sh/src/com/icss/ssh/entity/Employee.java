package com.icss.ssh.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Employee {
	
	private int id;//Ա�����
	private String name;//Ա������
	private Date birthday;//Ա������
	private Department department;//���Ŷ���Ա���Ͳ��Ź�ϵ�����һ��
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", birthday="
				+ birthday + ", department=" + department + "]";
	}


	
}
