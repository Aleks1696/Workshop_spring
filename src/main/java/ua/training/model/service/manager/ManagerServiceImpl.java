package ua.training.model.service.manager;

import ua.training.model.dao.DAOFactory;
import ua.training.model.dao.FeedbackDAO;
import ua.training.model.dao.RequestDAO;
import ua.training.model.dao.UserDAO;
import ua.training.model.entity.*;
import ua.training.model.types.RequestStatus;
import ua.training.model.utils.QueriesBinder;

import java.util.List;

public class ManagerServiceImpl implements ManagerService {
    private DAOFactory daoFactory = DAOFactory.getInstance();

    @Override
    public int getNumberOfNewRequests() throws Exception {
        String query = QueriesBinder.getProperty("request.get.count.of.new");
        try (RequestDAO requestDAO = daoFactory.createRequestDAO()) {
            return requestDAO.getNumberOfRows(query);
        }
    }

    @Override
    public int getNumberOfCustomerFeedbacks(int customerId) throws Exception {
        String query = QueriesBinder.getProperty("request.get.count.of.customer.feedbacks");
        try (FeedbackDAO feedbackDAO = daoFactory.createFeedbackDAO()) {
            return feedbackDAO.getNumberOfRows(String.format(query, customerId));
        }
    }

    @Override
    public List<Request> getNewRequests(int currentPage, int recordsPerPage) throws Exception {
        int start = currentPage * recordsPerPage - recordsPerPage;
        int end = start + recordsPerPage;
        String query = QueriesBinder.getProperty("request.find.by.one.status");
        try (RequestDAO requestDAO = daoFactory.createRequestDAO()) {
            return requestDAO.findRequestByStatus(String.format(query, RequestStatus.NEW.toString(), start, end));
        }
    }

    @Override
    public boolean acceptRequest(Request request) throws Exception {
        try (RequestDAO requestDAO = daoFactory.createRequestDAO()) {
            return requestDAO.updateAcceptedOrDeclined(request);
        }
    }

    @Override
    public boolean declineRequest(Request request) throws Exception {
        try (RequestDAO requestDAO = daoFactory.createRequestDAO()) {
            return requestDAO.updateAcceptedOrDeclined(request);
        }
    }

    @Override
    public User findCustomerById(String customerId) throws Exception {
        try (UserDAO userDAO = daoFactory.createUserDAO()) {
            return userDAO.findById(Integer.valueOf(customerId));
        }
    }

    @Override
    public List<Feedback> getCustomerFeedbacks(int customerId, int currentPage, int recordsPerPage) throws Exception {
        int start = currentPage * recordsPerPage - recordsPerPage;
        int end = start + recordsPerPage;
        String query = QueriesBinder.getProperty("feedback.find.by.customer");
        try (FeedbackDAO feedbackDAO = daoFactory.createFeedbackDAO()) {
            return feedbackDAO.findBy(String.format(query, customerId, start, end));
        }
    }
}