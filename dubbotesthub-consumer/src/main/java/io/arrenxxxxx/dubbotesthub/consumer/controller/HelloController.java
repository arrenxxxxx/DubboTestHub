package io.arrenxxxxx.dubbotesthub.consumer.controller;

import java.util.List;
import java.util.Map;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import io.arrenxxxxx.dubbotesthub.api.HelloFacade;
import io.arrenxxxxx.dubbotesthub.api.HelloRequest;
import io.arrenxxxxx.dubbotesthub.api.HelloResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * Hello service controller
 */
@Slf4j
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
        log.info("Calling sayHello() without parameters");
        return helloFacade.sayHello();
    }

    /**
     * String parameter call
     */
    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name) {
        log.info("Calling sayHello(String name) with parameter: {}", name);
        return helloFacade.sayHello(name);
    }

    /**
     * Object parameter call
     */
    @PostMapping("/object")
    public HelloResponse sayHelloObject(@RequestBody HelloRequest request) {
        log.info("Calling sayHello(HelloRequest request) with request: {}", request);
        return helloFacade.sayHello(request);
    }

    /**
     * List parameter call
     */
    @PostMapping("/list")
    public List<String> sayHelloList(@RequestBody List<String> names) {
        log.info("Calling sayHelloList(List<String> names) with {} names", names != null ? names.size() : 0);
        return helloFacade.sayHelloList(names);
    }

    /**
     * Map parameter call
     */
    @PostMapping("/map")
    public Map<String, Object> sayHelloMap(@RequestBody Map<String, Object> paramMap) {
        log.info("Calling sayHelloMap(Map<String, Object> paramMap) with {} parameters", 
                paramMap != null ? paramMap.size() : 0);
        return helloFacade.sayHelloMap(paramMap);
    }

    /**
     * List of objects parameter call
     */
    @PostMapping("/object-list")
    public List<HelloResponse> sayHelloObjectList(@RequestBody List<HelloRequest> requests) {
        log.info("Calling sayHelloList(List<HelloRequest> requests) with {} requests", 
                requests != null ? requests.size() : 0);
        return helloFacade.sayHelloListObject(requests);
    }

    /**
     * Multiple parameters call (three parameters)
     */
    @PostMapping("/multiple-params")
    public HelloResponse sayHelloMultipleParams(@RequestParam String name, 
                                               @RequestParam Integer age, 
                                               @RequestParam String message) {
        log.info("Calling sayHello(String name, Integer age, String message) with parameters: name={}, age={}, message={}", 
                name, age, message);
        return helloFacade.sayHello(name, age, message);
    }
}