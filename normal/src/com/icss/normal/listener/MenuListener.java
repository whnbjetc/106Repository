package com.icss.normal.listener;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import redis.clients.jedis.Jedis;

import com.icss.normal.entity.Menu;
import com.icss.normal.service.MenuService;
import com.icss.normal.service.impl.MenuServiceImpl;
import com.icss.normal.util.Log;
import com.icss.normal.util.RedisUtil;

public class MenuListener implements ServletContextListener {

	/**
	 * 系统启动时，把所有的菜品信息都装载到redis数据库中
	 * @author whn
	 * @param sce
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		MenuService menuService = new MenuServiceImpl();
		try {
			List<Menu> list = menuService.findAllMenu();
			Jedis jedis = RedisUtil.getJedis();	
			Map<String, String> map = new HashMap<String, String>();
			for(Menu menu : list){	
			    JSONObject jsonArray=JSONObject.fromObject(menu);			
				String menuString = jsonArray.toString();  //每个菜品生成一个json串		
				map.put(String.valueOf(menu.getMid()), menuString);
			}			
			jedis.hmset("allMenuList",map);  //把所有菜品，存于hash map中	
			
			RedisUtil.returnResource(jedis);
		} catch (Exception e) {
			Log.error(e.getMessage());
			e.printStackTrace();
		}	
	
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
