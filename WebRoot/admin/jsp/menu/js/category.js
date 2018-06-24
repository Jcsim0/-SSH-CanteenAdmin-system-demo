/**
 * 
 */
/* 类别编辑 */
/*
 * 参数解释： title 标题 url 请求的url id 需要操作的数据id w 弹出层宽度（缺省调默认值） h 弹出层高度（缺省调默认值）
 */
function category_edit(title,url,w,h){
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
}

/*修改类别*/

function changeCategoryName(obj){
	var o=$(obj).parents("tr");
    var spanValue = o.find("#categoryName").text();
    o.find("#categoryNameInput");
    o.find("#categoryNameInput").val(spanValue);
    o.find("#categoryNameInput").show();
    
    o.find("#categoryName").hide();
    o.find("#change").hide();
    o.find("#submitt").show();
}

function submitCategoryName(obj){
	var o=$(obj).parents("tr");
	var id = o.find("#categoryId").val();
	var inputValue = o.find("#categoryNameInput").val();
	category_change(inputValue,id);    
    o.find("#categoryName").text(inputValue);
    o.find("#categoryNameInput").hide();
    o.find("#categoryName").show();
    o.find("#change").show();
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


