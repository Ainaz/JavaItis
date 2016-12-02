package dao;

import models.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User find(String login);
    void save(User user);
    void delete(Integer id);
    void update(User user, String token);
    void saveUserToChat(Integer userId, Integer chatId);
}
