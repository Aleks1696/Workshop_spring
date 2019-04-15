package ua.training.model.dao;

import ua.training.model.entity.Request;
import ua.training.model.types.RequestStatus;

import java.sql.SQLException;
import java.util.List;

public interface RequestDAO extends GenericDAO<Request> {
    int getNumberOfRows(String query, int id);
    List<Request> findByUserIdAndStatus(String query, int userId, int currentPage, int recordsPerPage,  String ... requestStatus);
    List<Request> findAllByUserId(int userId);
    List<Request> findRequestByStatus(String query, String ... requestStatus);
    boolean updateStatusById(int requestId, RequestStatus requestStatus);
    boolean updateAcceptedOrDeclined(Request entity);
    boolean updateAcceptedByMaster(Request entity);
    boolean moveRequestToArchive(Request request) throws SQLException;
}
