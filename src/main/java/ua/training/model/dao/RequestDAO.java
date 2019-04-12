package ua.training.model.dao;

import ua.training.model.entity.Request;

import java.util.List;

public interface RequestDAO extends GenericDAO<Request> {
    List<Request> findActiveByUserId(int userId);
    List<Request> findAllByUserId(int userId);
    List<Request> findRequestByStatus(String query, String ... requestStatus);
    boolean updateAcceptedOrDeclined(Request entity);
    boolean updateAcceptedByMaster(Request entity);
}
