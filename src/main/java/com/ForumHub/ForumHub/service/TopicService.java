package com.ForumHub.ForumHub.service;

import com.ForumHub.ForumHub.model.Topic;
import com.ForumHub.ForumHub.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Transactional
    public Topic addTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public Topic getTopicById(Long id) {
        return topicRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Topic not found with id: " + id));
    }

    public void deleteTopic(Long id) {
        Topic topic = topicRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Topic not found with id: " + id));
        topicRepository.delete(topic);
    }

    public Topic editTopic(Long id, Topic topicDetails) {
        Topic topic = topicRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Topic not found with id: " + id));
        topic.setTitle(topicDetails.getTitle());
        topic.setMessage(topicDetails.getMessage());
        return topicRepository.save(topic);
    }

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }
}
