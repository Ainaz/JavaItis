package jdbc;

import dao.OwnersDao;
import models.Owner;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by KFU-user on 12.10.2016.
 */
public class OwnersDaoJdbcImpl implements OwnersDao {

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

    }

    public void delete(int id) {

    }

    public void add(Owner owner) {

    }

    public void update(Owner owner) {

    }
}
