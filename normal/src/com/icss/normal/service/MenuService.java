package com.icss.normal.service;

import java.util.List;

import com.icss.normal.entity.Menu;

public interface MenuService {
	
	public List<Menu> findAllMenu() throws Exception; //չʾ���в�Ʒ��Ϣ

	List<Menu> findAllMenuRedis() throws Exception;
	
}
