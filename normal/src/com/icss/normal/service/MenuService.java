package com.icss.normal.service;

import java.util.List;

import com.icss.normal.entity.Menu;

public interface MenuService {
	
	public List<Menu> findAllMenu() throws Exception; //展示所有菜品信息

	List<Menu> findAllMenuRedis() throws Exception;
	
}
