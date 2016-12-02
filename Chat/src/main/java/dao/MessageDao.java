package dao;

import dto.MessageDto;
import models.Message;

import java.util.List;

public interface MessageDao {
    List<Message> findAll();
    Message find(Integer messageId);
    void save(MessageDto messageDto, Integer userId);
    void update(Message message);
}
