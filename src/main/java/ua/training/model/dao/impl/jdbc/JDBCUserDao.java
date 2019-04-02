package ua.training.model.dao.impl.jdbc;

import ua.training.model.constants.Queries;
import ua.training.model.dao.UserDAO;
import ua.training.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JDBCUserDao implements UserDAO {
    private Connection connection;

    public JDBCUserDao(Connection connection) {
        this.connection = connection;
        System.out.println("Connection rom JDBCUserDAO: " + connection);
    }

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

    @Override
    public User findByLoginAndPassword(String login, String password) {
        //TODO get user from mapper
        User user = new User();
        try (PreparedStatement statement =
                     connection.prepareStatement(Queries.FIND_BY_LOGIN_AND_PASSWORD)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
