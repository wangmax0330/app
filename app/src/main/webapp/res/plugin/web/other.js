var web = web || {};
$(function() {
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
	web.getTagSide();
	web.getDateSide();
});