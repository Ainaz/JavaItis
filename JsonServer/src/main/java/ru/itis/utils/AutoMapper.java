package ru.itis.utils;


import ru.itis.models.Auto;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AutoMapper implements RowMapper {
    public Auto mapRow(ResultSet resultSet, int i) throws SQLException {
        Auto autos = new Auto(resultSet.getInt("auto_id"), resultSet.getString("auto_name"),
                resultSet.getString("auto_number"), resultSet.getInt("user_id"));
        return autos;
    }


}
