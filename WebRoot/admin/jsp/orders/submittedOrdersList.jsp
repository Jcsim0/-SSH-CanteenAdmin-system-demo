<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'all_ordersList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<jsp:include page="../meta.jsp" flush="true"></jsp:include>
<title>已提交餐单列表</title>

  </head>
  
  <body>
<nav class="breadcrumb">
	<i class="Hui-iconfont">&#xe67f;</i> 
	首页 <span class="c-gray en">&gt;</span> 
	餐单管理 <span class="c-gray en">&gt;</span> 
	未付费餐单
	<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
		<i class="Hui-iconfont">&#xe68f;</i>
	</a>
</nav>
<div class="page-container">	
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
			<thead>
				<tr class="text-c">
					<th width="80">桌号</th>
					<th width="130">餐单时间</th>
					<th width="80">折扣</th>
					<th width="80">总额</th>
					<th width="80">状态</th>
					<th width="120">操作</th>
				</tr>
			</thead>
			<tbody>
			<s:if test="#session.SubmittedOrdersList!=null">
				<s:iterator value="#session.SubmittedOrdersList" var="ordersInfo" status="st">

						<tr class="text-c">
							<td>
								<u style="cursor:pointer;" class="text-primary" onClick="orders_show('餐单详情','','1000','600')" title="查看">
									<s:property value="#ordersInfo.tables.tablesId"/>号桌
								</u>
							</td>
							<td><s:property value="#ordersInfo.ordersTime"/></td>
							<td><s:property value="#ordersInfo.discount*100"/>%</td>		
							<td><s:property value="#ordersInfo.totalPrice"/></td>
							<td class="td-status"><span class="label label-secondary radius"><s:property value="#ordersInfo.ordersState"/></span></td>
							<td class="f-14 td-manage">
								<a style="text-decoration:none"  onclick="orders_shoufei(this,'<s:property value="#ordersInfo.ordersId"/>')" href="javascript:;" title="收费">收费</a>
								<a id="del" style="text-decoration:none" class="ml-5" onClick="order_edit('餐点编辑','ordersManagerAction!queryOrderMsgListByOrderId?orderMsgId=<s:property value="#ordersInfo.ordersId"/>','1000','600')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> 
								<a style="text-decoration:none" class="ml-5" onClick="article_del(this,'10001')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
							</td>					
						</tr>
	
				</s:iterator>
			</s:if>
			</tbody>
		</table>
	</div>
</div>
<jsp:include page="../footer.jsp" flush="true" />

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=path %>/admin/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="<%=path %>/admin/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="<%=path %>/admin/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="<%=path %>/admin/js/ordersList.js"></script>
<script type="text/javascript">
$('.table-sort').dataTable({
	"aaSorting": [[ 0, "asc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"pading":false,
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[5]}// 不参与排序的列
	]
});
/*资讯-删除*/
function article_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}

</script> 
</body>
</html>
