package ru.itis.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import ru.itis.models.Auto;
import ru.itis.utils.AutoMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AutoDaoImpl implements AutoDao {

    private final String SQL_ALL_CARS = "SELECT * FROM auto";
    private final String SQL_FIND_CARS = "SELECT * FROM auto WHERE auto_id = ?";
    private final String SQL_ADD_CARS = "INSERT INTO auto (auto_name, auto_number, user_id) VALUES (:autoName, :autoNumber, :userId)";

    private Connection connection;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public AutoDaoImpl(DataSource dataSource, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        try {
            this.connection = dataSource.getConnection();
            this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Auto> getAll() {
        List auto = (List)namedParameterJdbcTemplate.query(SQL_ALL_CARS, new AutoMapper());
        return auto;
    }

    public Auto find(int id) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("autoId", id);
        Auto auto = (Auto)namedParameterJdbcTemplate.queryForObject(SQL_FIND_CARS, sqlParameterSource, new AutoMapper());
        return auto;
    }

    public void add(Auto auto) {
        Map map = new HashMap();
        map.put("autoName", auto.getAutoName());
        map.put("autoNumber", auto.getAutoNumber());
        map.put("userId", auto.getUserId());
        namedParameterJdbcTemplate.update(SQL_ADD_CARS, map);
    }
}
