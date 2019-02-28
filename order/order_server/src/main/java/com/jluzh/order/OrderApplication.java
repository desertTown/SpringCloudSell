package com.jluzh.order;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
//@EnableEurekaClient
//@EnableDiscoveryClient
//@EnableCircuitBreaker
@EnableFeignClients(basePackages = "com.jluzh.product.client")
@SpringCloudApplication    //这个注解充当 @SpringBootApplication，@EnableDiscoveryClient@EnableCircuitBreaker
//主要是为了能扫描到这个类com.jluzh.product.client.ProductClient, 扩大扫描范围
@ComponentScan(basePackages = "com.jluzh")
@EnableHystrixDashboard
@EnableHystrix
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
