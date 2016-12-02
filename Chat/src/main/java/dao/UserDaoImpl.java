package dao;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import utils.UserMapper;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {

    public static final String SQL_FIND_ALL = "SELECT * FROM chat_users";
    public static final String SQL_FIND = "SELECT * FROM chat_users WHERE user_login=:login";
    public static final String SQL_SAVE = "INSERT INTO chat_users (user_name, user_login, user_password) VALUES (:userName, :login, :password)";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Autowired
    public UserDaoImpl(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<User> findAll() {
        List<User> users = (List<User>)namedParameterJdbcTemplate.query(SQL_FIND_ALL, new UserMapper());
        return users;
    }

    @Override
    public User find(String login) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("login", login);
        User user =(User)namedParameterJdbcTemplate.queryForObject(SQL_FIND, sqlParameterSource, new UserMapper());
        return null;
    }

    @Override
    public void save(User user) {
        Map map = new HashMap();
        map.put("userName", user.getUserName());
        map.put("login", user.getLogin());
        map.put("password", user.getPassword());
        namedParameterJdbcTemplate.update(SQL_SAVE, map);
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(User user, String token) {
    }

    @Override
    public void saveUserToChat(Integer userId, Integer chatId) {

    }
}
