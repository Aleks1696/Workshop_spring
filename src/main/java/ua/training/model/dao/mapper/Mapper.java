package ua.training.model.dao.mapper;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Mapper<T> {
    T extract(ResultSet resultSet) throws SQLException;
    T extract(HttpServletRequest request);
}
