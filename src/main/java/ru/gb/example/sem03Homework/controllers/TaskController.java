package ru.gb.example.sem03Homework.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.example.sem03Homework.domain.User;
import ru.gb.example.sem03Homework.services.DataProcessingService;

import java.util.ArrayList;
import java.util.List;

/**
 * Контроллер задач.
 */

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private DataProcessingService service;
    /**
     Показывает доступные задачи
     */
    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    /**
     * Сортирует пользователей по возрасту
     * @return отсортированный список
     */
    @GetMapping("/sort")
    public List<User> sortUsersByAge() {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    /**
     * Фильтрует пользователей по возрасту
     * @param age возраст
     * @return отфильтрованный список
     */

    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable int age) {
        return service.getRepository().getUsers().stream()
                .filter(user -> user.getAge() > age)
                .toList().stream().toList();
    }

    /**
     * Показывает средний возраст пользователей
     * @return средний возраст
     */
    @GetMapping("/calc")
    public double calculateAverageAge() {
        return service.calculateAverageAge(service.getRepository().getUsers());
    }
}
