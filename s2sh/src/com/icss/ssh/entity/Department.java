package com.icss.ssh.entity;

import java.util.HashSet;
import java.util.Set;

public class Department {
	
	private int id;//部门编号
	private String departmentName;//部门名称
	
	private Set<Employee> employees = new HashSet<Employee>();//部门和员工关系：一对多
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	
}
