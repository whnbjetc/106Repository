package com.icss.ssh.biz.impl;

import java.util.List;

import com.icss.ssh.biz.EmployeeBiz;
import com.icss.ssh.dao.EmployeeDao;
import com.icss.ssh.entity.Employee;

/**
 * 员工业务层
 * @author whn
 *
 */
public class EmployeeBizImpl implements EmployeeBiz {

	//注入对象属性
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
