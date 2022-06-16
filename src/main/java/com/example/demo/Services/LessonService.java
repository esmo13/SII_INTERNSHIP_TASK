package com.example.demo.Services;

import com.example.demo.Entities.Lesson;
import com.example.demo.Repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;
    @Autowired
    LessonService(LessonRepository lessonRepository){
        this.lessonRepository=lessonRepository;
    }
    public List<Lesson> getLessons(){
        return lessonRepository.findAll();
    }
}
