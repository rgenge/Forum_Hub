package com.ForumHub.ForumHub.controller;

import com.ForumHub.ForumHub.model.Topic;
import com.ForumHub.ForumHub.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/topics")
@Validated
public class TopicController {

    @Autowired
    private TopicService topicService;

    @PostMapping
    public ResponseEntity<Topic> addTopic(@Valid @RequestBody Topic topic) {
        Topic savedTopic = topicService.addTopic(topic);
        return ResponseEntity.ok(savedTopic);
    }

    @GetMapping
    public ResponseEntity<List<Topic>> getAllTopics() {
        List<Topic> topics = topicService.getAllTopics();
        return ResponseEntity.ok(topics);
    }

}
