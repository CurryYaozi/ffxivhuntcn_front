
# 使用springboot+Mybatis搭建的FFXIV国服狩猎站前台网站后端内容
-浏览我们的网页：https://ffxivhuntcn.com/#/home/index

---

#计划实现的功能
-查询各服务器狩猎车内容 √
-特殊fate倒计时 ×



# 技术栈说明
- 持久层：MyBatis
- 视图层：无
- 日志：Logback
- 单元测试：未集成
- 插件：Swagger Lombok Spring Boot devtools 

---

# 包名说明
- api: 存放API
- service：存放业务类
- dao：存放持久层类
- core：存放核心类，如常量类，工具类，异常类，全局实体类等
- interceptor：存放拦截器
- filter：存放过滤器
- config: 存放配置类，如Swagger配置类

---

# 配置说明
所有配置文件全部位于src/main/resources目录下
- application.properties：项目全局配置文件
- logback.xml：logback配置

---

# 持久层说明
#### 实体类、Example类、Mapper类的生成
框架中集成了MyBatis Generator，可通过MyBatis Generator来生成。

---

# 控制层说明
#### 控制层基类
BaseController: 位于com.huntcn_front.api
#### 编写控制层
- 所有Controller类都应该继承BaseController，以获取全局处理
- Controller无需手动捕获异常，异常将进行全局捕获（将根据接口类型返回错误页面或异常JSON对象）

---

# 环境分离
不建议使用Maven profile和springboot提供的spring.profiles.active来处理环境分离，这样会暴露生产环境配置信息（如数据库地址，加密密钥等）。生产环境配置应该单独编写并放在打包好的jar包同级目录下。如下：
```
|- 目录
 |-- huntcn_front.jar
 |-- application.properties
```

---

# 切换环境
修改application.properties下的project.env即可，取值为production和development，同时这也是logback appender的名称，环境切换后将自动采用对应的appender。如需增加环境配置，只需要添加对应的logback appender即可。

---

# 全局异常处理
通过BaseController的exceptionHandle方法捕获全局异常，当访问一个数据处理接口出错时，将自动返回异常JSON对象。

---

# 日志说明
日志采用springboot推荐的logback框架，对应src/main/resources/logback.xml配置文件。拥有两个Appender，分别是development（日志输出到控制台）和production（日志输出将产生文件并存放至log目录下）。Appender跟随项目环境自动切换。

---

# JSON日期格式处理
当接口返回JSON时，默认日期格式为yyyy-MM-dd HH:mm:ss

---

# 关于Swagger
#### Swagger地址
http://101.43.32.88:10076/doc.html

#### Swagger的启用和禁用
在application.properties中修改swagger.enabled即可，true表示启用Swagger，false表示禁用Swagger。在项目启动后可查看Swagger的状态。
