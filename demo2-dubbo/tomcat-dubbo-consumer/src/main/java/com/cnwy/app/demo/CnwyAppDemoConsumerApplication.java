package com.cnwy.app.demo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDubbo
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.cnwy.app.demo.mapper"})
public class CnwyAppDemoConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CnwyAppDemoConsumerApplication.class, args);
    }

}
