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

/**
 * HelloFacade interface implementation
 */
@Service
@DubboService
public class HelloFacadeImpl implements HelloFacade {

    @Override
    public String sayHello() {
        return "Hello World!";
    }

    @Override
    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }

    @Override
    public HelloResponse sayHello(HelloRequest request) {
        HelloResponse response = new HelloResponse();
        response.setGreeting("Hello, " + request.getName() + "!");
        response.setTimestamp(new Date());
        response.setSuccess(true);
        response.setMessage("Your age is: " + request.getAge() + ", Your message is: " + request.getMessage());
        return response;
    }

    @Override
    public List<String> sayHelloList(List<String> names) {
        List<String> greetings = new ArrayList<>();
        for (String name : names) {
            greetings.add("Hello, " + name + "!");
        }
        return greetings;
    }

    @Override
    public Map<String, Object> sayHelloMap(Map<String, Object> paramMap) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("success", true);
        resultMap.put("timestamp", new Date());

        StringBuilder greeting = new StringBuilder("Hello");
        if (paramMap.containsKey("name")) {
            greeting.append(", ").append(paramMap.get("name"));
        }
        greeting.append("!");
        resultMap.put("greeting", greeting.toString());

        paramMap.forEach((key, value) -> {
            if (!resultMap.containsKey(key)) {
                resultMap.put("echo_" + key, value);
            }
        });

        return resultMap;
    }
}