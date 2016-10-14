package dao;

import models.Car;


public interface CarsDao {
    Car find(int id);
    void getAll();
    void delete(int id);
    void add(Car car);
    void update(Car car);
}
