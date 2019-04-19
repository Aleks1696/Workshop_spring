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
import java.util.List;

public class JDBCRequestDao extends AbstractDAO<Request> implements RequestDAO {
    private static Logger log = Logger.getLogger(JDBCRequestDao.class.getName());
    private Mapper<Request> mapper;

    public JDBCRequestDao(Connection connection) {
        super(connection);
        mapper = new RequestMapper();
    }

    @Override
    public Request create(Request entity) throws SQLException {
        log.info("Try to create new request");
        Request createdRequest;
        try (PreparedStatement statement =
                     connection.prepareStatement(QueriesBinder.getProperty("request.create"), Statement.RETURN_GENERATED_KEYS)) {
            connection.setAutoCommit(false);
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
            connection.commit();
        } catch (SQLIntegrityConstraintViolationException e) {
            connection.rollback();
            log.error("Error while creating new request(Request already exist)", e);
            throw new AlreadyExistException(e.getMessage(), e);
        } catch (SQLException e) {
            connection.rollback();
            log.error("Error while creating new request", e);
            throw new RuntimeException(e);
        }
        return createdRequest;
    }


    @Override
    public Request findById(int id) {
        log.info(String.format("Try to find request by id: %d", id));
        Request request;
        try (PreparedStatement statement =
                     connection.prepareStatement(QueriesBinder.getProperty("request.find.by.id"))) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            request = mapper.extract(resultSet);
        } catch (SQLException e) {
            log.error(String.format("Error finding request with id: %d", id), e);
            throw new RuntimeException(e);
        }
        return request;
    }

    @Override
    public List<Request> findByUserIdAndStatus(String query, int userId) {
        log.info(String.format("Try to find request by user id: %d and statuses", userId));
        List<Request> activeRequests = new ArrayList<>();
        try (PreparedStatement statement =
                     connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                activeRequests.add(mapper.extract(result));
            }
        } catch (SQLException e) {
            log.error(String.format("Error finding request by user id: %d and statuses", userId), e);
            throw new RuntimeException(e);
        }
        return activeRequests;
    }

    @Override
    public List<Request> findRequestByStatus(String query) {
        log.info("Try to find requests by statuses");
        List<Request> activeRequests = new ArrayList<>();
        try (PreparedStatement statement =
                     connection.prepareStatement(query)) {
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                activeRequests.add(mapper.extract(result));
            }
        } catch (SQLException e) {
            log.error("Error finding requests by statuses", e);
            throw new RuntimeException(e);
        }
        return activeRequests;
    }

    @Override
    public boolean updateStatusById(int requestId, RequestStatus requestStatus) {
        log.info(String.format("Try to update request status by id: %d", requestId));
        try (PreparedStatement statement =
                     connection.prepareStatement(QueriesBinder.getProperty("request.update.status.by.request.id"))) {
            statement.setString(1, requestStatus.toString());
            statement.setInt(2, requestId);
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error(String.format("Error updating request status by id: %d", requestId), e);
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public boolean updateAcceptedOrDeclined(Request entity) {
        log.info("Try to update accepted or declined request");
        try (PreparedStatement statement =
                     connection.prepareStatement(QueriesBinder.getProperty("request.update.accepted.or.declined"))) {
            statement.setString(1, entity.getStatus().toString());
            statement.setBigDecimal(2, entity.getPrice());
            statement.setString(3, entity.getManagerComment());
            statement.setInt(4, entity.getManager_id());
            statement.setInt(5, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("Error updating accepted or declined request", e);
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public boolean updateAcceptedByMaster(Request entity) {
        log.info("Try to update request accepted by master");
        try (PreparedStatement statement =
                     connection.prepareStatement(QueriesBinder.getProperty("request.update.accepted.by.master"))) {
            statement.setString(1, entity.getStatus().toString());
            statement.setInt(2, entity.getMaster_id());
            statement.setInt(3, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("Error updating request accepted by master", e);
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public boolean moveRequestToArchive(Request request) throws SQLException {
        log.info("Try to move request to archive");
        try (PreparedStatement moveStatement =
                     connection.prepareStatement(QueriesBinder.getProperty("request.move.to.archive"))) {
            connection.setAutoCommit(false);
            moveStatement.setInt(1, request.getId());
            moveStatement.execute();
            delete(request.getId());
            connection.commit();
            return true;
        } catch (SQLException e) {
            connection.rollback();
            log.error("Error moving request to archive", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Request> findAll() {
        return null;
    }

    @Override
    public boolean update(Request entity) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        log.info(String.format("Try to delete request by id: %d", id));
        try (PreparedStatement statement =
                     connection.prepareStatement(QueriesBinder.getProperty("request.delete"))) {
            statement.setInt(1, id);
            statement.execute();
            return true;
        } catch (SQLException e) {
            log.error("Error deleting request", e);
            throw new RuntimeException(e);
        }
    }
}
