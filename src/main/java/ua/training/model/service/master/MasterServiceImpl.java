package ua.training.model.service.master;

import ua.training.model.dao.*;
import ua.training.model.entity.*;
import ua.training.model.types.RequestStatus;
import ua.training.model.utils.QueriesBinder;
import java.util.List;

public class MasterServiceImpl implements MasterService {
    private RequestDAO requestDAO;

    public MasterServiceImpl() {
        this.requestDAO = DAOFactory.getInstance().createRequestDAO();
    }

    @Override
    public int getNumberOfAcceptedRequests(User user) {
        String query = QueriesBinder.getProperty("request.get.count.of.master.accepted");
        return requestDAO.getNumberOfRows(String.format(query, user.getId()));
    }

    @Override
    public int getNumberOfRequestsToProcess() {
        String query = QueriesBinder.getProperty("request.get.count.of.master.requests.to.process");
        return requestDAO.getNumberOfRows(query);
    }

    @Override
    public List<Request> getRequestsToProcess(int currentPage, int recordsPerPage) {
        int start = currentPage * recordsPerPage - recordsPerPage;
        int end = start + recordsPerPage;
        String query = QueriesBinder.getProperty("request.find.by.one.status");
        return requestDAO.findRequestByStatus(String.format(query, start, end),
                RequestStatus.ACCEPTED.toString());
    }

    @Override
    public boolean processRequest(Request request) {
        return requestDAO.updateAcceptedByMaster(request);
    }

    @Override
    public List<Request> getAcceptedRequests(User user, int currentPage, int recordsPerPage) {
        int start = currentPage * recordsPerPage - recordsPerPage;
        int end = start + recordsPerPage;
        String query = QueriesBinder.getProperty("request.find.by.master.and.status");
        return requestDAO.findByUserIdAndStatus(String.format(query, start, end),
                user.getId(),
                RequestStatus.IN_PROCESS.toString());
    }

    @Override
    public boolean closeRequest(Request request) {
        return requestDAO.updateStatusById(request.getId(), RequestStatus.FIXED);
    }
}
