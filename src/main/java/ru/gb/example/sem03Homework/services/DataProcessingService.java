package ru.gb.example.sem03Homework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.example.sem03Homework.domain.User;
import ru.gb.example.sem03Homework.repository.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {
    @Autowired
    private UserRepository repository;
    public List<User> sortUsersByAge(List<User> users) {

        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }
    public List<User> filterUsersByAge(List<User> users, int age) {

        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    public UserRepository getRepository() {
        return repository;
    }

    /**
     * Считает средний возраст
     * @param users список пользователей для счета
     * @return double средний возраст
     */

    public double calculateAverageAge(List<User> users) {

        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);

    }

    /**
     * Добавляет пользователя в список
     * @param user пользователь
     */
    public void addUserToList(User user) {

        repository.getUsers().add(user);

    }
}
