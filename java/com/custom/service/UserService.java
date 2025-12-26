package com.custom.service;

import com.custom.entity.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> userList = new ArrayList<>();
    // 初始化管理员账号
    {
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("admin123");
        admin.setRole("admin");
        userList.add(admin);
    }

    // 注册
    public boolean register(User user) {
        if (getUserByUsername(user.getUsername()) != null) return false;
        user.setRole("user");
        userList.add(user);
        return true;
    }

    // 登录
    public User login(String username, String password) {
        return userList.stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst().orElse(null);
    }

    // 根据用户名查询
    public User getUserByUsername(String username) {
        return userList.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst().orElse(null);
    }
}