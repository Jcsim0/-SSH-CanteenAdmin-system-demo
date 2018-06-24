package com.canteen.action;

import java.util.Map;

import com.canteen.pojo.Admin;
import com.canteen.service.AdminService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Admin admin;
	private AdminService adminService;
	
	private String result;
	
	public Admin getAdmin()
	{
		return admin;
	}
	public void setAdmin(Admin admin)
	{
		this.admin = admin;
	}
	public AdminService getAdminService()
	{
		return adminService;
	}
	public void setAdminService(AdminService adminService)
	{
		this.adminService = adminService;
	}
	
	public String getResult()
	{
		return result;
	}
	public void setResult(String result)
	{
		this.result = result;
	}
	@SuppressWarnings("unchecked")
	public String userLogin(){
		String name = adminService.adminLogin(admin);//返回的是用户的名字
		
		System.out.println(admin);
		System.out.println(admin.getAccount());
		System.out.println(admin.getPassword());
		
		if(name=="passwordError"||name=="accountError"||name=="unknowError"){
			this.setResult(name);			
		}
		else{
			((Map<String, Object>) ActionContext.getContext().get("session")).put("adminName",name);
			this.setResult("success");
		}	
		return "login";
	}


	 /**
	  * 用户退出
	  */
	 public String loginOut(){
		 ActionContext.getContext().getSession().remove("adminName");
		 ActionContext.getContext().getSession().remove("admin");
		 return "loginOut";
	 }
	 
	 /**
	  * 切换用户
	  */
	 public String changeAdmin(){
		 ActionContext.getContext().getSession().remove("adminName");
		 ActionContext.getContext().getSession().remove("admin");
		 return "changeAdmin";
	 }

}
