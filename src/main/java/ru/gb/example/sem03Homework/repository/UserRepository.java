package ru.gb.example.sem03Homework.repository;

import org.springframework.stereotype.Component;
import ru.gb.example.sem03Homework.domain.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    private List<User> users = new ArrayList<>();
}
