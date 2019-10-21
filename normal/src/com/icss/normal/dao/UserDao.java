package com.icss.normal.dao;

import com.icss.normal.entity.User;

public interface UserDao{

	public User login(String name,String pwd) throws Exception;//用户登录
	
	public void regist(User user) throws Exception;//用户注册
	
	public void deleteUser(int uid) throws Exception;//通过用户编号删除
	
	public int updateUser(User user) throws Exception;//修改用户信息
	
}
