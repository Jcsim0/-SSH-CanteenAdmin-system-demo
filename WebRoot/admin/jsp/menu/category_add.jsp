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
<head>
<base href="<%=basePath%>">

<title>My JSP 'category_edit.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<jsp:include page="../meta.jsp" flush="true"></jsp:include>

</head>

<body>
	<article class="page-container">
	<form class="form form-horizontal" id="form-admin-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>类别：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="请输入所要添加的类名" id="categoryName" name="categoryName">
			</div>
		</div>

		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="button" onclick="save();" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
	
	</article>
	<jsp:include page="../footer.jsp" flush="true" />
</body>
<script type="text/javascript" src="<%=path %>/admin/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="<%=path %>/admin/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="<%=path %>/admin/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">	
	function save(){
		if($("#categoryName").val()==''){
			$.Huimodalalert('类名不能为空',1000);
		}else{
			$.ajax({
				type: 'POST',
				url: "categoryAjaxAtion!insertCategory",
				data:{'category.categoryName':$("#categoryName").val()},
				success: function(data){
				console.debug("data="+data);
					parent.layer.msg('添加成功!', {icon:6,time:1000});
					parent.location.replace(parent.location.href);
					var index = parent.layer.getFrameIndex(window.name);
					parent.$('.btn-refresh').click();
					parent.layer.close(index); 
				},
				error:function(data) {
					console.debug(data);
					parent.layer.msg('添加失败，稍后再试试吧!',{icon: 5,time:1000});
					var index = parent.layer.getFrameIndex(window.name);
					parent.$('.btn-refresh').click();
					parent.layer.close(index); 
				},
			});
		
		}
	}
	!function($) {
	$.Huimodalalert = function(info, speed) {
		if ($(".modal-alert").length > 0) {
			$(".modal-alert").remove();
		}
		if (speed == 0 || typeof(speed) == "undefined") {
			$(document.body).append('<div id="modal-alert" class="modal modal-alert radius">' + '<div class="modal-alert-info">' + info + '</div>' + '<div class="modal-footer"> <button class="btn btn-primary radius" onClick="$.Huimodalalert.hide()">确定</button></div>' + '</div>');
			$("#modal-alert").fadeIn();
		} else {
			$(document.body).append('<div id="modal-alert" class="modal modal-alert radius" >' + '<div style="color:red;font-size:20px;" class="modal-alert-info">' + info + '</div>' + '</div>');
			$("#modal-alert").fadeIn();
			setTimeout($.Huimodalalert.hide, speed);
		}
	}
	$.Huimodalalert.hide = function() {
		$("#modal-alert").fadeOut("normal",
		function() {
			$("#modal-alert").remove();
		});
	}
} (window.jQuery);
</script>
</html>
