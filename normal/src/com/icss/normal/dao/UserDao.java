package com.icss.normal.dao;

import com.icss.normal.entity.User;

public interface UserDao{

	public User login(String name,String pwd) throws Exception;//�û���¼
	
	public void regist(User user) throws Exception;//�û�ע��
	
	public void deleteUser(int uid) throws Exception;//ͨ���û����ɾ��
	
	public int updateUser(User user) throws Exception;//�޸��û���Ϣ
	
}
