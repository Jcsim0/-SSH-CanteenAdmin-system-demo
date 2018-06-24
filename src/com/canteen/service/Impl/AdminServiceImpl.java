package com.canteen.service.Impl;

import org.springframework.transaction.annotation.Transactional;

import com.canteen.dao.AdminDAO;
import com.canteen.pojo.Admin;
import com.canteen.service.AdminService;

@Transactional
public class AdminServiceImpl implements AdminService
{
	private AdminDAO adminDAO;

	public AdminDAO getAdminDAO()
	{
		return adminDAO;
	}

	public void setAdminDAO(AdminDAO adminDAO)
	{
		this.adminDAO = adminDAO;
	}

	@Override
	public String adminLogin(Admin admin)
	{
		// TODO Auto-generated method stub
		return adminDAO.judgeAdminAccount(admin);
	}
}
