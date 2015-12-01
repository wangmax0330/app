<#setting number_format="#">
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8"/>
<title></title>
<#include "../../res/base.ftl">
<#import "../../res/macro.ftl" as calendarMacro>
<script type="text/javascript" src="${rc.contextPath}/assets/js/plugin/jquery/jquery.ba-hashchange.min.js"></script>
<script>
var firstClickMenu = location.hash;
$(function(){
  	$(window).hashchange(function() {
          coupon.couponDoHash(location.hash);
  	});
});
</script>
<script type="text/javascript" src="${rc.contextPath}/res/js/plugin/blog/index.js"></script>
</head>

<body>
<@calendarMacro.loadingPage contextPath=rc.contextPath />
<!--header Begin-->
<@calendarMacro.calendarHeader contextPath=rc.contextPath active=1/>
<!--header End-->
<!--secondary_bar Begin-->
<@calendarMacro.secondary_bar contextPath=rc.contextPath/>
<!--secondary_bar Ends-->

<div class="clear"><!----></div>
<div class="wp">
<!--sidebar Begin-->
<div id="sidebar" class="column">
   <div class="menu">
      <h3>广场推送</h3>
    <ul class="toggle">
           <li class="icn_photo"><a  href="#admin.ad.ad-list"  onclick="tk.load('${rc.contextPath}/d/page/admin.ad.ad-list','',tk.menuFocus,[this]);">广场推送</a></li>
    </ul>
    <h3>促销活动</h3>
    <ul class="toggle">
          <li class="icn_photo"><a  href="#coupon.coupon-list"  onclick="tk.load('${rc.contextPath}/d/page/coupon.coupon-list','',tk.menuFocus,[this]);">已上架</a></li>
          <li class="icn_photo"><a  href="#coupon.coupon-list-index"  onclick="tk.load('${rc.contextPath}/d/page/coupon.coupon-list-index','',tk.menuFocus,[this]);">广场</a></li>
          <li class="icn_photo"><a  href="#coupon.coupon-list-unpub"  onclick="tk.load('${rc.contextPath}/d/page/coupon.coupon-list-unpub','',tk.menuFocus,[this]);">待上架</a></li>
          <li class="icn_photo"><a  href="#coupon.coupon-list-passdate"  onclick="tk.load('${rc.contextPath}/d/page/coupon.coupon-list-passdate','',tk.menuFocus,[this]);">已过期</a></li>
          <li class="icn_photo"><a  href="#coupon.coupon-list-guidang"  onclick="tk.load('${rc.contextPath}/d/page/coupon.coupon-list-guidang','',tk.menuFocus,[this]);">已归档</a></li> 
          <li class="icn_photo"><a  href="#coupon.coupon-new"  onclick="tk.load('${rc.contextPath}/d/coupon/preEdit/0','',tk.menuFocus,[this]);">添加促销</a></li>
    </ul>
    
    <h3>返利管理</h3>
    <ul class="toggle">
          <li class="icn_photo"><a  href="#coupon.rebate-list"  onclick="tk.load('${rc.contextPath}/d/page/coupon.rebate-list','',tk.menuFocus,[this]);">已上架</a></li>
          <li class="icn_photo"><a  href="#coupon.rebate-list-unpub"  onclick="tk.load('${rc.contextPath}/d/page/coupon.rebate-list-unpub','',tk.menuFocus,[this]);">待上架</a></li>
          <li class="icn_photo"><a  href="#coupon.rebate-list-passdate"  onclick="tk.load('${rc.contextPath}/d/page/coupon.rebate-list-passdate','',tk.menuFocus,[this]);">已过期</a></li>
          <li class="icn_photo"><a  href="#coupon.rebate-list-guidang"  onclick="tk.load('${rc.contextPath}/d/page/coupon.rebate-list-guidang','',tk.menuFocus,[this]);">已归档</a></li> 
          <li class="icn_photo"><a  href="#coupon.rebate-new"  onclick="tk.load('${rc.contextPath}/d/rebate/preEdit/0','',tk.menuFocus,[this]);">添加返利</a></li>
          <li class="icn_photo"><a  href="#coupon.rebateTask-list"  onclick="tk.load('${rc.contextPath}/d/rebateTask/preEdit/0','',tk.menuFocus,[this]);">返利任务</a></li>
    </ul>
     <h3>问题管理</h3>
	    <ul class="toggle">  	  
	    	<li class="icn_photo"><a  href="#customerService.quetion-list"  onclick="tk.load('${rc.contextPath}/d/page/customerService.quetion-list','',tk.menuFocus,[this]);">问题管理</a></li>
	    </ul>
     <!--h3>小票匹配管理</h3>
    <ul class="toggle">
          <li class="icn_photo"><a  href="#coupon.recipt_no_coupon-list"  onclick="tk.load('${rc.contextPath}/d/page/coupon.recipt_no_coupon-list','',tk.menuFocus,[this]);">待匹配</a></li>
          <li class="icn_photo"><a  href="#coupon.recipt_has_coupon-list"  onclick="tk.load('${rc.contextPath}/d/page/coupon.recipt_has_coupon-list','',tk.menuFocus,[this]);">已匹配</a></li>
    </ul-->
    
     <h3>抽奖活动</h3>
    <ul class="toggle">
    	 <li class="icn_photo"><a  href="#coupon.coupon-list-lottory"  onclick="tk.load('${rc.contextPath}/d/page/coupon.coupon-list-lottory','',tk.menuFocus,[this]);">抽奖管理</a></li>
          <li class="icn_photo"><a  href="#coupon.coupon-list-activ2"  onclick="tk.load('${rc.contextPath}/d/page/coupon.coupon-list-activ2','',tk.menuFocus,[this]);">老版抽奖</a></li>
    </ul>
    
     <h3>月返管理</h3>
    <ul class="toggle">
          <li class="icn_photo"><a  href="#coupon.monthrebate-list"  onclick="tk.load('${rc.contextPath}/d/page/coupon.monthrebate-list','',tk.menuFocus,[this]);">月返</a></li>
    </ul>
    
    <h3>活动分享</h3>
    <ul class="toggle">
          <li class="icn_photo"><a  href="#coupon.spread.coupon-list-spread"  onclick="tk.load('${rc.contextPath}/d/page/coupon.spread.coupon-list-spread','',tk.menuFocus,[this]);">发起活动</a></li>
    </ul>
    <!--h3>活动奖励</h3>
    <ul class="toggle">
          <li class="icn_photo"><a onclick="tk.load('${rc.contextPath}/d/page/coupon.prize-list','',tk.menuFocus,[this]);" href="#coupon.prize-list">奖品管理</a></li>
    </ul-->
    
         
    <!--h3>基础设置</h3>
    <ul class="toggle">
          <li class="icn_categories  on"><a href="#currentIterators.html" onClick="tk.load('${rc.contextPath}/d/page/admin.charts.project-charts','',tk.menuFocus,[this]);">项目统计</a></li>
          <li class="icn_new_article"><a  href="#projectIterators.html" onClick="tk.load('${rc.contextPath}/d/page/admin.charts.user-charts','',tk.menuFocus,[this]);">人员统计</a></li>
          <li class="icn_photo"><a  href="#admin.usersCalendar.user-list"  onclick="tk.load('${rc.contextPath}/d/page/admin.userCalendar.user-list','',tk.menuFocus,[this]);">用户日志</a></li>
        </ul-->
    
    </div>
  <@calendarMacro.footer_left contextPath=rc.contextPath/>
</div>
<!--sidebar Ends-->

<!--main Begin-->
<div id="main" class="column frame_right_container" >

    
     
  
</div>
<!--main Ends-->
</div>
</body>
</html>