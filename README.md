这是一个第一次学习的博客项目

## github登录
[api构建地址](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)

2020/01/13 增加了简单的分页功能,把标题栏做成了一个独立的可以引用的文件.
[增加了热部署的功能] 需要引用
         <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <optional>true</optional>
        </dependency>
 在设置里面更改compiler 的选项,勾选自动构建,按住ctrl+shift+alt+?可以打开注册,勾选compiler.automake.allow.when.app.running