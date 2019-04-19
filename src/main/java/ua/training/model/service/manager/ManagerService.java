package ua.training.model.service.manager;

import ua.training.model.entity.Feedback;
import ua.training.model.entity.Request;
import ua.training.model.entity.User;
import java.util.List;

public interface ManagerService {
    int getNumberOfNewRequests() throws Exception;
    int getNumberOfCustomerFeedbacks(int customerId) throws Exception;
    List<Request> getNewRequests(int currentPage, int recordsPerPage) throws Exception;
    boolean acceptRequest(Request request) throws Exception;
    boolean declineRequest(Request request) throws Exception;
    User findCustomerById(String customerId) throws Exception;
    List<Feedback> getCustomerFeedbacks(int customerId, int currentPage, int recordsPerPage) throws Exception;
}
