package ua.training.model.dao.impl.jdbc;

import ua.training.model.dao.*;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DAOFactory {
    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    @Override
    public UserDAO createUserDAO() {
        return new JDBCUserDao(getConnection());
    }

    @Override
    public RequestDAO createRequestDAO() {
        return new JDBCRequestDao(getConnection());
    }

    @Override
    public FeedbackDAO createFeedbackDAO() {
        return new JDBCFeedbackDao(getConnection());
    }

    @Override
    public RequestArchiveDAO createRequestArchiveDAO() {
        return new JDBCRequestArchiveDao(getConnection());
    }

    private Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException ex) {
            log.error("Failed establishing connection to database", ex);
            throw new RuntimeException(ex);
        }
    }
}
