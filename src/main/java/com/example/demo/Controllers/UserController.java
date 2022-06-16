package com.example.demo.Controllers;

import com.example.demo.Classes.UserPutForm;
import com.example.demo.Entities.User;
import com.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/users")
public class UserController {
    private final UserService userService;
@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PutMapping(path="{userId}")
    public void updateUser(@PathVariable("userId") Long userId
            ,@RequestBody UserPutForm userPutForm)
    {
        userService.updateUser(userId,userPutForm.getEmail());
    }
    @PostMapping
    public User addUser(@RequestBody User user){
    return userService.addUser(user);

        }
    @GetMapping
    public List<User> getUsers(){
    return userService.getUsers();
    }


    }

