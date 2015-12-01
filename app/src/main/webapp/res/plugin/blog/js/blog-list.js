var blog = blog || {};
$(function() {
	// ----------------------日期选择器
	$.datepicker.setDefaults($.datepicker.regional['zh-CN'] = {
		showButtonPanel : true,
		currentText : '今天',
		monthNames : [ '一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月' ],
		dateFormat : 'yy-mm-dd',
		firstDay : 1,
		dayNamesMin : [ '日', '一', '二', '三', '四', '五', '六' ],
		changeYear : true
	});
	$(".datepicker").datepicker();

	var $blog_list_tbody = $("#blog_list_tbody");
	var $blog_list_pagination = $("#blog_list_pagination");
	var $_tpl_blog_list_tbody = $("#_tpl_blog_list_tbody");
	var $_tpl_blog_pagination = $("#_tpl_blog_pagination");
	blog.blogListing = function(pageIndex) {
		//tk.mask();
		var username = $(".dataGridFilter input[name='username']").val();
		$.ajax({
			url : contextPath + "/d/blog/getMoreBlogs",
			dataType : "json",
			data : {
				pageSize : 20,
				pageIndex : pageIndex,
				username : username
			},
			type : "post"
		}).done(function(data) {
			//tk.unmask();
			tk.checkIsTimeout(data);
			if (data.isSuc == 1) {
				tk.showSuccessMsg("请求成功");
				$blog_list_tbody.html($_tpl_blog_list_tbody.tmpl(data));
				$blog_list_pagination.html($_tpl_blog_pagination.tmpl(data.pagi));
			} else {
				tk.showErrorMsg(data.msg);
			}
		});
	};
	blog.blogListing(1);

	$("body").undelegate(".query-btn", "click").delegate(".query-btn", "click", function() {
		blog.blogListing(1);
	});

	
	$blog_list_tbody.undelegate(".blog_del", "click").delegate(".blog_del", "click", function() {
		var $this = $(this);
		var id = $this.attr("c-id");
		if (confirm('确认对此地址进行删除操作？')) {
			blog.blogDelete(id);
		}
	});

	blog.blogDelete = function(id) {
		$.ajax({
			url : contextPath + "/a/ms/blog/del/" + id,
			dataType : "json",
			type : "post"
		}).done(function(data) {
			tk.checkIsTimeout(data);
			if (data.isSuc == 1) {
				var pageIndex = $blog_list_pagination.find("li.active a").eq(0).text();
				blog.blogListing(pageIndex);
				tk.showSuccessMsg(data.msg);
			} else {
				tk.showErrorMsg(data.msg);
			}
		});
	};
});