package com.canteen.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "category", catalog = "canteen")
public class Category implements java.io.Serializable
{

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer categoryId;
	private Admin admin;
	private String categoryName;
	private Set<Menu> menus = new HashSet<Menu>(0);

	// Constructors

	/** default constructor */
	public Category()
	{
	}

	/** minimal constructor */
	public Category(String categoryName)
	{
		this.categoryName = categoryName;
	}

	/** full constructor */
	public Category(Admin admin, String categoryName, Set<Menu> menus)
	{
		this.admin = admin;
		this.categoryName = categoryName;
		this.menus = menus;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "category_id", unique = true, nullable = false)
	public Integer getCategoryId()
	{
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId)
	{
		this.categoryId = categoryId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "admin_id")
	public Admin getAdmin()
	{
		return this.admin;
	}

	public void setAdmin(Admin admin)
	{
		this.admin = admin;
	}

	@Column(name = "category_name", nullable = false, length = 20)
	public String getCategoryName()
	{
		return this.categoryName;
	}

	public void setCategoryName(String categoryName)
	{
		this.categoryName = categoryName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Menu> getMenus()
	{
		return this.menus;
	}

	public void setMenus(Set<Menu> menus)
	{
		this.menus = menus;
	}

}