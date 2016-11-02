package ru.itis.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.dao.UserDao;
import ru.itis.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    public void registrationUser(User users) {
        this.userDao.registration(users);
    }

    public User findUserByLogin(String login) {
        return userDao.find(login);
    }

    public User findUserByToken(String token) {
        return userDao.findByToken(token);
    }

    public void updateUser(String token, int id) {
        this.userDao.update(token, id);
    }
}
