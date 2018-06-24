package com.canteen.service;

import java.util.List;

import com.canteen.pojo.Category;

public interface CategoryService
{
	public List<Category> queryAllCategory();
	public void updateCategoryById(String name,Integer id);
	public void insertCategory(Category category );
	public void delCategory(Category category);
	public Category getCategoryById(Integer id);
}
