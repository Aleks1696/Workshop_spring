package ua.training.model.dao.impl.jdbc;

import org.apache.log4j.Logger;
import ua.training.model.dao.UserDAO;
import ua.training.model.dao.mapper.*;
import ua.training.model.entity.User;
import ua.training.model.exceptions.AlreadyExistException;
import ua.training.model.exceptions.UserNotFoundException;
import ua.training.model.utils.QueriesBinder;

import java.sql.*;
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
    public User create(User entity) throws AlreadyExistException {
        User registeredUser = null;
        try(PreparedStatement statement =
                    connection.prepareStatement(QueriesBinder.getProperty("user.create"), Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, entity.getLogin());
            statement.setString(2, entity.getPassword());
            statement.setString(3, entity.getRole().toString());
            statement.setString(4, entity.getName());
            statement.setString(5, entity.getName_ua());
            statement.setString(6, entity.getSurname());
            statement.setString(7, entity.getSurname_ua());
            statement.setString(8, entity.getEmail());
            statement.setString(9, entity.getPhoneNumber());
            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();
            result.next();
            int registeredUserId = result.getInt(1);
            registeredUser = findById(registeredUserId);
        } catch (SQLException e) {
            //TODO another exception can be thrown. Not only usernotfound
            log.error("User already exist", e);
            throw new AlreadyExistException(e.getMessage());
        }
        return registeredUser;
    }

    @Override
    public User findById(int id) {
        User user = null;
        try {
            PreparedStatement statement =
                    connection.prepareStatement(QueriesBinder.getProperty("user.find.by.id"));
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            result.next();
            user = mapper.extract(result);
        } catch (SQLException e) {
            log.error("User with such id is not found");
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public boolean update(User entity) {
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
                     connection.prepareStatement(QueriesBinder.getProperty("user.find.by.loginAndPassword"))) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            result.next();
            user = mapper.extract(result);
        } catch (SQLException e) {
            throw new UserNotFoundException("User is not found");
        }
        return user;
    }
}
