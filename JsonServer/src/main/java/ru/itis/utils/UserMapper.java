package ru.itis.utils;


import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper{
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User(resultSet.getInt("user_id"), resultSet.getString("user_name"),
                resultSet.getString("user_login"), resultSet.getInt("user_password"), resultSet.getString("user_token"));
        return user;
    }
}
