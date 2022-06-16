package com.example.demo.Controllers;

import com.example.demo.Entities.Lesson;
import com.example.demo.Entities.User;
import com.example.demo.Services.LessonService;
import com.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    public ResponseEntity<Object> signToLesson(@PathVariable("LessonID")Long lessonId , @RequestBody User user) {
        try {
            lessonService.signToLesson(lessonId, user);

            return new ResponseEntity<>("signed successfully", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);


        }
    }
    @PutMapping(path="unsign/{LessonID}")
    public ResponseEntity<Object> unsignFromLesson(@PathVariable("LessonID") Long lessonId, @RequestBody User user){
        try{
            lessonService.unsignFromLesson(lessonId,user);
            return new ResponseEntity<>("Operation successful",HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping(path="{username}")
    public List<Lesson> getLessonsByUsername(@PathVariable String username){
        return lessonService.getReservedLessons(username);
    }
    @GetMapping(path="/org/lessons")
    public Map<String,Float> getLessonPopularity(){
        return lessonService.getLessonPopulatiry();
    }
    @GetMapping(path="/org/topics")
    public Map <String,Float> getTopicPopularity(){
        return lessonService.getTopicPopularity();
    }
}
