var tk = tk || $.noop;
var editor;
// --------------------------------------------------Jquery插件加载完毕-后处理-------------------------------------------
(function($) {
	// ---------------------------------------遮罩效果
	tk.mask = function(txt) {
	};

	tk.unmask = function() {
	};
	$('.column').equalHeight();
	// -----------------------------------------通用显示处理信息(ajax,表单验证之类的)
	tk.showSuccessMsg = function(msg) {
		$(".alert_info").hide();
		$(".alert_error").hide();
		$(".alert_warning").hide();
		$(".alert_success").show("slide", {
			direction : "right"
		}, 500).find("span").html(msg + '&nbsp;&nbsp;&nbsp;&nbsp;');
	};
	tk.showErrorMsg = function(msg) {
		$(".alert_info").hide();
		$(".alert_warning").hide();
		$(".alert_success").hide();
		$(".alert_error").show("slide", {
			direction : "right"
		}, 500).find("span").html(msg + '&nbsp;&nbsp;&nbsp;&nbsp;');
	};
	tk.showWarningMsg = function(msg) {
		$(".alert_info").hide();
		$(".alert_error").hide();
		$(".alert_success").hide();
		$(".alert_warning").show("slide", {
			direction : "right"
		}, 500).find("span").html(msg + '&nbsp;&nbsp;&nbsp;&nbsp;')
	};
	tk.showInfoMsg = function(msg) {
		$(".alert_error").hide();
		$(".alert_warning").hide();
		$(".alert_success").hide();
		$(".alert_info").show("slide", {
			direction : "right"
		}, 500).find("span").html(msg + '&nbsp;&nbsp;&nbsp;&nbsp;')
	};
	// 回调函数
	function callback(obj) {
		setTimeout(function() {
			// $("#effect:visible").removeAttr("style").fadeOut();
			// $(".alert_info").show("slide", {}, 500).find("span").html(msg +
			// '&nbsp;&nbsp;&nbsp;&nbsp;');
		}, 1000);

	}
	;
	// --------------------------------------检查浏览器版本---------------------------------------
	tk.checkBrowserInfo = function(msg) {
		var userAgent = navigator.userAgent.toLowerCase();
		browser = {
			version : (userAgent.match(/.+(?:rv|it|ra|ie)[\/: ]([\d.]+)/) || [
					0, '0' ])[1],
			safari : /webkit/.test(userAgent),
			opera : /opera/.test(userAgent),
			msie : /msie/.test(userAgent) && !/opera/.test(userAgent),
			mozilla : /mozilla/.test(userAgent)
					&& !/(compatible|webkit)/.test(userAgent)
		}
		if (browser.msie) {
			alert("this is msie"); // ie 浏览器
		} else if (browser.safari) {
			alert("this is safari!");
		} else if (browser.mozilla) {
			alert("this is mozilla!");
		} else if (browser.opera) {
			alert("this is opera");
		} else {
			alert("i don't konw!");
		}
	};
})(jQuery);
// --------------------------------------检查插件时候已经加载完毕


