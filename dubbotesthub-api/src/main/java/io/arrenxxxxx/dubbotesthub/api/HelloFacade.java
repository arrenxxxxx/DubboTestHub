package io.arrenxxxxx.dubbotesthub.api;

import java.util.List;
import java.util.Map;

/**
 * Hello dubbo interface
 */
public interface HelloFacade {

    /**
     * non-parameter
     */
    String sayHello();

    /**
     * String parameter call
     */
    String sayHello(String name);

    /**
     * Object parameter call
     */
    HelloResponse sayHello(HelloRequest request);

    /**
     * List parameter call
     */
    List<String> sayHelloList(List<String> names);

    /**
     * Map parameter call
     */
    Map<String, Object> sayHelloMap(Map<String, Object> paramMap);
}