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
    <!--代码高亮解析插件 start-->
    <link type="text/css" rel="stylesheet" href="${rc.contextPath}/dev-lib/assets/js/syntaxhighlighter/styles/shCoreDefault.css" />
    
    <script src="${rc.contextPath}/dev-lib/assets/js/jquery/jquery-1.10.2.min.js"></script>
	<link type="text/css" rel="stylesheet" href="${rc.contextPath}/dev-lib/assets/js/syntaxhighlighter/styles/shCoreDefault.css" />
	<script type="text/javascript" src="${rc.contextPath}/dev-lib/assets/js/syntaxhighlighter/scripts/shCore.js"></script>
	<script type="text/javascript" src="${rc.contextPath}/dev-lib/assets/js/syntaxhighlighter/scripts/shAutoloader.js"></script>
  
	<!--代码高亮解析插件 end-->
    <script type="text/javascript">
		var contextPath = '${rc.contextPath}';
		var imgContextPath = '';
	</script>
</head>

<body>
   	<#import "./webMacro.ftl" as webMacro>
    <@webMacro.webHeader contextPath=rc.contextPath active=1/>
    
    <div class="container">
        <div class="blog-header">
            <h1 class="blog-title"></h1>
        </div>
        <div class="row">
            <div class="col-sm-12 blog-main">
            	<div>
					<#if blogDomain??>
		                <!-- /.blog-post -->
		                <div class="blog-post">
		                    <h2 class="blog-post-title">${blogDomain.title}</h2>
		                    <p class="blog-post-meta">${blogDomain.createTime?string("yyyy-MM-dd HH:mm:ss")} by <a href="#">${blogDomain.author.userName!''}</a></p>
		                    ${blogDomain.content!''}
		                    </div>
                	</#if>
                </div>
                <nav>
                    <ul class="pager">
                        <li><a href="#">Previous</a></li>
                        <li><a href="#">Next</a></li>
                    </ul>
                </nav>
            </div>
            <!-- /.blog-main -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /.container -->
    <@webMacro.webFooter contextPath=rc.contextPath/>
    <script type="text/javascript" src="${rc.contextPath}/dev-lib/assets/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${rc.contextPath}/res/plugin/web/index.js"></script>
	<script type="text/javascript">
	    SyntaxHighlighter.autoloader(
		            ['js','jscript','javascript','${rc.contextPath}/dev-lib/assets/js/syntaxhighlighter/scripts/shBrushJScript.js'],
		            ['bash','shell','${rc.contextPath}/dev-lib/assets/js/syntaxhighlighter/scripts/shBrushBash.js'],
		            ['css','${rc.contextPath}/dev-lib/assets/js/syntaxhighlighter/scripts/shBrushCss.js'],
		            ['xml','html','${rc.contextPath}/dev-lib/assets/js/syntaxhighlighter/scripts/shBrushXml.js'],
		            ['sql','${rc.contextPath}/dev-lib/assets/js/syntaxhighlighter/scripts/shBrushSql.js'],
		            ['php','${rc.contextPath}/dev-lib/assets/js/syntaxhighlighter/scripts/shBrushPhp.js']
		        ); 
		        console.info("代码高亮检测");
		SyntaxHighlighter.all(); 
	</script>
</body>

</html>
