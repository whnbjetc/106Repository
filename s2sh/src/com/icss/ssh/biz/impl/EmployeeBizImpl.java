package com.icss.ssh.biz.impl;

import java.util.List;

import com.icss.ssh.biz.EmployeeBiz;
import com.icss.ssh.dao.EmployeeDao;
import com.icss.ssh.entity.Employee;

/**
 * Ա��ҵ���
 * @author whn
 *
 */
public class EmployeeBizImpl implements EmployeeBiz {

	//ע���������
	EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}


	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}


	@Override
	public Employee findById(int id) {
		return employeeDao.findById(id);
	}


	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}

}
