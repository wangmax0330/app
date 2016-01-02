<!--一级导航栏-->
<#macro header_bar contextPath active>
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">个人隐私007</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">Dashboard</a></li>
                    <li><a href="#">Settings</a></li>
                    <li><a href="${rc.contextPath}/web/blog_index">去博客首页</a></li>
                    <li><a href="#">退出</a></li>
                </ul>
                <form class="navbar-form navbar-right">
                    <input type="text" class="form-control" placeholder="Search...">
                </form>
            </div>
        </div>
    </nav>
</#macro>
<!---->

<!--二级导航栏-->
<#macro secondary_bar contextPath>

</#macro>

<#macro footer_left contextPath>
    <div class="footer_left">
   		<ul>
          <li><a href="#1"><img src="${rc.contextPath}/dev-lib/assets/images/m1.png"></a></li>
          <li><a class="submenu" ><img src="${rc.contextPath}/dev-lib/assets/images/m2.png"></a>
              <div class="drop_menu_div" style="display:none">
                <ul>
                    <li><a href="#1">新情境...</a></li>
                    <li><a href="#1">新项目...</a></li>
                    <li><a href="#1">新目标...</a></li>
                </ul>
                <i></i>
               </div>
          </li>
          <li ><a href="#1"><img src="${rc.contextPath}/dev-lib/assets/images/m3.png"></a></li>
        </ul>
    </div>
</#macro>
<!--载入loading效果-->
<#macro loadingPage contextPath>
<div class='loading_wp'>
	<div>
		<img src='${rc.contextPath}/dev-lib/assets/images/loading.gif' />
		<p><span class='colorBlue'>小提示</span>：正在进入后台管理系统!</p>
	</div>
</div>
</#macro>

<!--数据选择器-->
<#macro dataSelector single param...>
    <div class='add_workgrounp <#if single>single</#if>' style="background:#fff;margin:0;" >
    	<div class='grounp_add'>
    		<input class="selectedInput" id="${param["inputId"]}" name='${param["inputId"]}' value="${param["initIds"]}" type="hidden">
    		<a class="add_idcon" func="${param["func"]!''}"><i></i><#if param["title"]??>${param["title"]}<#else>用户</#if></a>
    		<a><input class="dataSelectorInput" relObjId="${param["relObjId"]!'0'}" relObjId2="${param["relObjId2"]!'0'}" action="${param["action"]}" style="border: none;height: 22px;" type='text' value=''></input></a> 
    	</div>
    	<div class="cwidthdiv" style="display:none;"></div>
    </div>
    <script>
    	var initIds = '${param["initIds"]}'.split(",");
    	var initVals = '${param["initVals"]}'.split(",");
    	if('${param["initIds"]}'!=""){
	    	var $add_idconInit = $("#${param["inputId"]}").closest(".add_workgrounp").find(".add_idcon");
	    	$.each(initIds,function(i){
	    		$add_idconInit.before("<span class='z' did='"+initIds[i]+"'>"+initVals[i]+"<i class='del-dataSelector'></i></span>");
	    	});
    	}
    </script>
</#macro>

<#macro imgPath>http://121.42.212.240/</#macro>