<#setting number_format="#">
<!doctype html>
<html lang="en">

<head>
    <#include "../res/base.ftl">
	<#import "../res/macro.ftl" as calendarMacro>
    <script type="text/javascript" src="${rc.contextPath}/dev-lib/assets/js/jquery/jquery.ba-hashchange.min.js"></script>
    <script>
    var firstClickMenu = location.hash;
    $(function() {
        $(window).hashchange(function() {
            blog.blogDoHash(location.hash);
        });
    });
    </script>
    <script type="text/javascript" src="${rc.contextPath}/res/plugin/blog/js/index.js"></script>
</head>

<body>
    <@calendarMacro.loadingPage contextPath=rc.contextPath />
    <!--header Begin-->
    <@calendarMacro.header_bar contextPath=rc.contextPath active=1/>
    <!--header End-->
    <div class="clear">
        <!---->
    </div>
    <div class="container-fluid">
        <!--sidebar Begin-->
        <div class="row">
            <div class="col-sm-3 col-md-2 sidebar" id="sidebar">
                <ul class="nav nav-sidebar">
                    <li><a href="#">Overview <span class="sr-only">(current)</span></a></li>
                    <li><a href="#blog.blog-index">Dashboard </a></li>
                    <li><a href="#blog.blog-analytics">Analytics</a></li>
                    <li><a href="#">大数据</a></li>
                    <li class="icn_photo"><a href="#customerService.quetion-list" onclick="tk.load('${rc.contextPath}/d/page/customerService.quetion-list','',tk.menuFocus,[this]);">问题管理</a></li>
                </ul>
                <ul class="nav nav-sidebar">
                    <li><a href="#blog.blog-new" onclick="tk.load('${rc.contextPath}/d/blog/editBlog/0','',tk.menuFocus,[this]);">写一篇博客</a></li>
                    <li><a href="#blog.blog-list" onclick="tk.load('${rc.contextPath}/d/page/blog.blog_list','',tk.menuFocus,[this]);">博客列表</a></li>
                    <li><a href="#blog.blog-tags" onclick="tk.load('${rc.contextPath}/d/tag/showAllTag','',tk.menuFocus,[this]);">博客标签</a></li>
                    <li><a href="">...</a></li>
                    <li><a href="">...</a></li>
                </ul>
                <ul class="nav nav-sidebar">
                    <li><a href="">...</a></li>
                    <li><a href="">...</a></li>
                    <li><a href="">...</a></li>
                </ul>
            </div>
        </div>
        <!--sidebar Ends-->
        <!--main Begin-->
        <div class="row">
            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" id="main">
              
            </div>
        </div>
    </div>
    <!--main Ends-->
</body>

</html>
