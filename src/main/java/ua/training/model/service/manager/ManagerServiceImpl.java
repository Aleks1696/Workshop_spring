package ua.training.model.service.manager;

import ua.training.model.dao.DAOFactory;
import ua.training.model.dao.RequestDAO;
import ua.training.model.entity.Request;
import ua.training.model.types.RequestStatus;
import ua.training.model.utils.QueriesBinder;

import java.util.List;

public class ManagerServiceImpl implements ManagerService {
    private RequestDAO requestDAO;

    public ManagerServiceImpl() {
        this.requestDAO = DAOFactory.getInstance().createRequestDAO();
    }

    @Override
    public int getNumberOfNewRequests() {
        String query = QueriesBinder.getProperty("request.get.count.of.new");
        return requestDAO.getNumberOfRows(query);
    }

    @Override
    public Request findById(int requestId) {
        return requestDAO.findById(requestId);
    }

    @Override
    public List<Request> getNewRequests(int currentPage, int recordsPerPage) {
        int start = currentPage * recordsPerPage - recordsPerPage;
        int end = start + recordsPerPage;
        String query = QueriesBinder.getProperty("request.find.by.one.status");
        return requestDAO.findRequestByStatus(String.format(query, start, end),
                RequestStatus.NEW.toString());
    }

    @Override
    public boolean acceptRequest(Request request) {
        return requestDAO.updateAcceptedOrDeclined(request);
    }

    @Override
    public boolean declineRequest(Request request) {
        return requestDAO.updateAcceptedOrDeclined(request);
    }
}