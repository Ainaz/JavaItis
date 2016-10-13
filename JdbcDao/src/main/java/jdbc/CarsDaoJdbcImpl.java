package jdbc;

import com.sun.org.apache.bcel.internal.generic.Select;
import dao.CarsDao;
import models.Car;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CarsDaoJdbcImpl implements CarsDao {
    public final String SQL_DELETE_CARS = "DELETE FROM auto WHERE auto_id = ?";
    public final String SQL_ALL_CARS = "SELECT * FROM auto";
    public final String SQL_FIND_CARS = "SELECT * FROM auto WHERE auto_id = ?";

    private Connection connection;

    public CarsDaoJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    public Car find(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_CARS);
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            result.next();
            return new Car(result.getInt("auto_id"), result.getString("auto_name"), result.getInt("mileade"));
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void getAll() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ALL_CARS);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()){
                int autoId = result.getInt("auto_id");
                String autoName = result.getString("auto_name");
                int mileage = result.getInt("mileade");
                System.out.println("ID = " + autoId + ", Auto = " + autoName + ", Mileage = " + mileage);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_CARS);
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            result.next();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void add(Car car) {

    }

    public void update(Car car) {

    }
}
