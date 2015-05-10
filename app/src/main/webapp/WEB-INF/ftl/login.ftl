<#setting number_format="#">
﻿<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<!--Head-->
<head>
    <meta charset="utf-8" />
    <title>登录</title>
    <meta name="description" content="login page" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="shortcut icon" href="${rc.contextPath}/res/assets/img/favicon.png" type="image/x-icon">
    <!--Basic Styles-->
    <link href="${rc.contextPath}/res/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link id="bootstrap-rtl-link" href="" rel="stylesheet" />
    <link href="${rc.contextPath}/res/assets/css/font-awesome.min.css" rel="stylesheet" />
    <!--Beyond styles-->
    <link id="beyond-link" href="${rc.contextPath}/res/assets/css/beyond.min.css" rel="stylesheet" />
    <link href="${rc.contextPath}/res/assets/css/demo.min.css" rel="stylesheet" />
    <link href="${rc.contextPath}/res/assets/css/animate.min.css" rel="stylesheet" />
    <link id="skin-link" href="" rel="stylesheet" type="text/css" />
    <!--Skin Script: Place this script in head to load scripts for skins and rtl support-->
    <script src="${rc.contextPath}/res/assets/js/skins.min.js"></script>
</head>
<!--Head Ends-->
<!--Body-->
<body>
    <div class="login-container animated fadeInDown">
        <div class="loginbox bg-white">
            <div class="loginbox-title">登录</div>
            <div class="loginbox-social">
                <div class="social-title ">Connect with Your Social Accounts</div>
                <div class="social-buttons">
                    <a href="" class="button-facebook">
                        <i class="social-icon fa fa-facebook"></i>
                    </a>
                    <a href="" class="button-twitter">
                        <i class="social-icon fa fa-twitter"></i>
                    </a>
                    <a href="" class="button-google">
                        <i class="social-icon fa fa-google-plus"></i>
                    </a>
                </div>
            </div>
            <div class="loginbox-or">
                <div class="or-line"></div>
                <div class="or">OR</div>
            </div>
            <div class="loginbox-textbox">
                <input type="text" class="form-control" placeholder="Email" />
            </div>
            <div class="loginbox-textbox">
                <input type="text" class="form-control" placeholder="Password" />
            </div>
            <div class="loginbox-forgot">
                <a href="">忘记密码?</a>
            </div>
            <div class="loginbox-submit">
                <input type="button" class="btn btn-primary btn-block" value="Login">
            </div>
            <div class="loginbox-signup">
                <a href="">Sign Up With Email</a>
            </div>
        </div>
        <div class="logobox">
        </div>
    </div>
</body>
<!--Body Ends-->
</html>
