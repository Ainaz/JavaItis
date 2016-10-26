package dao;

import models.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
    String registration(User users);
    User find(String login);
    User findByToken(String token);
    void update(String token, int id);
}
