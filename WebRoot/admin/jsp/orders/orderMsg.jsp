<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<jsp:include page="../meta.jsp" flush="true"></jsp:include>
<title>编辑餐单 - 中餐厅后台餐单管理v3.1</title>
<meta name="keywords" content="">
<meta name="description" content="">
</head>
<body>
	<article class="page-container"> 
	
	<%-- <s:property value="#request.available_table_list" /> --%>
		<s:if test="#session.orderMsgList!=null">
			<form action="javascript:;" method="post" class="form form-horizontal" id="form-member-add">				
					<div class="page-container">
						<div class="mt-20">
							<s:if test="#request.available_table_list!=null">
								<div style="margin: 20px auto;">
									桌号：<select name="orders.tables">
											<s:iterator value="#session.orderMsgList" var="index" status="st" begin="0" end="0">
												<s:set value="#index[0]" name="oindex" />
												<option value='<s:property value="#oindex.tables.tablesId" />'>	
													<s:property value="#oindex.tables.tablesId" />
												</option>
											</s:iterator>
											
											<s:iterator value="#request.available_table_list" var="can">
												<option value='<s:property value="#can.tablesId" />'><s:property value="#can.tablesId" /></option>
											</s:iterator>
										</select>号桌&nbsp;&nbsp;&nbsp;
									折扣：<input type="number" min="0" max="1" step="0.01" style="width: 60px;text-align: center;" name="orders.discount" value='<s:property value="#oindex.discount" />'>	
								</div>
							</s:if>
								<table id="tableList" class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
									<thead>
										<tr class="text-c">
											<th width="80">类别</th>
											<th width="80">菜名</th>
											<th width="80">单价</th>									
											<th width="120">数量</th>
											<th width="120">价钱</th>
										</tr>
									</thead>
									<tbody>
									<s:iterator value="#session.orderMsgList" var="orderMsg" status="st">							
										<s:set value="#orderMsg[0]" name="orders" />
										<s:set value="#orderMsg[1]" name="menu" />
										<s:set value="#orderMsg[2]" name="orderitem" />
										<tr class="text-c">
											<td><s:property value="#orderitem.menu.category.categoryName" /></td>
											<td><s:property value="#menu.menuName" /></td>
											<td>￥<s:property value="#menu.price" /></td>
											<td ><input  type="number" min="1"  step="1" style="width: 60px;text-align: center;" name="orderitem.num" value='<s:property value="#orderitem.num" />'></td>
											<td ><s:property value="#menu.price * #orderitem.num" /></td>												
										</tr>
									</s:iterator>
									</tbody>
								</table>
						</div>	
					</div>
					
			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
					<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
				</div>
			</div>
		</form>
		</s:if> 
	</article>

	<jsp:include page="../footer.jsp" flush="true" />

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="<%=path%>/admin/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="<%=path%>/admin/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
	<script type="text/javascript"
		src="<%=path%>/admin/lib/jquery.validation/1.14.0/validate-methods.js"></script>
	<script type="text/javascript"
		src="<%=path%>/admin/lib/jquery.validation/1.14.0/messages_zh.js"></script>
	<script type="text/javascript"
		src="<%=path%>/admin/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="<%=path%>/admin/lib/laypage/1.2/laypage.js"></script>

<script type="text/javascript">
	$(function() {
		$('.table-sort').dataTable({
				"aaSorting": [[ 0, "asc" ]],//默认第几个排序
				"bStateSave": true,//状态保存
				"pading":false,
				"aoColumnDefs": [
				  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
				  {"orderable":false,"aTargets":[4]}// 不参与排序的列
				]
			});
		
		$("#form-member-add").validate({
			rules : {
				'orders.tables' : {
				required : true,
				minlength : 1,
				},
								
				'orders.discount' : {
				required : true,
				max : 1,
				min: 0,
				number:true,
				},
				
				'orderitem.num': {
				required : true,
				min: 1,
				digits : true,
				},
			},
			
			onkeyup : false,
			focusCleanup : true,
			success : "valid",
			submitHandler : function(form) {
					//$(form).ajaxSubmit();
					//var index = parent.layer.getFrameIndex(window.name);
					//parent.$('.btn-refresh').click();
					//parent.layer.close(index);
				}
			});
			
			var count= $("#tableList");
	});
	</script>
</body>
</html>