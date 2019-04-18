package ua.training.model.dao.impl.jdbc;

import ua.training.model.dao.RequestArchiveDAO;
import ua.training.model.entity.Request;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JDBCRequestArchiveDao extends AbstractDAO<Request> implements RequestArchiveDAO {

    public JDBCRequestArchiveDao(Connection connection) {
        super(connection);
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
}
