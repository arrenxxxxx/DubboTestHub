package io.arrenxxxxx.dubbotesthub.starter.consumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Consumer auto configuration
 */
@Configuration
@EnableDubbo
@ComponentScan(basePackages = "io.arrenxxxxx.dubbotesthub.consumer")
@PropertySource("classpath:application-consumer.yml")
public class ConsumerAutoConfiguration {
    
}