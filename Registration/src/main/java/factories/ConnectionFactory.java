package factories;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static ConnectionFactory instance;

    private Properties properties;
    private Connection connection;

    private ConnectionFactory() {
        try {
            properties = new Properties();

            properties.load(new FileInputStream("C:\\Users\\KFU-user\\Desktop\\JavaItis\\Cookies\\src\\main\\resources\\SQL.properties"));

            Class.forName(properties.getProperty("jdbc.driver"));
            this.connection = DriverManager.getConnection(properties.getProperty("jdbc.URL"),properties.getProperty("jdbc.name"), properties.getProperty("jdbc.password"));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static {
        instance = new ConnectionFactory();
    }

    public static ConnectionFactory getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
