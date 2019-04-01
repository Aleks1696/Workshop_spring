package ua.training.model.dao.impl.jdbc;

import ua.training.model.dao.UserDAO;
import ua.training.model.entity.User;

import java.util.List;

public class JDBCUserDao implements UserDAO {

    @Override
    public User create() {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
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
