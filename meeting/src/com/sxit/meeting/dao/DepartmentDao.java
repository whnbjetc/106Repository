package com.sxit.meeting.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sxit.meeting.entity.Department;

public class DepartmentDao extends BaseDao{
	public List<Department> findAll() throws Exception{
		List<Department> list = new ArrayList<Department>();
		this.openConnection();
		String sql = "select * from department";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Department department = new Department();
			department.setDepartmentid(rs.getInt("departmentid"));
			department.setDepartmentname(rs.getString("departmentname"));
			list.add(department);
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	public void addDepartment(String departmentname) throws Exception{
		this.openConnection();
		String sql = "insert into department(departmentname) values(?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, departmentname);
		pstmt.execute();
		pstmt.close();
	}
	public void editDepartment(String departmentname,int departmentid) throws Exception{
		this.openConnection();
		String sql = "update department set departmentname=? where departmentid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, departmentname);
		pstmt.setInt(2, departmentid);
		pstmt.execute();
		pstmt.close();
	}
	
	public void deleteDepartment(int departmentid) throws Exception{
		this.openConnection();
		String sql = "delete from department where departmentid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, departmentid);
		pstmt.execute();
		pstmt.close();
	}
	
	public void deleteEmployeeByDid(int departmentid) throws Exception{
		this.openConnection();
		String sql = "update employee set status=4 where departmentid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, departmentid);
		pstmt.execute();
		pstmt.close();
	}
}
