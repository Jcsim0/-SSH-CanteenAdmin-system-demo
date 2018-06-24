<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'menu_edit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<jsp:include page="../meta.jsp" flush="true"></jsp:include>
  </head>
  
  <body>
<div class="page-container">
	<form class="form form-horizontal" id="form-article-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>菜名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="" name="">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">价格：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="" name="">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>类别：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
				<select name="" class="select">
					<option value="0">全部栏目</option>
					<option value="1">新闻资讯</option>
					<option value="11">├行业动态</option>
					<option value="12">├行业资讯</option>
					<option value="13">├行业新闻</option>
				</select>
				</span>
			</div>
		</div>		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">简介：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" datatype="*10-100" dragonfly="true" nullmsg="备注不能为空！" onKeyUp="$.Huitextarealength(this,200)"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">图片：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<div class="uploader-thum-container">
					<div id="fileList" class="uploader-list"></div>
					<div id="filePicker">选择图片</div><input type="file" id="imgName" name="menuImgFile" >	
					<input id="btn-star" class="btn btn-default radius ml-10" onClick="uploadImg()" type="button" value="开始上传">
				</div>
			</div>
		</div>

		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button onClick="article_save_submit();" class="btn btn-primary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 提交</button>
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>


<jsp:include page="../footer.jsp" flush="true"></jsp:include>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=path %>/admin/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="<%=path %>/admin/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="<%=path %>/admin/lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript" src="<%=path %>/admin/lib/webuploader/0.1.5/webuploader.min.js"></script> 
<script type="text/javascript">

	function uploadImg() {
	var img_file = document.getElementById("imgName");
	var fileObj = img_file.files[0];
	var formData = new FormData();
	formData.append("menuImgFile",fileObj);
		$.ajax({
			type : 'POST',
			url : 'menuAjaxAction!uploadMenuImg',
			data : formData,
			processData : false,
			contentType : false,
			async:false,
			dataType : 'json',
			success : function(data) {
				console.debug("data=" + data);
				layer.msg('上传成功!', {
					icon : 6,
					time : 2000
				});
			},
			error : function(data) {
				console.log(data);
				layer.msg('上传失败!', {
					icon : 5,
					time : 2000
				});
			},
		});
	}
</script>
</body>
</html>
