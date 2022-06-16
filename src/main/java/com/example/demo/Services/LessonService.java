package com.example.demo.Services;

import com.example.demo.Entities.Lesson;
import com.example.demo.Entities.User;
import com.example.demo.Repositories.LessonRepository;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;
    private final UserService userService;
    @Autowired
    LessonService(LessonRepository lessonRepository,UserService userService){
        this.lessonRepository=lessonRepository;
        this.userService = userService;

    }
    public List<Lesson> getLessons(){
        return lessonRepository.findAll();
    }
    public List<Lesson> getReservedLessons(Long userid){
    return lessonRepository.findAllByUsersContaining(userService.getUserById(userid).get());
    }
    @Transactional
    public void signToLesson(Long lessonId, User user){
        User user_ ;
        if(userService.existsByName(user.getLogin())) {
             user_ = userService.getUserByName(user.getLogin());
             if(!user_.getEmail().equals(user.getEmail()) ){
                 throw new IllegalStateException("user with such login already exists");
             }
        }
        else{
             user_ = userService.addUser(user);
        }

       Lesson lesson = lessonRepository.findById(lessonId).orElseThrow(()-> new IllegalStateException("lesson not found"));
        Set<User> set = lesson.getUsers();
        if(set.size()>=5){
            throw new IllegalStateException("lesson is full");
        }
        else if (set.contains(user_)){
            throw new IllegalStateException("You are already signed for this lesson");
        }

        else{
            set.add(user_);
            lesson.setUsers(set);
        }

    }
    @Transactional
    public void unsignFromLesson(Long lessonId, User user){
        User user_ = userService.getUserByNameAndEmail(user.getLogin(),user.getEmail()) ;
        if (user_ != null) {
            Lesson lesson = lessonRepository.findById(lessonId).orElseThrow(()-> new IllegalStateException("lesson not found"));
            Set<User> set = lesson.getUsers();
            if(set.contains(user_)){
                set.remove(user_);
                lesson.setUsers(set);
            }
            else{
                throw new IllegalStateException("You are not signed for this lesson");
            }
        }
        else
            throw new IllegalStateException("user does not exist");

    }
}
