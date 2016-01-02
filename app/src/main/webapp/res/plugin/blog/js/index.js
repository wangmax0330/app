var blog = blog || {};
$(function() {
	blog.blogDoHash = function(hash) {
		console.info(hash);
		if (hash) {
			if ("#blog.blog-list" == hash) {
				tk.load(contextPath + '/d/page/blog.blog_list', '', tk.menuFocus,
						[ $("#sidebar li a[href='#blog.blog-list']")[0] ]);
			} else if ("#blog.blog-new" == hash) {
				console.debug($("#sidebar  li a[href='#blog.blog-new']")[0]);
				tk.load(contextPath + '/d/blog/editBlog/0', '', tk.menuFocus,
						[ $("#sidebar li a[href='#blog.blog-new']")[0] ]);
			}else if (hash.indexOf("#blog.blog-edit") > -1) {
				var cid = hash.substring(hash.indexOf("!bid=") + 5);
				tk.load(contextPath + '/d/blog/editBlog/' + cid, '', tk.menuFocus,
						[ $("#sidebar li a[href='#blog.blog-edit']")[0] ]);
			}else if(hash.indexOf("#blog.blog-tags") > -1){
				tk.load(contextPath + '/d/tag/showAllTag', '', tk.menuFocus,
						[ $("#sidebar li a[href='#blog.blog_tag_edit']")[0] ]);
			}else {
			
				$(".menu").find(".toggle li a[href='" + hash + "']").trigger("click");
			}
		} else {
			tk.load(contextPath + '/d/page/blog.blog_list', '', tk.menuFocus,
					[ $("#sidebar li a[href='#blog.blog-list']")[0] ]);
		}
	};
	blog.blogDoHash(firstClickMenu);
});