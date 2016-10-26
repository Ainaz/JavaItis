package factories;


import dao.AutoDao;
import dao.UserDao;
import services.AutoService;
import services.UserService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class ServiceFactory {
    private static ServiceFactory instance;

    private Properties properties;
    private AutoService autoService;
    private UserService userService;

    private ServiceFactory(){
        try{
            properties = new Properties();
            properties.load(new FileInputStream("C:\\Users\\KFU-user\\Desktop\\JavaItis\\JdbcDao\\src\\main\\resources\\services.properties"));

            String autoServiceClass = properties.getProperty("autoservice.class");
            String userServiceClass = properties.getProperty("userservice.class");

            Class autoClass = Class.forName(autoServiceClass);
            Class userClass = Class.forName(userServiceClass);

            Constructor autoConstructor = autoClass.getConstructor(AutoDao.class);
            Constructor userConstructor = userClass.getConstructor(UserDao.class);

            this.autoService = (AutoService)autoConstructor.newInstance(DaoFactory.getInstance().getAutoDao());
            this.userService = (UserService)userConstructor.newInstance(DaoFactory.getInstance().getUserDao());
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
        instance = new ServiceFactory();
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public AutoService getAutoService() {
        return autoService;
    }

    public UserService getUserService() {
        return userService;
    }
}
