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
    public Request findById(int requestId) {
        return requestDAO.findById(requestId);
    }

    @Override
    public List<Request> getNewRequests() {
        return requestDAO.findRequestByStatus(QueriesBinder.getProperty("request.find.by.one.status"),
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
