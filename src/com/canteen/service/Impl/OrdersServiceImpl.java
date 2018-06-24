package com.canteen.service.Impl;

import java.util.List;

import javassist.expr.NewArray;

import org.springframework.transaction.annotation.Transactional;

import com.canteen.dao.OrdersDAO;
import com.canteen.pojo.Orders;
import com.canteen.service.OrdersService;

@Transactional
public class OrdersServiceImpl implements OrdersService
{
	private OrdersDAO ordersDAO;

	public OrdersDAO getOrdersDAO()
	{
		return ordersDAO;
	}

	public void setOrdersDAO(OrdersDAO ordersDAO)
	{
		this.ordersDAO = ordersDAO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> findAllOrders()
	{
		// TODO Auto-generated method stub
		return ordersDAO.findAll();
	}

	@Override
	public void updateState(String state, Integer id)
	{
		// TODO Auto-generated method stub
		ordersDAO.updateState(state, id);
	}

	@Override
	public List<Object[]> getOrderMsg(Integer id)
	{
		// TODO Auto-generated method stub
		return ordersDAO.fingOrderMsg(id);
	}

	@Override
	public List<Orders> findPaidOrdersByState(String state)
	{
		// TODO Auto-generated method stub
		return ordersDAO.findByOrdersState(state);
	}

	@Override
	public List<Orders> findUnpaidOrdersByState()
	{
		// TODO Auto-generated method stub
		return ordersDAO.findUnpaidOrders();
	}

	@Override
	public List<Orders> findHaveToOrdersByState()
	{
		// TODO Auto-generated method stub
		return ordersDAO.findHaveToMakeOrders();
	}

	@Override
	public List<Orders> findOrdersByState(String State)
	{
		// TODO Auto-generated method stub
		return ordersDAO.findByOrdersState(State);
	}
	
}
