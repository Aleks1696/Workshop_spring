package ua.training.model.dao.impl.jdbc;

import org.apache.commons.dbcp.BasicDataSource;
import ua.training.model.utils.Binder;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionPoolHolder {
    private static volatile DataSource dataSource;
    private static ResourceBundle bundle = ResourceBundle.getBundle("database/connection");

    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    BasicDataSource bs = new BasicDataSource();
                    bs.setDriverClassName(Binder.getProperty(bundle, "mysql.driver"));
                    bs.setUrl(Binder.getProperty(bundle, "mysql.url"));
                    bs.setUsername(Binder.getProperty(bundle, "mysql.user"));
                    bs.setPassword(Binder.getProperty(bundle, "mysql.password"));
                    bs.setMinIdle(5);
                    bs.setMaxIdle(10);
                    bs.setMaxWait(40);
                    bs.setMaxActive(30);
                    bs.setMaxOpenPreparedStatements(100);
                    dataSource = bs;
                }
            }
        }
        return dataSource;
    }
}
