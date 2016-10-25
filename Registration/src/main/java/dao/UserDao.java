package dao;

import models.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
    void add(User autos);
    User find(int id);
}
