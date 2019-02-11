/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robert
 */
public class DataSource {

    private Connection connection = null;
    private String connectionString = "jdbc:mysql://localhost:3306/employees";
    private String user = "scott";
    private String password = "tiger";

    private DataSource() {

    }

    private static class InnerDataSource {

        private static final DataSource INSTANCE
                = new DataSource();
    }

    public static DataSource getInstance() {
        return InnerDataSource.INSTANCE;
    }

    public Connection createConnection() {
        try {

            /* 
            Source: https://stackoverflow.com/questions/17278060/database-connection-not-closing
            Author: My-Name-Is
            date: 2013-06-24
             */
            if (connection != null && !connection.isClosed()) {
                System.out.println("Cannot create new connection, one exists already");

            } else {
                // load and register JDBC driver for MySQL
                Class.forName("com.mysql.jdbc.Driver");

                connection = DriverManager.getConnection(connectionString + "?useSSL=false", user, password);

            }

        } catch (SQLException e) {
            System.out.println("Problem accessing database");
            System.out.println(e.getMessage());

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;

    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        this.connection.close();
    }
}
