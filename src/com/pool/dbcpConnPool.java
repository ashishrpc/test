package com.pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

public class dbcpConnPool {
	public static final String DRIVER = "org.postgresql.Driver";
    public static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "infotech@123";

    private GenericObjectPool connectionPool = null;

    public javax.sql.DataSource setUp() throws Exception {
        // Load JDBC Driver class.
        Class.forName(dbcpConnPool.DRIVER).newInstance();

        // Creates an instance of GenericObjectPool that holds our
        // pool of connections object.
        connectionPool = new GenericObjectPool();
        connectionPool.setMaxActive(10);

        // Creates a connection factory object which will be use by
        // the pool to create the connection object. We passes the
        // JDBC url info, username and password.
        ConnectionFactory cf = new DriverManagerConnectionFactory(
                dbcpConnPool.URL,
                dbcpConnPool.USERNAME,
                dbcpConnPool.PASSWORD);

        // Creates a PoolableConnectionFactory that will wraps the
        // connection object created by the ConnectionFactory to add
        // object pooling functionality.
        PoolableConnectionFactory pcf =
                new PoolableConnectionFactory(cf, connectionPool,
                        null, null, false, true);
        return new PoolingDataSource(connectionPool);
    }

    public GenericObjectPool getConnectionPool() {
        return connectionPool;
    }

    public static void main(String[] args) throws Exception {
        dbcpConnPool demo = new dbcpConnPool();
        javax.sql.DataSource dataSource = demo.setUp();
        demo.printStatus();

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = dataSource.getConnection();
            demo.printStatus();

            stmt = conn.prepareStatement("SELECT * FROM student");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Username: " + rs.getString("name"));
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        demo.printStatus();
    }

    /**
     * Prints connection pool status.
     */
    private void printStatus() {
        System.out.println("Max   : " + getConnectionPool().getMaxActive() + "; " +
                "Active: " + getConnectionPool().getNumActive() + "; " +
                "Idle  : " + getConnectionPool().getNumIdle());
    }
}