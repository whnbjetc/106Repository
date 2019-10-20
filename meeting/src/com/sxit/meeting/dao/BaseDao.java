package com.sxit.meeting.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * ���ݿ�����
 * @author sunys
 *
 */
public class BaseDao {
	
	protected Connection conn;
	
	public void openConnection() throws Exception{
		try {
			if(this.conn == null){
				Class.forName("com.mysql.jdbc.Driver"); 
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/meeting?useUnicode=true&characterEncoding=utf-8", "root", "root");
			}			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}		
	}
	
	public void closeConnection() {
		if(this.conn != null ){
			try {
				this.conn.close();	
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}		
	}
	
	/**
	 * ������
	 */
	public void beginTransaction() throws Exception{
		this.openConnection();
		this.conn.setAutoCommit(false);         //�����ֶ��ύ�����ģʽ		
	}
	
	/**
	 * �ύ����
	 * @throws Exception
	 */
	public void commit() throws Exception{		
		if(this.conn != null){			
			this.conn.commit();
		}		
	}
	
	/**
	 * �ع�����
	 * @throws Exception
	 */
	public void rollback () throws Exception{
		if(this.conn != null){
			this.conn.rollback();
		}
	}

}
 