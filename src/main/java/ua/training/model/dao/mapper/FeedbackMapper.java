package ua.training.model.dao.mapper;

import ua.training.model.entity.Feedback;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FeedbackMapper implements Mapper<Feedback> {
    @Override
    public Feedback extract(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public Feedback extract(HttpServletRequest request) {
        return null;
    }
}
