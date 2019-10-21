package com.icss.normal.service;

import com.icss.normal.entity.User;

public interface UserService {
	
	public User login(String name,String pwd) throws Exception;//用户登录
	
	public void regist(User user) throws Exception;//用户注册

}
