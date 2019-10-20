package com.sxit.meeting.service;

import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import com.sxit.meeting.dao.EmployeeDao;
import com.sxit.meeting.entity.Employee;
import com.sxit.meeting.util.Constant;
import com.sxit.meeting.util.PageResult;

public class EmployeeService {
	
	public Employee login(String username,String password) throws Exception{
		EmployeeDao employeeDao = new EmployeeDao();
		Employee employee = null;
		try {
			employee = employeeDao.findByNameAndPwd(username, password);
		} catch (Exception e) {
			throw e;
		} finally {
			employeeDao.closeConnection();
		}
		return employee;
	}
	
	public void changePwd(String newPwd,Integer employeeid) throws Exception{
		EmployeeDao employeeDao = new EmployeeDao();
		try {
			employeeDao.updatePwd(newPwd,employeeid);
		} catch (Exception e) {
			throw e;
		} finally {
			employeeDao.closeConnection();
		}
	}
	
	public void regist(String employeename,String username,String password,String phone,String email,Integer departmentid) throws Exception{
		EmployeeDao employeeDao = new EmployeeDao();
		try {
			employeeDao.saveEmployee(employeename, username, password, phone, email, departmentid);
		} catch (Exception e) {
			throw e;
		} finally{
			employeeDao.closeConnection();
		}
	}
	
	public Employee findByName(String username) throws Exception{
		Employee employee = null;
		EmployeeDao employeeDao = new EmployeeDao();
		try {
			employee = employeeDao.findByName(username);
		} catch (Exception e) {
			throw e;
		} finally{
			employeeDao.closeConnection();
		}
		return employee;
	}
	
	public List<Employee> findByStatus(String status) throws Exception{
		List<Employee> list = null;
		EmployeeDao employeeDao = new EmployeeDao();
		try {
			list = employeeDao.findByStatus(status);
		} catch (Exception e) {
			throw e;
		} finally{
			employeeDao.closeConnection();
		}
		return list;
	}
	
	public List<Employee> findByDepid(int departmentid) throws Exception{
		List<Employee> list = null;
		EmployeeDao employeeDao = new EmployeeDao();
		try {
			list = employeeDao.findByDepid(departmentid);
		} catch (Exception e) {
			throw e;
		} finally{
			employeeDao.closeConnection();
		}
		return list;
	}
	
	public void approveEmployee(String status,Integer employeeid) throws Exception{
		EmployeeDao employeeDao = new EmployeeDao();
		try {
			employeeDao.updateEmployee(status, employeeid);
		} catch (Exception e) {
			throw e;
		} finally{
			employeeDao.closeConnection();
		}
	}
	
	public void pageList(PageResult<Employee> page,int firstResult,int maxResult,String username,String employeename,String status) throws Exception{
		EmployeeDao employeeDao = new EmployeeDao();
		try {
			int totalCount = employeeDao.findCount(username,employeename,status);
			List<Employee> list = employeeDao.pageList(username,employeename,status,firstResult,maxResult);
			page.setList(list);
			page.setTotalCount(totalCount);
			int totalPage = (totalCount%Constant.pageSize==0)?(totalCount/Constant.pageSize):(totalCount/Constant.pageSize+1);
			page.setPageCount(totalPage);
		} catch (Exception e) {
			throw e;
		} finally{
			employeeDao.closeConnection();
		}
	}
}
