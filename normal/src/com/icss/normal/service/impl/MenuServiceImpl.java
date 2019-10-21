package com.icss.normal.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
import redis.clients.jedis.Jedis;

import com.icss.normal.dao.MenuDao;
import com.icss.normal.dao.impl.MenuDaoImpl;
import com.icss.normal.entity.Menu;
import com.icss.normal.service.MenuService;
import com.icss.normal.util.DbFactory;
import com.icss.normal.util.Log;
import com.icss.normal.util.RedisUtil;

public class MenuServiceImpl implements MenuService {

	/**
	 * 展示全部菜品信息
	 * @author whn
	 * @return
	 * @throws Exception
	 * @dateTime 2018年9月27日下午7:35:54
	 */
	@Override
	public List<Menu> findAllMenuRedis() throws Exception {
		List<Menu> list = new ArrayList<Menu>();
		
		try {
			Jedis jedis = RedisUtil.getJedis();	
			Map<String,String> allMenus =  jedis.hgetAll("allMenuList");
			Set<String> keys =  allMenus.keySet();
			for(String mid : keys){
				 String menuString = allMenus.get(mid);
				 String menuNew = menuString.substring(0, menuString.length());
				 JSONObject jsonObject=JSONObject.fromObject(menuNew);
				 Menu menu  = (Menu) JSONObject.toBean(jsonObject,Menu.class); 
				 list.add(menu);
			}			
			RedisUtil.returnResource(jedis);	
		} catch (Exception e) {
			//e.printStackTrace();
			Log.error(e.getMessage());
			throw e;
		}
		return list;
	}

	/**
	 * 展示全部菜品信息
	 * @author whn
	 * @return
	 * @throws Exception
	 * @dateTime 2018年9月27日下午7:35:54
	 */
	@Override
	public List<Menu> findAllMenu() throws Exception {
		List<Menu> list = null;
		
		MenuDao menuDao = new MenuDaoImpl();
		try {
			list = menuDao.findAllMenu();
		} catch (Exception e) {
			//e.printStackTrace();
			Log.error(e.getMessage());
			throw e;
		} finally{
			DbFactory.closeConnection();
		}
		
		return list;
	}
}
