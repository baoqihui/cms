# cms
+ Github地址：https://github.com/baoqihui/cms
+ Gitee地址(非实时更新)：https://gitee.com/idse666666/cms
## 需求

基于vue的媒体综合网站 

+ 第一块首页新闻带个搜索框
+ 第二块娱乐播放（音乐视频这些）
+ 第三块个人动态（就是你可以在这个界面发个动态 但是咱可以简单点来 直接就在这个界面多做个文本框发布就可 然后这个界面也可以显示咱们从数据库提取的动态）
+ 第四块 个人中心（可以写个登录界面然后随便加点功能就可）

## 模块

登录，注册；首页，娱乐，动态（发布和消息提醒）；个人中心设置

## 原型

![原型图](https://minio.service.cf/file/%E5%8E%9F%E5%9E%8B%E5%88%9D%E7%A8%BF.png)

## 项目技术
1. 原始项目骨架：[个人模板](https://github.com/baoqihui/code-demo-persion)

2. 相关项目：[代码生成器](https://github.com/baoqihui/code-generator-persion)

3. 简化大部分项目代码，只保留必要技术栈。
   + 语言：`Java`
   + 项目框架：`spring boot`
   + 数据库：`mysql`
   + 持久层框架：`mybatis plus`
   + 非关系数据库：`redis`
   + 文件存储：`自建minio`
   + 接口文档: `swagger`
   + 容器化：`docker`