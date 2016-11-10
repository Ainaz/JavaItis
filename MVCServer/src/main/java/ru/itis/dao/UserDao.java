package ru.itis.dao;

import ru.itis.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
    void registration(User users);
    User find(String login);
    User findByToken(String token);
    void update(String token, int id);
}
