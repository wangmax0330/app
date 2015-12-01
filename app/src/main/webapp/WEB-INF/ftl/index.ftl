<#setting number_format="#">
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8"/>
	<title>中心城</title>
	<#include "res/base.ftl">
	<#import "res/macro.ftl" as calendarMacro>
</head>


<body>
	<@calendarMacro.loadingPage contextPath=rc.contextPath />
	<!--header Begin-->
	<@calendarMacro.calendarHeader contextPath=rc.contextPath active=2/>
	<!--header End-->
	<!--secondary_bar Begin-->
	<@calendarMacro.secondary_bar contextPath=rc.contextPath/>
	<!--secondary_bar Ends-->
	
	
	<!--sidebarPage Begin-->
	<@calendarMacro.sidebarPage contextPath=rc.contextPath/>
	<!--sidebarPage Ends-->
	  <div class="alert_div">
	    <h4 class="alert_info"><span>Welcome to the free MediaLoot admin panel template, this could be an informative message.</span></h4>
	    <h4 class="alert_warning"><span>A Warning Alert</span></h4>
	    <h4 class="alert_error"><span>An Error Message</span></h4>
	    <h4 class="alert_success"><span>A Success Message</span></h4>
       </div>
 <section id="main" class="column">
        <article class="module width_full">
            <header>
                <h3>Stats</h3></header>
            <div class="module_content">
                <article class="stats_graph">
                    <img src="http://chart.apis.google.com/chart?chxr=0,0,3000&chxt=y&chs=520x140&cht=lc&chco=76A4FB,80C65A&chd=s:Tdjpsvyvttmiihgmnrst,OTbdcfhhggcTUTTUadfk&chls=2|2&chma=40,20,20,30" width="520" height="140" alt="" />
                </article>
                <article class="stats_overview">
                    <div class="overview_today">
                        <p class="overview_day">Today</p>
                        <p class="overview_count">1,876</p>
                        <p class="overview_type">Hits</p>
                        <p class="overview_count">2,103</p>
                        <p class="overview_type">Views</p>
                    </div>
                    <div class="overview_previous">
                        <p class="overview_day">Yesterday</p>
                        <p class="overview_count">1,646</p>
                        <p class="overview_type">Hits</p>
                        <p class="overview_count">2,054</p>
                        <p class="overview_type">Views</p>
                    </div>
                </article>
                <div class="clear"></div>
            </div>
        </article>
        <article class="module width_full">
            <header>
                <h3>Basic Styles</h3></header>
            <div class="module_content">
                <h1>Header 1</h1>
                <h2>Header 2</h2>
                <h3>Header 3</h3>
                <h4>Header 4</h4>
                <p>Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Cras mattis consectetur purus sit amet fermentum. Maecenas faucibus mollis interdum. Maecenas faucibus mollis interdum. Cras justo odio, dapibus ac facilisis in, egestas eget quam.</p>
                <p>Donec id elit non mi porta <a href="#">link text</a> gravida at eget metus. Donec ullamcorper nulla non metus auctor fringilla. Cras mattis consectetur purus sit amet fermentum. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum.</p>
                <ul>
                    <li>Donec ullamcorper nulla non metus auctor fringilla. </li>
                    <li>Cras mattis consectetur purus sit amet fermentum.</li>
                    <li>Donec ullamcorper nulla non metus auctor fringilla. </li>
                    <li>Cras mattis consectetur purus sit amet fermentum.</li>
                </ul>
            </div>
        </article>
</body>

</html>