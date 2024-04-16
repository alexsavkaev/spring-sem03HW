package ru.gb.example.sem03Homework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.example.sem03Homework.domain.User;
/*
Создать сервис "RegistrationService", который принимает на вход данные о пользователе (имя, возраст, email),
 создает пользователя с помощью UserService, затем использует DataProcessingService для добавления пользователя
 в список и выполнения операций над этим списком. После выполнения каждой операции,
 использовать NotificationService для вывода информации о выполненной операции.
 */
@Service

public class RegistrationService {
    @Autowired
    private UserService userService;
    @Autowired
    private DataProcessingService dataProcessingService;

    private final NotificationService notificationService;

    public RegistrationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    /**
     * Создает пользователя с помощью UserService и добавляет его в список с помощью DataProcessingService
     * и отправляет уведомление о создании нового пользователя с помощью NotificationService
     * @param name имя
     * @param age возраст
     * @param email email
     */
    public void processRegistration(String name, int age, String email) {
        User user = userService.createUser(name, age, email);
        dataProcessingService.getRepository().getUsers().add(user);
        notificationService.notifyUser(user);
    }

}
