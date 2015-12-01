var userList = userList || {};
$(function() {
	/** 列表 start---------------------------- * */
	userList.userListing = function(pageIndex) {
		$.ajax({
			url : contextPath + "/a/a-admin/users/list",
			dataType : "json",
			data : {
				pageSize : 10,
				pageIndex : pageIndex
			},
			type : "post"
		}).done(
				function(data) {
					if (data.isSuc == 1) {
						$("#user_list_tbody").html(
								$("#_tpl_user_list_tbody").tmpl(data));
						$("#user-list-pagination").html(
								$("#_tpl_user_pagination").tmpl(data.pagi));
					}
				});
	};

	userList.userListing(1);

});