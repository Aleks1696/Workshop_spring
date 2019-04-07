package ua.training.model.dao.impl.jdbc;

import org.apache.log4j.Logger;
import ua.training.model.dao.RequestDAO;
import ua.training.model.dao.mapper.*;
import ua.training.model.entity.*;
import ua.training.model.exceptions.UserAlreadyExistException;
import ua.training.model.utils.QueriesBinder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCRequestDao implements RequestDAO {
    private static Logger log = Logger.getLogger(JDBCRequestDao.class.getName());
    private Connection connection;
    private Mapper<Request> mapper;

    public JDBCRequestDao(Connection connection) {
        this.connection = connection;
        mapper = new RequestMapper();
        System.out.println("Connection from JDBCRequestDAO: " + connection);
    }


    @Override
    public List<Request> findAllByUserId(int userId) {
        List<Request> activeRequests = new ArrayList<>();
        try (PreparedStatement statement =
                     connection.prepareStatement(QueriesBinder.getProperty("request.find.all.by.user"))) {
            statement.setInt(1, userId);
            ResultSet result = statement.executeQuery();
            //TODO NPE from resultSet
//            while (result.next()) {
//                activeRequests.add(mapper.extract(result));
//            }
        } catch (SQLException e) {
            log.error("Failed to find user active requests");
        }
        return activeRequests;
    }

    @Override
    public Request create(Request entity) throws UserAlreadyExistException {
        return null;
    }

    @Override
    public Request findById(int id) {
        return null;
    }

    @Override
    public List<Request> findAll() {
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
