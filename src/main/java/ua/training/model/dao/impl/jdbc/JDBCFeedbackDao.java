package ua.training.model.dao.impl.jdbc;

import ua.training.model.dao.FeedbackDAO;
import ua.training.model.entity.Feedback;

import java.sql.Connection;
import java.util.List;

public class JDBCFeedbackDao implements FeedbackDAO {
    private Connection connection;

    public JDBCFeedbackDao(Connection connection) {
        this.connection = connection;
        System.out.println("Connection rom JDBCFeedbackDAO: " + connection);
    }

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
