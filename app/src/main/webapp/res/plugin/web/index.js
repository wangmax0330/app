var web = web || {};
$(function() {
	var $blog_list_tbody = $("#blog_list_tbody");
	web.webListing = function(pageIndex) {
		// tk.mask();
		$.ajax({
			url : contextPath + "/web/getMoreBlog",
			dataType : "html",
			data : {
				pageSize : 5,
				pageIndex : pageIndex,
				tag:TAG,
				month:MONTH
			},
			type : "post",
			success : function(data) {
			},
			error : function(data) {
			}
		}).done(function(data) {
			$blog_list_tbody.html("");
			$blog_list_tbody.html(data);
			$("#blog_pagination_tbody").html($("#_tpl_blog_pagination").html());
		});
	};
	web.getTagSide = function() {
		// tk.mask();
		$.ajax({
			url : contextPath + "/web/getTagSide",
			dataType : "html",
			data : {},
			type : "get",
			success : function(data) {
			},
			error : function(data) {
			}
		}).done(function(data) {
			$("#blog_tag_side_tbody").append(data);
		});
	};
	web.getDateSide = function() {
		// tk.mask();
		$.ajax({
			url : contextPath + "/web/getDateSide",
			dataType : "html",
			data : {},
			type : "get",
			success : function(data) {
			},
			error : function(data) {
			}
		}).done(function(data) {
			$("#blog_date_side_tbody").html();// 清空数据
			$("#blog_date_side_tbody").append(data);
		});
	};
	web.webListing(0);
	web.getTagSide();
	web.getDateSide();
});