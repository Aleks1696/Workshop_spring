package ua.training.model.dao.impl.jdbc;

import ua.training.model.dao.RequestDAO;
import ua.training.model.entity.Request;

import java.util.List;

public class JDBCRequestDao implements RequestDAO {
    @Override
    public Request create() {
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