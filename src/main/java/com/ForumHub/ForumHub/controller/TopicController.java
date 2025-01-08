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

    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable Long id) {
        Topic topic = topicService.getTopicById(id);
        return ResponseEntity.ok(topic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topic> editTopic(@PathVariable Long id, @Valid @RequestBody Topic topicDetails) {
        Topic updatedTopic = topicService.editTopic(id, topicDetails);
        return ResponseEntity.ok(updatedTopic);
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
