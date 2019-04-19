package ua.training.model.dao.impl.jdbc;

import org.apache.log4j.Logger;
import ua.training.model.dao.UserDAO;
import ua.training.model.dao.mapper.*;
import ua.training.model.entity.User;
import ua.training.model.exceptions.*;
import ua.training.model.utils.QueriesBinder;
import java.sql.*;
import java.util.List;

public class JDBCUserDao extends AbstractDAO<User> implements UserDAO {
    private static Logger log = Logger.getLogger(JDBCUserDao.class.getName());
    private Mapper<User> mapper;

    public JDBCUserDao(Connection connection) {
        super(connection);
        this.mapper = new UserMapper();
    }

    @Override
    public User create(User entity) throws AlreadyExistException, SQLException {
        log.info("Try to create new user with");
        User registeredUser;
        try (PreparedStatement statement =
                     connection.prepareStatement(QueriesBinder.getProperty("user.create"), Statement.RETURN_GENERATED_KEYS)) {
            connection.setAutoCommit(false);
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
            connection.commit();
        } catch (SQLIntegrityConstraintViolationException e) {
            connection.rollback();
            log.warn("User already exist");
            throw new AlreadyExistException("User already exist", e);
        } catch (SQLException e) {
            connection.rollback();
            log.error("Error while creating new user", e);
            throw new RuntimeException(e);
        }
        return registeredUser;
    }

    @Override
    public User findById(int id) {
        log.info(String.format("Try to find user by id: %d", id));
        User user;
        try (PreparedStatement statement =
                     connection.prepareStatement(QueriesBinder.getProperty("user.find.by.id"))) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            result.next();
            user = mapper.extract(result);
        } catch (SQLException e) {
            log.warn(String.format("Error while finding user with id: %d", id), e);
            throw new UserNotFoundException("User is not found", e);
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
    public User findByLoginAndPassword(String login, String password) {
        log.info(String.format("Try to find user with login: %s and password: %s", login, password));
        User user;
        try (PreparedStatement statement =
                     connection.prepareStatement(QueriesBinder.getProperty("user.find.by.loginAndPassword"))) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            result.next();
            user = mapper.extract(result);
        } catch (SQLException e) {
            log.warn(String.format("Error while finding user with login: %s and password: %s", login, password));
            throw new RuntimeException(e);
        }
        return user;
    }
}
