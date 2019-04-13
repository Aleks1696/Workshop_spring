package ua.training.model.dao;

import ua.training.model.entity.Feedback;
import ua.training.model.entity.Request;

import java.sql.SQLException;

public interface FeedbackDAO extends GenericDAO<Feedback> {
    Feedback createAndSetToRequest(Feedback feedback, Request request) throws SQLException;
}
