package ru.gb.example.sem03Homework.services;

import org.springframework.stereotype.Service;
import ru.gb.example.sem03Homework.domain.User;

@Service
public class NotificationService {
    /**
     * Отправляет уведомление о создании нового пользователя
     * @param user пользователь
     */

    public void notifyUser(User user) {

        System.out.println("A new user has been created: " + user.getName());

    }

}