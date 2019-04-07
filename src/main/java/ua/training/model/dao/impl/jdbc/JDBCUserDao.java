package ua.training.model.dao.impl.jdbc;

import org.apache.log4j.Logger;
import ua.training.model.dao.UserDAO;
import ua.training.model.dao.mapper.*;
import ua.training.model.entity.User;
import ua.training.model.exceptions.UserAlreadyExistException;
import ua.training.model.exceptions.UserNotFoundException;
import ua.training.model.utils.QueriesBinder;

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
    public User create(User entity) throws UserAlreadyExistException {
        User registeredUser = null;
        try(PreparedStatement statement =
                    connection.prepareStatement(QueriesBinder.getProperty("user.create"))) {
            statement.setString(1, entity.getLogin());
            statement.setString(2, entity.getPassword());
            statement.setString(3, entity.getRole().toString());
            statement.setString(4, entity.getName());
            statement.setString(5, entity.getName_ua());

            System.out.println(entity.getName_ua());

            statement.setString(6, entity.getSurname());
            statement.setString(7, entity.getSurname_ua());

            System.out.println(entity.getSurname_ua());

            statement.setString(8, entity.getEmail());
            statement.setString(9, entity.getPhoneNumber());
            statement.execute();
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new UserAlreadyExistException(e.getMessage());
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
