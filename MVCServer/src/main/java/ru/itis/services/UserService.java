package ru.itis.services;


import ru.itis.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void registrationUser(User users);
    User findUserByLogin(String login);
    User findUserByToken(String token);
    void updateUser(String token, int id);
}
