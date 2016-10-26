package services;

import dao.AutoDao;
import models.Auto;

import java.util.List;

public class AutoServiceImpl implements AutoService {
    private AutoDao autoDao;
    public List<Auto> getAllAuto() {
        return autoDao.getAll();
    }

    public Auto findAuto(int id) {
        return autoDao.find(id);
    }

    public void addAuto(Auto auto) {
        this.autoDao.add(auto);
    }
}
