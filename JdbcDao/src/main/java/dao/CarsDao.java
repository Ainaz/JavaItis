package dao;

import models.Car;

/**
 * Created by KFU-user on 12.10.2016.
 */
public interface CarsDao {
    Car find(int id);
    void getAll();
    void delete(int id);
    void add(Car car);
    void update(Car car);
}
