package com.icss.normal.service;

import com.icss.normal.entity.User;

public interface UserService {
	
	public User login(String name,String pwd) throws Exception;//�û���¼
	
	public void regist(User user) throws Exception;//�û�ע��

}
