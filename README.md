##自己做的一个博客的后台管理系统
####开发环境
Spring+Mybatis+Mysql+Maven
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
###常见问题
Maven build 打包成war时候, 出现下列error

[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.1:compile (default-compile) on project app: Compilation failure
[ERROR] An unknown compilation problem occurred
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException

原因:pom.xml需要需要指定本地jdk安装目录

<properties>
		<project.build.sourceEncoding>
			UTF-8
		</project.build.sourceEncoding>
		<spring.version>4.0.6.RELEASE</spring.version>
		<JAVA_HOME>D:\Program Files\Java\jdk1.8.0_51</JAVA_HOME>
</properties>


