package com.custom.controller;

import com.custom.entity.LogisticsExt;
import com.custom.service.LogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/logistics")
@CrossOrigin(origins = "*")
public class LogisticsController {
    @Autowired
    private LogisticsService logisticsService;

    // 保存物流信息（含快递员）
    @PostMapping("/save")
    public Map<String, Object> saveLogistics(@RequestBody LogisticsExt logistics) {
        logisticsService.saveLogistics(logistics);
        Map<String, Object> res = new HashMap<>();
        res.put("code", 200);
        return res;
    }

    // 根据订单ID查询物流
    @GetMapping("/{orderId}")
    public Map<String, Object> getLogistics(@PathVariable Long orderId) {
        Map<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("data", logisticsService.getLogisticsByOrderId(orderId));
        return res;
    }

    // 追踪物流轨迹
    @GetMapping("/track/{orderId}")
    public Map<String, Object> trackLogistics(@PathVariable Long orderId) {
        Map<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("data", logisticsService.trackLogistics(orderId));
        return res;
    }
}