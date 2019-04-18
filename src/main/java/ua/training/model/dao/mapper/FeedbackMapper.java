package ua.training.model.dao.mapper;

import ua.training.model.entity.Feedback;
import ua.training.model.types.Marks;

import static ua.training.model.utils.AttributesBinder.getProperty;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FeedbackMapper implements Mapper<Feedback> {
    @Override
    public Feedback extract(ResultSet resultSet) throws SQLException {
        Feedback feedback = new Feedback();
        feedback.setId(resultSet.getInt(getProperty("parameter.id")));
        feedback.setCommentary(resultSet.getString(getProperty("parameter.commentary")));
        feedback.setMark(Marks.valueOf(resultSet.getString(getProperty("parameter.mark"))));
        return feedback;
    }

    @Override
    public Feedback extract(HttpServletRequest request) {
        return null;
    }
}
