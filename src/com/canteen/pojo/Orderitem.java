package com.canteen.pojo;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Orderitem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "orderitem", catalog = "canteen")
public class Orderitem implements java.io.Serializable
{

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrderitemId id;
	private Orders orders;
	private Menu menu;
	private Integer num;

	// Constructors

	/** default constructor */
	public Orderitem()
	{
	}

	/** minimal constructor */
	public Orderitem(OrderitemId id, Orders orders, Menu menu)
	{
		this.id = id;
		this.orders = orders;
		this.menu = menu;
	}

	/** full constructor */
	public Orderitem(OrderitemId id, Orders orders, Menu menu, Integer num)
	{
		this.id = id;
		this.orders = orders;
		this.menu = menu;
		this.num = num;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "orderItemId", column = @Column(name = "orderItem_id", nullable = false)),
			@AttributeOverride(name = "menuId", column = @Column(name = "menu_id", nullable = false)),
			@AttributeOverride(name = "ordersId", column = @Column(name = "orders_id", nullable = false)) })
	public OrderitemId getId()
	{
		return this.id;
	}

	public void setId(OrderitemId id)
	{
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orders_id", nullable = false, insertable = false, updatable = false)
	public Orders getOrders()
	{
		return this.orders;
	}

	public void setOrders(Orders orders)
	{
		this.orders = orders;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "menu_id", nullable = false, insertable = false, updatable = false)
	public Menu getMenu()
	{
		return this.menu;
	}

	public void setMenu(Menu menu)
	{
		this.menu = menu;
	}

	@Column(name = "num")
	public Integer getNum()
	{
		return this.num;
	}

	public void setNum(Integer num)
	{
		this.num = num;
	}

}