package com.icss.normal.util;

import org.apache.log4j.Logger;
/**
 * @author whn
 * ��־��
 */
public class Log {	
	
	public static Logger logger = Logger.getLogger(Log.class.getName());   

	public static void error(String message){
		logger.error(message);
	}
}
