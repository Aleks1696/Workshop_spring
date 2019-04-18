package ua.training.model.dao.impl.jdbc;

import org.apache.log4j.Logger;
import ua.training.model.dao.FeedbackDAO;
import ua.training.model.dao.mapper.*;
import ua.training.model.entity.*;
import ua.training.model.exceptions.AlreadyExistException;
import ua.training.model.utils.QueriesBinder;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCFeedbackDao extends AbstractDAO<Feedback> implements FeedbackDAO {
    private static Logger log = Logger.getLogger(JDBCFeedbackDao.class.getName());
    private Mapper<Feedback> mapper;

    public JDBCFeedbackDao(Connection connection) {
        super(connection);
        this.mapper = new FeedbackMapper();
    }

    @Override
    public Feedback create(Feedback entity) {
        return null;
    }

    @Override
    public Feedback findById(int id) {
        log.info(String.format("Try to find feedback by id: %d", id));
        Feedback feedback = null;
        try (PreparedStatement statement =
                    connection.prepareStatement(QueriesBinder.getProperty("feedback.find.by.id"))) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            result.next();
            feedback = mapper.extract(result);
        } catch (SQLException e) {
            log.error(String.format("Error finding feedback with id: %d", id), e);
            throw new RuntimeException(e);
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
    public Feedback createAndSetToRequest(Feedback feedback, Request request) throws SQLException {
        log.info("Trying to create new feedback and bind it with relative request");
        Feedback createdFeedback = null;
        try (PreparedStatement createStatement =
                     connection.prepareStatement(QueriesBinder.getProperty("feedback.create"), Statement.RETURN_GENERATED_KEYS);
             PreparedStatement updateStatement =
                     connection.prepareStatement(QueriesBinder.getProperty("request.update.feedback.by.request.id"))) {

            connection.setAutoCommit(false);
            createStatement.setString(1, feedback.getCommentary());
            createStatement.setString(2, feedback.getMark().toString());
            createStatement.executeUpdate();

            ResultSet result = createStatement.getGeneratedKeys();
            result.next();
            int createdFeedbackId = result.getInt(1);
            createdFeedback = findById(createdFeedbackId);

            updateStatement.setInt(1, createdFeedbackId);
            updateStatement.setInt(2, request.getId());
            updateStatement.executeUpdate();

            connection.commit();
        } catch (SQLIntegrityConstraintViolationException e) {
            connection.rollback();
            log.error("Error while creating feedback (Feedback already exist)", e);
            throw new AlreadyExistException("Feedback already exist", e);
        } catch (SQLException e) {
            connection.rollback();
            log.error("Error creating and setting feedback to request", e);
            throw new RuntimeException(e);
        }
        return createdFeedback;
    }

    @Override
    public List<Feedback> findBy(String query) {
        log.info("Try to find feedbacks by passed parameter");
        List<Feedback> feedbacks = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                feedbacks.add(mapper.extract(result));
            }
        } catch (SQLException e) {
            log.error("Error finding feedbacks by passed parameter", e);
            throw new RuntimeException(e);
        }
        return feedbacks;
    }
}
