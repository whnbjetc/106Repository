package com.sxit.meeting.service;

import java.util.List;

import com.sxit.meeting.dao.DepartmentDao;
import com.sxit.meeting.entity.Department;

public class DepartmentService {
	
	public List<Department> findAll() throws Exception{
		List<Department> list = null;
		DepartmentDao dao = new DepartmentDao();
		try {
			list = dao.findAll();
		} catch (Exception e) {
			throw e;
		} finally{
			dao.closeConnection();
		}
		return list;
	}
	
	public void addDepartment(String departmentname) throws Exception{
		DepartmentDao dao = new DepartmentDao();
		try {
			dao.addDepartment(departmentname);
		} catch (Exception e) {
			throw e;
		} finally{
			dao.closeConnection();
		}
	}
	public void editDepartment(String departmentname,int departmentid) throws Exception{
		DepartmentDao dao = new DepartmentDao();
		try {
			dao.editDepartment(departmentname,departmentid);
		} catch (Exception e) {
			throw e;
		} finally{
			dao.closeConnection();
		}
	}
	
	public void deleteDepartment(int departmentid) throws Exception{
		DepartmentDao dao = new DepartmentDao();
		dao.beginTransaction();
		try {
			dao.deleteDepartment(departmentid);
			//删除属于该部门的员工（修改员工状态为4）
			dao.deleteEmployeeByDid(departmentid);
			dao.commit();
		} catch (Exception e) {
			dao.rollback();
			throw e;
		} finally{
			dao.closeConnection();
		}
	}
	
}
