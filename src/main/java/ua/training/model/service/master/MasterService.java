package ua.training.model.service.master;

import ua.training.model.entity.Request;
import ua.training.model.entity.User;
import java.util.List;

/**
 * The root interface for services made for registered users
 * with role 'master'
 *
 * @see MasterServiceImpl
 * */
public interface MasterService {

    /**
     * Method for pagination purpose only. It counts number of records
     * with IN_PROCESS status for specified user
     *
     * @param user user for which method should count active records
     * @return number of requests in process
     * @throws Exception if an error happened while counting number of records
     * */
    int getNumberOfAcceptedRequests(User user) throws Exception;

    /**
     * Method for pagination purpose only. It counts number of records
     * with ACCEPTED status
     *
     * @return number of accepted requests
     * @throws Exception if an error happened while counting number of records
     * */
    int getNumberOfRequestsToProcess() throws Exception;

    /**
     * Method to get all requests with status 'ACCEPTED'. As it uses pagination
     * an additional parameters passed to this method (currentPage, recordsPerPage)
     *
     * @param currentPage number of page chosen by user that needs to be shown
     * @param recordsPerPage number of records to be shown on one page
     * @return returns list of requests with status 'ACCEPTED'
     * @throws Exception if an error happened while finding accomplished requests
     * */
    List<Request> getRequestsToProcess(int currentPage, int recordsPerPage) throws Exception;

    /**
     * Changes request status from 'ACCEPTED' to 'IN_PROCESS' and makes it belong to
     * master(sets master id to this request)
     *
     * @param request request to be processed
     * @return true if request is updated successfully
     * @throws Exception if request can not be updated due to some errors
     * */
    boolean processRequest(Request request) throws Exception;

    /**
     * Returns list of requests for user(master). As it uses pagination
     * an additional parameters passed to this method (currentPage, recordsPerPage)
     *
     * @param user user for which method should return records
     * @param currentPage number of page chosen by user that needs to be shown
     * @param recordsPerPage number of records to be shown on one page
     * @throws Exception if an error happened while getting accepted requests by master
     * */
    List<Request> getAcceptedRequests(User user, int currentPage, int recordsPerPage) throws Exception;

    /**
     * Changes request status to FIXED
     *
     * @param request request to be processed
     * @throws Exception if an error happened while closing requests
     * */
    boolean closeRequest(Request request) throws Exception;
}
