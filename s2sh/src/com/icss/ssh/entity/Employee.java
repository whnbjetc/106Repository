package com.icss.ssh.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Employee {
	
	private int id;//员工编号
	private String name;//员工姓名
	private Date birthday;//员工生日
	private Department department;//部门对象（员工和部门关系：多对一）
	
	

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
