# 27西餐厅pos系统

#### 项目介绍
（1）产品应用场景：西餐厅POS销售管理系统
（2）用户：餐厅的服务员、经理
（3）系统范围：西餐厅
（4）基本目标：开发一个界面友好、简单易用的销售管理系统，餐厅使用该系统后， 能够更高效地为客户服务，更有效地控制西餐厅的管理成本、节约资源。


#### 软件架构
本项目是基于B/S架构开发的，使用的技术工具有
1.	maven管理工具，用于管理jar包和项目构建
2.	git版本控制
3.	navicate数据库管理软件
4.	ecplise ee 编写代码的ide
包括的开发语言有java1.8，mysql5.7，jsp，html，css，javascrtpt，jquery等，本项目前端采用easyui，easyui集成了较多了样式，减少了前端的部分工作，简洁大方。后端采用spring4.2.4，hibernate5.0.7，struts2.3.24框架，使用ssh框架能提高工作效率，可扩展性，可维护性等。 



#### 安装教程

1. 导入项目到ecplise或者idea，然后通过maven加载jar包
2. 修改pos-web项目下db.properties的数据库账号的密码
3. 新建wfpos数据库，将pos-web下的wfpos.sql导入数据库
4.正常的话便可运行即可
数据库已有账号  管理员 用户名admin 密码123
               普通用户 账号123 密码123
密码使用md5进行加密，所以数据库看不出来密码是什么


#### 项目截图
餐台界面

![餐台界面](https://gitee.com/uploads/images/2018/0617/220339_45f7438e_1667883.png "微信截图_20180617220026.png")
点菜界面

![点菜界面](https://gitee.com/uploads/images/2018/0617/220351_7cda6b9a_1667883.png "微信截图_20180617220056.png")
支付界面

![支付界面](https://gitee.com/uploads/images/2018/0617/220401_ccf520b1_1667883.png "微信截图_20180617220115.png")
报表界面

![报表界面](https://gitee.com/uploads/images/2018/0617/220412_50df52e0_1667883.png "微信截图_20180617220124.png")
菜单管理界面

![菜单管理界面](https://gitee.com/uploads/images/2018/0617/220420_14d2876f_1667883.png "微信截图_20180617220133.png")
