package dao;

import models.Chat;

import java.util.List;

public interface ChatDao {
    List<Chat> findAll();
}
