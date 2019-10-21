package com.icss.normal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icss.normal.dao.MenuDao;
import com.icss.normal.entity.Menu;
import com.icss.normal.util.DbFactory;

public class MenuDaoImpl implements MenuDao {

	/**
	 * 展示所有菜系信息
	 * @author whn
	 * @return
	 * @throws Exception
	 * @dateTime 2018年9月27日下午7:35:06
	 */
	@Override
	public List<Menu> findAllMenu() throws Exception {
		List<Menu> list = new ArrayList<Menu>();
		
		String sql = "select * from menu";
		Connection connection = DbFactory.openConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Menu menu = new Menu();
			menu.setFtno(rs.getInt("ftid"));
			//menu.setMdate(rs.getString("mdate"));
			menu.setMid(rs.getInt("mid"));
			menu.setMimg(rs.getString("mimg"));
			menu.setMinstroduce(rs.getString("mintro"));
			menu.setMname(rs.getString("mname"));
			menu.setMprice(rs.getDouble("mprice"));
			list.add(menu);
		}
		rs.close();
		ps.close();
		
		return list;
	}

}
