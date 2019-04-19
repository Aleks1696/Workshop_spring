package ua.training.model.dao.impl.jdbc;

import org.apache.log4j.Logger;
import ua.training.model.dao.GenericDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractDAO<T> implements GenericDAO<T> {
    private static Logger log = Logger.getLogger(AbstractDAO.class.getName());
    Connection connection;

    public AbstractDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void close() throws Exception {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getNumberOfRows(String query) {
        int numberOfRows = 0;
        try (PreparedStatement statement =
                     connection.prepareStatement(query)) {
            ResultSet result = statement.executeQuery();
            result.next();
            numberOfRows = result.getInt("numberOfRows");
        } catch (SQLException e) {
            log.error("Failed get number of rows");
        }
        return numberOfRows;
    }
}
