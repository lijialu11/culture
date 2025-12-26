package com.custom.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Order {
    private Long id;
    private String username;       // 下单用户
    private String productType;    // 产品类型（书签/保温杯等）
    private String size;           // 尺寸
    private String material;       // 材质
    private String imagePath;      // 图片Base64
    private String contact;        // 联系方式
    private int quantity;          // 定制数量
    private LocalDateTime expectDate; // 期望到货日期
    private int expectDays;        // 期望到货时长（天）
    private String status;         // 订单状态：待审核/待生产/已发货/已完成
    private LocalDateTime createTime; // 创建时间
}