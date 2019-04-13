package ua.training.model.dao.impl.jdbc;

import org.apache.log4j.Logger;
import ua.training.model.dao.FeedbackDAO;
import ua.training.model.dao.mapper.*;
import ua.training.model.entity.Feedback;
import ua.training.model.entity.Request;
import ua.training.model.exceptions.AlreadyExistException;
import ua.training.model.utils.QueriesBinder;

import java.sql.*;
import java.util.List;

public class JDBCFeedbackDao implements FeedbackDAO {
    private static Logger log = Logger.getLogger(JDBCFeedbackDao.class.getName());
    private Connection connection;
    private Mapper<Feedback> mapper;

    public JDBCFeedbackDao(Connection connection) {
        this.connection = connection;
        this.mapper = new FeedbackMapper();
        System.out.println("Connection rom JDBCFeedbackDAO: " + connection);
    }

    @Override
    public Feedback create(Feedback entity) {
        return null;
    }

    @Override
    public Feedback findById(int id) {
        Feedback feedback = null;
        try {
            PreparedStatement statement =
                    connection.prepareStatement(QueriesBinder.getProperty("feedback.find.by.id"));
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            feedback = mapper.extract(result);
        } catch (SQLException e) {
            log.error("User with such id is not found");
        }
        return feedback;
    }

    @Override
    public List<Feedback> findAll() {
        return null;
    }

    @Override
    public boolean update(Feedback entity) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public void close() throws Exception {

    }

    @Override
    public Feedback createAndSetToRequest(Feedback feedback, Request request) throws SQLException {
        Feedback createdFeedback = null;
        try {
            connection.setAutoCommit(false);

            PreparedStatement createStatement =
                    connection.prepareStatement(QueriesBinder.getProperty("feedback.create"), Statement.RETURN_GENERATED_KEYS);
            createStatement.setString(1, feedback.getCommentary());
            createStatement.setString(2, feedback.getMark().toString());
            createStatement.executeUpdate();
            ResultSet result = createStatement.getGeneratedKeys();
            result.next();
            int createdFeedbackId = result.getInt(1);
            createdFeedback = findById(createdFeedbackId);

            PreparedStatement updateStatement =
                    connection.prepareStatement(QueriesBinder.getProperty("request.update.feedback.by.request.id"));
            updateStatement.setInt(1, createdFeedbackId);
            updateStatement.setInt(2, request.getId());
            updateStatement.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            //TODO another exception can be thrown. Not only entitynotfound
            log.error("Feedback already exist", e);
            throw new AlreadyExistException(e.getMessage());
        } finally {
            connection.setAutoCommit(true);
        }
        return createdFeedback;
    }
}
