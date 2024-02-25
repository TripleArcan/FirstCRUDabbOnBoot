package com.example.FirstCRUDappOnSpringBoot.dao;

import com.example.FirstCRUDappOnSpringBoot.model.User;
import com.example.FirstCRUDappOnSpringBoot.servise.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Component
public class UserServiceDAO implements UserService {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT e FROM User e", User.class).getResultList();
    }
    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));;
        }
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }
}
