<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="${rc.contextPath}/dev-lib/assets/icon16x16.png">
    <title>简单随意</title>
    <!-- Bootstrap core CSS -->
    <link href="${rc.contextPath}/dev-lib/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${rc.contextPath}/dev-lib/assets/css/blog.css" rel="stylesheet">
    <script type="text/javascript">
		var contextPath = '${rc.contextPath}';
		var imgContextPath = '';
	</script>
</head>
	<#import "./webMacro.ftl" as webMacro>
    <@webMacro.webHeader contextPath=rc.contextPath active=3/>
    <div class="container">
        <div class="blog-header">
            <h1 class="blog-title"></h1>
            <p class="lead blog-description"></p>
        </div>
        <div class="row">
            <div class="col-sm-8 blog-main">
                <div id="blog_list_tbody">
<p>
	曾经自己也是资深的软件迷,爱好找各种奇葩有趣实用的软件,所谓是还没学会写几行代码,就要先武装一下电脑;真正的原因只是因为自己有点轻微的强迫症,几百g的电脑硬盘,里面空空的没装几个软件,空着几百G的容量,内心忐忑总会觉得少些什么,少了东西总要填满一下吧,虽然有句话是这么说的:
</p>
<p>
	<span style="font-size:18px;color:#E56600;"><u><em>外在的追求始终是无法填满内心的空虚</em></u></span><span style="color:#E56600;">,</span>
</p>
<span class="time SG_txtc"></span>
<p>
	但是实际上,外在的追求填的很快,只是填不满.所以什么软件都在自己的电脑装了个便,
</p>
<p>
	后来慢慢的电脑里面的安装软件开始慢慢的固定下来,好的工具软件都是经得起时间的检验的,[太TM对了],
</p>
<h3>
	<span style="color:#4C33E5;">---------------------------------------常用软件列表</span><br />
</h3>
<p>
	<span style="color:#E53333;">Xsearch</span> 可以指定路径都说指定的字符串的搜索工具
</p>
<span style="color:#E53333;">Everything </span> 搜索文件名包含关键词的轻量级快速搜索工具<br />
<span style="color:#E53333;">FastStone </span> 截图软件外带截图编辑<br />
<span style="color:#E53333;">Eclipse keeper</span> Java 开发IDE 工具<br />
<span style="color:#E53333;">JD-GUI </span>Java反编译软件<br />
<span style="color:#E53333;">Navicat for MySQL</span><br />
Ubuntu 用的是<span style="color:#E53333;">mysql workbench</span>但是到了win 平台 workbench 卡的要命,就抛弃了,还有<span style="color:#E53333;">SQLyog</span>也是mysql 的可视化管理工具,但是用着不习惯;<br />
<h3>
	<span style="font-size:14px;color:#4C33E5;">------------------------------文本编辑器</span>
</h3>
<span style="color:#E53333;"> <s>UltraEdit</s></span>  启动太慢了,基本没使用过<br />
<span style="color:#E53333;">gVim 7.4   </span>打开日志文件的时候会用到,一般例子文件都是几十兆的,只有这个软件能顺利打开,<br />
<span style="color:#E53333;">Editplus</span>   启动超快,在我不知道怎么把Sublime Txt设置到右键菜单的时候我经常用它快速打开文件查看内容,当我知道怎么把Sublime Txt设置到右键菜单的时候,它就被抛弃;<br />
<span style="color:#E53333;"><s>Notepad++</s></span>   启动太慢了,在我不知道有其他软件一样可以在复制代码的时候顺便把代码高亮也复制过去的时候,我是使用它的,但是用了 Sublime Txt 的Highlight 插件后,它就被我束置高阁了<br />
<span style="color:#E53333;">Sublime Txt 3</span>  启动较快,装了这么多插件,一点也没拖慢启动速度,优良的插件管理系统package controller,美观的界面,除了打开超大日志文件的时候会卡死,没发现其他缺点<br />
<span style="color:#E53333;">PicPick</span>   经常用这个软件来取色,有16进制哦<br />
<span style="color:#E53333;">filezilla   </span>ftp 文本传输软件<br />
<span style="color:#E53333;">Xshell   </span>ssh 链接器,以前用的是<span style="color:#E53333;"><s>p</s></span><span style="color:#E53333;"><s>u</s></span><span style="color:#E53333;"><s>t</s></span><span style="color:#E53333;"><s>t</s></span><span style="color:#E53333;"><s>y</s>,<span style="color:#000000;">但是界面操作不习惯</span></span><br />
<span style="color:#E53333;">virtualbox</span>   虚拟机,,内存小就不要装Vmware了<br />
<h3>
	<span style="color:#4C33E5;">----------------------------------------------日常软件</span>
