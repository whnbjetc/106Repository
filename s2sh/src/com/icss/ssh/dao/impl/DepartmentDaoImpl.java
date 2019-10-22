package com.icss.ssh.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.icss.ssh.dao.DepartmentDao;
import com.icss.ssh.entity.Department;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {


	@Override
	public void addDepartment(Department department) {
		this.getHibernateTemplate().save(department);
	}

}
