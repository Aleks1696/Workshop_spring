package ua.training.model.service.user;

import ua.training.model.dao.DAOFactory;
import ua.training.model.entity.User;
import ua.training.model.exceptions.UserAlreadyExistException;

public interface UserService {
    User logInUser(String login, String password);
    User createUser(User user) throws UserAlreadyExistException;
}
