<#macro webHeader contextPath active>
 <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Mock 君</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav blog-nav">
                    <li <#if active==1>class="active"</#if>><a href="${rc.contextPath}/web/blog_index">Home</a></li>
                    <li <#if active==2>class="active"</#if>><a href="${rc.contextPath}/web/blog_assort">分类</a></li>
                    <li <#if active==3>class="active"</#if>><a href="${rc.contextPath}/web/blog_collect">开发珍藏</a></li>
                    <li <#if active==4>class="active"</#if>><a href="${rc.contextPath}/web/blog_mine">生活感悟</a></li>
                    <!--<li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">小应用 <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">音乐播放器</a></li>
                            <li><a href="#">..</a></li>
                            <li role="separator" class="divider"></li>
                            <li class="dropdown-header">暂无</li>
                            <li><a href="#">...</a></li>
                            <li><a href="#">...</a></li>
                        </ul>
                    </li>-->
                </ul>
                <ul class="nav navbar-nav navbar-right">
                  
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
    </nav>
</#macro>

<!--个人信息描述-->
<#macro webPersonDesc>
	<div class="sidebar-module sidebar-module-inset">
	    <h4>About</h4>
	    <p>我曾臆想过这事情有多么的复杂难以完成,但最终还是慢慢完成了...</p>
	    <p></p>
	</div>
</#macro>

<#macro webFooter contextPath>
  <footer class="blog-footer">
        <p>This land is contracted by by <a href="">@Methew</a>.</p>
        <p>
            <a href="#">Back to top</a>
        </p>
  </footer>
</#macro>


<#macro imgPath>http://121.42.212.240/</#macro>