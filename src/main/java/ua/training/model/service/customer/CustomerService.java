package ua.training.model.service.customer;

import ua.training.model.entity.Feedback;
import ua.training.model.entity.Request;
import ua.training.model.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    Request createRequest(Request request) throws Exception;
    int getNumberOfActiveRequests(User user) throws Exception;
    List<Request> getActiveRequests(User user, int currentPage, int recordsPerPage) throws Exception;
    List<Request> getAccomplishedRequests(User user) throws Exception;
    Feedback leaveFeedback(Feedback feedback, Request request) throws Exception;
    boolean archiveRequest(Request request) throws Exception;
}
