$(function() {

	/**
	 * 幻灯片
	 */
	
	/**
	 * 选项卡
	 */
	// 订购机票
	$('.booking').click(function() {
		$('.booking').addClass('active');
		$('.booking > .icon').addClass('active');
		$('.search').removeClass('active');
		$('.browse').removeClass('active');
		$('.ship').removeClass('active');
		$('.search > .icon').removeClass('active');
		$('.browse > .icon').removeClass('active');
		$('.ship > .icon').removeClass('active');
		$('#line').addClass('one');
		$('#line').removeClass('two');
		$('#line').removeClass('three');
		// $('#line').removeClass('four');
	});

	// 搜索航班
	$('.search').click(function() {
		$('.search').addClass('active');
		$('.search > .icon').addClass('active');
		$('.booking').removeClass('active');
		$('.browse').removeClass('active');
		$('.ship').removeClass('active');
		$('.booking > .icon').removeClass('active');
		$('.browse > .icon').removeClass('active');
		$('.ship > .icon').removeClass('active');
		$('#line').addClass('two');
		$('#line').removeClass('one');
		$('#line').removeClass('three');
		// $('#line').removeClass('four');
	});

	// 浏览航班信息
	$('.browse').click(function() {
		$('.browse').addClass('active');
		$('.browse > .icon').addClass('active');
		$('.search').removeClass('active');
		$('.booking').removeClass('active');
		$('.ship').removeClass('active');
		$('.search > .icon').removeClass('active');
		$('.booking > .icon').removeClass('active');
		$('.ship > .icon').removeClass('active');
		$('#line').addClass('three');
		$('#line').removeClass('two');
		$('#line').removeClass('one');
		// $('#line').removeClass('four');
	});

	// $('.ship').click(function() {
	// $('.ship').addClass('active');
	// $('.ship > .icon').addClass('active');
	// $('.search').removeClass('active');
	// $('.browse').removeClass('active');
	// $('.booking').removeClass('active');
	// $('.search > .icon').removeClass('active');
	// $('.browse > .icon').removeClass('active');
	// $('.booking > .icon').removeClass('active');
	// $('#line').addClass('four');
	// $('#line').removeClass('two');
	// $('#line').removeClass('three');
	// $('#line').removeClass('one');
	// });

	$('.booking').click(function() {
		$('#first').addClass('active');
		$('#second').removeClass('active');
		$('#third').removeClass('active');
		// $('#fourth').removeClass('active');
	});

	$('.search').click(function() {
		$('#first').removeClass('active');
		$('#second').addClass('active');
		$('#third').removeClass('active');
		// $('#fourth').removeClass('active');
	});

	$('.browse').click(function() {
		$('#first').removeClass('active');
		$('#second').removeClass('active');
		$('#third').addClass('active');
		// $('#fourth').removeClass('active');
	});

	// $('.ship').click(function() {
	// $('#first').removeClass('active');
	// $('#second').removeClass('active');
	// $('#third').removeClass('active');
	// $('#fourth').addClass('active');
	// });
	
});

/**
 * 弹出层 使用H-ui,div背景颜色，自己修改
 * 
 * @param $
 * @returns
 */

!function($) {
	$.Huimodalalert = function(info, speed) {
		if ($(".modal-alert").length > 0) {
			$(".modal-alert").remove();
		}
		if (speed == 0 || typeof(speed) == "undefined") {
			$(document.body).append('<div id="modal-alert" class="modal modal-alert radius">' + '<div class="modal-alert-info">' + info + '</div>' + '<div class="modal-footer"> <button class="btn btn-primary radius" onClick="$.Huimodal_alert.hide()">确定</button></div>' + '</div>');
			$("#modal-alert").fadeIn();
		} else {
			$(document.body).append('<div id="modal-alert" style="opacity: 0.6;" class="modal modal-alert radius">' + '<div style="color:red;" class="modal-alert-info">' + info + '</div>' + '</div>');
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


