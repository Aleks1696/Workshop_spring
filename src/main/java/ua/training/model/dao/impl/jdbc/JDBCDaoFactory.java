package ua.training.model.dao.impl.jdbc;

import ua.training.model.dao.*;
import ua.training.model.dao.impl.ConnectionPoolHolder;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DAOFactory {
    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    @Override
    protected UserDAO createUserDAO() {
        return new JDBCUserDao();
    }

    @Override
    protected RequestDAO createRequestDAO() {
        return new JDBCRequestDao();
    }

    @Override
    protected FeedbackDAO createFeedbackDAO() {
        return new JDBCFeedbackDao();
    }

    @Override
    protected RequestArchiveDAO createRequestArchiveDAO() {
        return new JDBCRequestArchiveDao();
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException ex) {
            log.error("Failed establishing connection to database", ex);
            throw new RuntimeException(ex);
        }
    }
}
