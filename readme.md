# cms-plus
+ Github地址：https://github.com/baoqihui/cms
+ Gitee地址(非实时更新)：https://gitee.com/idse666666/cms
## 需求

基于javaweb的个人学习空间管理系统
+ 该学习空间能够让用户设计自己的学习进度和学习任务（增删改查）
+ 公共论坛，论坛里面有每个用户发的问题题目，点进去之后是各个用户的回答
+ 日志模块，有点类似日记，把每天想说的话记录下来
+ 第四块 个人中心（可以写个登录界面然后随便加点功能就可）

## 模块

+ 用户模块：登录，注册，修改密码；
+ 任务模块：增删改查；
+ 论坛模块：提问，回复；
+ 日志模块：增删改查；

## 特殊需求

1. 登录测试：
   + 用户名不存在登录不了
   + 用户名为空时，会提示输入用户名
   + 密码错误登录不了
   + 密码为空时，会提示输入密码

## 项目技术
1. 原始项目骨架：[个人模板](https://github.com/baoqihui/code-demo-persion)
2. 相关项目：[代码生成器](https://github.com/baoqihui/code-generator-persion)
3. 简化大部分项目代码，只保留必要技术栈。
   + 语言：`Java`
   + 项目框架：`spring boot`
   + 数据库：`mysql`
   + 持久层框架：`mybatis plus`
   + 非关系数据库（了解）：`redis`
   + 接口文档（了解）: `swagger`
   + 容器化（了解）：`docker`