</h3>
<span style="color:#E53333;">ConEmu-Maximus5</span> DOS系统仿真器，体积小巧，界面清爽,用于替换window 自带的cmd 程序,关键是这个由类似Linux 控制台的代码提示<br />
<span style="color:#E53333;font-size:18px;">myBase</span> myBase 是一款用于分类管理自由格式资料的数据库软件， 对个人用户在( Linux/MacOSX/Windows )桌面电脑系统上实施文档、知识、笔记、日记、图片和网页的分类管理任务相当有帮助。<br />
<span style="color:#E53333;">为知笔记</span><br />
<span style="color:#E53333;">Thunderbird</span>和<span style="color:#E53333;">Foxmail</span><br />
<span style="color:#E53333;">PDF-Viewer</span><br />
<span style="color:#E53333;">Firefox</span> 和 <span style="color:#E53333;">Chrome</span><br />
屏蔽广告的插件<br />
<span style="color:#E53333;">Adguard</span><br />
<span style="color:#E53333;">AdBlock</span><br />
<p>
	<span style="color:#E53333;">必应输入法</span>
</p>
<p>
	<br />
<span style="color:#E53333;"></span>
</p>
<p>
	<br />
</p>
<h3>
	<span style="color:#E53333;"></span>
</h3>
<h3>
	<span style="color:#E53333;"></span>
</h3>
<h3>
	<span style="color:#E53333;"><span style="color:#000000;">
	<p>
		<span style="color:#4C33E5;">------------------------------长逛的软件博客</span>
	</p>
</span></span>
</h3>
<h3>
	<span style="color:#E53333;"><span style="color:#000000;"></span></span>
</h3>
<p>
	<span style="color:#E53333;"><span style="color:#000000;"></span></span>
</p>
<p>
	精品绿色便携软件         <span style="color:#4C33E5;"><u>http://www.portablesoft.org/</u></span>
</p>
<p>
	异次元                        <span style="color:#4C33E5;"><u>http://www.iplaysoft.com/</u></span>
</p>
<p>
	小众软件                     <span style="color:#4C33E5;"><u>http://www.appinn.com/</u></span>
</p>
<p>
	软矿                           <span style="color:#4C33E5;"><u>http://www.wowrk.com/</u></span>
</p>
<p>
	善用佳软                     <span style="color:#4C33E5;"><u>http://xbeta.info/</u></span>
</p>
<p>
	<br />
</p>
<p>
	后来接触了Ubuntu 系统,然后日常长逛的软件博客就有变成了:
</p>
<p>
	Linux 中国-开源社区      <span style="color:#4C33E5;"><u>https://linux.cn/</u></span>
</p>
<p>
	薄荷开源                     <span style="color:#4C33E5;"><u>http://www.mintos.org/</u></span>
</p>
<p>
	imcn开源资讯博客         <span style="color:#4C33E5;"><u>http://imcn.me/</u></span>
</p>
<p>
	国外的
</p>
<p>
	itsfoss                         <span style="color:#4C33E5;"><u>http://itsfoss.com/</u></span>
</p>
<h3>
	<span style="color:#E53333;"><span style="color:#000000;">
	<p>
		<span style="color:#4C33E5;">-------------------------------其他:</span>
	</p>
</span></span>
</h3>
<p>
	<span style="color:#E53333;"><span style="color:#000000;"></span></span>
</p>
<p>
	Jeff 的阳台                 
</p>
<p>
	<span style="color:#4C33E5;">http://www.jianhui.org/</span>
</p>
<br />
<p>
	<br />
</p>

                </div>
                <nav>
                    <ul class="pager">
                        <div class="pagination">
                            <ul class="fr">
                              
                            </ul>
                        </div>
                    </ul>
                </nav>
            </div>
            <!-- /.blog-main -->
            <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
                <@webMacro.webPersonDesc/>
                <div class="sidebar-module">
                    <h4>日期归档</h4>
                    <ol class="list-unstyled" id="blog_date_side_tbody">
                       
                    </ol>
                </div>
                <div class="sidebar-module">
                    <h4>标签云</h4>
                    <ol class="list-unstyled" id="blog_tag_side_tbody">
                       
                       
                    </ol>
                </div>
                <div class="sidebar-module">
                    <h4>Elsewhere</h4>
                    <ol class="list-unstyled">
                        <li><a href="#">GitHub</a></li>
                        <li>
                            <a href="#"></a>
                        </li>
                        <li>
                            <a href="#"></a>
                        </li>
                    </ol>
                </div>
            </div>
            <!-- /.blog-sidebar -->
        </div>
        <!-- /.row -->
    </div>
    <@webMacro.webFooter contextPath=rc.contextPath/>
    <script src="${rc.contextPath}/dev-lib/assets/js/jquery/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${rc.contextPath}/dev-lib/assets/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${rc.contextPath}/res/plugin/web/other.js"></script>
