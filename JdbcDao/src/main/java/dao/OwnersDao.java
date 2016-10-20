package dao;

import models.Owner;

import java.util.List;

public interface OwnersDao {
    Owner find(int id);
    List getAll();
    void delete(int id);
    void add(Owner owner);
    void update(Owner owner);
}
