package ua.training.model.dao.impl.jdbc;

import ua.training.model.dao.FeedbackDAO;
import ua.training.model.entity.Feedback;

import java.util.List;

public class JDBCFeedbackDao implements FeedbackDAO {

    @Override
    public Feedback create() {
        return null;
    }

    @Override
    public Feedback findById(int id) {
        return null;
    }

    @Override
    public List<Feedback> findAll() {
        return null;
    }

    @Override
    public boolean update(int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public void close() throws Exception {

    }
}
