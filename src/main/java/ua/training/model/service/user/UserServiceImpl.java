package ua.training.model.service.user;

import ua.training.model.dao.UserDAO;
import ua.training.model.entity.User;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public UserServiceImpl() {
        this.userDAO = FACTORY.createUserDAO();
        System.out.println("User dao object: " + userDAO);
    }

    @Override
    public User logInUser(String login, String password) {
        User user = userDAO.findByLoginAndPassword(login, password);
        return null;
    }
}
