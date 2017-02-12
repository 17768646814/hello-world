# 项目介绍

1. 配置环境（略）
```
Good luck
```
2. 安装jar包
```java
#网上下载ojdbc7-12.1.0.2.jar
$ cd ${jar包位置}
$ mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0.2 -Dpackaging=jar -Dfile=ojdbc7-12.1.0.2.jar
```

3. 配置文件
```config
配置文件为application.yml，可配置项目context、端口、数据库等
```

4. 启动项目
```mvn
#mvn 启动
$ cd ?/hello-world/study
$ mvn spring-boot:run
#main方法启动
Debug或者直接运行com.pch.App.mail(String[])
#容器启动
$ cd ?/hello-world
$ mvn package
拷贝study/target/hello-world.war至容器，运行容器
```

5. 其他介绍
> 您可以访问我的个人网站[http://baismusic.com](http://baismusic.com)，Good Luck