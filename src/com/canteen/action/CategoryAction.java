package com.canteen.action;

import java.awt.Window;
import java.util.List;
import java.util.Map;







import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.canteen.pojo.Admin;
import com.canteen.pojo.Category;
import com.canteen.service.CategoryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Category category;
	private CategoryService categoryService;
	
	private String result;
	
	public Category getCategory()
	{
		return category;
	}
	public void setCategory(Category category)
	{
		this.category = category;
	}
	public CategoryService getCategoryService()
	{
		return categoryService;
	}
	public void setCategoryService(CategoryService categoryService)
	{
		this.categoryService = categoryService;
	}
	
	public String getResult()
	{
		return result;
	}
	public void setResult(String rusult)
	{
		this.result = rusult;
	}
	
	@SuppressWarnings("unchecked")
	public String queryAllCategoryList(){
		List<Category> list = categoryService.queryAllCategory();
		((Map<String, Object>) ActionContext.getContext().get("session")).put("all_categoryList", list);
		return "queryAllCategoryList";
	}
	
	public String updateCategoryById(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String name = request.getParameter("name");
		//System.out.println(name);	
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		//System.out.println(id);
		
		categoryService.updateCategoryById(name, id);
		this.setResult("updateSuccess");
		return "updateCategoryById";
	}
	
	@SuppressWarnings("unchecked")
	public String insertCategory(){
		//System.out.println("lalalalall");
		
		Admin admin = (Admin) ((Map<String, Object>) ActionContext.getContext().get("session")).get("admin");
		//System.out.println("admin="+admin);
		
		category.setAdmin(admin);
		
		//System.out.println("添加开始");
		categoryService.insertCategory(category);
		//System.out.println("添加成功");
		
		this.setResult("insertSuccess");
		
		return "insertCategory";
	}
	
	public String delCategory(){
		System.out.println("准备删除");
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer id = Integer.valueOf(request.getParameter("id"));
		System.out.println(id);
		category = categoryService.getCategoryById(id);
		categoryService.delCategory(category);
		System.out.println("准备chenggong");
		this.setResult("delCategorySuccess");
		System.out.println("shezhi Result");
		return "delCategory";
	}

}
