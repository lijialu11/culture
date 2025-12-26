package com.custom.controller;

import com.custom.entity.ChatMessage;
import com.custom.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "*")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @PostMapping("/send")
    public Map<String, Object> sendMessage(@RequestParam String username, @RequestParam String content) {
        Map<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("data", chatService.sendMessage(username, content));
        return res;
    }

    @GetMapping("/history/{username}")
    public Map<String, Object> getChatHistory(@PathVariable String username) {
        Map<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("data", chatService.getChatHistory(username));
        return res;
    }
}
