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
 * Menu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "menu", catalog = "canteen")
public class Menu implements java.io.Serializable
{

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer menuId;
	private Admin admin;
	private Category category;
	private String menuName;
	private Integer price;
	private String summary;
	private String img;
	private Set<Orderitem> orderitems = new HashSet<Orderitem>(0);

	// Constructors

	/** default constructor */
	public Menu()
	{
	}

	/** minimal constructor */
	public Menu(Admin admin, Category category, String menuName, Integer price)
	{
		this.admin = admin;
		this.category = category;
		this.menuName = menuName;
		this.price = price;
	}

	/** full constructor */
	public Menu(Admin admin, Category category, String menuName, Integer price,
			String summary, String img, Set<Orderitem> orderitems)
	{
		this.admin = admin;
		this.category = category;
		this.menuName = menuName;
		this.price = price;
		this.summary = summary;
		this.img = img;
		this.orderitems = orderitems;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "menu_id", unique = true, nullable = false)
	public Integer getMenuId()
	{
		return this.menuId;
	}

	public void setMenuId(Integer menuId)
	{
		this.menuId = menuId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "admin_id", nullable = false)
	public Admin getAdmin()
	{
		return this.admin;
	}

	public void setAdmin(Admin admin)
	{
		this.admin = admin;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	public Category getCategory()
	{
		return this.category;
	}

	public void setCategory(Category category)
	{
		this.category = category;
	}

	@Column(name = "menu_name", nullable = false, length = 20)
	public String getMenuName()
	{
		return this.menuName;
	}

	public void setMenuName(String menuName)
	{
		this.menuName = menuName;
	}

	@Column(name = "price", nullable = false)
	public Integer getPrice()
	{
		return this.price;
	}

	public void setPrice(Integer price)
	{
		this.price = price;
	}

	@Column(name = "summary", length = 100)
	public String getSummary()
	{
		return this.summary;
	}

	public void setSummary(String summary)
	{
		this.summary = summary;
	}

	@Column(name = "img", length = 100)
	public String getImg()
	{
		return this.img;
	}

	public void setImg(String img)
	{
		this.img = img;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "menu")
	public Set<Orderitem> getOrderitems()
	{
		return this.orderitems;
	}

	public void setOrderitems(Set<Orderitem> orderitems)
	{
		this.orderitems = orderitems;
	}

}