package com.icss.ssh.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.icss.ssh.dao.EmployeeDao;
import com.icss.ssh.entity.Employee;

/**
 * 员工数据层
 * @author whn
 *
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

	@Override
	public List<Employee> findAll() {
		List<Employee> list = this.getHibernateTemplate().find("from Employee");
		return list;
	}

	@Override
	public Employee findById(int id) {
		
        List<Employee> list = this.getHibernateTemplate().find("from Employee where id=?",id);
        
        Employee employee = null;
        
        if(list!=null && list.size()>0){
        	employee = list.get(0);
        }
		return employee;
	}

	@Override
	public void updateEmployee(Employee employee) {
		this.getHibernateTemplate().update(employee);
	}

}
