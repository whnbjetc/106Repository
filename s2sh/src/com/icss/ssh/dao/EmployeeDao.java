package com.icss.ssh.dao;

import java.util.List;

import com.icss.ssh.entity.Employee;

public interface EmployeeDao {
	
	public List<Employee> findAll();//��ѯ����Ա����Ϣ
	
	public Employee findById(int id);//ͨ���������ض���
	
	public void updateEmployee(Employee employee);//�޸�Ա����Ϣ
}
