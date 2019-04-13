package ua.training.model.service.master;

import ua.training.model.entity.Request;
import ua.training.model.entity.User;

import java.util.List;

public interface MasterService {
    List<Request> getRequestsToProcess();
    boolean processRequest(Request request);
    List<Request> getAcceptedRequests(User user);
    boolean closeRequest(Request request);
}
