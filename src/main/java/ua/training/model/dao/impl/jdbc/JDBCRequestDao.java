package ua.training.model.dao.impl.jdbc;

import org.apache.log4j.Logger;
import ua.training.model.dao.RequestDAO;
import ua.training.model.dao.mapper.*;
import ua.training.model.entity.*;
import ua.training.model.exceptions.AlreadyExistException;
import ua.training.model.types.RequestStatus;
import ua.training.model.utils.QueriesBinder;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
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
    public Request create(Request entity) {
        Request createdRequest = null;
        try (PreparedStatement statement =
                     connection.prepareStatement(QueriesBinder.getProperty("request.create"), Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, entity.getProductCategory().toString());
            statement.setString(2, entity.getDevice());
            statement.setString(3, entity.getDescription());
            statement.setDate(4, Date.valueOf(entity.getCreationDate()));
            statement.setString(5, entity.getStatus().toString());
            statement.setInt(6, entity.getCustomer_id());
            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();
            result.next();
            int createdRequestId = result.getInt(1);
            createdRequest = findById(createdRequestId);
        } catch (SQLException e) {
            throw new AlreadyExistException(e.getMessage(), e);
        }
        return createdRequest;
    }


    @Override
    public Request findById(int id) {
        Request request = null;
        try(PreparedStatement statement =
                    connection.prepareStatement(QueriesBinder.getProperty("request.find.by.id"))) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            request = mapper.extract(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return request;
    }

    @Override
    public int getNumberOfRows(String query){
        int numberOfRows = 0;
        try (PreparedStatement statement =
                     connection.prepareStatement(query)) {
            ResultSet result = statement.executeQuery();
            result.next();
            numberOfRows = result.getInt("numberOfRows");
        } catch (SQLException e) {
            log.error("Failed get number of rows");
        }
        return numberOfRows;
    }

    @Override
    public List<Request> findByUserIdAndStatus(String query, int userId, String ... requestStatus) {
        List<Request> activeRequests = new ArrayList<>();
        try (PreparedStatement statement =
                     connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            for (int j = 2, i = 0; i < requestStatus.length; j++, i++) {
                statement.setString(j, requestStatus[i]);
            }
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                activeRequests.add(mapper.extract(result));
            }
        } catch (SQLException e) {
            log.error("Failed to find user active requests");
        }
        return activeRequests;
    }

    @Override
    public List<Request> findAllByUserId(int userId) {
        List<Request> activeRequests = new ArrayList<>();
        try (PreparedStatement statement =
                     connection.prepareStatement(QueriesBinder.getProperty("request.find.all.by.customer"))) {
            statement.setInt(1, userId);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                activeRequests.add(mapper.extract(result));
            }
        } catch (SQLException e) {
            log.error("Failed to find user active requests");
            e.printStackTrace();
        }
        return activeRequests;
    }

    @Override
    public List<Request> findRequestByStatus(String query, String... requestStatus) {
        List<Request> activeRequests = new ArrayList<>();
        try (PreparedStatement statement =
                     connection.prepareStatement(query)) {
            for (int i = 1; i <= requestStatus.length; i++) {
                statement.setString(i, requestStatus[i - 1]);
            }
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                activeRequests.add(mapper.extract(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Failed to find user active requests");
        }
        return activeRequests;
    }

    @Override
    public boolean updateStatusById(int requestId, RequestStatus requestStatus) {
        try (PreparedStatement statement =
                     connection.prepareStatement(QueriesBinder.getProperty("request.update.status.by.request.id"))) {
            statement.setString(1, requestStatus.toString());
            statement.setInt(2, requestId);
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("Error while executing request update", e);
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateAcceptedOrDeclined(Request entity) {
        try (PreparedStatement statement =
                     connection.prepareStatement(QueriesBinder.getProperty("request.update.accepted.or.declined"))) {
            statement.setString(1, entity.getStatus().toString());
            statement.setBigDecimal(2, entity.getPrice());
            statement.setString(3, entity.getManagerComment());
            statement.setInt(4, entity.getManager_id());
            statement.setInt(5, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("Error while executing request update", e);
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateAcceptedByMaster(Request entity) {
        try (PreparedStatement statement =
                     connection.prepareStatement(QueriesBinder.getProperty("request.update.accepted.by.master"))) {
            statement.setString(1, entity.getStatus().toString());
            statement.setInt(2, entity.getMaster_id());
            statement.setInt(3, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("Error while executing request update after master taking it", e);
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean moveRequestToArchive(Request request) throws SQLException {
        try {
            connection.setAutoCommit(false);
            PreparedStatement moveStatement =
                    connection.prepareStatement(QueriesBinder.getProperty("request.move.to.archive"));
            moveStatement.setInt(1, request.getId());
            moveStatement.execute();

            delete(request.getId());
            connection.commit();
            return true;
        } catch (SQLException e) {
            connection.rollback();
            log.error("Error while executing request update", e);
            return false;
        } finally {
            connection.setAutoCommit(false);
        }
    }


    @Override
    public List<Request> findAll() {
        return null;
    }

    @Override
    public boolean update(Request entity) {
        try (PreparedStatement statement =
                connection.prepareStatement(QueriesBinder.getProperty("request.update"))) {
            statement.setString(1, entity.getProductCategory().toString());
            statement.setString(2, entity.getDevice());
            statement.setString(3, entity.getDescription());
            statement.setDate(4,Date.valueOf(entity.getCreationDate()));
            statement.setString(5, entity.getStatus().toString());
            statement.setBigDecimal(6, entity.getPrice());
            statement.setString(7, entity.getManagerComment());
            statement.setInt(8, entity.getCustomer_id());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            log.error("Error while executing request update", e);
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try (PreparedStatement statement =
                     connection.prepareStatement(QueriesBinder.getProperty("request.delete"))) {
            statement.setInt(1, id);
            statement.execute();
            return true;
        } catch (SQLException e) {
            log.error("Error while executing request update", e);
            return false;
        }
    }

    @Override
    public void close() throws Exception {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
