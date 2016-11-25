package dao;

import models.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User find(Integer id);
    Integer save(User user);
    void delete(Integer id);
    void update(User user);
    void saveUserToChat(Integer userId, Integer chatId);
}
