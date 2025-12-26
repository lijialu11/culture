package com.custom.entity;

import lombok.Data;

@Data
public class Logistics {
    private Long orderId;
    private String company;        // 物流公司
    private String trackingNo;     // 快递单号
    private String progress;       // 物流进度
}