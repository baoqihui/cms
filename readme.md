# office
+ Github地址：https://github.com/baoqihui/cms/tree/office
+ Gitee地址(非实时更新)：https://gitee.com/idse666666/cms/tree/office
## 需求

基于springboot的在线办公
使用Springboot + SpringMVC + MyBatisPlus，系统分为表现层，controller层，service层，DAO层四层
登陆分三个身份进行，自动生成验证码登录（不需要注册，由管理员执行）
1. 管理员：
登陆后管理员工与领导的信息，分部门查看领导与员工的信息，并可作出修改或删除；新增领导员工信息/新部门信息
2. 领导：
发送新通知给本部门员工；查看过往通知与员工的收到情况；接收员工的工作汇报并作出批改
3. 员工：
工作日打卡；查看领导的通知并确认收到；向领导发送工作汇报，包含文本/文件；查看过往工作汇报（可作出修改）

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