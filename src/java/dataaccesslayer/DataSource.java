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

	public DataSource() {

	}

	public Connection createConnection() {
		try {
			if(connection != null){
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
}

