package ua.training.model.service.user;

import ua.training.model.dao.DAOFactory;
import ua.training.model.entity.User;

public interface UserService {
    DAOFactory FACTORY = DAOFactory.getInstance();
    User logInUser(String login, String password);
}
