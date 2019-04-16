package ua.training.model.service.manager;

import ua.training.model.entity.Request;
import ua.training.model.entity.User;

import java.util.List;

public interface ManagerService {
    int getNumberOfNewRequests();
    Request findById(int requestId);
    List<Request> getNewRequests(int currentPage, int recordsPerPage);
    boolean acceptRequest(Request request);
    boolean declineRequest(Request request);

}
