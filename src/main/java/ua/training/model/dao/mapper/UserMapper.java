package ua.training.model.dao.mapper;

import ua.training.model.entity.User;
import ua.training.model.types.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements Mapper<User> {
    @Override
    public User extractFromResultSet(ResultSet resultSet) throws SQLException {
        resultSet.next();
        //TODO move all constants to resources
        User user = new User();
//        user.setId(resultSet.getInt("id"));
        user.setLogin(resultSet.getString("login"));
        //TODO Does user need to carry password in session?
        user.setPassword(resultSet.getString("password"));
        user.setRole(UserRole.getRole(resultSet.getString("role")));
        user.setName(resultSet.getString("name"));
        user.setSurname(resultSet.getString("surname"));
        user.setEmail(resultSet.getString("email"));
        //TODO take out list of requests
        return user;
    }
}
