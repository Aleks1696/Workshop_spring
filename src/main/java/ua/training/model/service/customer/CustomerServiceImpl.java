package ua.training.model.service.customer;

import ua.training.model.dao.DAOFactory;
import ua.training.model.dao.FeedbackDAO;
import ua.training.model.dao.RequestDAO;
import ua.training.model.entity.Feedback;
import ua.training.model.entity.Request;
import ua.training.model.entity.User;
import ua.training.model.types.RequestStatus;
import ua.training.model.utils.QueriesBinder;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private RequestDAO requestDAO;
    private FeedbackDAO feedbackDAO;

    public CustomerServiceImpl() {
        this.requestDAO = DAOFactory.getInstance().createRequestDAO();
        this.feedbackDAO = DAOFactory.getInstance().createFeedbackDAO();
        System.out.println("User dao object from userService: " + requestDAO);
    }

    @Override
    public Request createRequest(Request request) {
        return requestDAO.create(request);
    }

    @Override
    public int getNumberOfActiveRequests(User user) {
        return requestDAO.getNumberOfRows(QueriesBinder.getProperty("request.get.count.of.customer.active.requests"),
                user.getId());
    }

    @Override
    public List<Request> getActiveRequests(User user, int currentPage, int recordsPerPage) {
        int start = currentPage * recordsPerPage - recordsPerPage;
        int end = start + recordsPerPage;
        return requestDAO.findByUserIdAndStatus(
                QueriesBinder.getProperty("request.find.active.by.customer"),
                user.getId(),
                start,
                end,
                RequestStatus.NEW.toString(), RequestStatus.ACCEPTED.toString(), RequestStatus.IN_PROCESS.toString());
    }

    @Override
    public List<Request> getAllRequests(User user) {
        return requestDAO.findAllByUserId(user.getId());
    }

    @Override
    public List<Request> getAccomplishedRequests(User user) {
//        return requestDAO.findByUserIdAndStatus(
//                QueriesBinder.getProperty("request.find.by.customer.and.status"),
//                user.getId(),
//                RequestStatus.FIXED.toString()
//        );
        return null;
    }

    @Override
    public Feedback leaveFeedback(Feedback feedback, Request request) throws SQLException {
        return feedbackDAO.createAndSetToRequest(feedback, request);
    }

    @Override
    public boolean archiveRequest(Request request) throws SQLException {
        return requestDAO.moveRequestToArchive(request);
    }
}
