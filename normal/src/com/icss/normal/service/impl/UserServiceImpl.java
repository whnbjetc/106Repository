package com.icss.normal.service.impl;

import com.icss.normal.dao.UserDao;
import com.icss.normal.dao.impl.UserDaoImpl;
import com.icss.normal.entity.User;
import com.icss.normal.exception.NullException;
import com.icss.normal.service.UserService;
import com.icss.normal.util.DbFactory;
import com.icss.normal.util.Log;

public class UserServiceImpl implements UserService {

	/**
	 * 用户登录
	 * @author whn
	 * @param name
	 * @param pwd
	 * @return
	 * @throws Exception
	 * @dateTime 2018年9月27日下午7:36:29
	 */
	public User login(String name, String pwd) throws Exception {
		User user = null;
		
		if(name!=null && !"".equals(name) && pwd!=null && !"".equals(pwd)){
			UserDao userDao = new UserDaoImpl();
			try {
				user = userDao.login(name, pwd);
			} catch (Exception e) {
				Log.error(e.getMessage());
				throw e;
			} finally{
				DbFactory.closeConnection();
			}
		}else{
			throw new NullException("请输入用户名或者密码……");
		}
			
		return user;
	}

	/**
	 * 用户注册
	 * @author whn
	 * @param user
	 * @throws Exception
	 * @dateTime 2018年9月27日下午7:36:17
	 */
	@Override
	public void regist(User user) throws Exception {
	
		try {
			DbFactory.beginTransaction();
			UserDao userDao = new UserDaoImpl();
			userDao.regist(user);
			DbFactory.commit();
		} catch (Exception e) {
			DbFactory.roolback();
			Log.error(e.getMessage());
			throw e;
		} finally{
			DbFactory.closeConnection();
		}
	}


}
