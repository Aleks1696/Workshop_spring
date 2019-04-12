package ua.training.model.service.master;

import ua.training.model.dao.DAOFactory;
import ua.training.model.dao.RequestDAO;
import ua.training.model.entity.Request;
import ua.training.model.types.RequestStatus;
import ua.training.model.utils.QueriesBinder;

import java.util.List;

public class MasterServiceImpl implements MasterService {
    private RequestDAO requestDAO;

    public MasterServiceImpl() {
        this.requestDAO = DAOFactory.getInstance().createRequestDAO();
    }

    @Override
    public List<Request> getAcceptedRequests() {
        return requestDAO.findRequestByStatus(QueriesBinder.getProperty("request.find.by.one.status"),
                RequestStatus.ACCEPTED.toString());
    }

    @Override
    public boolean processRequest(Request request) {
        return requestDAO.updateAcceptedByMaster(request);
    }
}
