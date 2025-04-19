package io.arrenxxxxx.dubbotesthub.server;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Test hub application
 */
@SpringBootApplication
@EnableDubbo
@ComponentScan(basePackages = { "io.arrenxxxxx.dubbotesthub" })
public class DubboTestHubApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboTestHubApplication.class, args);
    }
}