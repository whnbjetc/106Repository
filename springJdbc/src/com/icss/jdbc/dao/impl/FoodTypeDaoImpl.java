package com.icss.jdbc.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.icss.jdbc.dao.FoodTypeDao;
import com.icss.jdbc.entity.FoodType;

public class FoodTypeDaoImpl1 implements FoodTypeDao {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void save(FoodType foodType) {
		String sql = "insert into food_type(ftname) values(?)";
		jdbcTemplate.update(sql,foodType.getFtname());	
	}

}
