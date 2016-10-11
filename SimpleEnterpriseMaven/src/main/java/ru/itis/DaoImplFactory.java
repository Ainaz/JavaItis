package ru.itis;

import ru.itis.dao.UsersDao;
import ru.itis.service.SimpleUsersService;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Ainaz on 11.10.2016.
 */
public class DaoImplFactory {
    private static DaoImplFactory instance;

    private Properties properties;
    private UsersDao usersDao;
    private SimpleUsersService service;

    private DaoImplFactory(){
        properties = new Properties();

        try {
            properties.load(new FileInputStream("C:\\Users\\Ainaz\\Desktop\\JavaItis\\SimpleEnterpriseMaven\\src\\main\\resources\\dao.properties"));

            String daoClass = properties.getProperty("dao.class");
            String serviceClass = properties.getProperty("service.class");

            usersDao = (UsersDao)Class.forName(daoClass).newInstance();
            service = (SimpleUsersService)Class.forName(serviceClass).newInstance();
            service.setUsersDao(usersDao);
        }catch (IOException e) {
            throw new IllegalArgumentException(e);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException();
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException();
        } catch (InstantiationException e) {
            throw new IllegalArgumentException();
        }
    }

    static {
        instance = new DaoImplFactory();
    }

    public static DaoImplFactory getInstance() {
        return instance;
    }

    public UsersDao getUsersDao() {
        return usersDao;
    }

    public Properties getDaoProperties() {
        return properties;
    }

    public SimpleUsersService getService() {
        return service;
    }
}
