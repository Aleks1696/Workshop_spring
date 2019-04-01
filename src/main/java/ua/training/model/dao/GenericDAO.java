package ua.training.model.dao;

import java.util.List;

public interface GenericDAO<T> extends AutoCloseable {
    T create();
    T findById(int id);
    List<T> findAll();
    boolean update(int id);
    boolean delete(int id);

    @Override
    void close() throws Exception;
}
