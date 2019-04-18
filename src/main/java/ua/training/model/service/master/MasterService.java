package ua.training.model.service.master;

import ua.training.model.entity.Request;
import ua.training.model.entity.User;

import java.util.List;

public interface MasterService {
    int getNumberOfAcceptedRequests(User user) throws Exception;
    int getNumberOfRequestsToProcess() throws Exception;
    List<Request> getRequestsToProcess(int currentPage, int recordsPerPage) throws Exception;
    boolean processRequest(Request request) throws Exception;
    List<Request> getAcceptedRequests(User user, int currentPage, int recordsPerPage) throws Exception;
    boolean closeRequest(Request request) throws Exception;
}
