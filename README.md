# Springcloud
springcloud demo搭建
1.eureka          注册中心
2.zuul            路由
3.producer        服务生产者
4.feign（Hystric）（Hystric Dashboard ）     
    服务消费者 （负载均衡）/断路器 /监控仪表盘
    zipkin 添加链路追踪 http://localhost:9411/
5.config           分布式配置中心
6.config-client    配置消费（bus 消息总线通过RabbitMQ）
7.链路追踪  https://blog.csdn.net/u013815546/article/details/73086975
 首先建立数据库： 
 默认情况下 zipkin 运行时数据保存在内存中，重启数据会丢失 
 数据库脚本下载 (https://github.com/openzipkin/zipkin/blob/master/zipkin-storage/mysql/src/main/resources/mysql.sql)
 
 查看与mysql storage相关的配置
 启动服务脚本：
 java -server -jar zipkin-server-1.26.0-exec.jar --zipkin.storage.type=mysql --zipkin.storage.mysql.host=localhost --zipkin.storage.mysql.port=3306 --zipkin.storage.mysql.username=root --zipkin.storage.mysql.password=root --zipkin.storage.mysql.db=zipkin
 
