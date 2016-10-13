package dao;

import models.Owner;

/**
 * Created by KFU-user on 12.10.2016.
 */
public interface OwnersDao {
    Owner find(int id);
    void getAll();
    void delete(int id);
    void add(Owner owner);
    void update(Owner owner);
}
