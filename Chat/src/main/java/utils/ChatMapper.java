package utils;

import models.Chat;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ChatMapper implements RowMapper{

    @Override
    public Chat mapRow(ResultSet resultSet, int i) throws SQLException {

        Chat chat = new Chat(resultSet.getInt("chat_id"), resultSet.getString("chat_name"));
        return chat;
    }
}
