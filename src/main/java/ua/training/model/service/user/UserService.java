package ua.training.model.service.user;

import ua.training.model.entity.User;

/**
 * The root interface for services made for users with unknown
 * role.
 *
 * @see UserServiceImpl
 */

public interface UserService {
    /**
     * Processes provided parameters and returns registered user
     * if only login and password matches already signed up users.
     *
     * @param login provided login by user
     * @param password provided password by user
     * @return returns user if such already exist in database
     * @throws ua.training.model.exceptions.UserNotFoundException
     *          if user is not found in database
     * */
    User logInUser(String login, String password);

    /**
     * Takes {@link User} entity and tries to create new user record
     * in database. Is success created user will be returned.
     *
     * @param user {@link User} entity with field provided by user
     * @return returns user if such is successfully created
     * @throws Exception if user is an error happened while creating
     *          new user record
     * */
    User createUser(User user) throws Exception;
}
