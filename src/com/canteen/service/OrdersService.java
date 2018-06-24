package com.canteen.service;

import java.util.List;

import com.canteen.pojo.Orders;

public interface OrdersService
{
	public List<Orders> findAllOrders();
	public void updateState(String state, Integer id);
	public List<Object[]> getOrderMsg(Integer id);
	public List<Orders> findPaidOrdersByState(String state);
	public List<Orders> findUnpaidOrdersByState();
	public List<Orders> findHaveToOrdersByState();
	public List<Orders> findOrdersByState(String State);
}
