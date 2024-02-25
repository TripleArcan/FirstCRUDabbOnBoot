package com.example.FirstCRUDappOnSpringBoot.servise;

import com.example.FirstCRUDappOnSpringBoot.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {
    List<User> getAllUsers();

    public void addUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);

    void updateUser(User user);
}
