package ua.training.model.dao;

import ua.training.model.entity.Request;

import java.util.List;

public interface RequestDAO extends GenericDAO<Request> {
    List<Request> findAllByUserId(int userId);
}
