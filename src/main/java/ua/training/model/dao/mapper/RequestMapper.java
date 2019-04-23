package ua.training.model.dao.mapper;

import ua.training.model.entity.*;
import ua.training.model.types.*;
import ua.training.model.utils.AttributesBinder;
import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import static ua.training.model.utils.AttributesBinder.getProperty;

public class RequestMapper implements Mapper<Request> {

    @Override
    public Request extract(ResultSet resultSet) throws SQLException {
        Request request = new Request();
        request.setId(resultSet.getInt(getProperty("parameter.id")));
        request.setProductCategory(ProductCategory.valueOf(
                resultSet.getString(getProperty("parameter.product.category"))));
        request.setDevice(resultSet.getString(getProperty("parameter.device")));
        request.setDescription(resultSet.getString(getProperty("parameter.description")));
        request.setCreationDate(resultSet.getDate(getProperty("parameter.creationDate")).toLocalDate());
        request.setStatus(RequestStatus.valueOf(resultSet.getString(getProperty("parameter.status"))));
        request.setPrice(resultSet.getBigDecimal(getProperty("parameter.price")));
        request.setManagerComment(resultSet.getString(getProperty("parameter.manager.commentary")));
        request.setCustomer_id(resultSet.getInt(getProperty("parameter.customer")));
        request.setManager_id(resultSet.getInt(getProperty("parameter.manager")));
        request.setMaster_id(resultSet.getInt(getProperty("parameter.master")));
        request.setFeedback_id(resultSet.getInt(getProperty("parameter.feedback")));
        return request;
    }

    @Override
    public Request extract(HttpServletRequest req) {
        Request request = new Request();
        request.setProductCategory(ProductCategory.valueOf(
                Optional.ofNullable(req.getParameter(AttributesBinder.getProperty("parameter.product.category")))
                        .orElse("UNKNOWN")));
        request.setDevice(Optional.ofNullable(req.getParameter(AttributesBinder.getProperty("parameter.device")))
                .orElse(Optional.empty().toString()));
        request.setDescription(Optional.ofNullable(req.getParameter(AttributesBinder.getProperty("parameter.description")))
                .orElse(Optional.empty().toString()));
        return request;
    }
}
