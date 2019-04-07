package ua.training.model.service.customer;

import ua.training.model.entity.Request;
import ua.training.model.entity.User;

import java.util.List;

public interface CustomerService {
    List<Request> getActiveRequests(User user);
}
