package ua.training.model.service.user;

import ua.training.controller.utils.ScriptMD5;
import ua.training.model.dao.DAOFactory;
import ua.training.model.dao.UserDAO;
import ua.training.model.entity.User;
import ua.training.model.exceptions.UserNotFoundException;
import ua.training.model.types.UserRole;

public class UserServiceImpl implements UserService {
    private DAOFactory daoFactory = DAOFactory.getInstance();

    @Override
    public User logInUser(String login, String password) {
        String passwordHash = new ScriptMD5().getPwdHash(password);
        try (UserDAO userDAO = daoFactory.createUserDAO()) {
            return userDAO.findByLoginAndPassword(login, passwordHash);
        } catch (Exception e) {
            throw new UserNotFoundException("User is not found", e);
        }
    }

    @Override
    public User createUser(User user) throws Exception {
        user.setRole(UserRole.CUSTOMER);
        user.setPassword(new ScriptMD5().getPwdHash(user.getPassword()));
        try (UserDAO userDAO = daoFactory.createUserDAO()) {
            return userDAO.create(user);
        }
    }
}
