package ua.training.model.dao;

import org.apache.log4j.Logger;
import ua.training.model.dao.impl.jdbc.JDBCDaoFactory;

public abstract class DAOFactory {
    protected static Logger log = Logger.getLogger(DAOFactory.class.getName());
    private static volatile DAOFactory daoFactory;

    public abstract UserDAO createUserDAO();
    public abstract RequestDAO createRequestDAO();
    public abstract FeedbackDAO createFeedbackDAO();
    public abstract RequestArchiveDAO createRequestArchiveDAO();

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
