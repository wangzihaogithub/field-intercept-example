package com.github.wangzihaogithub.case2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * -Xmx556m -Xms556m -XX:+UseG1GC
 * 试验阶段
 */
@SpringBootApplication
public class Case2ApplicationBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(Case2ApplicationBootstrap.class, args);
    }

}
