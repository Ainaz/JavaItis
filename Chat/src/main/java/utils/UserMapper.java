package utils;

import models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper{
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User(resultSet.getInt("userId"), resultSet.getString("userName"), resultSet.getString("login"),resultSet.getInt("password"));
        return user;
    }
}
