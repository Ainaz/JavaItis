package factory;


import dao.CarsDao;
import dao.OwnersDao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.Properties;

public class DaoSupportFactory {
    private static DaoSupportFactory instanse;

    private Properties properties;
    private OwnersDao ownersDao;
    private CarsDao carsDao;

    private DaoSupportFactory(){
       try {
           properties = new Properties();
           properties.load(new FileInputStream("C:\\Users\\KFU-user\\Desktop\\JavaItis\\JdbcDao\\src\\main\\resources\\dao.properties"));

           String carsDaoClass = properties.getProperty("carsdao.class");
           String ownersDaoClass = properties.getProperty("ownersdao.class");

           Class carsClass = Class.forName(carsDaoClass);
           Class ownersClass = Class.forName(ownersDaoClass);

           Constructor carsConstructor = carsClass.getConstructor(Connection.class);
           Constructor ownersConstructor = ownersClass.getConstructor(Connection.class);

           this.carsDao = (CarsDao)carsConstructor.newInstance(ConnectionSupportFactory.getInstance().getConnect());
           this.ownersDao = (OwnersDao)ownersConstructor.newInstance(ConnectionSupportFactory.getInstance().getConnect());

       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       } catch (NoSuchMethodException e) {
           e.printStackTrace();
       } catch (IllegalAccessException e) {
           e.printStackTrace();
       } catch (InstantiationException e) {
           e.printStackTrace();
       } catch (InvocationTargetException e) {
           e.printStackTrace();
       }
    }

    static {
        instanse = new DaoSupportFactory();
    }

    public static DaoSupportFactory getInstanse() {
        return instanse;
    }

    public OwnersDao getOwnersDao() {
        return ownersDao;
    }

    public CarsDao getCarsDao() {
        return carsDao;
    }
}
