package com.cnwy.app.demo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
@MapperScan(basePackages = {"com.cnwy.app.demo.mapper"})
public class CnwyAppDemoProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CnwyAppDemoProviderApplication.class, args);
    }

}
