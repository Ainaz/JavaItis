package dao;

import dao.OwnersDao;
import models.Owner;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OwnersDaoJdbcImpl implements OwnersDao {

    public final String SQL_ADD_OWNERS = "INSERT INTO car_owner (owner_id, fio, owner_age, owner_city) VALUES (?,?,?,?)";
    public final String SQL_UPDATE_OWNERS = "UPDATE car_owner SET owner_age = ? WHERE owner_id = ?";
    public final String SQL_DELETE_OWNERS = "DELETE FROM car_owner WHERE owner_id = ?";
    public final String SQL_ALL_OWNERS = "SELECT * FROM car_owner";
    public final String SQL_FIND_OWNER = "SELECT * FROM car_owner WHERE owner_id = ?";
    private Connection connection;

    public OwnersDaoJdbcImpl(Connection connection) {

        this.connection = connection;
    }

    public Owner find(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_OWNER);
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            result.next();
            return new Owner(result.getInt("owner_id"), result.getString("FIO"), result.getInt("owner_ade"), result.getString("owner_city"));
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void getAll() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ALL_OWNERS);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()){
                int ownerId = result.getInt("owner_id");
                String ownerName = result.getString("FIO");
                int ownerAge = result.getInt("owner_age");
                String ownerCity = result.getString("owner_city");
                System.out.println("ID = " + ownerId + ", Owner = " + ownerName + ", Age = " + ownerAge + ", City = " + ownerCity);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_OWNERS);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void add(Owner owner) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_OWNERS);
            preparedStatement.setInt(1, owner.getId());
            preparedStatement.setString(2, owner.getName());
            preparedStatement.setInt(3, owner.getAge());
            preparedStatement.setString(4, owner.getCity());
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void update(Owner owner) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_OWNERS);
            preparedStatement.setInt(1, owner.getAge());
            preparedStatement.setInt(2, owner.getId());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }
}
