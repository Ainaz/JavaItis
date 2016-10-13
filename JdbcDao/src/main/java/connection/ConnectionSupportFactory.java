package connection;

import java.sql.Connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionSupportFactory {
    private static ConnectionSupportFactory instance;

    private Properties properties;
    private Connection connection;

    private ConnectionSupportFactory(){
        try {
            properties = new Properties();
            properties.load(new FileInputStream("C:\\Users\\KFU-user\\Desktop\\JavaItis\\JdbcDao\\src\\main\\resources\\SQL.properties"));

            Class.forName(properties.getProperty("jdbc.driver"));
            connection = DriverManager.getConnection(properties.getProperty("jdbc.URL"), properties.getProperty("jdbc.name"), properties.getProperty("jdbc.password"));
        }catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    static {
        instance = new ConnectionSupportFactory();
    }

    public static ConnectionSupportFactory getInstance() {
        return instance;
    }

    public Connection getConnect() {
        return this.connection;
    }
}
