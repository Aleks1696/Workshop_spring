package ua.training.model.service.master;

import ua.training.model.entity.Request;

import java.util.List;

public interface MasterService {
    List<Request> getAcceptedRequests();
    boolean processRequest(Request request);
}
