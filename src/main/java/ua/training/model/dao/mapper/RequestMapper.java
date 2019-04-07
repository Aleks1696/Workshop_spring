package ua.training.model.dao.mapper;

import ua.training.model.dao.DAOFactory;
import ua.training.model.entity.*;
import ua.training.model.types.*;
import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static ua.training.model.utils.AttributesBinder.getProperty;

public class RequestMapper implements Mapper<Request> {

    @Override
    public Request extract(ResultSet resultSet) throws SQLException {
        //TODO handle NPE when db has null value and resultSet takes it
        Request request = new Request();
        request.setId(Optional.of(resultSet.getInt(getProperty("parameter.id"))).orElse(0));
        request.setProductCategory(ProductCategory.valueOf(
                resultSet.getString(getProperty("parameter.product.category"))));
        request.setDescription(resultSet.getString(getProperty("parameter.description")));
        request.setCreationDate(resultSet.getDate(getProperty("parameter.creationDate")).toLocalDate());
        request.setClosingDate(Optional.ofNullable(resultSet.getDate(getProperty("parameter.closingDate")).toLocalDate()).orElse(null));
        request.setStatus(RequestStatus.valueOf(resultSet.getString(getProperty("parameter.status"))));
        request.setPrice(resultSet.getBigDecimal(getProperty("parameter.price")));
        request.setManagerComment(resultSet.getString(getProperty("parameter.manager.commentary")));

        int customerId = resultSet.getInt(getProperty("parameter.customer"));
        request.setCustomer(getRelatedUser(customerId));
        int managerId = resultSet.getInt(getProperty("parameter.manager"));
        request.setCustomer(getRelatedUser(managerId));
        int masterId = resultSet.getInt(getProperty("parameter.master"));
        request.setCustomer(getRelatedUser(masterId));
        int feedbackId = resultSet.getInt(getProperty("parameter.feedback"));
        request.setFeedback(getRelatedFeedback(feedbackId));
        return request;
    }

    private User getRelatedUser(int id) {
        return DAOFactory.getInstance().createUserDAO().findById(id);
    }

    private Feedback getRelatedFeedback(int id) {
        return DAOFactory.getInstance().createFeedbackDAO().findById(id);
    }

    @Override
    public Request extract(HttpServletRequest request) {
        return null;
    }
}
