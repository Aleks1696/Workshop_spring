package ua.training.model.dao.impl;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

public class ConnectionPoolHolder {
    private static volatile DataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    //TODO move all hardcode to properties
                    BasicDataSource bs = new BasicDataSource();
                    bs.setDriverClassName("com.mysql.jdbc.Driver");
                    bs.setUrl("jdbc:mysql://localhost:3306/workshop");
                    bs.setUsername("myRoot");
                    bs.setPassword("root");
                    bs.setMinIdle(5);
                    bs.setMaxIdle(10);
                    bs.setMaxOpenPreparedStatements(100);
                    dataSource = bs;
                }
            }
        }
        return dataSource;
    }
}
