package com.journaldev.jsf.util;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DataConnect {

	public static Connection getConnection() {
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			// Connection con = DriverManager.getConnection(
			//		"jdbc:mysql://localhost:3306/loginapp", "root", "root");
			
			
			InitialContext initialContext = new InitialContext ();
	        Context envContext = (Context) initialContext.lookup ("java:comp/env");
	        DataSource dataSource = (DataSource) envContext.lookup ("jdbc/loginapp");
	        Connection con = dataSource.getConnection();

			return con;
		} catch (Exception ex) {
			System.out.println("Database.getConnection() Error -->"
					+ ex.getMessage());
			return null;
		}
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}
}