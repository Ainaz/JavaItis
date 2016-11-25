package dao;

import models.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Service
public class ChatDaoImpl implements ChatDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ChatDaoImpl(DataSource dataSource){
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public ChatDaoImpl(){
    }


    @Override
    public List<Chat> findAll() {
        List chat = namedParameterJdbcTemplate.query("SELECT * FROM chats", new ChatMapper())
        return null;
    }

    @Override
    public Chat find(int chatId) {
        return null;
    }

    @Override
    public int save(Chat chat) {
        return 0;
    }

    @Override
    public void update(Chat chat) {

    }
}
