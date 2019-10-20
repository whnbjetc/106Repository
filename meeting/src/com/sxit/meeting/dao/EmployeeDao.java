package com.sxit.meeting.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sxit.meeting.entity.Employee;

public class EmployeeDao extends BaseDao{
	
	public Employee findByNameAndPwd(String username,String password) throws Exception{
		this.openConnection();
		Employee employee = null;
		String sql = "select * from employee where username=? and password=? and status!=4";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			employee = new Employee();
			employee.setDepartmentid(rs.getInt("departmentid"));
			employee.setEmail(rs.getString("email"));
			employee.setEmployeeid(rs.getInt("employeeid"));
			employee.setEmployeename(rs.getString("employeename"));
			employee.setPassword(rs.getString("password"));
			employee.setPhone(rs.getString("phone"));
			employee.setRole(rs.getString("role"));
			employee.setStatus(rs.getString("status"));
			employee.setUsername(rs.getString("username"));
		}
		rs.close();
		pstmt.close();
		return employee;
	}
	
	
	public void updatePwd(String newPwd,Integer employeeid) throws Exception{
		this.openConnection();
		String sql = "update employee set password=? where employeeid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, newPwd);
		pstmt.setInt(2, employeeid);
		pstmt.execute();
		pstmt.close();
	}
	
	public void saveEmployee(String employeename,String username,String password,String phone,String email,Integer departmentid) throws Exception{
		this.openConnection();
		String sql = "insert into employee(employeename,username,password,phone,email,departmentid,status,role) values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, employeename);
		pstmt.setString(2, username);
		pstmt.setString(3, password);
		pstmt.setString(4,phone);
		pstmt.setString(5, email);
		pstmt.setInt(6, departmentid);
		pstmt.setString(7, "0");
		pstmt.setString(8, "2");
		pstmt.execute();
		pstmt.close();
	}
	
	public Employee findByName(String username) throws Exception{
		Employee employee = null;
		this.openConnection();
		String sql = "select * from employee where username=? and status!=4";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, username);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			employee = new Employee();
			employee.setDepartmentid(rs.getInt("departmentid"));
			employee.setEmail(rs.getString("email"));
			employee.setEmployeeid(rs.getInt("employeeid"));
			employee.setEmployeename(rs.getString("employeename"));
			employee.setPassword(rs.getString("password"));
			employee.setPhone(rs.getString("phone"));
			employee.setRole(rs.getString("role"));
			employee.setStatus(rs.getString("status"));
			employee.setUsername(rs.getString("username"));
		}
		rs.close();
		pstmt.close();
		return employee;
	}
	
	public List<Employee> findByStatus(String status) throws Exception{
		List<Employee> list = new ArrayList<Employee>();
		this.openConnection();
		String sql = "select * from employee where status=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, status);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Employee employee = new Employee();
			employee.setDepartmentid(rs.getInt("departmentid"));
			employee.setEmail(rs.getString("email"));
			employee.setEmployeeid(rs.getInt("employeeid"));
			employee.setEmployeename(rs.getString("employeename"));
			employee.setPassword(rs.getString("password"));
			employee.setPhone(rs.getString("phone"));
			employee.setRole(rs.getString("role"));
			employee.setStatus(rs.getString("status"));
			employee.setUsername(rs.getString("username"));
			list.add(employee);
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	public List<Employee> findByDepid(int departmentid) throws Exception{
		List<Employee> list = new ArrayList<Employee>();
		this.openConnection();
		String sql = "select * from employee where departmentid=? and status!=4";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, departmentid);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Employee employee = new Employee();
			employee.setDepartmentid(rs.getInt("departmentid"));
			employee.setEmail(rs.getString("email"));
			employee.setEmployeeid(rs.getInt("employeeid"));
			employee.setEmployeename(rs.getString("employeename"));
			employee.setPassword(rs.getString("password"));
			employee.setPhone(rs.getString("phone"));
			employee.setRole(rs.getString("role"));
			employee.setStatus(rs.getString("status"));
			employee.setUsername(rs.getString("username"));
			list.add(employee);
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	public void updateEmployee(String status,Integer employeeid) throws Exception{
		this.openConnection();
		String sql = "update employee set status=? where employeeid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, status);
		pstmt.setInt(2, employeeid);
		pstmt.execute();
		pstmt.close();
	}
	
	public int findCount(String username,String employeename,String status) throws Exception{
		int count = 0;
		this.openConnection();
		String sql = "select count(*) from employee where role=2";
		if(username!=null && !"".equals(username)){
			sql += " and username like '%"+username+"%'";
		}
		if(employeename!=null && !"".equals(employeename)){
			sql += " and employeename like '%"+employeename+"%'";
		}
		if(status!=null && !"".equals(status)){
			sql += " and status ="+status;
		}
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			count = rs.getInt(1);
		}
		rs.close();
		pstmt.close();
		return count;
	}
	
	public List<Employee> pageList(String username,String employeename,String status,int firstResult,int maxResult) throws Exception{
		this.openConnection();
		List<Employee> list = new ArrayList<Employee>();
		String sql = "select * from employee where role=2";
		if(username!=null && !"".equals(username)){
			sql += " and username like '%"+username+"%'";
		}
		if(employeename!=null && !"".equals(employeename)){
			sql += " and employeename like '%"+employeename+"%'";
		}
		if(status!=null && !"".equals(status)){
			sql += " and status ="+status;
		}
		sql += " limit "+firstResult+","+maxResult;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Employee employee = new Employee();
			employee.setDepartmentid(rs.getInt("departmentid"));
			employee.setEmail(rs.getString("email"));
			employee.setEmployeeid(rs.getInt("employeeid"));
			employee.setEmployeename(rs.getString("employeename"));
			employee.setPassword(rs.getString("password"));
			employee.setPhone(rs.getString("phone"));
			employee.setRole(rs.getString("role"));
			employee.setStatus(rs.getString("status"));
			employee.setUsername(rs.getString("username"));
			list.add(employee);
		}
		rs.close();
		pstmt.close();
		return list;
	}
}
