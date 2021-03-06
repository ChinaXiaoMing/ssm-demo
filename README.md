# ssm-demo
[![License](http://img.shields.io/badge/license-apache%202-brightgreen.svg)](https://github.com/ChinaXiaoMing/ssm-demo/blob/master/LICENSE)
[![](https://img.shields.io/badge/Author-fuyuanming-orange.svg)](https://github.com/ChinaXiaoMing)

## 项目介绍
ssm整合框架入门学习使用，从零开始，重复造个轮子。

## 在线演示地址
- http://47.106.88.138/

## 更新内容
- 2018-4-27：整合添加druid监控<br/>
- 2018-4-28：整合添加mybaits-generator代码自动生成功能
- 2018-5-4：整合shiro
- 2018-5-9：加入登录页
- 2018-5-16 完善登录功能
- 2018-5-18 整合aop,添加登录日志功能
- 2018-5-23 添加Kaptcha验证码功能
- 2018-6-22 整合FreeMarker

## 计划
- 后台主页开发

## 技术选型
### 后端技术
技术 | 名称 | 官网
----|------|----
Spring Framework | 容器  | [http://projects.spring.io/spring-framework/](http://projects.spring.io/spring-framework/)
Mybatis | 持久化框架 | [http://www.mybatis.org/mybatis-3/](http://www.mybatis.org/mybatis-3/)
MyBatis Generator | mybatis自动生成代码工具 | [http://www.mybatis.org/generator/](http://www.mybatis.org/generator/)
Druid | 阿里高性能连接池 | [http://druid.io/](http://druid.io/)
Shiro | 权限安全框架 | [http://shiro.apache.org/](http://shiro.apache.org/)
Kaptcha | 验证码 | [https://github.com/penggle/kaptcha](https://github.com/penggle/kaptcha)
Maven | 项目构建工具  | [http://maven.apache.org/](http://maven.apache.org/)
FreeMarker | 模板引擎 | [https://freemarker.apache.org/](https://freemarker.apache.org/)

### 前端技术
技术 | 名称 | 官网
----|------|----
Layer | 弹出层控件 | [http://layer.layui.com/](http://layer.layui.com/)
jQuery | JavaScript封装库 | [http://jquery.com/](http://jquery.com/)
jQuery Validation | jQuery表单验证 | [https://jqueryvalidation.org/](https://jqueryvalidation.org/)


## 开发工具
- IntelliJ IDEA：开发IDE
- Git：版本管理
- Maven 项目构建工具
- Tomcat 容器服务器

## 本地开发运行部署
下载zip直接解压或安装git后执行克隆命令 `git clone https://github.com/ChinaXiaoMing/ssm-demo.git`<br/>
数据库工具执行`test.sql`建立数据库及添加简单测试数据<br/>
部署到tomcat服务器
