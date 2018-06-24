package com.canteen.action;

import com.canteen.pojo.Orderitem;
import com.canteen.service.OrderitemService;
import com.opensymphony.xwork2.ActionSupport;

public class OrderitemAction extends ActionSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Orderitem orderitem;
	private OrderitemService orderitemService;
	
	public Orderitem getOrderitem()
	{
		return orderitem;
	}
	public void setOrderitem(Orderitem orderitem)
	{
		this.orderitem = orderitem;
	}
	public OrderitemService getOrderitemService()
	{
		return orderitemService;
	}
	public void setOrderitemService(OrderitemService orderitemService)
	{
		this.orderitemService = orderitemService;
	}
	

}
