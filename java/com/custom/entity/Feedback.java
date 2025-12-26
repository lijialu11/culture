package com.custom.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Feedback {
    private Long id;
    private String username;
    private Long orderId;
    private String content;
    private LocalDateTime createTime;
}