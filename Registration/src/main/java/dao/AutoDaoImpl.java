package dao;

import models.Auto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AutoDaoImpl implements AutoDao {

    private final String SQL_ALL_CARS = "SELECT * FROM auto";
    private final String SQL_FIND_CARS = "SELECT * FROM auto WHERE auto_id = ?";
    private final String SQL_ADD_CARS = "INSERT INTO auto (auto_name, auto_number, user_id) VALUES (?,?,?)";

    private Connection connection;

    public AutoDaoImpl(Connection connection) {
        this.connection = connection;
    }

    public List<Auto> getAll() {
        ArrayList carsList = new ArrayList();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ALL_CARS);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()){
                int autoId = result.getInt("auto_id");
                String autoName = result.getString("auto_name");
                int mileage = result.getInt("mileage");
                String cars ="ID = " + autoId + ", Auto = " + autoName + ", Mileage = " + mileage;
                carsList.add(cars);
            }
            return carsList;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public Auto find(int id) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_CARS);
                preparedStatement.setInt(1, id);

                ResultSet result = preparedStatement.executeQuery();

                result.next();
                return new Auto(result.getString("auto_name"), result.getString("auto_number"), result.getInt("user_id"));
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
    }

    public void add(Auto auto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_CARS);
            preparedStatement.setString(1, auto.getAutoName());
            preparedStatement.setString(2, auto.getAutoNumber());
            preparedStatement.setInt(3, auto.getUserId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
