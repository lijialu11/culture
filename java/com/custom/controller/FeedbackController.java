package com.custom.controller;

import com.custom.entity.Feedback;
import com.custom.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "*")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/submit")
    public Map<String, Object> submitFeedback(@RequestBody Feedback feedback) {
        feedbackService.submitFeedback(feedback);
        Map<String, Object> res = new HashMap<>();
        res.put("code", 200);
        return res;
    }
}