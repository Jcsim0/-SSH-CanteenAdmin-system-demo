/**
 * 
 */

/*餐单-收费*/
function orders_shoufei(obj,id){
	layer.confirm('收费？', {
		btn: ['确认','取消'], 
		shade: false,
		closeBtn: 0
	},
	function(){
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已收费</span>');
			$.ajax({
			type: 'POST',
			url: 'ordersAjaxAtion!updateOrderState',
			data:{'state':'已付费' , 'id':id },
			dataType: 'json',
			success: function(data){
			//console.debug(data);
			//console.debug("data="+data.result);
				$(obj).parents("tr").find("#del").remove();
				$(obj).parents("tr").find(".td-manage").prepend("<a style=\'text-decoration:none\' class=\'ml-5\' onClick=\'article_del(this,\'10001\')\' href=\'javascript:;\' title=\'删除\'><i class=\'Hui-iconfont\'>&#xe6e2;</i></a>");
				$(obj).remove();
				layer.msg('已收费', {icon:6,time:1000});
			},
			error:function(data) {
				console.debug(data);
			},
		});
		
	});	
}
/*餐单-编辑*/
/* 弹出层 */
/*
 * 参数解释： title 标题 url 请求的url id 需要操作的数据id w 弹出层宽度（缺省调默认值） h 弹出层高度（缺省调默认值）
 */
function order_edit(title,url,w,h){
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