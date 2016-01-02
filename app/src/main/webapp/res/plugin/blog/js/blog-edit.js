$("#blog_img_uploadify").uploadify({
	'swf' : contextPath + '/dev-lib/assets/js/uploadify/uploadify.swf',
	'uploader' : contextPath + '/d/blog/pic/upload',
	'buttonImage' : contextPath + "/dev-lib/assets/js/uploadify/img/20131101143957.png",
	'auto' : true,
	'width' : 71,
	'height' : 25,
	'buttonClass' : "uploadify-btn",
	'fileTypeExts' : '*.gif;*.jpg;*.png;*.bmp',
	'fileSizeLimit' : "600KB",
	'formData' : {
		thume : "M",
		fd : "filedataPic"
	},
	'onUploadSuccess' : function(fileObj, response, data) {
		console.info(response);
		var json = eval("(" + response + ")");
		// alert(json.msg);
		var $img = $("form#form-blog-edit .blog-detail-pic-img");
		$img.attr("src", imgContextPath + "/uploads/" + json.msg);
		$("form#form-blog-edit  #pic-address").html(imgContextPath + "/uploads/" + json.msg);
		$img.closest("a").attr("href", contextPath + "/d/page/view-image?size=M&name=" + json.msg);
		$("form#form-blog-edit input[name='pic']").val(json.msg);
	},
	'onUploadError' : function(event, queueID, fileObj) {
		alert("文件:" + fileObj.name + "上传失败");
	}
});

// --------------------------------------富文本编辑器
var editor;

// --------------------------------------------

var blog = blog || {};
blog.isAutoSave = false;
blog.publishState = 1;
blog.assort = '';
blog.id = 0;
blog.tagIds = '';
(function($) {
	// -------------------------操作
	editor = KindEditor.create('textarea[name="content"]', {
		allowFileManager : true
	});
	console.debug(editor);

	// ---------------------博客的表单处理
	blog.init = function() {
		var $form = $('form#form-blog-edit');
		var title = $form.find("input[name='title']");
		if (title.val() == null || $.trim(title.val()).length == 0) {
			$form.find("input[name='title']").next().show();
			alert("博客一个好的标题很重要");
			return false;
		} else {
			blog.title = title.val();
			$form.find("input[name='title']").next().hide();
		}
		var tagsId = $form.find("input[name='tagsId']");
		if (tagsId.val() == null || $.trim(tagsId.val()).length == 0) {
			alert("给博客选个好的标签,以后好分类查询");
			return false;
		} else {
			blog.tagIds = tagsId.val();
		}
		blog.id = $form.find("input[name='id']").val();
		blog.content = editor.html();
		console.info(blog.content);
		return true;
	};
	// ----------------博客内容自动保存
	blog.autoSaveBlog = function(editor) {
		// // 使用方法名字执行方法
		// var t1 = window.setTimeout(blog.saveBlog, 1000);
		// var t2 = window.setTimeout("hello()", 3000); // 使用字符串执行方法
		// window.clearTimeout(t1); // 去掉定时器
	};
	// -----------------博客保存到草稿箱
	blog.saveBlog = function() {
		$.ajax({
			url : contextPath + "/a/blog/saveBlog",
			dataType : "json",
			type : "post",
			async : false,
			data : {
				bid : blog.id,
				title : blog.title,
				content : blog.content,
				publishState : blog.publishState,
				tagIds : blog.tagIds
			},
			error : function(data) {
				alert("请求出错了");
			}
		}).done(function(data) {
			if (data.isSuc == '1') {
				if(blog.publishState==1){
					alert("发布成功");
				}else{
					alert("保存草稿成功");
				}
			} else {
				alert("保存失败,    "+data.msg+"   请选择[取得HTML] 自行保存博客内容,以免丢失信息");
			}
		});
	};

	$("form#form-blog-edit").delegate("#submit_publish", "click", function() {
		if(blog.init()){
			blog.init();
			blog.publishState = 1;
			$(this).next().show();
			blog.saveBlog();
			$(this).next().hide();
		}
	});
	$("form#form-blog-edit").undelegate("#submit_save", "click").delegate("#submit_save", "click", function() {
		if(blog.init()){
			blog.publishState = 0;
			$(this).next().show();
			blog.saveBlog();
			$(this).next().hide();
		}
	});
	
	$("form#form-blog-edit").undelegate("input[name=showHtml]", "click").delegate(
			"input[name=showHtml]",
			"click",
			function() {
				document.getElementById("preview_blog").innerHTML = "<textarea  rows=12 style='width:100%'>"
						+ editor.html() + "</textarea>";
			});
	$("form#form-blog-edit").undelegate("input[name=previewHtml]", "click").delegate("input[name=previewHtml]",
			"click", function() {
				document.getElementById("preview_blog").innerHTML = editor.html();
				SyntaxHighlighter.all();
			});

})(jQuery);
