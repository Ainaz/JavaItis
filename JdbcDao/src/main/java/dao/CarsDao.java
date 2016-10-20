package dao;

import models.Car;

import java.util.List;


public interface CarsDao {
    Car find(int id);
    List getAll();
    void delete(int id);
    void add(Car car);
    void update(Car car);
}
