package com.icss.normal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.icss.normal.dao.UserDao;
import com.icss.normal.entity.User;
import com.icss.normal.util.DbFactory;
/**
 * @author whn
 * 用户数据层
 */
public class UserDaoImpl implements UserDao {
	

	/**
	 * 用户登录
	 * @author whn
	 * @param name
	 * @param pwd
	 * @return
	 * @throws Exception
	 * @dateTime 2018年9月27日下午7:35:40
	 */
	@Override
	public User login(String name, String pwd) throws Exception {	
		User user = null;
		
		Connection connection = DbFactory.openConnection();
		String sql = "select uname,usid,upwd from users where uname=? and upwd=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, pwd);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			user = new User();
			user.setUname(rs.getString("uname"));
			user.setUpwd(rs.getString("upwd"));
			user.setUsid(rs.getInt("usid"));
			break;
		}
		rs.close();
		ps.close();
		
		return user;
	}

	/**
	 * 用户注册
	 * @author whn
	 * @param user
	 * @throws Exception
	 * @dataTime 2018年9月27日下午7:35:21
	 */
	@Override
	public void regist(User user) throws Exception {

		String sql = "insert into users(uname,upwd,uaddress) VALUES(?,?,?)";
		Connection connection = DbFactory.openConnection();		
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, user.getUname());
		ps.setString(2, user.getUpwd());
		ps.setString(3, user.getUaddress());
		int row = ps.executeUpdate();
		ps.close();
	
	}

	/**
	 * 通过用户编号删除用户信息
	 * @author whn
	 * @param uid
	 * @throws Exception
	 * @dataTime 2018年9月27日下午7:36:56
	 */
	@Override
	public void deleteUser(int uid) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 修改用户信息
	 * @author whn
	 * @param user
	 * @return
	 * @throws Exception
	 * @dataTime 2018年9月27日下午7:37:45
	 */
	@Override
	public int updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
