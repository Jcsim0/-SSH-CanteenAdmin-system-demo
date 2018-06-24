package com.canteen.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OrderitemId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class OrderitemId implements java.io.Serializable
{

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer orderItemId;
	private Integer menuId;
	private Integer ordersId;

	// Constructors

	/** default constructor */
	public OrderitemId()
	{
	}

	/** full constructor */
	public OrderitemId(Integer orderItemId, Integer menuId, Integer ordersId)
	{
		this.orderItemId = orderItemId;
		this.menuId = menuId;
		this.ordersId = ordersId;
	}

	// Property accessors

	@Column(name = "orderItem_id", nullable = false)
	public Integer getOrderItemId()
	{
		return this.orderItemId;
	}

	public void setOrderItemId(Integer orderItemId)
	{
		this.orderItemId = orderItemId;
	}

	@Column(name = "menu_id", nullable = false)
	public Integer getMenuId()
	{
		return this.menuId;
	}

	public void setMenuId(Integer menuId)
	{
		this.menuId = menuId;
	}

	@Column(name = "orders_id", nullable = false)
	public Integer getOrdersId()
	{
		return this.ordersId;
	}

	public void setOrdersId(Integer ordersId)
	{
		this.ordersId = ordersId;
	}

	public boolean equals(Object other)
	{
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderitemId))
			return false;
		OrderitemId castOther = (OrderitemId) other;

		return ((this.getOrderItemId() == castOther.getOrderItemId()) || (this
				.getOrderItemId() != null && castOther.getOrderItemId() != null && this
				.getOrderItemId().equals(castOther.getOrderItemId())))
				&& ((this.getMenuId() == castOther.getMenuId()) || (this
						.getMenuId() != null && castOther.getMenuId() != null && this
						.getMenuId().equals(castOther.getMenuId())))
				&& ((this.getOrdersId() == castOther.getOrdersId()) || (this
						.getOrdersId() != null
						&& castOther.getOrdersId() != null && this
						.getOrdersId().equals(castOther.getOrdersId())));
	}

	public int hashCode()
	{
		int result = 17;

		result = 37
				* result
				+ (getOrderItemId() == null ? 0 : this.getOrderItemId()
						.hashCode());
		result = 37 * result
				+ (getMenuId() == null ? 0 : this.getMenuId().hashCode());
		result = 37 * result
				+ (getOrdersId() == null ? 0 : this.getOrdersId().hashCode());
		return result;
	}

}