<#setting number_format="#">
<!doctype html>
<html>

<head>
    <meta charset="utf-8" />
    
    <#include "../../res/base.ftl">
	<#import "../../res/macro.ftl" as calendarMacro>
	
    <link rel="stylesheet" href="${rc.contextPath}/assets/js/plugin/kindeditor/themes/default/default.css" />
    <script charset="utf-8" src="${rc.contextPath}/assets/js/plugin/kindeditor/kindeditor-min.js"></script>
    <script charset="utf-8" src="${rc.contextPath}/assets/js/plugin/kindeditor/lang/zh_CN.js"></script>
    <style>
    .error {padding: 3px 0 3px 20px;width: 210px;display: none;color: red}
    .loading {color: #999999;display: none;font-size: 12px;margin-left: 10px;}
    </style>
</head>

<body>
    <!--页面过渡的效果,在载入js插件的时候显示-->
    <@calendarMacro.loadingPage contextPath=rc.contextPath />
    
    <div class="alert_div">
        <div class='goBack' onclick="javascript:history.back(-1);"></div>
		<div class="breadcrumbs sync_icon_div" style="display:none"> <a href="#1"><img src="${rc.contextPath}/assets/images/reflesh.gif"></a> </div>
		<span id="targetFixed" class="target_fixed"></span>
	    <h4 class="alert_message alert_info"><span>Welcome to the free MediaLoot admin panel template, this could be an informative message.</span></h4>
    </div>
    <section id="main" class="column">
        <header>
            <h3></h3>
        </header>
        <form class="form-blog-edit" action="${rc.contextPath}/a/blog/saveBlog" method="post">
            <input type="hidden" name="uid" value="1" />
            <input type="hidden" name="publishState" value="1" />
            <input type="hidden" name="id" value="<#if blogDomain??>${blogDomain.id!''}<#else>0</#if>"/>
            <div class="module_content" id="_blog">
                <fieldset>
                    <label style="width:50px;">标题</label>
                    <input type="text" name="title" style="width:48%;" value="${blogDomain.title!''}">
                    <label class="error">请填写促销活动标题!</label>
                </fieldset>
                <fieldset style="width:48%; float:left; margin-right: 3%;">
                    <!-- to make two field float next to one another, adjust values accordingly -->
                    <label>Category</label>
                    <div class="clear"></div>
                    <select style="width:100px;">
                        <option>Articles</option>
                        <option>Tutorials</option>
                        <option>Freebies</option>
                    </select>
                    <select style="width:100px;">
                        <option>Articles</option>
                        <option>Tutorials</option>
                        <option>Freebies</option>
                    </select>
                </fieldset>
                <fieldset style="width:48%; float:left;">
                    <!-- to make two field float next to one another, adjust values accordingly -->
                    <label>Tags</label>
                    <input type="text" style="width:92%;">
                </fieldset>
                <fieldset>
                    <label>内容</label>
                    <textarea name="content" style="height:500px;">${blogDomain.content!''}</textarea>
                </fieldset>
                <div class="clear"></div>
            </div>
            <footer>
                <div class="submit_link">
                    <input id="clear_blog" type="submit" value="清空">
                    <select>
                        <option>草稿箱</option>
                        <option>立刻发布</option>
                    </select>
                    <form method="post" target="_blank" action="http://www.go108.com.cn/go108_mobile_free_sz.php">
                        <input id="save_blog" type="submit" value="立刻发布" class="alt_btn">
                        <span class='loading'><img src="${rc.contextPath}/assets/images/reflesh.gif"/>正在保存...</span>
                    </form>
                </div>
            </footer>
        </form>
    </section>
    <script type="text/javascript" src="${rc.contextPath}/res/plugin/blog/js/blog-edit.js"></script>
</body>
</html>
