package io.arrenxxxxx.dubbotesthub.provider.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.arrenxxxxx.dubbotesthub.api.HelloFacade;
import io.arrenxxxxx.dubbotesthub.api.HelloRequest;
import io.arrenxxxxx.dubbotesthub.api.HelloResponse;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * HelloFacade interface implementation
 */
@Slf4j
@Service
@DubboService
public class HelloFacadeImpl implements HelloFacade {

    @Override
    public String sayHello() {
        log.info("Executing sayHello() without parameters");
        return "Hello World!";
    }

    @Override
    public String sayHello(String name) {
        log.info("Executing sayHello(String name) with parameter: {}", name);
        return "Hello, " + name + "!";
    }

    @Override
    public HelloResponse sayHello(HelloRequest request) {
        log.info("Executing sayHello(HelloRequest request) with request: {}", request);
        HelloResponse response = new HelloResponse();
        response.setGreeting("Hello, " + request.getName() + "!");
        response.setTimestamp(new Date());
        response.setSuccess(true);
        response.setMessage("Your age is: " + request.getAge() + ", Your message is: " + request.getMessage());
        return response;
    }

    @Override
    public List<String> sayHelloList(List<String> names) {
        log.info("Executing sayHelloList(List<String> names) with {} names", names != null ? names.size() : 0);
        List<String> greetings = new ArrayList<>();
        if (names != null) {
            for (String name : names) {
                greetings.add("Hello, " + name + "!");
            }
        }
        return greetings;
    }

    @Override
    public Map<String, Object> sayHelloMap(Map<String, Object> paramMap) {
        log.info("Executing sayHelloMap(Map<String, Object> paramMap) with {} parameters", 
                paramMap != null ? paramMap.size() : 0);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("success", true);
        resultMap.put("timestamp", new Date());

        StringBuilder greeting = new StringBuilder("Hello");
        if (paramMap != null && paramMap.containsKey("name")) {
            greeting.append(", ").append(paramMap.get("name"));
        }
        greeting.append("!");
        resultMap.put("greeting", greeting.toString());

        if (paramMap != null) {
            paramMap.forEach((key, value) -> {
                if (!resultMap.containsKey(key)) {
                    resultMap.put("echo_" + key, value);
                }
            });
        }

        return resultMap;
    }

    @Override
    public List<HelloResponse> sayHelloListObject(List<HelloRequest> requests) {
        log.info("Executing sayHelloList(List<HelloRequest> requests) with {} requests", 
                requests != null ? requests.size() : 0);
        List<HelloResponse> responses = new ArrayList<>();
        if (requests != null) {
            for (HelloRequest request : requests) {
                HelloResponse response = new HelloResponse();
                response.setGreeting("Hello, " + request.getName() + "!");
                response.setTimestamp(new Date());
                response.setSuccess(true);
                response.setMessage("Your age is: " + request.getAge() + ", Your message is: " + request.getMessage());
                responses.add(response);
            }
        }
        return responses;
    }

    @Override
    public HelloResponse sayHello(String name, Integer age, String message) {
        log.info("Executing sayHello(String name, Integer age, String message) with parameters: name={}, age={}, message={}", 
                name, age, message);
        HelloResponse response = new HelloResponse();
        response.setGreeting("Hello, " + name + "!");
        response.setTimestamp(new Date());
        response.setSuccess(true);
        response.setMessage("Your age is: " + age + ", Your message is: " + message);
        return response;
    }
}