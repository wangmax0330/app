<!doctype html>
<html>
<body>
<head>
<#include "../../res/base.ftl">
</head>

<#setting number_format="#">
<script type="text/javascript" src="${rc.contextPath}/res/plugin/blog/js/blog-list.js"></script>
<div class="alert_div">
	<div class='goBack' onclick="javascript:history.back(-1);"></div>
	<div class="breadcrumbs sync_icon_div" style="display:none"> <a href="#1"><img src="${rc.contextPath}/assets/images/reflesh.gif"></a> </div>
	<span id="targetFixed" class="target_fixed"></span>
    <h4 class="alert_message alert_info"><span>Welcome to the free MediaLoot admin panel template, this could be an informative message.</span></h4>
</div>
 <section id="main" class="column">
        <article class="module width_full">
            <header>
                <h3 class="tabs_involved">Content Manager</h3>
                <ul class="tabs">
                    <li><a href="#tab1">Posts</a></li>
                </ul>
            </header>
            <div class="tab_container">
                <div id="tab1" class="tab_content">
                    <div class="dataGridFilter">
                        <ul class="filterList">
                            <li><span>用户： </span>
                                <input type="text" class="input_text" value="" name="username">
                            </li>
                            <li><span>用户： </span>
                                <input type="text" class="input_text" value="" name="username">
                            </li>
                        </ul>
                        <ul class="filterList">
                            <li><span> 开始时间: </span>
                                <input class="datepicker input_text" type="text" name="search_start_date">
                            </li>
                            <li><span> 结束时间: </span>
                                <input class="datepicker input_text" type="text" onfocus="" value="Message">
                            </li>
                            <li>
                                <input type="button" value="搜索" class="quersy-btn btn">
                            </li>
                        </ul>
                    </div>
                    <table class="tablesorter" cellspacing="0">
                        <thead>
                            <tr>
                                <th>全选</th>
                                <th>博客名</th>
                                <th>博客作者</th>
                                <th>创建时间</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody id="blog_list_tbody">
                           
                           
                        </tbody>
                    </table>
                </div>
                <!-- end of #tab1 -->
                <!-- 如果是多tab,在这你append就可以 -->
            </div>
            <!-- end of .tab_container -->
            <div class="pagination" id="blog_list_pagination">
               
            </div>
        </article>
        <!-- end of content manager article -->
<#include "./blog_list_tmpl.ftl">
</body>