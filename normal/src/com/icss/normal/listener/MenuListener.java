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
	 * ϵͳ����ʱ�������еĲ�Ʒ��Ϣ��װ�ص�redis���ݿ���
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
				String menuString = jsonArray.toString();  //ÿ����Ʒ����һ��json��		
				map.put(String.valueOf(menu.getMid()), menuString);
			}			
			jedis.hmset("allMenuList",map);  //�����в�Ʒ������hash map��	
			
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
