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
    private Connection connection;

    public UserServiceImpl(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println(e);
        }
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("CookieBeans.xml");
        this.userDao = (UserDao) applicationContext.getBean("userDao");
    }

    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    public String registrationUser(User users) {
        return userDao.registration(users);
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
