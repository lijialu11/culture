package com.custom.service;

import com.custom.entity.Feedback;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class FeedbackService {
    private final List<Feedback> feedbackList = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    // 提交反馈
    public void submitFeedback(Feedback feedback) {
        feedback.setId(idGenerator.getAndIncrement());
        feedback.setCreateTime(LocalDateTime.now());
        feedbackList.add(feedback);
    }
}
