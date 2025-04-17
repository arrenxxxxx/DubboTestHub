package io.arrenxxxxx.controller;

import io.arrenxxxxx.model.Result;
import io.arrenxxxxx.model.User;
import io.arrenxxxxx.service.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HelloController {
    
    @DubboReference
    private HelloService helloService;
    
    // 原有接口 - 字符串参数
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return helloService.sayHello(name);
    }
    
    // 无参方法
    @GetMapping("/hello")
    public String hello() {
        return helloService.sayHello();
    }
    
    // 对象参数
    @PostMapping("/user")
    public Result<User> getUserInfo(@RequestBody User user) {
        return helloService.getUserInfo(user);
    }
    
    // 数组参数
    @GetMapping("/users")
    public List<User> getUserList(@RequestParam("names") String namesStr) {
        String[] names = namesStr.split(",");
        return helloService.getUserList(names);
    }
    
    // Map参数
    @GetMapping("/user/map")
    public Map<String, User> getUserMap(@RequestParam(value = "id", required = false) Long id,
                                       @RequestParam(value = "name", required = false) String name) {
        Map<String, Object> params = new HashMap<>();
        if (id != null) {
            params.put("id", id);
        }
        if (name != null) {
            params.put("name", name);
        }
        return helloService.getUserMap(params);
    }
    
    // 组合参数
    @GetMapping("/users/search")
    public Result<List<User>> searchUsers(@RequestParam("keyword") String keyword,
                                          @RequestParam(value = "page", defaultValue = "1") int page,
                                          @RequestParam(value = "size", defaultValue = "10") int size) {
        return helloService.searchUsers(keyword, page, size);
    }
    
    // List<User>参数
    @PostMapping("/users/batch")
    public Result<Integer> batchSaveUsers(@RequestBody List<User> users) {
        return helloService.batchSaveUsers(users);
    }
} 