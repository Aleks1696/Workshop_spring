package ua.training.model.service.customer;

import ua.training.model.dao.DAOFactory;
import ua.training.model.dao.RequestDAO;
import ua.training.model.entity.Request;
import ua.training.model.entity.User;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private RequestDAO requestDAO;

    public CustomerServiceImpl() {
        this.requestDAO = DAOFactory.getInstance().createRequestDAO();
        System.out.println("User dao object from userService: " + requestDAO);
    }

    @Override
    public List<Request> getActiveRequests(User user) {
        return requestDAO.findAllByUserId(user.getId());

    }
}
