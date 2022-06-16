package com.example.demo.Controllers;

import com.example.demo.Entities.Lesson;
import com.example.demo.Entities.User;
import com.example.demo.Services.LessonService;
import com.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping(path="{LessonID}")

    public void signToLesson(@PathVariable("LessonID")Long lessonId ,@RequestBody User user){
    lessonService.signToLesson(lessonId,user);

    }
    @ExceptionHandler
    public String handleException(){
        return "sum think wronk";
    }
}
