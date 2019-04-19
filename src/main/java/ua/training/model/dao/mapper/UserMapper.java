package ua.training.model.dao.mapper;

import ua.training.model.entity.User;
import ua.training.model.types.UserRole;
import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import static ua.training.model.utils.AttributesBinder.getProperty;

public class UserMapper implements Mapper<User> {
    @Override
    public User extract(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt(getProperty("parameter.id")));
        user.setLogin(resultSet.getString(getProperty("parameter.login")));
        user.setPassword(resultSet.getString(getProperty("parameter.password")));
        user.setName(resultSet.getString(getProperty("parameter.name")));
        user.setName_ua(resultSet.getString(getProperty("parameter.name_ua")));
        user.setSurname(resultSet.getString(getProperty("parameter.surname")));
        user.setSurname_ua(resultSet.getString(getProperty("parameter.surname_ua")));
        user.setRole(UserRole.getRole(resultSet.getString(getProperty("parameter.role"))));
        user.setEmail(resultSet.getString(getProperty("parameter.email")));
        user.setPhoneNumber(resultSet.getString(getProperty("parameter.phoneNumber")));
        return user;
    }

    public User extract(HttpServletRequest request) {
        User user = new User();
        user.setLogin(request.getParameter(getProperty("parameter.login")));
        user.setPassword(request.getParameter(getProperty("parameter.password")));
        user.setName(request.getParameter(getProperty("parameter.name")));
        user.setName_ua(request.getParameter(getProperty("parameter.name_ua")));
        user.setSurname(request.getParameter(getProperty("parameter.surname")));
        user.setSurname_ua(request.getParameter(getProperty("parameter.surname_ua")));
        user.setEmail(request.getParameter(getProperty("parameter.email")));
        user.setPhoneNumber(request.getParameter(getProperty("parameter.phoneNumber")));
        return user;
    }
}
