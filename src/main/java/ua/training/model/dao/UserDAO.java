package ua.training.model.dao;

import ua.training.model.entity.User;

public interface UserDAO extends GenericDAO<User> {
    User findByLoginAndPassword(String login, String password);
}
