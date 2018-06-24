package com.canteen.service.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.canteen.dao.CategoryDAO;
import com.canteen.pojo.Category;
import com.canteen.service.CategoryService;

@Transactional
public class CategoryServiceImpl implements CategoryService
{
	private CategoryDAO categoryDAO;

	public CategoryDAO getCategoryDAO()
	{
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO)
	{
		this.categoryDAO = categoryDAO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> queryAllCategory()
	{
		// TODO Auto-generated method stub
		return categoryDAO.findAll();
	}

	@Override
	public void updateCategoryById(String name, Integer id)
	{
		categoryDAO.updateCategpory(name, id);
	}

	@Override
	public void insertCategory(Category category)
	{
		// TODO Auto-generated method stub
		categoryDAO.save(category);
	}

	@Override
	public void delCategory(Category category)
	{
		// TODO Auto-generated method stub
		categoryDAO.delete(category);
	}

	@Override
	public Category getCategoryById(Integer id)
	{
		// TODO Auto-generated method stub
		return categoryDAO.findById(id);
	}
}
