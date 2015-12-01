<!--一级导航栏-->
<#macro calendarHeader contextPath active>
	<script>
		var projectID = '${projectID!''}';
	</script>
   <header id="header">
        <hgroup>
            <h1 class="site_title"><a href="index.html">Website Admin</a></h1>
            <h2 class="section_title">
                <ul class="hd_info">
                    <li class=" c_color">
						<a>Dashboard</a>
						<i></i>
                    </li>
                    <li>
						<a>博客系统</a>
                    </li>
                    <li>
						<a>系统管理</a>
                    </li>
                </ul>
            </h2>
            <div class="btn_view_site"><a href="">View Site</a></div>
        </hgroup>
    </header>
</#macro>
<!---->

<!--二级导航栏-->
<#macro secondary_bar contextPath>
<section id="secondary_bar">
    <div class="user">
        <p>John Doe (<a href="#">3 Messages</a>)</p>
        <!-- <a class="logout_user" href="#" title="Logout">Logout</a> -->
    </div>
    <div class="breadcrumbs_container">
        <article class="breadcrumbs"><a href="index.html">Website Admin</a>
            <div class="breadcrumb_divider"></div> <a class="current">Dashboard</a>
            <div class="breadcrumb_divider"></div> <a class="current">web</a></article>
    </div>
</section>
</#macro>
<!------------------------------------>
<!--侧边栏:注意侧边栏的代码应该单独写到每个模块的index.ftl中,因为每个模块的侧边栏内容都不同-->
<#macro sidebarPage contextPath>
        <aside id="sidebar" class="column">
        <form class="quick_search">
            <input type="text" value="Quick Search" onfocus="if(!this._haschanged){this.value=''};this._haschanged=true;">
        </form>
        <hr/>
        <h3>Content</h3>
        <ul class="toggle">
            <li class="icn_new_article"><a href="#">New Article</a></li>
            <li class="icn_edit_article"><a href="#">Edit Articles</a></li>
            <li class="icn_categories"><a href="#">Categories</a></li>
            <li class="icn_tags"><a href="#">Tags</a></li>
        </ul>
        <h3>Users</h3>
        <ul class="toggle">
            <li class="icn_add_user"><a href="#">Add New User</a></li>
            <li class="icn_view_users"><a href="#">View Users</a></li>
            <li class="icn_profile"><a href="#">Your Profile</a></li>
        </ul>
        <h3>Media</h3>
        <ul class="toggle">
            <li class="icn_folder"><a href="#">File Manager</a></li>
            <li class="icn_photo"><a href="#">Gallery</a></li>
            <li class="icn_audio"><a href="#">Audio</a></li>
            <li class="icn_video"><a href="#">Video</a></li>
        </ul>
        <h3>Admin</h3>
        <ul class="toggle">
            <li class="icn_settings"><a href="#">Options</a></li>
            <li class="icn_security"><a href="#">Security</a></li>
            <li class="icn_jump_back"><a href="#">Logout</a></li>
        </ul>
        <footer>
            <hr />
            <p><strong>Copyright &copy; 2011 Website Admin</strong></p>
            <p>Theme by <a href="http://www.medialoot.com">MediaLoot</a></p>
        </footer>
        </aside>
</#macro>
<!--载入loading效果-->
<#macro loadingPage contextPath>
<div class='loading_wp'>
	<div>
		<img src='${rc.contextPath}/assets/images/loading.gif' />
		<p><span class='colorBlue'>小提示</span>：正在进入后台管理系统!</p>
	</div>
</div>
</#macro>
<!---->
<#macro alertMessageDiv contextPath>
	<div class="alert_div">
	    <h4 class="alert_info"><span>Welcome to the free MediaLoot admin panel template, this could be an informative message.</span></h4>
	    <h4 class="alert_warning"><span>A Warning Alert</span></h4>
	    <h4 class="alert_error"><span>An Error Message</span></h4>
	    <h4 class="alert_success"><span>A Success Message</span></h4>
    </div>
</#macro>
<#macro imgPath>http://img.jdsao.com</#macro>