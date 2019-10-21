package com.icss.normal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbFactory {
	
	private static final ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

	/**
	 * ��Connection����
	 * @author whn
	 * @return
	 * @dateTime 2018��9��27������7:44:55
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
			System.out.println("�Ҳ���������");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}

	/**
	 * �ر�Connection
	 * @author whn
	 * @dateTime 2018��9��27������7:44:33
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
	 * �����ֶ���������
	 * @author whn
	 * @throws Exception
	 * @dateTime 2018��9��27������7:44:16
	 */
	public static void beginTransaction() throws Exception{
		Connection con = openConnection();   
		con.setAutoCommit(false);
	}
	
	/**
	 * �����ύ
	 * @author whn
	 * @throws Exception
	 * @dateTime 2018��9��27������7:44:06
	 */
	public static void commit() throws Exception{
		Connection con = openConnection(); 
		if(con != null && !con.isClosed()){
			con.commit();
		}
	}
	
	/**
	 * ����ع�
	 * @author whn
	 * @throws Exception
	 * @dateTime 2018��9��27������7:43:53
	 */
	public static void roolback() throws Exception{
		Connection con = openConnection(); 
		if(con != null && !con.isClosed()){
			con.rollback();
		}	
	}
}
