package com.example.demo.Repositories;

import com.example.demo.Entities.Lesson;
import com.example.demo.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson,Long> {
    List<Lesson> findAllByUsersContaining(User user);
    List<Lesson> findAllByDateTime(LocalDateTime dateTime);
    List<Lesson> getLessonByTopic(String topic);
    @Query("select distinct l.topic from Lesson l")
    List<String> getDistinctTopics();
}
