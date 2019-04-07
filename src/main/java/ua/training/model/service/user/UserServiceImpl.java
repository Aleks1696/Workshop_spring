package ua.training.model.service.user;

import ua.training.model.dao.DAOFactory;
import ua.training.model.dao.UserDAO;
import ua.training.model.entity.User;
import ua.training.model.types.UserRole;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public UserServiceImpl() {
        this.userDAO = DAOFactory.getInstance().createUserDAO();
        System.out.println("User dao object from userService: " + userDAO);
    }

    @Override
    public User logInUser(String login, String password) {
        User user = userDAO.findByLoginAndPassword(login, password);
        return user;
    }

    @Override
    public User createUser(User user) {
        user.setRole(UserRole.CUSTOMER);
        return userDAO.create(user);
    }
}
