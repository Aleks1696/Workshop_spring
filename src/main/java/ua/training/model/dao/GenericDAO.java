package ua.training.model.dao;

import java.util.List;

public interface GenericDAO<T> extends AutoCloseable {
    T create(T entity);
    T findById(int id);
    List<T> findAll();
    boolean update(T entity);
    boolean delete(int id);

    @Override
    void close() throws Exception;
}
