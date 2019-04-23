package ua.training.model.dao.mapper;

import ua.training.model.entity.User;
import ua.training.model.types.UserRole;
import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
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
        user.setLogin(Optional.ofNullable(request.getParameter(getProperty("parameter.login")))
                .orElse(Optional.empty().toString()));
        user.setPassword(Optional.ofNullable(request.getParameter(getProperty("parameter.password")))
                .orElse(Optional.empty().toString()));
        user.setName(Optional.ofNullable(request.getParameter(getProperty("parameter.name")))
                .orElse(Optional.empty().toString()));
        user.setName_ua(Optional.ofNullable(request.getParameter(getProperty("parameter.name_ua")))
                .orElse(Optional.empty().toString()));
        user.setSurname(Optional.ofNullable(request.getParameter(getProperty("parameter.surname")))
                .orElse(Optional.empty().toString()));
        user.setSurname_ua(Optional.ofNullable(request.getParameter(getProperty("parameter.surname_ua")))
                .orElse(Optional.empty().toString()));
        user.setEmail(Optional.ofNullable(request.getParameter(getProperty("parameter.email")))
                .orElse(Optional.empty().toString()));
        user.setPhoneNumber(Optional.ofNullable(request.getParameter(getProperty("parameter.phoneNumber")))
                .orElse(Optional.empty().toString()));
        return user;
    }
}
