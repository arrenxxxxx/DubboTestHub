package io.arrenxxxxx.dubbotesthub.starter.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Provider auth configuration
 */
@Configuration
@EnableDubbo(scanBasePackages = "io.arrenxxxxx.dubbotesthub.provider.service")
@ComponentScan(basePackages = "io.arrenxxxxx.dubbotesthub.provider.service")
@PropertySource("classpath:application-provider.yml")
public class ProviderAutoConfiguration {
    
}