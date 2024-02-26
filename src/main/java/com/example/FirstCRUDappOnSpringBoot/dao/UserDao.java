package com.example.FirstCRUDappOnSpringBoot.dao;

import com.example.FirstCRUDappOnSpringBoot.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();


    void addUser(User user);


    void deleteUser(Long id);

    User getUserById(Long id);

    void updateUser(User user);
}
