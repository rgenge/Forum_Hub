package com.ForumHub.ForumHub.repository;

import com.ForumHub.ForumHub.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
