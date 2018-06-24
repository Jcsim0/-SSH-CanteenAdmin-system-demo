package com.canteen.action;

import com.canteen.pojo.Tables;
import com.canteen.service.TablesService;
import com.opensymphony.xwork2.ActionSupport;

public class TablesAction extends ActionSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Tables tables;
	private TablesService tablesService;
	
	public Tables getTables()
	{
		return tables;
	}
	public void setTables(Tables tables)
	{
		this.tables = tables;
	}
	public TablesService getTablesService()
	{
		return tablesService;
	}
	public void setTablesService(TablesService tablesService)
	{
		this.tablesService = tablesService;
	}
	

}
