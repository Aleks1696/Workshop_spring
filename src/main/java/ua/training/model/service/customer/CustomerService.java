package ua.training.model.service.customer;

import ua.training.model.entity.Feedback;
import ua.training.model.entity.Request;
import ua.training.model.entity.User;
import java.util.List;

/**
 * The root interface for services made for registered users
 * with role 'customer'
 *
 * @see CustomerServiceImpl
 * */

public interface CustomerService {
    /**
     * New request will be created by this method.
     *
     * @param request {@link Request} with parameters provided customer
     * @return returns created request
     * @throws Exception if an error happened while creating new request
     *          record this exception will be thrown
     * @throws ua.training.model.exceptions.AlreadyExistException if request
     * used to be created
     * */
    Request createRequest(Request request) throws Exception;

    /**
     * Method for pagination purpose only. It counts number of records
     * with 'active'(NEW, ACCEPTED, IN_PROCESS) status for user
     *
     * @param user user for which method should cont active records
     * @return number of active requests
     * @throws Exception if an error happened while counting number of records
     * @see ua.training.model.types.UserRole
     * */
    int getNumberOfActiveRequests(User user) throws Exception;

    /**
     * Method to get all customer active requests (with status: NEW, ACCEPTED,
     * IN_PROCESS). As it uses pagination an additional parameters passed to
     * this method (currentPage, recordsPerPage)
     *
     * @param user user for which method should return requests
     * @param currentPage number of page chosen by user that needs to be shown
     * @param recordsPerPage number of records to be shown on one page
     * @return returns list of customer's active requests
     * @throws Exception if an error happened while finding accomplished requests
     * */
    List<Request> getActiveRequests(User user, int currentPage, int recordsPerPage) throws Exception;

    /**
     * Method to get all customer accomplished requests (with status: FIXED)
     *
     * @param user user for which method should return requests
     * @return returns list of customer's active requests
     * @throws Exception if an error happened while finding requests
     * */
    List<Request> getAccomplishedRequests(User user) throws Exception;

    /**
     * Creates new {@link Feedback} from data passed as a parameter. Feedback
     * will also be stored to related request as a foreign key in database.
     *
     * @param feedback customer feedback
     * @param request request for feedback
     * @throws Exception if an error while creating feedback happens
     * @throws ua.training.model.exceptions.AlreadyExistException if such feedback
     * is already exist
     * */
    Feedback leaveFeedback(Feedback feedback, Request request) throws Exception;

    /**
     * After request has been accomplished (status: FIXED) can this method be called.
     * It archives(moves) request to archive database table.
     *
     * @param request request to be archived
     * @throws Exception if an error happened while archiving request
     * */
    boolean archiveRequest(Request request) throws Exception;
}
