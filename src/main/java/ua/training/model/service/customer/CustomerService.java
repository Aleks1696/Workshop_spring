package ua.training.model.service.customer;

import ua.training.model.entity.Request;
import ua.training.model.entity.User;

import java.util.List;

public interface CustomerService {
    Request createRequest(Request request);
    List<Request> getActiveRequests(User user);
    List<Request> getAllRequests(User user);
}
