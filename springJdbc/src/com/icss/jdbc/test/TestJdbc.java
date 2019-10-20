package com.icss.jdbc.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.icss.jdbc.dao.FoodTypeDao;
import com.icss.jdbc.entity.FoodType;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestJdbc {
	
	@Test
	public void testJdbcTemplate() {
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		FoodTypeDao foodTypeDao = (FoodTypeDao) applicationContext.getBean("foodTypeDao");
		FoodType ft = new FoodType();
		ft.setFtname("11");
		foodTypeDao.save(ft);
	}
}
