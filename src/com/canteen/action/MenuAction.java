package com.canteen.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.canteen.pojo.Category;
import com.canteen.pojo.Menu;
import com.canteen.service.CategoryService;
import com.canteen.service.MenuService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MenuAction extends ActionSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Menu menu ;
	private MenuService menuService;
	
	private CategoryService categoryService;
	
	private String savePath;
	private File menuImgFile;
	private String menuImgFileFileName;
	private String menuImgFileContentType;
	
	private String result;
	
	public Menu getMenu()
	{
		return menu;
	}
	public void setMenu(Menu menu)
	{
		this.menu = menu;
	}
	public MenuService getMenuService()
	{
		return menuService;
	}
	public void setMenuService(MenuService menuService)
	{
		this.menuService = menuService;
	}
	public CategoryService getCategoryService()
	{
		return categoryService;
	}
	public void setCategoryService(CategoryService categoryService)
	{
		this.categoryService = categoryService;
	}
	public String getSavePath()
	{
		return savePath;
	}
	public void setSavePath(String savePath)
	{
		this.savePath = savePath;
	}
	public File getMenuImgFile()
	{
		return menuImgFile;
	}
	public void setMenuImgFile(File menuImgFile)
	{
		this.menuImgFile = menuImgFile;
	}
	public String getMenuImgFileFileName()
	{
		return menuImgFileFileName;
	}
	public void setMenuImgFileFileName(String menuImgFileFileName)
	{
		this.menuImgFileFileName = menuImgFileFileName;
	}
	public String getMenuImgFileContentType()
	{
		return menuImgFileContentType;
	}
	public void setMenuImgFileContentType(String menuImgFileContentType)
	{
		this.menuImgFileContentType = menuImgFileContentType;
	}
		
	public String getResult()
	{
		return result;
	}
	public void setResult(String result)
	{
		this.result = result;
	}
	
	public String uploadMenuImg() throws IOException{
//		HttpServletRequest request1 = ServletActionContext.getRequest();
		//System.out.println("准备上传");
		String path = ServletActionContext.getServletContext().getRealPath(savePath);
		String saveFileName = path + "\\" + menuImgFileFileName;
		File destFile = new File(saveFileName);
		FileUtils.copyFile(menuImgFile, destFile);
		//System.out.println("上传成功啦");
		//System.out.println(path);
		//System.out.println(saveFileName);
		this.setResult("uploadSuccess");
		return "uploadMenuImg";		
	}
	
	@SuppressWarnings("unchecked")
	public String queryAllMenuList(){
		List<Object[]> list = menuService.queryAllMenu();
		((Map<String, Object>) ActionContext.getContext().get("session")).put("all_menuList",list);
		List<Category> categories = categoryService.queryAllCategory();
		((Map<String, Object>) ActionContext.getContext().get("request")).put("all_categoryList",categories);
		return "queryAllMenuList";
	}
	
	@SuppressWarnings("unchecked")
	public String  queryAllCategory(){
		List<Category> categories = categoryService.queryAllCategory();
		((Map<String, Object>) ActionContext.getContext().get("request")).put("all_categoryList",categories);
		return "queryAllCategory";
	}

}
