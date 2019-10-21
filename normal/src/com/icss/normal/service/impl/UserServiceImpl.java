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
	 * �û���¼
	 * @author whn
	 * @param name
	 * @param pwd
	 * @return
	 * @throws Exception
	 * @dateTime 2018��9��27������7:36:29
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
			throw new NullException("�������û����������롭��");
		}
			
		return user;
	}

	/**
	 * �û�ע��
	 * @author whn
	 * @param user
	 * @throws Exception
	 * @dateTime 2018��9��27������7:36:17
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
