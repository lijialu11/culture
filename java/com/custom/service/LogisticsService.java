package com.custom.service;

import com.custom.entity.LogisticsExt;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 物流服务（含快递员信息和轨迹追踪）
 */
@Service
public class LogisticsService {
    // 存储物流信息（键：订单ID）
    private final Map<Long, LogisticsExt> logisticsMap = new HashMap<>();
    // 模拟物流轨迹
    private final String[] PROGRESS_LIST = {
            "商家已发货，快递员取件中",
            "快递员已取件，运输中",
            "快件到达中转中心",
            "快件离开中转中心，前往目的地",
            "快件到达派送点",
            "快递员正在派送",
            "快件已签收"
    };

    // 保存物流信息（含快递员）
    public void saveLogistics(LogisticsExt logistics) {
        // 初始化物流进度
        logistics.setProgress(PROGRESS_LIST[0]);
        logisticsMap.put(logistics.getOrderId(), logistics);
    }

    // 根据订单ID查询物流
    public LogisticsExt getLogisticsByOrderId(Long orderId) {
        return logisticsMap.get(orderId);
    }

    // 追踪物流轨迹（模拟更新进度）
    public LogisticsExt trackLogistics(Long orderId) {
        LogisticsExt logistics = logisticsMap.get(orderId);
        if (logistics == null) return null;

        // 随机更新物流进度（模拟真实轨迹）
        Random random = new Random();
        int currentIndex = 0;
        for (int i = 0; i < PROGRESS_LIST.length; i++) {
            if (PROGRESS_LIST[i].equals(logistics.getProgress())) {
                currentIndex = i;
                break;
            }
        }
        // 进度未到最后则更新
        if (currentIndex < PROGRESS_LIST.length - 1) {
            logistics.setProgress(PROGRESS_LIST[currentIndex + 1]);
        }
        return logistics;
    }
}