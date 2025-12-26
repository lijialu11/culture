package com.custom.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ChatMessage {
    private String sender;         // "user"或"admin"
    private String content;
    private LocalDateTime time;
}