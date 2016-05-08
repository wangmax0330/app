##自己做的一个博客的后台管理系统
####开发环境
Spring+Mybatis+Mysql+Maven
页面css 用的 [boostrap](http://v3.bootcss.com/"")   的博客例子的模板
####博客显示页面主页
http://herong.me/app/web/blog_index	--->本地访问herong替换成localhost
####博客后台登陆地址
http://herong.me/app/d/page/login		--->本地访问herong替换成localhost
初始用户:  admin
初始密码:  123456
**数据库密码是经过MD5加密的*
####博客数据库初始化sql位置
/app/document/db/app.sql

-----------
####界面预览
 * 网站主页
 ![image](https://raw.githubusercontent.com/wangmax0330/app/master/app/document/20160508220611.png)
* 博客博文页面
 ![image](https://raw.githubusercontent.com/wangmax0330/app/master/app/document/20160508220657.png)
* 后台登陆页面
 ![image](https://raw.githubusercontent.com/wangmax0330/app/master/app/document/20160508220723.png)
* 后台管理页面
 ![image](https://raw.githubusercontent.com/wangmax0330/app/master/app/document/20160508220816.png)
 
--------

###常见问题
Maven build 打包成war时候, 出现下列error

>[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.1:compile (default-compile) on project app: Compilation failure
>[ERROR] An unknown compilation problem occurred
>[ERROR] -> [Help 1]
>[ERROR] 
>[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
>[ERROR] Re-run Maven using the -X switch to enable full debug logging.
>[ERROR] 
>[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException


原因:pom.xml需要需要指定本地jdk安装目录
 ![image](https://raw.githubusercontent.com/wangmax0330/app/master/app/document/20160508220452.png)





