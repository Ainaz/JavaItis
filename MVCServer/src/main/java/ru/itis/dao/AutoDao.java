package ru.itis.dao;

import ru.itis.models.Auto;

import java.util.List;

public interface AutoDao {
    List<Auto> getAll();
    Auto find(int id);
    void add(Auto auto);
}
