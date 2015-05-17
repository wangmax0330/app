var tk = tk || $.noop;// 未定义 或者 null 的时候 就赋值 一个 {}; $.noop
// 空对象,函数没有返回值(也可视作返回undefined)
var ie6 = false;
tk.nohash = false;


// 页面加载完之后执行
(function(){
	$.Placeholder.init();
//    jQuery.fn.load = function(e, t, n) {
//        if (typeof e != "string" && _load) return _load.apply(this, arguments);
//        var r, i, s, o = this,
//        u = e.indexOf(" ");
//        return u >= 0 && (r = e.slice(u, e.length), e = e.slice(0, u)),
//        jQuery.isFunction(t) ? (n = t, t = undefined) : t && typeof t == "object" && (s = "POST"),
//        o.length > 0 && jQuery.ajax({
//            url: e,
//            type: s,
//            dataType: "html",
//            data: t
//        }).done(function(e) {
//            if (e && e.indexOf("loginpagehtmlsessiontimeout") > -1) {
//                window.location.href = contextPath + "/d/page/login";
//                return
//            }
//            i = arguments,
//            o.html(r ? jQuery("<div>").append(jQuery.parseHTML(e)).find(r) : e)
//        }).complete(n &&
//        function(e, t) {
//            o.each(n, i || [e.responseText, t, e])
//        }),
//        this
//    };
	tk.mask = function(txt) {
        $('.sync_icon_div').show();
        if (!txt) txt = "处理";
        // 显示操作提示，最关键核心代码
        $("#targetFixed").powerFloat({
            eventType: null,
            targetMode: "doing",
            target: "正在" + txt + "中...",
            position: "1-2"
        });
    };
    tk.unmask = function() {
        $('.sync_icon_div').hide();
        $("#overLay").remove();
        $.powerFloat.hide();
    };
    
    tk.load = function(url, containerObj, fun, params) {
    	alert("load");
        tk.nohash = true;
        if (containerObj && containerObj != '') {

        } else {
            containerObj = $("#main");
        }
        tk.mask('加载');
        var funExe = false;
        if (fun && fun == tk.menuFocus) {
            fun(params);
            funExe = true;
        }
        containerObj.load(url, {},
        function() {
            containerObj.scrollTop(0);
            tk.nohash = false;
            tk.unmask();
            $('.loading_wp').hide();
            $("input[placeHolder],textarea[placeHolder]").powerFloat({
                eventType: "focus",
                targetMode: "remind",
                targetAttr: "placeHolder",
                position: "1-4"
            });

            if (fun && funExe == false) {
                fun(params);
            }
        });
    }
    tk.showSuccessMsg = function(msg) {
        $(".welcome").hide();
        $(".welcome.sucMsg").show("slide", {},
        500).find("span").html(msg + '&nbsp;&nbsp;&nbsp;&nbsp;');
        var msgDiv = $('#tk_alert_Dialog');
        msgDiv.find('span').html(msg);
        msgDiv.removeClass('errorDialog');
        msgDiv.addClass('warningDialog');
        msgDiv.show();
        msgDiv.hide('highlight', {},
        3000,
        function() {

        });
    };

    
    tk.showErrorMsg = function(msg) {
        $(".welcome").hide();
        $(".welcome.errMsg").show("slide", {},
        500).find("span").html(msg + '&nbsp;&nbsp;&nbsp;&nbsp;');
        var msgDiv = $('#tk_alert_Dialog');
        msgDiv.find('span').html(msg);
        msgDiv.removeClass('warningDialog');
        msgDiv.addClass('errorDialog');
        msgDiv.show();
        msgDiv.hide('highlight', {},
        3000,
        function() {});
    };

})(jQuery);
Date.prototype.Format = function(fmt) {
    var o = {
        "M+": this.getMonth() + 1,
        "d+": this.getDate(),
        "h+": this.getHours(),
        "m+": this.getMinutes(),
        "s+": this.getSeconds(),
        "q+": Math.floor((this.getMonth() + 3) / 3),
        "S": this.getMilliseconds()
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o) if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}
