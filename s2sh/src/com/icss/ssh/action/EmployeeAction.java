package com.icss.ssh.action;

import java.util.List;
import java.util.Map;

import com.icss.ssh.biz.EmployeeBiz;
import com.icss.ssh.entity.Employee;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 员工处理层
 * @author whn
 *
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {
	
	//注入业务层对象
	EmployeeBiz employeeBiz;
	
	public void setEmployeeBiz(EmployeeBiz employeeBiz) {
		this.employeeBiz = employeeBiz;
	}

	private Employee employee = new Employee();
	@Override
	public Employee getModel() {
		return this.employee;
	}
	
	private String type;
	
    public void setType(String type) {
		this.type = type;
	}


	/**
     * 查询所有员工信息
     * @return
     */
	public String findAll(){
		
		List<Employee> list = null;
		
		try {
			
			list = employeeBiz.findAll();
			
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
		Map request = (Map) ActionContext.getContext().get("request");
		
		request.put("eList", list);
		
		return SUCCESS;
	}

	
	/**
	 * 通过id查询单个员工
	 */
	public String findById(){
		
		Employee emp = null;
				
		try {
			emp = employeeBiz.findById(employee.getId());
			
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
		Map request = (Map) ActionContext.getContext().get("request");
		
		request.put("employee", emp);
		
		if("find".equals(type)){
			return "findByIdSuccess";
		}
		return "findByIdEditSuccess";
	}

	/**
	 * 修改员工信息
	 * @return
	 */
	public String update(){
		
		try {
			employeeBiz.updateEmployee(employee);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
		return "updateSuccess";
	}

}
