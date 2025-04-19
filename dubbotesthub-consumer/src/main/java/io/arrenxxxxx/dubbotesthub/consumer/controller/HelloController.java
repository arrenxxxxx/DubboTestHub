package io.arrenxxxxx.dubbotesthub.consumer.controller;

import java.util.List;
import java.util.Map;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import io.arrenxxxxx.dubbotesthub.api.HelloFacade;
import io.arrenxxxxx.dubbotesthub.api.HelloRequest;
import io.arrenxxxxx.dubbotesthub.api.HelloResponse;

/**
 * Hello service controller
 */
@RestController
@RequestMapping("/api/v1/hello")
public class HelloController {

    @DubboReference
    private HelloFacade helloFacade;

    /**
     * non-parameter call
     */
    @GetMapping
    public String sayHello() {
        return helloFacade.sayHello();
    }

    /**
     * String parameter call
     */
    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name) {
        return helloFacade.sayHello(name);
    }

    /**
     * Object parameter call
     */
    @PostMapping("/object")
    public HelloResponse sayHelloObject(@RequestBody HelloRequest request) {
        return helloFacade.sayHello(request);
    }

    /**
     * List parameter call
     */
    @PostMapping("/list")
    public List<String> sayHelloList(@RequestBody List<String> names) {
        return helloFacade.sayHelloList(names);
    }

    /**
     * Map parameter call
     */
    @PostMapping("/map")
    public Map<String, Object> sayHelloMap(@RequestBody Map<String, Object> paramMap) {
        return helloFacade.sayHelloMap(paramMap);
    }
}