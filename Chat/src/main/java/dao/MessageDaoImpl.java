package dao;

import dto.MessageDto;
import models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import utils.MessageMapper;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageDaoImpl implements MessageDao {


    public static final String SQL_FIND_ALL = "SELECT * FROM messages";
    public static final String SQL_FIND_BY_ID = "SELECT * FROM message WHERE message_id=:messageId";
    public static final String SQL_SAVE = "INSERT INTO message (message_text, user_id, chat_id) VALUES (:messageText, :userId, :chatId)";
    public static final String SQL_UPDATE = "UPDATE user_message SET last_message_id=:messageId WHERE user_id=:userId AND chat_id=:chatId";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public MessageDaoImpl(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public MessageDaoImpl(){
    }

    @Override
    public List<Message> findAll() {
        List<Message> messages = namedParameterJdbcTemplate.query(
                SQL_FIND_ALL, new MessageMapper());
        return messages;
    }

    @Override
    public Message find(Integer messageId) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("messageId", messageId);
        Message message = (Message)namedParameterJdbcTemplate.queryForObject(
                SQL_FIND_BY_ID, sqlParameterSource, new MessageMapper());
        return null;
    }

    @Override
    public void save(MessageDto messageDto, Integer userId) {
        Map map = new HashMap();
        map.put("messageText",messageDto.getMessageText());
        map.put("userId", userId);
        map.put("chatId", messageDto.getChatId());
        namedParameterJdbcTemplate.update(SQL_SAVE, map);
    }

    @Override
    public void update(Message message) {
        Map map = new HashMap();
        map.put("messageText", message.getMessageText());
        map.put("userId", message.getUserId());
        map.put("chatId", message.getChatId());
        namedParameterJdbcTemplate.update(SQL_UPDATE, map);
    }
}
