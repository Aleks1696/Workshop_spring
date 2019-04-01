package ua.training.model.dao;

import org.apache.log4j.Logger;
import ua.training.model.dao.impl.jdbc.JDBCDaoFactory;

public abstract class DAOFactory {
    protected static Logger log = Logger.getLogger(DAOFactory.class.getName());
    private static DAOFactory daoFactory;

    protected abstract UserDAO createUserDAO();
    protected abstract RequestDAO createRequestDAO();
    protected abstract FeedbackDAO createFeedbackDAO();
    protected abstract RequestArchiveDAO createRequestArchiveDAO();

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            synchronized (DAOFactory.class) {
                if (daoFactory == null) {
                    daoFactory = new JDBCDaoFactory();
                }
            }
        }
        return daoFactory;
    }
}
