package com.icss.ssh.biz.impl;

import com.icss.ssh.biz.DepartmentBiz;
import com.icss.ssh.dao.DepartmentDao;
import com.icss.ssh.entity.Department;

public class DepartmentBizImpl implements DepartmentBiz {

	private DepartmentDao departmentDao;
	
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public void addDepartment(Department department) {
		departmentDao.addDepartment(department);
	}

}
