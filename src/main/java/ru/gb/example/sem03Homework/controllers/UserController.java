package ru.gb.example.sem03Homework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.example.sem03Homework.domain.User;
import ru.gb.example.sem03Homework.services.RegistrationService;

import java.util.List;
/*
В классе UserController добавить обработчик userAddFromParam
извлекающий данные для создания пользователя из параметров HTTP запроса
 */

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RegistrationService service;

    /**
     * Показывает список пользователей
     * @return список всех пользователей
     */
    @GetMapping
    public List<User> userList(){
        return service.getDataProcessingService().getRepository().getUsers();
    }

    /**
     * Добавляет пользователя из тела HTTP запроса
     * @param user пользователь
     * @return сообщение о добавлении
     */

    @PostMapping("/body")
    public String UserAddFromBody(@RequestBody User user){
        service.getDataProcessingService().getRepository().getUsers().add(user);
        return "201 Created";
    }

    /**
     * Добавляет пользователя из параметров HTTP запроса
     * @param name имя
     * @param age возраст
     * @param email email
     * @return сообщение о добавлении
     */
    @PostMapping("/userAddFromParam")
    public String userAddFromParam(@RequestParam String name, @RequestParam int age, @RequestParam String email) {
        service.processRegistration(name, age, email);
        return "201 Created";
    }
}
