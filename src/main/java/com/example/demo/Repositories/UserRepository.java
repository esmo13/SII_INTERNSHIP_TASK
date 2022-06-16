package com.example.demo.Repositories;

import com.example.demo.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    boolean  existsByEmail(String email);
    User findByLogin(String login);
    boolean existsByLogin(String login);
    User findByLoginAndEmail(String login, String email);
}
