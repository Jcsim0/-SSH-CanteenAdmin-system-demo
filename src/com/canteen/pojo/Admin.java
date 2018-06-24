package com.canteen.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "admin", catalog = "canteen")
public class Admin implements java.io.Serializable
{

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer adminId;
	private String account;
	private String password;
	private String adminName;
	private String job;
	private String sex;
	private String phone;
	private Set<Category> categories = new HashSet<Category>(0);
	private Set<Menu> menus = new HashSet<Menu>(0);
	private Set<Orders> orderses = new HashSet<Orders>(0);

	// Constructors

	/** default constructor */
	public Admin()
	{
	}

	/** minimal constructor */
	public Admin(String account, String password, String adminName, String job,
			String sex, String phone)
	{
		this.account = account;
		this.password = password;
		this.adminName = adminName;
		this.job = job;
		this.sex = sex;
		this.phone = phone;
	}

	/** full constructor */
	public Admin(String account, String password, String adminName, String job,
			String sex, String phone, Set<Category> categories,
			Set<Menu> menus, Set<Orders> orderses)
	{
		this.account = account;
		this.password = password;
		this.adminName = adminName;
		this.job = job;
		this.sex = sex;
		this.phone = phone;
		this.categories = categories;
		this.menus = menus;
		this.orderses = orderses;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "admin_id", unique = true, nullable = false)
	public Integer getAdminId()
	{
		return this.adminId;
	}

	public void setAdminId(Integer adminId)
	{
		this.adminId = adminId;
	}

	@Column(name = "account", nullable = false, length = 10)
	public String getAccount()
	{
		return this.account;
	}

	public void setAccount(String account)
	{
		this.account = account;
	}

	@Column(name = "password", nullable = false, length = 10)
	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Column(name = "admin_name", nullable = false, length = 10)
	public String getAdminName()
	{
		return this.adminName;
	}

	public void setAdminName(String adminName)
	{
		this.adminName = adminName;
	}

	@Column(name = "job", nullable = false, length = 10)
	public String getJob()
	{
		return this.job;
	}

	public void setJob(String job)
	{
		this.job = job;
	}

	@Column(name = "sex", nullable = false, length = 5)
	public String getSex()
	{
		return this.sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	@Column(name = "phone", nullable = false, length = 20)
	public String getPhone()
	{
		return this.phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "admin")
	public Set<Category> getCategories()
	{
		return this.categories;
	}

	public void setCategories(Set<Category> categories)
	{
		this.categories = categories;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "admin")
	public Set<Menu> getMenus()
	{
		return this.menus;
	}

	public void setMenus(Set<Menu> menus)
	{
		this.menus = menus;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "admin")
	public Set<Orders> getOrderses()
	{
		return this.orderses;
	}

	public void setOrderses(Set<Orders> orderses)
	{
		this.orderses = orderses;
	}

}