package com.canteen.service.Impl;

import org.springframework.transaction.annotation.Transactional;

import com.canteen.dao.OrderitemDAO;
import com.canteen.service.OrderitemService;

@Transactional
public class OrderitemServiceImpl implements OrderitemService
{
	private OrderitemDAO orderitemDAO;

	public OrderitemDAO getOrderitemDAO()
	{
		return orderitemDAO;
	}

	public void setOrderitemDAO(OrderitemDAO orderitemDAO)
	{
		this.orderitemDAO = orderitemDAO;
	}
	

}
