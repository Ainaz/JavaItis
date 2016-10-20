package services;

import models.Car;

import java.util.List;

public interface CarsService {
    Car findByCarInId(int id);
    List getAllCars();
    void deleteCarInId(int id);
    void addCar(Car car);
    void updateCars(Car car);
}
