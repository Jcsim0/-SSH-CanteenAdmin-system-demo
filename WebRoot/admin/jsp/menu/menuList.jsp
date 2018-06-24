<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'menuList.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<jsp:include page="../meta.jsp" flush="true"></jsp:include>

<style type="text/css">
.share_category_wp{width:480px; padding:20px; background-color:#fff; margin-left:auto; margin-right:auto; margin-top:20px;-khtml-border-radius:10px;-ms-border-radius:10px;-o-border-radius:10px;-moz-border-radius:10px;-webkit-border-radius:10px;border-radius:10px;behavior: url(../../../ext/1401031623/ie-css3.htc);}
.count_txt{color: #B5B5B5;text-align: right;}
.count_txt strong {font-family: georgia;font-size: 24px; padding: 0 2px;}
.inputstyle {height: 75px;line-height: 18px;overflow-x: hidden;overflow-y: auto;width: 472px;}
</style>

</head>
<body>
	<nav class="breadcrumb"> 
		<i class="Hui-iconfont">&#xe67f;</i> 首页
		<span class="c-gray en">&gt;</span> 菜单管理
		<span class="c-gray en">&gt;</span>菜品管理
		<a class="btn btn-success radius r"style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新">
			<i class="Hui-iconfont">&#xe68f;</i>
		</a>
	</nav>
	<div class="page-container">
		<div class="text-c">
			<form class="Huiform" method="post" action="" target="_self">
				<input type="text" placeholder="分类名称" value="" class="input-text" style="width:120px"> 
				<span class="btn-upload form-group">
					<input class="input-text upload-url" type="text" name="uploadfile-2" id="uploadfile-2" readonly style="width:200px">
					<a href="javascript:void();" class="btn btn-primary upload-btn">
						<i class="Hui-iconfont">&#xe642;</i> 上传菜品图
					</a> 
					<input type="file" multiple name="menuImgFile" class="input-file">					
				</span> 
				菜名：<input type="text" name="menu.menuName">
				<button type="button" class="btn btn-success" id="" name="" onClick="picture_colume_add(this);">
					<i class="Hui-iconfont">&#xe600;</i> 添加
				</button>
			</form>
		</div>
		<div class="mt-20">
			
			<table class="table table-border table-bordered table-bg table-sort">
				<thead>
					<tr class="text-c">
						<th width="70">菜系</th>
						<th width="70">菜名</th>
						<th width="200">图片</th>
						<th width="70">价格</th>
						<th>具体描述</th>
						<th width="100">操作</th>
					</tr>
				</thead>
				<tbody>
					<s:if test="#session.all_menuList!=null">
						<s:iterator value="#session.all_menuList" var="menuInfos" status="st">
							<s:set value="#menuInfos[0]" name="menus"/>
							<s:set value="#menuInfos[1]" name="categorys"/>
							<tr class="text-c">
								<td>
									<span id="categoryName"><s:property value="#categorys.categoryName"/></span>
									<select id="categorySelect" name="categoryId" style="display:none;">
										<option><s:property value="#categorys.categoryName"/></option>
										<s:iterator value="#request.all_categoryList" var="c">
											<s:if test="#c.categoryName!=#categorys.categoryName">
												<option value='<s:property value="#c.categoryName" />'><s:property value="#c.categoryName"/></option>
											</s:if>
										</s:iterator>
								</select>
								</td>
								
								<td>
									<span id="menuName"><s:property value="#menus.menuName"/></span>
									<div id="menuNameInputDiv" style="display:none;" ><input id="menuNameInputVal" type="text" ></div>
								</td>
								
								<td>
									<span id="menuImg"><img alt="菜品图" width="200px"src='<%=path %>/<s:property value="#menus.img"/>'></span>
									<div id="menuImgInputDiv" style="display:none;">选择图片：<input id="menuImgInputVal" name="menuImgFile" type="file" ></div>
								</td>
								
								<td>
									<span id="menuPrice"><s:property value="#menus.price"/></span>
									<div id="menuPriceInputDiv"  style="display:none;">价格：<input id="menuPriceInputVal" name="menuPrice" type="number" ></div>
								</td>
								
								<td class="text-l">
									<span id="menuSummary"><s:property value="#menus.summary"/></span>
									<div id="menuSummaryInputDiv" class="cl share_category_wp" style="display:none;">
										<div class="cl">
											<h4 class="l">菜品简介</h4>
											<span class="r count_txt">还能输入<strong id="currentLength">100</strong>字</span>
										</div>
										<textarea id="menuSummaryInputVal" onkeyup="checkLength(this,100);" class="textarea radius inputstyle" name="" cols="" rows=""></textarea>
									</div>
								</td>
								<td class="f-14 product-brand-manage">
									<a style="text-decoration:none" id="edit" onClick="changeMenu(this)" href="javascript:;" title="编辑">
										<i class="Hui-iconfont">&#xe6df;</i>
									</a>
									<a style="text-decoration:none;display:none;" id="submitt" onClick="submitMenu(this)"  href="javascript:;" title="提交">提交</a>
									<a style="text-decoration:none" class="ml-5" onClick="active_del(this,'10001')" href="javascript:;" title="删除">
										<i class="Hui-iconfont">&#xe6e2;</i>
									</a>
								</td>
							</tr>
						</s:iterator>
					</s:if>
				</tbody>
			</table>
		</div>
	</div>

	<jsp:include page="../footer.jsp" flush="true"></jsp:include>
	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript" src="<%=path %>/admin/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=path %>/admin/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="<%=path %>/admin/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="<%=path %>/admin/jsp/menu/js/menu.js"></script>
	<script type="text/javascript">
		$('.table-sort').dataTable({
			"aaSorting" : [ [ 0, "src" ] ],//默认第几个排序
			"bStateSave" : true,//状态保存
			"aoColumnDefs" : [{"orderable" : false,"aTargets" : [5 ]}] // 制定列不参与排序			
		});
		
function menu_edit(title,url,w,h){
	if (title == null || title == '') {
		title = false;
	};
	if (url == null || url == '') {
		url = "404.html";
	};
	if (w == null || w == '') {
		w = 800;
	};
	if (h == null || h == '') {
		h = ($(window).height() - 50);
	};	
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
	//layer.full(index);
}

/*修改类别*/

function changeMenu(obj){
	var o=$(obj).parents("tr");
	
	//显示菜名输入框
    var spanValue = o.find("#menuName").text();
    o.find("#menuNameInputVal").val(spanValue);
    o.find("#menuNameInputDiv").show();
    
    //显示价格输入框
    var priceSpan = o.find("#menuPrice").text();
    o.find("#menuPriceInputVal").val(priceSpan);
    o.find("#menuPriceinputDiv").show();
    
    //显示简介
    var summarySpan = o.find("#menuSummary").text();
    o.find("#menuSummaryInputVal").val(summarySpan);
    o.find("#menuSummaryInputDiv").show();

    //显示类别选择框
    o.find("#categorySelect").show();
   
    //显示图片上传
	o.find("#menuImgInputDiv").show(); 
      
    o.find("#categoryName").hide();  //隐藏类名
    o.find("#menuName").hide();		//隐藏菜名
    o.find("#menuImg").hide();		//隐藏菜图
    o.find("#menuPrice").hide();		//隐藏价格
    o.find("#menuSummary").hide();	//隐藏简介
    
    o.find("#edit").hide();
    o.find("#submitt").show();
}

function submitMenu(obj){
	var o=$(obj).parents("tr");
	
	var categoryName = o.find("#categorySelect").val();
	var menuName = o.find("#menuNameInputVal").val();
	var menuImg = o.find("#menuImgInputVal").val();
	var menuPrice = o.find("#menuPriceInputVal").val();
	var menuSummary = o.find("#menuSummaryInputVal").val();
	
	//category_change(inputValue,id);   
	 
	o.find("#categoryName").text(categoryName);  //更新新类名
    o.find("#menuName").text(menuName);  //更新新菜名
    
    if(menuImg!=''){
    o.find("#menuImg").html("<img alt=\'菜品图\' width=\'200px\'src=\'<%=path %>/img-menu/"+menuImg+"\'>");
    }		//更新 新图片
    console.debug("newImg="+menuImg);//图片名还没解决
    		
    o.find("#menuPrice").text(menuPrice);		//更新 新价格
    o.find("#menuSummary").text(menuSummary);	//更新 新简介

	o.find("#menuNameInputDiv").hide();
	o.find("#menuImgInputDiv").hide(); 
	o.find("#categorySelect").hide();
    o.find("#menuSummaryInputDiv").hide();
    o.find("#menuPriceinputDiv").hide();
    
    o.find("#menuName").show();
	o.find("#menuImg").show(); 
	o.find("#categoryName").show();
    o.find("#menuSummary").show();
    o.find("#menuPrice").show();

    o.find("#edit").show();
    o.find("#submitt").hide();
    
    
}

function category_change(name,id){
	layer.confirm('确认更改吗？', {
		btn: ['确认','取消'], 
		shade: false,
		closeBtn: 0
	},
	function(){
			$.ajax({
			type: 'POST',
			url: 'categoryAjaxAtion!updateCategoryById',
			data:{'name':name,'id':id },
			dataType: 'json',
			success: function(data){
			console.debug("data="+data);
				layer.msg('更新成功!', {icon:6,time:1000});
			},
			error:function(data) {
				console.debug(data);
				layer.msg('更新失败，稍后再试试吧!',{icon: 5,time:1000});
			},
		});
		
	});	
}

function checkLength(which,max) {
	var maxChars = max;
	if (which.value.length > maxChars)
	which.value = which.value.substring(0,maxChars);
	var curr = maxChars - which.value.length;
	document.getElementById("currentLength").innerHTML = curr.toString(); 
}  
</script>
</body>
</html>
