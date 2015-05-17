<#setting number_format="#">
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8"/>
<title>Pikia</title>
<#include "../res/base.ftl">
<#import "../res/macro.ftl" as calendarMacro>
<!--Page Related styles-->
<link href="${rc.contextPath}/res/assets/css/dataTables.bootstrap.css" rel="stylesheet" />
<script type="text/javascript" src="${rc.contextPath}/res/assets/js/jquery.ba-hashchange.min.js"></script>
<script>
var firstClickMenu = location.hash;
$(function(){
  	$(window).hashchange(function() {
          admin.adminDoHash(location.hash);
  	});
});
</script>
<script src="${rc.contextPath}/res/js/user/index.js"></script>
</head>
<body>
<!--		loadingPage			-->
<@calendarMacro.loadingPage contextPath=rc.contextPath />
<!--		Navbar begin		-->
<@calendarMacro.navbarPage contextPath=rc.contextPath />
<!--		Navbar end			-->
<!-- Main Container -->
    <div class="main-container container-fluid">
        <!-- Page Container -->
        <div class="page-container">
        <!--		Page Sidebar begin		-->
		<@calendarMacro.sidebarPage contextPath=rc.contextPath />
		<!--		Page Sidebar end			-->
 		<!-- Page Content -->
            <div class="page-content">
                <!-- Page Breadcrumb -->
                <div class="page-breadcrumbs">
                    <ul class="breadcrumb">
                        <li>
                            <i class="fa fa-home" onclick="tk.load('${rc.contextPath}/d/page/user.user-list','',tk.menuFocus,[this]);">
                           	 <a href="#user.user-list">用户管理</a>
                            </i>
                        </li>
                        <li class="active">Dashboard</li>
                    </ul>
                </div>
                <!-- /Page Breadcrumb -->
                
                <!-- Page Header -->
                <div class="page-header position-relative">
                    <div class="header-title">
						<div class='goBack' onclick="javascript:history.back(-1);">返回</div>
						<div class="breadcrumbs sync_icon_div" style="display:none"> <a href="#1"><img src="${rc.contextPath}/res/assets/img/reflesh.gif"></a> </div>
						<span id="targetFixed" class="target_fixed"></span>
						<div class="welcome info"><img src="${rc.contextPath}/res/assets/img/icn_alert_info.png"><span style="margin-right: 14px;">欢迎使用，我们将全心全意为您服务！</span></div>
                    </div>
                    <!--Header Buttons-->
                    <div class="header-buttons">
                        <a class="sidebar-toggler" href="#">
                            <i class="fa fa-arrows-h"></i>
                        </a>
                        <a class="refresh" id="refresh-toggler" href="">
                            <i class="glyphicon glyphicon-refresh"></i>
                        </a>
                        <a class="fullscreen" id="fullscreen-toggler" href="#">
                            <i class="glyphicon glyphicon-fullscreen"></i>
                        </a>
                    </div>
                    <!--Header Buttons End-->
                </div>
                <!-- /Page Header -->
     
      			<!-- Page Body -->
                <div class="page-body">
                    <div class="row">
                        <div class="col-xs-12 col-md-12">
                            <div class="widget">
                                <div class="widget-header ">
                                    <span class="widget-caption">用户管理</span>
                                    <div class="widget-buttons">
                                        <a href="#" data-toggle="maximize">
                                            <i class="fa fa-expand"></i>
                                        </a>
                                        <a href="#" data-toggle="collapse">
                                            <i class="fa fa-minus"></i>
                                        </a>
                                        <a href="#" data-toggle="dispose">
                                            <i class="fa fa-times"></i>
                                        </a>
                                    </div>
                                </div>
                                <div class="widget-body" id="main">
                                
                                
                                
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Page Body -->
                
            </div>
            <!-- /Page Content -->
        </div>
        <!-- /Page Container -->
<!-- Main Container -->
         <#include "../res/endBase.ftl">
</body>
</html>






