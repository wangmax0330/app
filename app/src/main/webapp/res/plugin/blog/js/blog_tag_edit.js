 $(".blog_tag").delegate(".del-dataSelector", "click", function(event) {
     var $this = $(this).closest("span");
     var data = [];
     console.debug($this);
     var tag = $this.attr("did");
     console.info(tag + "-------------");
     $.ajax({
         url: contextPath + "/a/tag/delTag",
         dataType: "json",
         data: {
             tag: tag
         },
         type: "post"
     }).done(function(data) {
         console.info(data.isSuc == 1);
         if (data.isSuc == 1) {
             alert("删除成功");
             $this.remove();
         } else {
             alert(data.msg);
         }
     });
     console.debug(this);
     console.debug($(this));
 });
 $(".blog_tag").delegate("#add_new_tag", "keydown", function(event) {
     var $this = $(this);
     var keyCode = event.which || event.keyCode;
     if (keyCode == 13) { //up
         console.info("按键事件");
         var value = $this.val();
         if (value != '') {
             var _thisSibling = $(this).siblings("span[did='" + value + "']");
             if (_thisSibling.length > 0) {
                 alert(_thisSibling.attr("did") + "已经添加过了,请不要重复添加");
                 return;
             }
             $.ajax({
                 url: contextPath + "/a/tag/saveTag",
                 dataType: "json",
                 data: {
                     tag: value
                 },
                 type: "post"
             }).done(function(data) {
                 tk.checkIsTimeout(data);
                 if (data.isSuc == 1) {
                     alert("添加成功");
                     $this.after("<span class='z' did='" + value + "'>" + value + "<i class='del-dataSelector'></i></span>");
                     $this.val("");
                     return true;
                 } else {
                     alert(data.msg);
                     return false;
                 }
             });
         }
     }
     if (keyCode == 27) {}
 });
