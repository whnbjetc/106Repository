package com.icss.ssh.action;

import com.icss.ssh.biz.DepartmentBiz;
import com.icss.ssh.entity.Department;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {

	private DepartmentBiz departmentBiz;
	
	public void setDepartmentBiz(DepartmentBiz departmentBiz) {
		this.departmentBiz = departmentBiz;
	}


	private Department department = new Department();
	
	@Override
	public Department getModel() {
		return this.department;
	}

	
	public String add(){
		
		try {
			departmentBiz.addDepartment(department);
		} catch (Exception e) {
			//e.printStackTrace();
			return ERROR;
		}
		
		return SUCCESS;
	}

}
