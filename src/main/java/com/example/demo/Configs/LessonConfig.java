package com.example.demo.Configs;

import com.example.demo.Entities.Lesson;
import com.example.demo.Entities.User;
import com.example.demo.Repositories.LessonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class LessonConfig {
 @Bean(name = "lessoncfg")
    CommandLineRunner commandLineRunner(LessonRepository repository){
        Set<User> set = new HashSet<>();
        String str= "2012-06-01 10:00";
        String str2= "2012-06-01 12:00";
        String str3= "2012-06-01 14:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println(new Lesson("Topic", LocalDateTime.parse(str,formatter),set).toString());
        return args -> {
           Lesson lesson1 = new Lesson(
                   "Topic1",
                   LocalDateTime.parse(str,formatter),
                   set


            ),
                   lesson2 = new Lesson(
                           "Topic2",
                           LocalDateTime.parse(str,formatter),
                           set
                   ),
                   lesson3 = new Lesson(
                           "Topic3",
                           LocalDateTime.parse(str,formatter),
                           set),
                   lesson4 = new Lesson(
                           "Topic1",
                           LocalDateTime.parse(str2,formatter),
                           set
                   ),
                   lesson5 = new Lesson(
                           "Topic2",
                           LocalDateTime.parse(str2,formatter),
                           set
                   ),lesson6 = new Lesson(
                    "Topic3",
                    LocalDateTime.parse(str2,formatter),
                    set
            ),
                   lesson7 = new Lesson(
                           "Topic1",
                           LocalDateTime.parse(str3,formatter),
                           set
                   ),
                   lesson8 = new Lesson(
                           "Topic2",
                           LocalDateTime.parse(str3,formatter),
                           set
                   ),
                   lesson9 = new Lesson(
                           "Topic3",
                           LocalDateTime.parse(str3,formatter),
                           set
                   );
           repository.saveAll(List.of(lesson1,lesson2,lesson3,lesson4,lesson5,lesson6,lesson7,lesson8,lesson9));


    };
}}
