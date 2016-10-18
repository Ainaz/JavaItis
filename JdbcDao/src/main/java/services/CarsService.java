package services;

import models.Car;

public interface CarsService {
    Car findByCarInId(int id);
    void getAllCars();
    void deleteCarInId(int id);
    void addCar(Car car);
    void updateCars(Car car);
}
