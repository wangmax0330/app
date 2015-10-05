var login = {} || login;
var b = new Base64();
$(function() {
	login.autoLogin = false;
	login.cookieName = '_work_cookie_login_name';
	login.cookieCompany = '_work_cookie_login_company';
	login.cookiePasword = '_work_cookie_login_pwd';
	login.cookieChk = '_work_cookie_login_chk';
	login.cookieUID = "_desed_gdpj";
	
	//$.Placeholder.init();
	//$("input[placeHolder]").powerFloat({ eventType: "focus", targetMode: "remind", targetAttr: "placeholder", position: "1-4" });
	$(".login_form input[name='userName']").focus();
	$('.loading_wp').show();
	$(".login_form").undelegate(".cancel","click").delegate(".cancel","click",function(){
		login.autoLogin = false;
		$('.login_form .submit').val('登录');
		$('.login_form .cancel').hide();
	});
	
	//如果设置了内存，直接登录x
	login.autoLogin = function(){
		if((""+window.location).indexOf('d-front/logout')>=0){
			$.removeCookie(login.cookieUID,{expires: 60,path: '/' });
			$.removeCookie(login.cookieName,{expires: 60,path: '/' });
			$.removeCookie(login.cookiePasword,{expires: 60,path: '/' });
			$.removeCookie(login.cookieChk,{expires: 60,path: '/' });
			$.removeCookie(login.cookieCompany,{expires: 60,path: '/' });
			$('.loading_wp').hide();
			return;
		}
		var canLogin = true;
		if(typeof $.cookie(login.cookieName)!='undefined' ){
			$(".login_form input[name='userName']").val($.cookie(login.cookieName));
		}else{
			canLogin =  false;
		}
		if(typeof $.cookie(login.cookiePasword)!='undefined' ){
			$(".login_form input[name='password']").val(b.decode($.cookie(login.cookiePasword)));
		}else{
			canLogin =  false;
		}
		if(typeof $.cookie(login.cookieChk)!='undefined' && $.cookie(login.cookieChk)=='1' && canLogin){
			$('.login_form input[type="checkbox"]').attr('checked',"true");
		}else{
			$('.login_form input[type="checkbox"]').removeAttr('checked');
			canLogin =  false;
		}
		if(canLogin){
			login.autoLogin = true;
			//$('.login_form .cancel').show();
			//$('.login_form .submit').val('3稍后自动登录');
			login.toLogin(true);
//			window.setTimeout(function(){
//				if(!login.autoLogin)return;
//				$('.login_form .submit').val('2稍后自动登录');
//				window.setTimeout(function(){
//					if(!login.autoLogin)return;
//					$('.login_form .submit').val('1稍后自动登录');
//					window.setTimeout(function(){
//						if(!login.autoLogin)return;
//						login.toLogin(true);
//						$('.login_form .cancel').hide();
//					},1000);
//
//				},1000);
//
//			},1000);
		}else{
			//show login page
			$('.loading_wp').hide();
		}
	}
	//-------------------------手动登陆
    var validate = true;
    login.toLogin = function(isAuto) {
        var userName = $(".login_form input[name='userName']");
        if (userName.val() == null || $.trim(userName.val()).length == 0) {
            validate = false;
        }
        var password = $(".login_form input[name='password']");
        if (password.val() == null || $.trim(password.val()).length == 0) {
            validate = false;
        }
        var submiBtn = $('.login_form .submit');
        if (validate == false) {
            submiBtn.val('登录');
            submiBtn.powerFloat({
                eventType: null,
                targetMode: "remind",
                target: "输入内容不能为空！",
                position: "2-1"
            });
            return false;
        }
        $(".loading").show();
       // alert($('.login_form input[type="checkbox"]').is(':checked'));
        if (validate) {
            $.ajax({
                url: contextPath + "/a/d-front/company/login",
                dataType: "json",
                type: "post",
                data: {
                    userName: userName.val(),
                    password: password.val()
                }
            }).done(function(data) {
                if (data.isSuc == '1') {
                    if (!isAuto) {
                        if ($('.login_form input[type="checkbox"]').is(':checked')) {
                            $.cookie(login.cookieName, userName.val(), {
                                expires: 60,
                                path: '/'
                            });
                            $.cookie(login.cookiePasword, b.encode(password.val()), {
                                expires: 60,
                                path: '/'
                            });
                            $.cookie(login.cookieChk, "1", {
                                expires: 60,
                                path: '/'
                            });
                            $.cookie(login.cookieCompany, $(".login_form input[name='company']").val(), {
                                expires: 60,
                                path: '/'
                            });
                        } else {
                            $.removeCookie(login.cookieName, {
                                expires: 60,
                                path: '/'
                            });
                            $.removeCookie(login.cookiePasword, {
                                expires: 60,
                                path: '/'
                            });
                            $.removeCookie(login.cookieChk, {
                                expires: 60,
                                path: '/'
                            });
                        }
                    }
                    if (typeof $.cookie(login.cookieUID) == 'undefined' || $.cookie(login.cookieUID) == "") {
                        var str = b.encode("jpd1psaaio" + data.uid);
                        $.cookie(login.cookieUID, str, {
                            expires: 60,
                            path: '/'
                        });
                    }
                    // if (data.role == 1) {
                    window.location = contextPath + "/d/page/index";
                    // }
                } else {
                    submiBtn.powerFloat({
                        eventType: null,
                        targetMode: "remind",
                        target: "用户名或密码错误！",
                        position: "2-1"
                    });
                    $(".loading").hide();
                    $('.loading_wp').hide();
                }
            });
        }
    };

    //---------------取消登陆
    $(".login_form").undelegate(".cancel", "click").delegate(".cancel", "click", function() {
        login.autoLogin = false;
        $('.login_form .submit').val('登录');
        $('.login_form .cancel').hide();
    });
    //----------------登陆
    $(".login_form").undelegate(".submit", "click").delegate(".submit", "click", function() {
    	//alert("click");
        login.toLogin(false);
    });
    
    $(".login_form").undelegate("input[name='userName']", "keydown").delegate("input[name='userName']", "keydown", function(e) {
        var key = e.which;
        if (key == 13) {
            $(".login_form input[name='password']").focus();
        }
    });
    $(".login_form").undelegate("input[name='password']", "keydown").delegate("input[name='password']", "keydown", function(e) {
        var key = e.which;
        if (key == 13) {
            login.toLogin(false);
        }
    });
    //---------------------执行自动登陆,如果有缓存cookie的话
    login.autoLogin();
});
