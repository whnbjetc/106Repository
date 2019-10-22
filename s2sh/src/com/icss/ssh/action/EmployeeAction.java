package com.icss.ssh.action;

import java.util.List;
import java.util.Map;

import com.icss.ssh.biz.EmployeeBiz;
import com.icss.ssh.entity.Employee;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Ա�������
 * @author whn
 *
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {
	
	//ע��ҵ������
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
     * ��ѯ����Ա����Ϣ
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
	 * ͨ��id��ѯ����Ա��
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
	 * �޸�Ա����Ϣ
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
