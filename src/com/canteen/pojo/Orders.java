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
 * Orders entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "orders", catalog = "canteen")
public class Orders implements java.io.Serializable
{

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer ordersId;
	private Tables tables;
	private Admin admin;
	private String ordersTime;
	private Integer discount;
	private Integer totalPrice;
	private String ordersState;
	private Set<Orderitem> orderitems = new HashSet<Orderitem>(0);

	// Constructors

	/** default constructor */
	public Orders()
	{
	}

	/** minimal constructor */
	public Orders(Tables tables, Admin admin, String ordersTime)
	{
		this.tables = tables;
		this.admin = admin;
		this.ordersTime = ordersTime;
	}

	/** full constructor */
	public Orders(Tables tables, Admin admin, String ordersTime,
			Integer discount, Integer totalPrice, String ordersState,
			Set<Orderitem> orderitems)
	{
		this.tables = tables;
		this.admin = admin;
		this.ordersTime = ordersTime;
		this.discount = discount;
		this.totalPrice = totalPrice;
		this.ordersState = ordersState;
		this.orderitems = orderitems;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "orders_id", unique = true, nullable = false)
	public Integer getOrdersId()
	{
		return this.ordersId;
	}

	public void setOrdersId(Integer ordersId)
	{
		this.ordersId = ordersId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tables_id", nullable = false)
	public Tables getTables()
	{
		return this.tables;
	}

	public void setTables(Tables tables)
	{
		this.tables = tables;
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

	@Column(name = "orders_time", nullable = false, length = 50)
	public String getOrdersTime()
	{
		return this.ordersTime;
	}

	public void setOrdersTime(String ordersTime)
	{
		this.ordersTime = ordersTime;
	}

	@Column(name = "discount")
	public Integer getDiscount()
	{
		return this.discount;
	}

	public void setDiscount(Integer discount)
	{
		this.discount = discount;
	}

	@Column(name = "totalPrice")
	public Integer getTotalPrice()
	{
		return this.totalPrice;
	}

	public void setTotalPrice(Integer totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	@Column(name = "orders_state", length = 50)
	public String getOrdersState()
	{
		return this.ordersState;
	}

	public void setOrdersState(String ordersState)
	{
		this.ordersState = ordersState;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orders")
	public Set<Orderitem> getOrderitems()
	{
		return this.orderitems;
	}

	public void setOrderitems(Set<Orderitem> orderitems)
	{
		this.orderitems = orderitems;
	}

}