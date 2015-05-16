<#setting number_format="#">
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8"/>
<title>用户管理</title>
<#include "../res/base.ftl">
<#import "../res/macro.ftl" as calendarMacro>
<!--Page Related styles-->
<link href="${rc.contextPath}/res/assets/css/dataTables.bootstrap.css" rel="stylesheet" />
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
                            <i class="fa fa-home"></i>
                            <a href="#">Home</a>
                        </li>
                        <li class="active">Dashboard</li>
                    </ul>
                </div>
                <!-- /Page Breadcrumb -->
                
                
                <!-- Page Header -->
                <div class="page-header position-relative">
                    <div class="header-title">
                        <h1>
                            Dashboard
                        </h1>
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
                                    <span class="widget-caption">Expandable DataTable</span>
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
                                <div class="widget-body">
                                    <table class="table table-striped table-bordered table-hover" id="expandabledatatable">
                                        <thead>
                                            <tr>
                                                <th style="width: 10px;">
                                                    Name
                                                </th>
                                                <th style="width: 10px;">
                                                    Family
                                                </th>
                                                <th>
                                                    Age
                                                </th>
                                                <th>
                                                    Position
                                                </th>
                                                <th>
                                                   Picture 
                                                </th>
                                                <th>Interests</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <tr>
                                                <td>
                                                    Nicolai
                                                </td>
                                                <td>
                                                    Larson
                                                </td>
                                                <td>
                                                    27
                                                </td>
                                                <td>
                                                    Software Manager
                                                </td>
                                                <td>
                                                    Swimming
                                                </td>
                                                <td>
                                                    Nicolai-Larson.jpg
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    Divya
                                                </td>
                                                <td>
                                                    Johnson
                                                </td>
                                                <td>
                                                    22
                                                </td>
                                                <td>
                                                    Software Developer
                                                </td>
                                                <td>
                                                    Jugging
                                                </td>
                                                <td>
                                                    divyia.jpg
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    Javi
                                                </td>
                                                <td>
                                                    Jimenez
                                                </td>
                                                <td>
                                                    32
                                                </td>
                                                <td>
                                                    Software Developer
                                                </td>
                                                <td>
                                                    Gaming
                                                </td>
                                                <td>
                                                    Javi-Jimenez.jpg
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    Osvaldus
                                                </td>
                                                <td>
                                                    Valutis
                                                </td>
                                                <td>
                                                    29
                                                </td>
                                                <td>
                                                    Software Analyst
                                                </td>
                                                <td>
                                                    Swimming,Gaming
                                                </td>
                                                <td>
                                                    Osvaldus-Valutis.jpg
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    Lee
                                                </td>
                                                <td>
                                                    Munroe
                                                </td>
                                                <td>
                                                    21
                                                </td>
                                                <td>
                                                    Software Developer
                                                </td>
                                                <td>
                                                    Swimming,Gaming
                                                </td>
                                                <td>
                                                    Lee-Munroe.jpg
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    Sergey
                                                </td>
                                                <td>
                                                    Azovskiy
                                                </td>
                                                <td>
                                                    40
                                                </td>
                                                <td>
                                                    SEO
                                                </td>
                                                <td>
                                                    Napping
                                                </td>
                                                <td>
                                                    Sergey-Azovskiy.jpg
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
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
	    <script>
	        InitiateExpandableDataTable.init();
	    </script>
</body>
</html>






