package com.example.demo.Services;

import com.example.demo.Entities.User;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
@Transactional
    public void updateUser(Long id, String newEmail){
    User user = userRepository.findById(id).orElseThrow(()->new IllegalStateException("user with id" + id + " does not exist"));
    if (newEmail != null && newEmail.length() > 0 && !Objects.equals(user.getEmail(), newEmail) && !userRepository.existsByEmail(newEmail)) {
        user.setEmail(newEmail);
    }
    else throw new IllegalStateException("user with such email already exists");
    }
    public User addUser(User user){
        return userRepository.save(user);
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }
    public User getUserByName(String name){
        return userRepository.findByLogin(name);
    }
    public boolean existsByName(String name){
        return userRepository.existsByLogin(name);
    }
    public User getUserByNameAndEmail(String name, String email){
        return userRepository.findByLoginAndEmail(name,email);
    }
    public Long countUsers(){
        return userRepository.count();
    }
}
