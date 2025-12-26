package com.custom.service;

import com.custom.entity.Order;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OrderService {
    private final Map<Long, Order> orderMap = new ConcurrentHashMap<>();
    private long currentId = 1;

    public Order createOrder(Order order) {
        order.setId(currentId++);
        order.setStatus("待审核");
        order.setCreateTime(LocalDateTime.now());
        orderMap.put(order.getId(), order);
        return order;
    }

    // 确保方法名是getOrdersByUsername
    public List<Order> getOrdersByUsername(String username) {
        List<Order> userOrders = new ArrayList<>();
        for (Order order : orderMap.values()) {
            if (order.getUsername().equals(username)) {
                userOrders.add(order);
            }
        }
        userOrders.sort((o1, o2) -> o2.getCreateTime().compareTo(o1.getCreateTime()));
        return userOrders;
    }

    public Order getOrderById(Long id) {
        return orderMap.get(id);
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orderMap.values());
    }

    public boolean updateOrderStatus(Long id, String status) {
        if (orderMap.containsKey(id)) {
            Order order = orderMap.get(id);
            order.setStatus(status);
            orderMap.put(id, order);
            return true;
        }
        return false;
    }
}