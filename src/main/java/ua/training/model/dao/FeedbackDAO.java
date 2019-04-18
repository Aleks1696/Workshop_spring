package ua.training.model.dao;

import ua.training.model.entity.*;
import java.sql.SQLException;
import java.util.List;

public interface FeedbackDAO extends GenericDAO<Feedback> {
    Feedback createAndSetToRequest(Feedback feedback, Request request) throws SQLException;
    List<Feedback> findBy(String query);
}
