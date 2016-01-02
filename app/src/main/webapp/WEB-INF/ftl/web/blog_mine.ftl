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
    <@webMacro.webHeader contextPath=rc.contextPath active=4/>
    <div class="container">
        <div class="blog-header">
            <h1 class="blog-title"></h1>
            <p class="lead blog-description"></p>
        </div>
        <div class="row">
            <div class="col-sm-8 blog-main">
                <div id="blog_list_tbody">
                    
                    <!-- /.blog-post -->
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
