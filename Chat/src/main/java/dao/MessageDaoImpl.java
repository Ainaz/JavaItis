package dao;

import models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class MessageDaoImpl implements MessageDao {


    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public MessageDaoImpl(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Message> findAll() {
        return null;
    }

    @Override
    public Message find(int messageId) {
        return null;
    }

    @Override
    public void save(Message message) {

    }

    @Override
    public void update(Message message) {

    }
}
