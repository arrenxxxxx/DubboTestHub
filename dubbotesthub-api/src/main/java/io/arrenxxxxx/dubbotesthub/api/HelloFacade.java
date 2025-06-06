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

    /**
     * List of objects parameter call
     */
    List<HelloResponse> sayHelloListObject(List<HelloRequest> requests);

    /**
     * Multiple parameters call (three parameters)
     */
    HelloResponse sayHello(String name, Integer age, String message);
}