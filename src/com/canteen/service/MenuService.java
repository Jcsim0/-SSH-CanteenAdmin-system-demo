package com.canteen.service;

import java.util.List;

import com.canteen.pojo.Menu;

public interface MenuService
{
	public void saveMenuImg(String fileName,Integer menuId);
	public void saveMenu(Menu menu);
	public List<Object[]> queryAllMenu();
}
