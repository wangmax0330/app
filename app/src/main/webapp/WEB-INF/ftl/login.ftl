<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>一片叶子飘到脸上,偶然麽...</title>
<link rel="icon" href="${rc.contextPath}/dev-lib/assets/icon48x48.png">
<link rel="stylesheet" href="${rc.contextPath}/res/plugin/login/css/register.css" type="text/css" media="screen" />
<script type="text/javascript" src="${rc.contextPath}/dev-lib/assets/js/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/dev-lib/assets/js/jquery/jquery.placeholder.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/dev-lib/assets/js/jquery/jquery.cookie.js"></script>
<link rel="stylesheet" href="${rc.contextPath}/dev-lib/assets/js/powerFloat/powerFloat.css"  />
<script type="text/javascript" src="${rc.contextPath}/dev-lib/assets/js/powerFloat/jquery-powerFloat-min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/dev-lib/assets/js/basic/base64.js"></script>
<script type="text/javascript" src="${rc.contextPath}/res/plugin/login/js/login.js"></script>
<script type="text/javascript">
	var contextPath = '${rc.contextPath}';
</script>
</head>
<body>
<div class='loading_wp'>
	<div>
		<img src='${rc.contextPath}/dev-lib/assets/images/loading.gif' />
		<p><span class='colorBlue'>小提示</span>:正在进入后台管理系统!</p>
	</div>
</div>
<div class='signup_container'>
        <#--<form class="signup_form_form" id="signup_form" method="post" action="" data-secure-action="https://www.tumblr.com/login" data-secure-ajax-action="">-->
          <div class="login_form">
                <h3>用户登录 </h3>
                <table cellpadding="0" cellspacing="0">
                    <tr>
                        <td width="40px">帐&nbsp;号:</td>
                        <td>
                            <input type="text" name="userName" placeHolder='帐号/手机/邮箱' class="text" />
                        </td>
                    </tr>
                    <tr>
                        <td>密&nbsp;码:</td>
                        <td>
                            <input type="password" name="password" class="text" />
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>
                            <input type="checkbox">60天免登录&nbsp;&nbsp;&nbsp;&nbsp; <a href="#1">忘记密码?</a><a href="#1">注册</a></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>
                            <input type="button" class="submit" value='登录' />
                            <input type="button" style="display:none" class="cancel btn" value='取消' /><span class='loading'><img src="${rc.contextPath}/dev-lib/assets/images/reflesh.gif"/>正在登陆...</span></td>
                    </tr>
                </table>
            </div>
        <#--</form>-->
    <p class='copyright'>Copyright © 2015 Methew. All Rights Reserved.</p>
</div>
</body>
</html>