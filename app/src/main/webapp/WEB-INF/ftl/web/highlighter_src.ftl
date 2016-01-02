<!--代码高亮解析插件 start-->
<link type="text/css" rel="stylesheet" href="${rc.contextPath}/dev-lib/assets/js/syntaxhighlighter/styles/shCoreDefault.css" />
<script type="text/javascript" src="${rc.contextPath}/dev-lib/assets/js/syntaxhighlighter/scripts/shCore.js"></script>
<script type="text/javascript" src="${rc.contextPath}/dev-lib/assets/js/syntaxhighlighter/scripts/shAutoloader.js"></script><script type="text/javascript">
$(document).ready(function(){
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
});
</script>
<!--代码高亮解析插件 end-->