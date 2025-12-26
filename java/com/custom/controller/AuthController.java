package com.custom.controller;

import com.custom.entity.User;
import com.custom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User user) {
        Map<String, Object> res = new HashMap<>();
        if (userService.register(user)) {
            res.put("code", 200);
            res.put("msg", "注册成功");
        } else {
            res.put("code", 400);
            res.put("msg", "用户名已存在");
        }
        return res;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        Map<String, Object> res = new HashMap<>();
        User loginUser = userService.login(user.getUsername(), user.getPassword());
        if (loginUser != null) {
            res.put("code", 200);
            res.put("data", loginUser);
        } else {
            res.put("code", 400);
            res.put("msg", "用户名或密码错误");
        }
        return res;
    }
}