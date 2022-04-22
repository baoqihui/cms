# cms-plus
+ Github地址：https://github.com/baoqihui/cms
+ Gitee地址(非实时更新)：https://gitee.com/idse666666/cms

## 需求

基于SpringBoot医疗服务系统的设计与实现 系统分三个角色
+ 患者：注册登录系统 预约挂号医生 查看医生信息
+ 医生：对预约患者就诊，开药
+ 系统管理员：对本系统资源进行管理（例如：对药品信息，医生信息进行增删改查等）

## 模块

+ 用户模块：登录，注册，修改密码；
+ 患者模块：生成就诊单；
+ 医生模块：对就诊单进行修改，选择对应药品；
+ 管理员模块：药品添加修改，医生信息修改；


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