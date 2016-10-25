package factory;

import dao.CarsDao;
import dao.OwnersDao;
import services.CarsService;
import services.OwnersService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class ServicesSupportFactory {
    private static ServicesSupportFactory instance;

    private Properties properties;
    private CarsService carsService;
    private OwnersService ownersService;

    private ServicesSupportFactory(){
        try{
            properties = new Properties();
            properties.load(new FileInputStream("C:\\Users\\Ainaz\\Desktop\\JavaItis\\JdbcDao\\src\\main\\resources\\services.properties"));

            String carsServiceClass = properties.getProperty("carsservice.class");
            String ownersServiceClass = properties.getProperty("ownersservice.class");

            Class carsClass = Class.forName(carsServiceClass);
            Class ownersClass = Class.forName(ownersServiceClass);

            Constructor carsConstructor = carsClass.getConstructor(CarsDao.class);
            Constructor ownersConstructor = ownersClass.getConstructor(OwnersDao.class);

            this.carsService = (CarsService) carsConstructor.newInstance(DaoSupportFactory.getInstance().getCarsDao());
            this.ownersService = (OwnersService) ownersConstructor.newInstance(DaoSupportFactory.getInstance().getOwnersDao());
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
        instance = new ServicesSupportFactory();
    }

    public static ServicesSupportFactory getInstance() {
        return instance;
    }

    public Properties getProperties() {
        return properties;
    }

    public CarsService getCarsService() {
        return carsService;
    }

    public OwnersService getOwnersService() {
        return ownersService;
    }
}
