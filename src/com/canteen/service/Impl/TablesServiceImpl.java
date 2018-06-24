package com.canteen.service.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.canteen.dao.TablesDAO;
import com.canteen.pojo.Tables;
import com.canteen.service.TablesService;

@Transactional
public class TablesServiceImpl implements TablesService
{
	private TablesDAO tablesDAO;

	public TablesDAO getTablesDAO()
	{
		return tablesDAO;
	}

	public void setTablesDAO(TablesDAO tablesDAO)
	{
		this.tablesDAO = tablesDAO;
	}

	@Override
	public List<Tables> getAvailableTables()
	{
		// TODO Auto-generated method stub
		return tablesDAO.findAvailableTable();
	}
	
}
