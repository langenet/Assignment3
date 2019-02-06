/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Robert
 */
public class DataSource {

	private Connection connection = null;
	private String connectionString = "jdbc:mysql://localhost:3306/taskdb";
	private String user = "scott";
	private String password = "tiger";

	public DataSource() {

	}

	public Connection createConnection() {
		try {
			if(connection != null){
				System.out.println("Cannot create new connection, one exists already");
				
			} else {
			connection = DriverManager.getConnection(connectionString + "?useSSL=false", user, password);
			
			}
			

		} catch (SQLException e) {
			System.out.println("Problem accessing database");
			System.out.println(e.getMessage());
		
		}
		return connection;

	}
}

