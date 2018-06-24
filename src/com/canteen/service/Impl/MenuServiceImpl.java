package com.canteen.service.Impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.canteen.dao.MenuDAO;
import com.canteen.pojo.Menu;
import com.canteen.service.MenuService;

@Transactional
public class MenuServiceImpl implements MenuService
{
	private MenuDAO menuDAO;

	public MenuDAO getMenuDAO()
	{
		return menuDAO;
	}

	public void setMenuDAO(MenuDAO menuDAO)
	{
		this.menuDAO = menuDAO;
	}

	@Override
	public void saveMenuImg(String fileName, Integer menuId)
	{
		// TODO Auto-generated method stub
			menuDAO.setImgPath(fileName, menuId);
	
	}

	@Override
	public void saveMenu(Menu menu)
	{
		// TODO Auto-generated method stub
		menuDAO.save(menu);
	}

	@Override
	public List<Object[]> queryAllMenu()
	{
		// TODO Auto-generated method stub
		return menuDAO.findAllMenuList();
	}

}
