package com.canteen.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.management.loading.PrivateClassLoader;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.canteen.pojo.Menu;
import com.canteen.pojo.Orderitem;
import com.canteen.pojo.Orders;
import com.canteen.pojo.Tables;
import com.canteen.service.OrdersService;
import com.canteen.service.TablesService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OrdersAction extends ActionSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Orders orders;
	private OrdersService ordersService;
	
	private List<Orders> ordersList;
	
	private Tables tables;
	private TablesService tablesService;
	
	private String result;
	
	public Orders getOrders()
	{
		return orders;
	}
	public void setOrders(Orders orders)
	{
		this.orders = orders;
	}
	public OrdersService getOrdersService()
	{
		return ordersService;
	}
	public void setOrdersService(OrdersService ordersService)
	{
		this.ordersService = ordersService;
	}
		
	public List<Orders> getOrdersList()
	{
		return ordersList;
	}
	public void setOrdersList(List<Orders> ordersList)
	{
		this.ordersList = ordersList;
	}
	

	public Tables getTables()
	{
		return tables;
	}
	public void setTables(Tables tables)
	{
		this.tables = tables;
	}
	public TablesService getTablesService()
	{
		return tablesService;
	}
	public void setTablesService(TablesService tablesService)
	{
		this.tablesService = tablesService;
	}
	public String getResult()
	{
		return result;
	}
	public void setResult(String result)
	{
		this.result = result;
	}
	/**
	 * 查询所有订单
	 */
	@SuppressWarnings("unchecked")
	public String findAllOrders(){
		ordersList = ordersService.findAllOrders();
		
		((Map<String, Object>) ActionContext.getContext().get("session")).put("all_ordersList", ordersList);
		return "findAllOrders";
	}
	
	/**
	 * 更新餐单状态
	 */
	public String updateOrderState(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String state = request.getParameter("state");
		System.out.println(state);
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		System.out.println(id);
		ordersService.updateState(state, id);
		this.setResult("updateOrderState_success");
		return "updateOrderState_success";
	}
	
	@SuppressWarnings("unchecked")
	public String queryOrderMsgListByOrderId(){
		HttpServletRequest request1 = ServletActionContext.getRequest();
		Integer id = Integer.valueOf(request1.getParameter("orderMsgId"));
		List<Object[]> list = ordersService.getOrderMsg(id);	
		
	/*	for(Iterator<Object[]> iterator = list.iterator();iterator.hasNext();){
			Object[] objects = iterator.next();
			Orders orders = (Orders) objects[0];
			Menu menu = (Menu) objects[1];
			Orderitem oi = (Orderitem) objects[2];
			System.out.println(orders.getOrdersTime()+"  "+menu.getMenuName()+"  "+oi.getMenu().getCategory().getCategoryName());
		}*/
		List<Tables> tableList = tablesService.getAvailableTables();
		((Map<String, Object>) ActionContext.getContext().get("session")).put("orderMsgList",list);
		((Map<String, Object>) ActionContext.getContext().get("request")).put("available_table_list",tableList);
		return "queryOrderMsg";			
	}
	
	@SuppressWarnings("unchecked")
	public String queryPaidOrdes(){
		List<Orders> paidOrdersList = ordersService.findOrdersByState("已付费");
		((Map<String, Object>) ActionContext.getContext().get("session")).put("paidOrdersList",paidOrdersList);
		return "queryPaidOrders";
	}
	
	@SuppressWarnings("unchecked")
	public String queryUnpaidOrdes(){
		List<Orders> unpaidOrdersList = ordersService.findOrdersByState("未付费");
		((Map<String, Object>) ActionContext.getContext().get("session")).put("unpaidOrdersList",unpaidOrdersList);
		return "queryUnpaidOrders";
	}	
	
	@SuppressWarnings("unchecked")
	public String queryMakingOrdes(){
		List<Orders> makingOrdersList = ordersService.findOrdersByState("制作中");
		((Map<String, Object>) ActionContext.getContext().get("session")).put("makingOrdersList",makingOrdersList);
		return "queryMakingOrders";
	}	

	@SuppressWarnings("unchecked")
	public String queryHaveToMakeOrders(){
		List<Orders> haveToMakeOrdersList = ordersService.findHaveToOrdersByState();
		((Map<String, Object>) ActionContext.getContext().get("session")).put("haveToMakeOrdersList",haveToMakeOrdersList);
		return "queryHaveToMakeOrders";		
	}
	
	@SuppressWarnings("unchecked")
	public String querySubmittedOrders(){
		List<Orders> SubmittedOrdersList = ordersService.findOrdersByState("已提交");
		((Map<String, Object>) ActionContext.getContext().get("session")).put("SubmittedOrdersList",SubmittedOrdersList);
		return "querySubmittedOrders";		
	}
}
