package com.custom.controller;

import com.custom.entity.Order;
import com.custom.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public Map<String, Object> createOrder(@RequestBody Order order) {
        Map<String, Object> res = new HashMap<>();
        Order newOrder = orderService.createOrder(order);
        res.put("code", 200);
        res.put("data", newOrder);
        return res;
    }

    // 修正：将getOrdersByUser改为getOrdersByUsername
    @GetMapping("/user/{username}")
    public Map<String, Object> getOrdersByUser(@PathVariable String username) {
        Map<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("data", orderService.getOrdersByUsername(username)); // 方法名修正
        return res;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getOrderById(@PathVariable Long id) {
        Map<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("data", orderService.getOrderById(id));
        return res;
    }

    @PostMapping("/updateStatus")
    public Map<String, Object> updateStatus(@RequestParam Long id, @RequestParam String status) {
        Map<String, Object> res = new HashMap<>();
        res.put("code", orderService.updateOrderStatus(id, status) ? 200 : 400);
        return res;
    }

    @GetMapping("/all")
    public Map<String, Object> getAllOrders() {
        Map<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("data", orderService.getAllOrders());
        return res;
    }
}