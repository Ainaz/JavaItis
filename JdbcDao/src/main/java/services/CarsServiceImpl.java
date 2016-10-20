package services;

import dao.CarsDao;
import models.Car;

import java.util.List;

public class CarsServiceImpl implements CarsService {

    private CarsDao carsDao;

    public CarsServiceImpl(CarsDao carsDao) {
        this.carsDao = carsDao;
    }

    public Car findByCarInId(int id) {
        return carsDao.find(id);
    }

    public List getAllCars() {
        return this.carsDao.getAll();
    }

    public void deleteCarInId(int id) {
        this.carsDao.delete(id);
    }

    public void addCar(Car car) {
        this.carsDao.add(car);
    }

    public void updateCars(Car car) {
        this.carsDao.update(car);
    }
}
