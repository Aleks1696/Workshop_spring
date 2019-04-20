package ua.training.model.service.manager;

import ua.training.model.entity.Feedback;
import ua.training.model.entity.Request;
import ua.training.model.entity.User;
import java.util.List;

/**
 * The root interface for services made for registered users
 * with role 'manager'
 *
 * @see ManagerServiceImpl
 * */
public interface ManagerService {
    /**
     * Method for pagination purpose only. It counts number of records
     * with NEW status
     *
     * @return number of new requests
     * @throws Exception if an error happened while counting number of records
     * */
    int getNumberOfNewRequests() throws Exception;

    /**
     * Method for pagination purpose only. It counts number of feedback
     * record for specific user
     *
     * @param customerId customer for which to get count of feedbacks
     * @return number of customer feedbacks
     * @throws Exception if an error happened while counting number of records
     * */
    int getNumberOfCustomerFeedbacks(int customerId) throws Exception;

    /**
     * Method to get new requests with status 'NEW'. As it uses pagination
     * an additional parameters passed to this method (currentPage, recordsPerPage)
     *
     * @param currentPage number of page chosen by user that needs to be shown
     * @param recordsPerPage number of records to be shown on one page
     * @return returns list of requests with status 'NEW'
     * @throws Exception if an error happened while finding new requests
     * */
    List<Request> getNewRequests(int currentPage, int recordsPerPage) throws Exception;

    /**
     * Changes request status from 'NEW' to 'ACCEPTED', request price
     * will be set according to values passed as parameter and also
     * manager commentary can be set if provided
     *
     * @param request request to process
     * @return true if operation is successful
     * @throws Exception if an error happened while accepting request
     * @see Request
     * */
    boolean acceptRequest(Request request) throws Exception;

    /**
     * Changes request status from 'NEW' to 'DECLINED', manager commentary
     * will also be set
     *
     * @param request request to process
     * @return true if operation is successful
     * @throws Exception if an error happened while accepting request
     * */
    boolean declineRequest(Request request) throws Exception;

    /**
     * Allows to find customer by it's id.
     *
     * @param customerId customer id
     * @return user found in database
     * @throws ua.training.model.exceptions.UserNotFoundException if
     *          customer with such id is not found in database
     * */
    User findCustomerById(String customerId) throws Exception;

    /**
     * Finds all customer feedbacks left for accomplished requests.
     * As it uses pagination an additional parameters passed to this
     * method (currentPage, recordsPerPage)
     *
     * @param customerId customer whose feedbacks to find
     * @param currentPage number of page chosen by user that needs to be shown
     * @param recordsPerPage number of records to be shown on one page
     * @return list of customer feedbacks
     * @throws Exception if an error happened while finding customer feedbacks
     * */
    List<Feedback> getCustomerFeedbacks(int customerId, int currentPage, int recordsPerPage) throws Exception;
}
