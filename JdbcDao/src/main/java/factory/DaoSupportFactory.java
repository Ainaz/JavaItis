package factory;


import dao.CarsDao;
import dao.OwnersDao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DaoSupportFactory {
    private static DaoSupportFactory instanse;

    private Properties properties;
    private OwnersDao ownersDao;
    private CarsDao carsDao;

    private DaoSupportFactory(){
       try {
           properties = new Properties();
           properties.load(new FileInputStream("C:\\Users\\Ainaz\\Desktop\\JavaItis\\JdbcDao\\src\\main\\resources\\dao.properties"));

           String carsDaoClass = properties.getProperty("carsdao.class");
           String ownersDaoClass = properties.getProperty("ownersdao.class");


       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }


    }
}
