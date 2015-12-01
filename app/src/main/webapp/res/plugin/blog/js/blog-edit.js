// -- -- -- -- -- -- --KindEditor初始化
var editor;
KindEditor.ready(function(K) {
	editor = K.create('textarea[name="content"]', {
		allowFileManager : true,
		autoHeightMode : true,
		afterCreate : function() {
			this.loadPlugin('autoheight');
		},
		urlType : 'absolute',
		allowUpload : true, // 允许上传图片
		imageUploadJson : '/blog/pic/upload' // 服务端上传图片处理URI
	});
	// -----------------初始化清空内容,不清空,后台传的参数会被覆盖掉
	// editor.html('');
});	

var blog = blog || {};
blog.isAutoSave = false;
blog.isPublish = false;
(function($) {
	// ---------------------博客的表单提交
	$("form.form-blog-edit").ajaxForm({
		dataType : 'json',
		beforeSubmit : function(formData, jqForm, options) {
			var validate = true;
			var $form = $('form.form-blog-edit');
			var title = $form.find("input[name='title']");
			var content = $form.find("input[name='content']");
			if (title.val() == '' || title.val() == undefined) {
				title.powerFloat({
					eventType : null,
					targetMode : "remind",
					target : "输入标题不能为空！",
					position : "2-1"
				});
				validate = false;
			}
			// if (content.val() == '' || content.val() == undefined) {
			// console.info(content.val());
			// content.powerFloat({
			// eventType: null,
			// targetMode: "remind",
			// target: "输入内容不能为空！",
			// position: "4-1"
			// });
			// }
			if (validate) {
				// tk.mask();
				$form.find('input[type="submit"]').next().show();
			}
			return validate;
		},
		success : function(data) {
			$('form.form-blog-edit').find('input[type="submit"]').next().hide();
			// tk.checkIsTimeout(data); 检查是否登陆超时
			if (data.isSuc == 1) {
				tk.showSuccessMsg("信息保存成功");
				// if (data.attrs[0] == "Y") {
				// tk.load(contextPath + '/d/coupon/preShopEdit/'
				// + data.msg + "?isCreate=1");
				// } else {
				// history.back(-1);
				// //
				// tk.load(contextPath+'/d/page/coupon.coupon-list-unpub','',tk.menuFocus,[$("#sidebar
				// // .menu ul.toggle li
				// // a[href='#coupon.coupon-list-unpub']")[0]]);
				// }
				// alert();
			} else {
				tk.showErrorMsg(data.msg);
			}

		}
	});

	// ----------------博客内容自动保存
	blog.autoSaveBlog = function(editor) {
		// // 使用方法名字执行方法
		// var t1 = window.setTimeout(blog.saveBlog, 1000);
		// var t2 = window.setTimeout("hello()", 3000); // 使用字符串执行方法
		// window.clearTimeout(t1); // 去掉定时器
	};
	// -----------------博客保存到草稿箱
	blog.saveBlog = function(editor) {
		blog.title = blog.content;
		$.ajax({
			url : contextPath + "/a/blog/saveBlog",
			dataType : "json",
			type : "post",
			data : {
				title : blog.title,
				content : blog.content,
				isPublish : blog.isPublish,
				uid : 1
			}
		}).done(function(data) {
			if (data.isSuc == '1') {
				alert("保存成功");
			}
		});
	};
	// -----------------发布博客
	blog.publishBlog = function(editor) {
		blog.saveBlog(editor);
	};

	// -------------------------操作

})(jQuery);
