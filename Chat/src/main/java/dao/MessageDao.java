package dao;

import models.Message;

import java.util.List;

public interface MessageDao {
    List<Message> findAll();
    Message find(int messageId);
    void save(Message message);
    void update(Message message);
}
