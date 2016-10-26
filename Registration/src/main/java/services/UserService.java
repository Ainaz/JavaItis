package services;


import models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    String registrationUser(User users);
    User findUserByLogin(String login);
    User findUserByToken(String token);
    void updateUser(String token, int id);
}
