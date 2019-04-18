package ua.training.model.service.user;

import ua.training.model.entity.User;
import ua.training.model.exceptions.AlreadyExistException;

public interface UserService {
    User logInUser(String login, String password);
    User createUser(User user) throws Exception;
}
