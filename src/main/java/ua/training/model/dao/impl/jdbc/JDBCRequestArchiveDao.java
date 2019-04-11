package ua.training.model.dao.impl.jdbc;

import ua.training.model.dao.RequestArchiveDAO;
import ua.training.model.entity.Request;

import java.sql.Connection;
import java.util.List;

public class JDBCRequestArchiveDao implements RequestArchiveDAO {
    private Connection connection;

    public JDBCRequestArchiveDao(Connection connection) {
        this.connection = connection;
        System.out.println("Connection rom JDBCRequestArchiveDAO: " + connection);
    }

    @Override
    public Request create(Request entity) {
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
    public boolean update(Request entity) {
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
