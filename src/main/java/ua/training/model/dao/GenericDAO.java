package ua.training.model.dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> extends AutoCloseable {
    T create(T entity) throws SQLException;
    T findById(int id);
    List<T> findAll();
    boolean update(T entity);
    boolean delete(int id);

    int getNumberOfRows(String query);
}
