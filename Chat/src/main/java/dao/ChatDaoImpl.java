package dao;

import models.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import utils.ChatMapper;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Service
public class ChatDaoImpl implements ChatDao {

    public static final String SQL_FIND_ALL = "SELECT * FROM chats";
    public static final String SQL_FIND = "SELECT * FROM chat WHERE chat_id=:chatId";
    public static final String SQL_SAVE = "INSERT INTO chat(chat_name, user_id) VALUES(:chatName, :userId)";
    public static final String SQL_UPDATE = "UPDATE chat SET chat_name=:chatName WHERE chat_id=:chatId";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ChatDaoImpl(DataSource dataSource){
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public ChatDaoImpl(){
    }


    @Override
    public List<Chat> findAll() {
        List chat = namedParameterJdbcTemplate.query(SQL_FIND_ALL, new ChatMapper());
        return chat;
    }

    @Override
    public Chat find(int chatId) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("chatId", chatId);
        Chat chat = (Chat)namedParameterJdbcTemplate.queryForObject(SQL_FIND, sqlParameterSource, new ChatMapper());
        return chat;
    }

    @Override
    public void save(Chat chat) {
        Map map = new HashMap<>();
        map.put("chatName", chat.getChatName());
        map.put("userId", chat.getUserId());
        namedParameterJdbcTemplate.update(SQL_SAVE, map);
    }

    @Override
    public void update(Chat chat) {
        Map map = new HashMap<>();
        map.put("chatName", chat.getChatName());
        map.put("userId", chat.getUserId());
        namedParameterJdbcTemplate.update(SQL_UPDATE, map);
    }
}
