package com.github.wangzihaogithub.case1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * -Xmx556m -Xms556m -XX:+UseG1GC
 */
@SpringBootApplication
public class Case1ApplicationBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(Case1ApplicationBootstrap.class, args);
    }

}
