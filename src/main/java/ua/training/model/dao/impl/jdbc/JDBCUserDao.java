package ua.training.model.dao.impl.jdbc;

import org.apache.log4j.Logger;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import ua.training.model.constants.Queries;
import ua.training.model.dao.UserDAO;
import ua.training.model.dao.mapper.Mapper;
import ua.training.model.dao.mapper.UserMapper;
import ua.training.model.entity.User;
import ua.training.model.exceptions.UserNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JDBCUserDao implements UserDAO {
    private static Logger log = Logger.getLogger(JDBCUserDao.class.getName());
    private Connection connection;
    private Mapper<User> mapper;

    public JDBCUserDao(Connection connection) {
        this.connection = connection;
        this.mapper = new UserMapper();
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
        User user = null;
        try (PreparedStatement statement =
                     connection.prepareStatement(Queries.FIND_BY_LOGIN_AND_PASSWORD)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            user = mapper.extractFromResultSet(result);
        } catch (SQLException e) {
            throw new UserNotFoundException("User is not found");
        }
        return user;
    }
}
