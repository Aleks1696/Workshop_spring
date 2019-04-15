package ua.training.model.service.customer;

import ua.training.model.entity.Feedback;
import ua.training.model.entity.Request;
import ua.training.model.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    Request createRequest(Request request);
    int getNumberOfActiveRequests(User user);
    List<Request> getActiveRequests(User user, int currentPage, int recordsPerPage);
    List<Request> getAllRequests(User user);
    List<Request> getAccomplishedRequests(User user);
    Feedback leaveFeedback(Feedback feedback, Request request) throws SQLException;
    boolean archiveRequest(Request request) throws SQLException;
}
