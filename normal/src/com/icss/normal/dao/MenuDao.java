package com.icss.normal.dao;

import java.util.List;

import com.icss.normal.entity.Menu;

public interface MenuDao{
	
	public List<Menu> findAllMenu() throws Exception; //展示所有菜品信息
	
}
