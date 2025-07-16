package com.cnwy.app.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan(basePackages = {"com.cnwy.app.demo.mapper"})
public class CnwyAppDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CnwyAppDemoApplication.class, args);
    }

}
