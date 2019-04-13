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
    public List<Request> getRequestsToProcess() {
        return requestDAO.findRequestByStatus(QueriesBinder.getProperty("request.find.by.one.status"),
                RequestStatus.ACCEPTED.toString());
    }

    @Override
    public boolean processRequest(Request request) {
        return requestDAO.updateAcceptedByMaster(request);
    }

    @Override
    public List<Request> getAcceptedRequests(User user) {
        return requestDAO.findByUserIdAndStatus(
                QueriesBinder.getProperty("request.find.by.master.and.status"),
                user.getId(),
                RequestStatus.IN_PROCESS.toString());

    }

    @Override
    public boolean closeRequest(Request request) {
        return requestDAO.updateStatusById(request.getId(), RequestStatus.FIXED);
    }
}
