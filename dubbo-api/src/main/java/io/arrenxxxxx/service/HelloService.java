package io.arrenxxxxx.service;

import io.arrenxxxxx.model.Result;
import io.arrenxxxxx.model.User;

import java.util.List;
import java.util.Map;

public interface HelloService {
    // 原有方法：字符串参数
    String sayHello(String name);
    
    // 无参方法
    String sayHello();
    
    // 对象参数
    Result<User> getUserInfo(User user);
    
    // 数组参数
    List<User> getUserList(String[] names);
    
    // Map参数
    Map<String, User> getUserMap(Map<String, Object> params);
    
    // 组合参数
    Result<List<User>> searchUsers(String keyword, int page, int size);
    
    // List<User>入参
    Result<Integer> batchSaveUsers(List<User> users);
} 