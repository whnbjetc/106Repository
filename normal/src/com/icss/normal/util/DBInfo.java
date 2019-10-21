package com.icss.normal.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * @author whn
 * 
 */
public class DBInfo {

	private String driverClass;//
	private String url;//
	private String username;
	private String userpwd;
	private static DBInfo dBInfo;

	private DBInfo() {
		try {
			// 读取properties文件
			Properties prop = new Properties();
			
			String path = DBInfo.class.getResource("/").getPath() + "db.properties";
			prop.load(new FileInputStream(new File(path)));

			this.driverClass = prop.getProperty("driverClass");
			this.url = prop.getProperty("url");
			this.username = prop.getProperty("username");
			this.userpwd = prop.getProperty("userpwd");
		} catch (FileNotFoundException e) {
			System.out.println("无法找到db.properties文件");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getDriverClass() {
		return driverClass;
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public static DBInfo getInstance() {
		if (dBInfo == null) {
			dBInfo = new DBInfo();
		}
		return dBInfo;
	}

}
