package ua.training.model.service.master;

import ua.training.model.entity.Request;
import ua.training.model.entity.User;

import java.util.List;

public interface MasterService {
    int getNumberOfAcceptedRequests(User user);
    int getNumberOfRequestsToProcess();
    List<Request> getRequestsToProcess(int currentPage, int recordsPerPage);
    boolean processRequest(Request request);
    List<Request> getAcceptedRequests(User user, int currentPage, int recordsPerPage);
    boolean closeRequest(Request request);
}
