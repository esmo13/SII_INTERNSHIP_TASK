package com.example.demo.Controllers;

import com.example.demo.Entities.Lesson;
import com.example.demo.Services.LessonService;
import com.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path=("/api/lessons"))
public class LessonController {
    private final LessonService lessonService;
    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }
    @GetMapping
    public List<Lesson> getLessons(){
        return lessonService.getLessons();
    }
}
