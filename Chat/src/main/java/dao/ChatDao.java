package dao;

import models.Chat;

import java.util.List;

public interface ChatDao {
    List<Chat> findAll();
    Chat find(int chatId);
    void save(Chat chat);
    void update(Chat chat);
}
