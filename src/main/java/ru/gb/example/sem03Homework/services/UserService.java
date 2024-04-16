package ru.gb.example.sem03Homework.services;

import org.springframework.stereotype.Service;
import ru.gb.example.sem03Homework.domain.User;

@Service
public class UserService {

    private final NotificationService notificationService;

// Внедрение зависимости через конструктор

    public UserService(NotificationService notificationService) {

        this.notificationService = notificationService;

    }

    public User createUser(String name, int age, String email) {

        User user = new User();

        user.setName(name);

        user.setAge(age);

        user.setEmail(email);

        return user;

    }

}