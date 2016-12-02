package utils;

import models.Message;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageMapper implements RowMapper {
    @Override
    public Message mapRow(ResultSet resultSet, int i) throws SQLException {
        Message message = new Message(resultSet.getInt("message_id"), resultSet.getString("message_text"), resultSet.getInt("user_id"), resultSet.getInt("chat_id"));
        return message;
    }
}
