package io.arrenxxxxx.service.impl;

import io.arrenxxxxx.model.Result;
import io.arrenxxxxx.model.User;
import io.arrenxxxxx.service.HelloService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DubboService
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name + "! (from provider)";
    }
    
    @Override
    public String sayHello() {
        return "Hello World! (from provider, no params)";
    }
    
    @Override
    public Result<User> getUserInfo(User user) {
        // Simulate processing user information and return
        if (user != null && user.getId() != null) {
            user.setName(user.getName() + " (processed by provider)");
            return Result.success(user);
        }
        return Result.error("Incomplete user information");
    }
    
    @Override
    public List<User> getUserList(String[] names) {
        List<User> userList = new ArrayList<>();
        if (names != null) {
            for (int i = 0; i < names.length; i++) {
                userList.add(new User((long) (i + 1), names[i], 20 + i));
            }
        }
        return userList;
    }
    
    @Override
    public Map<String, User> getUserMap(Map<String, Object> params) {
        Map<String, User> userMap = new HashMap<>();
        if (params != null) {
            // Simulate getting users through parameters
            if (params.containsKey("id")) {
                Long id = Long.valueOf(params.get("id").toString());
                userMap.put("user" + id, new User(id, "User" + id, 25));
            }
            
            if (params.containsKey("name")) {
                String name = params.get("name").toString();
                userMap.put(name, new User(999L, name, 30));
            }
        }
        return userMap;
    }
    
    @Override
    public Result<List<User>> searchUsers(String keyword, int page, int size) {
        // Simulate paginated query
        List<User> users = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int userId = (page - 1) * size + i + 1;
            users.add(new User((long) userId, keyword + "_User" + userId, 20 + i));
        }
        return Result.success(users);
    }
    
    @Override
    public Result<Integer> batchSaveUsers(List<User> users) {
        // Simulate batch saving users
        if (users == null || users.isEmpty()) {
            return Result.error("User list cannot be empty");
        }
        
        // Simulate processing each user and return the number of successfully saved
        int successCount = 0;
        for (User user : users) {
            // Simulate save logic: users with id and non-empty name can be saved successfully
            if (user.getId() != null && user.getName() != null && !user.getName().isEmpty()) {
                // In actual applications, this would call database operations to save the user
                successCount++;
            }
        }
        
        return Result.success(successCount);
    }
} 