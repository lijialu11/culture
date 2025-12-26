package com.custom.entity;

import lombok.Data;

/**
 * 物流扩展实体（含快递员信息）
 */
@Data
public class LogisticsExt {
    private Long orderId;          // 订单ID
    private String company;        // 物流公司
    private String trackingNo;     // 快递单号
    private String progress;       // 物流进度
    private String courierName;    // 快递员姓名
    private String courierPhone;   // 快递员电话
}