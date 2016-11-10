package ru.itis.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.dao.AutoDao;
import ru.itis.models.Auto;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AutoServiceImpl implements AutoService {
    private AutoDao autoDao;

    public AutoServiceImpl(AutoDao autoDao) {
        this.autoDao = autoDao;
    }

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
