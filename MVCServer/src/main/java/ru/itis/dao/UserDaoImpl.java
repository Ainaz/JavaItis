package ru.itis.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import ru.itis.models.User;
import ru.itis.utils.UserMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserDaoImpl implements UserDao {

    private Connection connection;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final String SQL_ALL_USERS = "SELECT * FROM users";
    private final String SQL_UPDATE_USERS = "UPDATE users SET user_token =:userToken WHERE user_id=:userId;";
    private final String SQL_REGISTRATION = "INSERT INTO users (user_name, user_login, user_password, user_token) VALUES (:userName, :userLogin, :userPassword, :userToken)";
    private final String SQL_FIND_USER = "SELECT * FROM users WHERE user_login=:userLogin";
    private final String SQL_FIND_USER_BY_TOKEN = "SELECT * FROM users WHERE user_token=:userToken";

    public UserDaoImpl(DataSource dataSource, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        try {
            this.connection = dataSource.getConnection();
            this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<User> getAll() {
        List<User> user = (List<User>)namedParameterJdbcTemplate.query(SQL_ALL_USERS, new UserMapper());
        return user;
    }

    public void registration(User users) {
        Map map = new HashMap();
        map.put("userName", users.getUserName());
        map.put("userLogin", users.getUserLogin());
        map.put("userPassword", users.getUserPassword());
        map.put("userToken", "");
        System.out.println(map.toString());
        namedParameterJdbcTemplate.update(SQL_REGISTRATION, map);
    }

    public User find(String login) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("userLogin", login);
        User user = (User)namedParameterJdbcTemplate.queryForObject(SQL_FIND_USER, sqlParameterSource, new UserMapper());
        return user;
    }

    public User findByToken(String token) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("userToken", token);
        User user = (User)namedParameterJdbcTemplate.queryForObject(SQL_FIND_USER_BY_TOKEN, sqlParameterSource, new UserMapper());
        return user;
    }

    public void update(String token, int id) {
        Map map = new HashMap();
        map.put("userToken", token);
        map.put("userId", id);
        namedParameterJdbcTemplate.update(SQL_UPDATE_USERS, map);
    }

}
