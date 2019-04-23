package ua.training.model.service.master;

import ua.training.model.dao.*;
import ua.training.model.entity.*;
import ua.training.model.types.RequestStatus;
import ua.training.model.utils.QueriesBinder;
import java.util.List;

public class MasterServiceImpl implements MasterService {
    private DAOFactory daoFactory = DAOFactory.getInstance();

    @Override
    public int getNumberOfAcceptedRequests(User user) throws Exception {
        String query = QueriesBinder.getProperty("request.get.count.of.master.accepted");
        try (RequestDAO requestDAO = daoFactory.createRequestDAO()) {
            return requestDAO.getNumberOfRows(String.format(query, user.getId()));
        }
    }

    @Override
    public int getNumberOfRequestsToProcess() throws Exception {
        String query = QueriesBinder.getProperty("request.get.count.of.master.requests.to.process");
        try (RequestDAO requestDAO = daoFactory.createRequestDAO()) {
            return requestDAO.getNumberOfRows(query);
        }
    }

    @Override
    public List<Request> getRequestsToProcess(int currentPage, int recordsPerPage) throws Exception {
        int start = currentPage * recordsPerPage - recordsPerPage;
        String query = QueriesBinder.getProperty("request.find.by.one.status");
        try (RequestDAO requestDAO = daoFactory.createRequestDAO()) {
            return requestDAO.findRequestByStatus(String.format(query, RequestStatus.ACCEPTED.toString(),
                    start, recordsPerPage));
        }
    }

    @Override
    public boolean processRequest(Request request) throws Exception {
        request.setStatus(RequestStatus.IN_PROCESS);
        try (RequestDAO requestDAO = daoFactory.createRequestDAO()) {
            return requestDAO.updateAcceptedByMaster(request);
        }
    }

    @Override
    public List<Request> getAcceptedRequests(User user, int currentPage, int recordsPerPage) throws Exception {
        int start = currentPage * recordsPerPage - recordsPerPage;
        String query = QueriesBinder.getProperty("request.find.by.master.and.status");
        try (RequestDAO requestDAO = daoFactory.createRequestDAO()) {
            return requestDAO.findByUserIdAndStatus(String.format(query, RequestStatus.IN_PROCESS.toString(),
                    start, recordsPerPage), user.getId());
        }
    }

    @Override
    public boolean closeRequest(Request request) throws Exception {
        try (RequestDAO requestDAO = daoFactory.createRequestDAO()) {
            return requestDAO.updateStatusById(request.getId(), RequestStatus.FIXED);
        }
    }
}
