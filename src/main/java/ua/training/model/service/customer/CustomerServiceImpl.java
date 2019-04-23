package ua.training.model.service.customer;

import ua.training.model.dao.DAOFactory;
import ua.training.model.dao.FeedbackDAO;
import ua.training.model.dao.RequestDAO;
import ua.training.model.entity.Feedback;
import ua.training.model.entity.Request;
import ua.training.model.entity.User;
import ua.training.model.types.RequestStatus;
import ua.training.model.utils.QueriesBinder;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private DAOFactory daoFactory = DAOFactory.getInstance();

    @Override
    public Request createRequest(Request request) throws Exception {
        try (RequestDAO requestDAO = daoFactory.createRequestDAO()) {
            return requestDAO.create(request);
        }
    }

    @Override
    public int getNumberOfActiveRequests(User user) throws Exception {
        String query = QueriesBinder.getProperty("request.get.count.of.customer.active");
        try (RequestDAO requestDAO = daoFactory.createRequestDAO()) {
            return requestDAO.getNumberOfRows(String.format(query, user.getId(), RequestStatus.NEW.toString(),
                    RequestStatus.ACCEPTED.toString(), RequestStatus.IN_PROCESS.toString()));
        }
    }

    @Override
    public List<Request> getActiveRequests(User user, int currentPage, int recordsPerPage) throws Exception {
        int start = currentPage * recordsPerPage - recordsPerPage;
        String query = QueriesBinder.getProperty("request.find.active.by.customer");
        try (RequestDAO requestDAO = daoFactory.createRequestDAO()) {
            return requestDAO.findByUserIdAndStatus(String.format(query, RequestStatus.NEW.toString(),
                    RequestStatus.ACCEPTED.toString(), RequestStatus.IN_PROCESS.toString(), start, recordsPerPage), user.getId());
        }
    }

    @Override
    public List<Request> getAccomplishedRequests(User user) throws Exception {
        String query = QueriesBinder.getProperty("request.find.by.customer.and.status");
        try (RequestDAO requestDAO = daoFactory.createRequestDAO()) {
            return requestDAO.findByUserIdAndStatus(String.format(query, RequestStatus.FIXED.toString(),
                    RequestStatus.DECLINED.toString()),
                    user.getId());
        }
    }

    @Override
    public Feedback leaveFeedback(Feedback feedback, Request request) throws Exception {
        try (FeedbackDAO feedbackDAO = daoFactory.createFeedbackDAO()) {
            return feedbackDAO.createAndSetToRequest(feedback, request);
        }
    }

    @Override
    public boolean archiveRequest(Request request) throws Exception {
        try (RequestDAO requestDAO = daoFactory.createRequestDAO()) {
            return requestDAO.moveRequestToArchive(request);
        }
    }
}
