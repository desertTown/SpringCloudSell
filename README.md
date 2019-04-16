# SpringCloudSell

#### 介绍
A project practice with sell using SpringBoot 2.0.3 + SpringCloud Finchley.RELEASE.  include Eureka, Feign, SpringCloudConfig, SpringCloudBus,Zuul, Hystrix,SpringCloud Sleuth, ZipKin,Redis, RabbitMQ

#### 启动步骤：
1. 本地host文件映射 eureka1 和eureka2
2. 启动linux容器， 启动redis， rabbiitMq, Zipkin
3. 本地启动mysql
4. 启动内网穿透
5. 启动 eureka1， eureka2， config, order, product, user, api_gateway 服务
