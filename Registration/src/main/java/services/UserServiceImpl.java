package services;

import dao.AutoDao;
import dao.UserDao;
import models.User;

import java.util.List;


public class UserServiceImpl implements UserService {
    private UserDao userDao;

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
