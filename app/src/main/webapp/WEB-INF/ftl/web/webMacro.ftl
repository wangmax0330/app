


<#macro webHeader contextPath active>
  <div class="header">
    <div class="grid"><a href="#1" class="logo"><img src="${contextPath}/res/images/web/logo.png" alt='集豆'/></a>
      <ul class="nav clearfix">
        <li><a href="${contextPath}/web/index" <#if active==1>class="on"</#if>><span>首页</span></a></li>
        <#if false><li><a href="${contextPath}/web/mall" <#if active==3>class="on"</#if>><span>提货券</span></a></li></#if>
        <li><a href="${contextPath}/web/page/web.cooperation" <#if active==2>class="on"</#if>><span>合作</span></a></li>
        <li><a href="${contextPath}/web/page/web.about" <#if active==4>class="on"</#if>><span>关于我们</span></a></li>
      </ul>
    </div>
  </div>
   
</#macro>
<#macro webDownJs>
function a(apkName,qqApk){
	var ua = navigator.userAgent.toLowerCase();
    if (/iphone|ipod/.test(ua)) {
        if(/micromessenger/.test(ua)){
        	window.location="http://a.app.qq.com/o/simple.jsp?pkgname=com.jidou.jdsao";
        }else{
        	window.location="https://itunes.apple.com/us/app/pai-pai-fan-li/id874721776?l=zh&ls=1&mt=8";
        }
    }else if (/android/.test(ua)) {
        if(/micromessenger/.test(ua)){
        	window.location="http://a.app.qq.com/o/simple.jsp?pkgname=com.jidou.jdsao";
        }else{
        	if(!apkName)apkName = "com.jidou.jdsao.apk";
    		if(/MQQBrowser/.test(ua)){
    			if(qqApk){
    				window.location="http://img.jdsao.com/uploads/install/"+apkName;
    			}else{
    				window.location="http://img.jdsao.com/uploads/install/"+apkName;
    			}
    		}else{
    			window.location="http://img.jdsao.com/uploads/install/"+apkName;
    		}
        }
    }else{
    	window.location="http://www.jdsao.com";
    }
    
}

</#macro>
<#macro webFooter contextPath>
  <div class="grid footer">
    <p><a href="${contextPath}/web/page/web.about">关于我们</a><span>|</span><a href="${contextPath}/web/page/web.promotew">许可及服务协议</a><span>|</span><a href="${contextPath}/web/page/web.cooperation">合作</a></p>
    <div>www.jdsao.com 2014-2017 © All Rights Reserved.<br />
      沪ICP备14042936号-1</div>
  </div>
</#macro>

<#macro webDownloadArea contextPath>
<div class="download_area" id="download">
    <div class="grid1 posRelative  clearfix">
    <dl>
    	<dt>
      <h3><img src="${contextPath}/res/images/web/d_title.png" alt='集豆iphone下载'/></h3>
      <ul class="clearfix">
        <li><a href="https://itunes.apple.com/us/app/pai-pai-fan-li/id874721776?l=zh&ls=1&mt=8"><img src="${contextPath}/res/images/web/d1.png" alt='appStore下载'/></a></li>
        <li><a href="${contextPath}/res/p1paifanli.ipa"><img src="${contextPath}/res/images/web/d4.png" alt='本地ipa文件下载'/></a></li>
      </ul>
      </dt>
      <dd>
       <h3 style="margin-left:64px"><img src="${contextPath}/res/images/web/d_title1.png" alt='集豆android下载'/></h3>
      <ul style="margin-left:64px">
        <li><a href="#1"><img src="${contextPath}/res/images/web/d5.png" alt='360下载'/></a></li>
        <li><a href="${contextPath}/res/com.jidou.jdsao.apk"><img src="${contextPath}/res/images/web/d6.png" alt='本地apk下载'/></a></li>
      </ul>
      </dd>
      <dd class="erweima">
      	<h3 style="margin-left:120px"><img src="${contextPath}/res/images/web/d_title3.png" alt='扫描二维码'/></h3>
        <p class="alignRight"><img src="${contextPath}/res/images/web/erweima1.png" /></p>
      </dd>
      </dl>
      
      </div>
  </div>
</#macro>

<#macro webLoginDiv contextPath>
<div id="login_div" style="display:none">
	<div class="shadow"></div>
	<div class="shadowInner"></div>
	<div class="login">
		<div class="loginInner">
	    	<h3><a href="javascript:void(0);" onclick="$('#login_div').hide();$('#login_div .error').hide();$('#login_div .loginname').val('');$('#login_div .loginpwd').val('');" title="关闭" class="close"></a></h3>
	        <form id="login_frm" action="${contextPath}/web/loginw" method="post">
	        <p class='linfo'>
	        请输入集豆手机端绑定的手机号及密码
	        </p>
	        <table cellpadding="0" cellspacing="0">
	        	<tr><td class="td1">手机号:</td><td class="td2"><input type="text" name="name"  class="text loginname"/></td></tr>
	            <tr><td  class="td1">密&nbsp;&nbsp;&nbsp;码:</td><td  class="td2"><input type="password" name="pwd" class="text loginpwd" /></td></tr>
	            <tr><td colspan="2"><input type="submit" class="loginBut"  value="登录"/></td></tr>
	            <tr><td class="forget" colspan="2"><span class="grey">您还没有集豆账号请<a href="${rc.contextPath}/web/registTip" title="注册">注册</a></span></td></tr>
	            <tr>
	            	<td colspan="2">
	                	<p>使用其他方式登录</p>
	                    <a onclick="return window.open('${rc.contextPath}/qq/login.do', 'oauth2Login_10585' ,'height=525,width=585, toolbar=no, menubar=no, scrollbars=no, status=no, location=yes, resizable=yes');" href="javascript:;" title="QQ登录" class="loginIco"><img src="http://qzonestyle.gtimg.cn/qzone/vas/opensns/res/img/Connect_logo_7.png" /></a>
	                </td>
	            </tr>
	        </table>
	        </form>
	    </div>
	</div>
</div>
</#macro>

<#macro wwebMenuFixDiv contextPath active>
	<div class="menu clearfix">
		<div class="grid">
			<a class="logo"><img src="${rc.contextPath}/res/images/wapimg/logo.png"></a>
			<ul>
				<li class="ico_dh"><a href="${rc.contextPath}/web/windex" <#if active=1>class="on"</#if>><span>兑换产品</span></a></li>
				<li class="ico_kc"><a href="${rc.contextPath}/web/toWstock" <#if active=2>class="on"</#if>><span>查看库存</span></a></li>
				<li class="ico_kc"><a href="${rc.contextPath}/web/toBill/0" <#if active=3>class="on"</#if> ><span>查看流水</span></a></li>
				<li class="ico_kc"><a href="${rc.contextPath}/web/toCheck" <#if active=4>class="on"</#if> ><span>库存盘点</span></a></li>
				<!--li class="ico_kc"><a href="${rc.contextPath}/web/toHistory"" <#if active=5>class="on"</#if> ><span>历史盘点</span></a></li-->
			</ul>
			<div class="side_bar">
				<span><#if userName?? >${userName!''}</#if> <#if shopName??>${shopName!''}</#if></span><a href="${rc.contextPath}/web/toPwd">修改密码</a><a href="${rc.contextPath}/web/salerExit">退出</a>
			</div>
		</div>
	</div>
</#macro>
<!----http://img-test.p1pai.com----->
<#macro imgPath>http://img.jdsao.com</#macro>