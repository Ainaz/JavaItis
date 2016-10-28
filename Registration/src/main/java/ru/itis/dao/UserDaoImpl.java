package ru.itis.dao;

import ru.itis.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl implements UserDao {

    private Connection connection;

    private final String SQL_ALL_USERS = "SELECT * FROM users";
    private final String SQL_UPDATE_USERS = "UPDATE users SET user_token = ? WHERE user_id=?;";
    private final String SQL_REGISTRATION = "INSERT INTO users (user_name, user_login, user_password, user_token) VALUES(?,?,?,?)";
    private final String SQL_FIND_USER = "SELECT * FROM users WHERE user_login=?";
    private final String SQL_FIND_USER_BY_TOKEN = "SELECT * FROM users WHERE user_token=?";

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }

    public List<User> getAll() {
        List<User> userList = new ArrayList();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ALL_USERS);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()){
                int userId = result.getInt("user_id");
                String userName = result.getString("user_name");
                String login = result.getString("user_login");
                int password = result.getInt("user_password");
                String token = result.getString("user_token");
                User user = new User(userId, userName, login, password, token);
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public String registration(User users) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_REGISTRATION);
            preparedStatement.setString(1, users.getUserName());
            preparedStatement.setString(2, users.getUserLogin());
            preparedStatement.setInt(3, users.getUserPassword());
            preparedStatement.setString(4, "");

            return users.getUserName() + " зарегестрирован!";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Ошибка при регистрации!";
        }

    }

    public User find(String login) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_USER);
            preparedStatement.setString(1, login);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            User user = new User(resultSet.getInt("user_id"), resultSet.getString("user_name"),
                    resultSet.getString("user_login"), resultSet.getInt("user_password"),
                    resultSet.getString("user_token"));
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User findByToken(String token) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_USER_BY_TOKEN);
            preparedStatement.setString(1, token);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            User user = new User(resultSet.getInt("user_id"), resultSet.getString("user_name"),
                    resultSet.getString("user_login"), resultSet.getInt("user_password"),
                    resultSet.getString("user_token"));
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(String token, int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_USERS);
            preparedStatement.setString(1, token);
            preparedStatement.setInt(2, id);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

}
