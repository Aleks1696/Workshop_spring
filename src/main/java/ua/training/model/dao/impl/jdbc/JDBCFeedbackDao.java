package ua.training.model.dao.impl.jdbc;

import org.apache.log4j.Logger;
import ua.training.model.dao.FeedbackDAO;
import ua.training.model.dao.mapper.*;
import ua.training.model.entity.Feedback;
import ua.training.model.utils.QueriesBinder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
