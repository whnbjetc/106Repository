package com.icss.ssh.dao;

import java.util.List;

import com.icss.ssh.entity.Employee;

public interface EmployeeDao {
	
	public List<Employee> findAll();//查询所有员工信息
	
	public Employee findById(int id);//通过主键返回对象
	
	public void updateEmployee(Employee employee);//修改员工信息
}
