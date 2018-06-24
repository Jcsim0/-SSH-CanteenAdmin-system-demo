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
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<jsp:include page="../meta.jsp" flush="true"></jsp:include>
<title>菜单列表</title>

  </head>
  
  <body>
<nav class="breadcrumb">
	<i class="Hui-iconfont">&#xe67f;</i> 
		首页 <span class="c-gray en">&gt;</span> 
		菜单管理 <span class="c-gray en">&gt;</span> 
		类别管理 
	<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
		<i class="Hui-iconfont">&#xe68f;</i>
	</a>
</nav>
<div class="cl pd-5 bg-1 bk-gray mt-20"> 
		<span class="l">
			<a href="javascript:;" onclick="category_add('添加类别','<%=path %>/admin/jsp/menu/category_add.jsp','800','500')" class="btn btn-primary radius">
				<i class="Hui-iconfont">&#xe600;</i> 
				添加类别
			</a>
		</span
	</div>	
<div class="page-container">
	
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
			<thead>
				<tr class="text-c">
					<th width="80">类别</th>
					<th width="120">操作</th>
				</tr>
			</thead>
			<tbody>
			<s:if test="#session.all_categoryList!=null">
				<s:iterator value="#session.all_categoryList" var="categoryInfo" status="st">
				<tr class="text-c">
					<td><span id="categoryName"><s:property value="#categoryInfo.categoryName"/></span>
						<input type="text" id="categoryNameInput" style="display:none"/>
						<input id="categoryId" type="hidden" value='<s:property value="#categoryInfo.categoryId"/>'/>
					</td>
					<td class="f-14 td-manage">
					<%-- 	<a style="text-decoration:none" class="ml-5" onClick="category_edit('类别编辑','<%=path %>/admin/jsp/menu/category_edit.jsp?categoryIndex=<s:property value="#st.index"/>','1000','600')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a>  --%>
						<a style="text-decoration:none" class="ml-5" id="change" onClick="changeCategoryName(this);" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> 
						<a style="text-decoration:none;display:none;" id="submitt" onClick="submitCategoryName(this);" class="ml-5" onClick="" href="javascript:;" title="提交">提交</a> 
						<a style="text-decoration:none" class="ml-5" onClick="category_del(this,'<s:property value="#categoryInfo.categoryId"/>')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
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
<script type="text/javascript" src="<%=path %>/admin/jsp/menu/js/category.js"></script>
<script type="text/javascript">
$('.table-sort').dataTable({
	"aaSorting": [[ 0, "asc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"pading":false,
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[1]}// 不参与排序的列
	]
});

/*资讯-添加*/
function category_add(title,url,w,h){
	layer.open({
		type: 2,
		area : [ w + 'px', h + 'px' ],
		//offset : '5%',// 快捷设置顶部坐标
		fix : false, // 不固定
		move : true,// 拖拽
		maxmin: true,
		shade : 0.4,
		title: title,
		content: url,
	});
}

/*类别-删除*/
function category_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: 'categoryAjaxAtion!delCategory',
			data:{"id":id},
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").remove();
				layer.msg('删除成功!',{icon:1,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
				layer.msg('删除失败，稍后再试试吧!',{icon: 5,time:1000});
			},
		});		
	});
}

</script> 
</body>
</html>
