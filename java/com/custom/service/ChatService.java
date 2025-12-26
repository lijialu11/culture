package com.custom.service;

import com.custom.entity.ChatMessage;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChatService {
    private final Map<String, List<ChatMessage>> chatRecords = new HashMap<>();

    // 发送消息
    public List<ChatMessage> sendMessage(String username, String content) {
        chatRecords.computeIfAbsent(username, k -> new ArrayList<>());
        // 用户消息
        ChatMessage userMsg = new ChatMessage();
        userMsg.setSender("user");
        userMsg.setContent(content);
        userMsg.setTime(LocalDateTime.now());
        chatRecords.get(username).add(userMsg);
        // 客服回复（模拟）
        ChatMessage adminMsg = new ChatMessage();
        adminMsg.setSender("admin");
        adminMsg.setContent("已收到您的消息：" + content);
        adminMsg.setTime(LocalDateTime.now());
        chatRecords.get(username).add(adminMsg);
        return chatRecords.get(username);
    }

    // 获取聊天记录
    public List<ChatMessage> getChatHistory(String username) {
        return chatRecords.getOrDefault(username, new ArrayList<>());
    }
}
