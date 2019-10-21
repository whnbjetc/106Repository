package com.icss.normal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbFactory {
	
	private static final ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

	/**
	 * 打开Connection连接
	 * @author whn
	 * @return
	 * @dateTime 2018年9月27日下午7:44:55
	 */
	public static Connection openConnection() {
		Connection connection = tl.get();
		try {
			if (connection == null || connection.isClosed()) {
				DBInfo dBInfo = DBInfo.getInstance();
				Class.forName(dBInfo.getDriverClass());
				connection = DriverManager.getConnection(dBInfo.getUrl(),
						dBInfo.getUsername(), dBInfo.getUserpwd());
				tl.set(connection);

			}
		} catch (ClassNotFoundException e) {
			System.out.println("找不到驱动类");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}

	/**
	 * 关闭Connection
	 * @author whn
	 * @dateTime 2018年9月27日下午7:44:33
	 */
	public static void closeConnection(){
		tl.set(null);
		Connection con = openConnection();
		try {
			con.close();
		} catch (SQLException e) {
			Log.error(e.getMessage());
			e.printStackTrace();
		}
	}	
	
	/**
	 * 设置手动控制事务
	 * @author whn
	 * @throws Exception
	 * @dateTime 2018年9月27日下午7:44:16
	 */
	public static void beginTransaction() throws Exception{
		Connection con = openConnection();   
		con.setAutoCommit(false);
	}
	
	/**
	 * 事务提交
	 * @author whn
	 * @throws Exception
	 * @dateTime 2018年9月27日下午7:44:06
	 */
	public static void commit() throws Exception{
		Connection con = openConnection(); 
		if(con != null && !con.isClosed()){
			con.commit();
		}
	}
	
	/**
	 * 事务回滚
	 * @author whn
	 * @throws Exception
	 * @dateTime 2018年9月27日下午7:43:53
	 */
	public static void roolback() throws Exception{
		Connection con = openConnection(); 
		if(con != null && !con.isClosed()){
			con.rollback();
		}	
	}
}
