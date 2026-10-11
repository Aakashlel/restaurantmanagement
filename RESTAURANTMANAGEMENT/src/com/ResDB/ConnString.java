package com.ResDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnString {
	
	static Connection con=null;
	public static Connection createConnection() {
		
		try {
			Class<?> driver=Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Registered");
			String url = System.getenv().getOrDefault("DB_URL",
					"jdbc:mysql://localhost:3306/restaurantmanagement?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
			String username = System.getenv().getOrDefault("DB_USERNAME", "root");
			String password = System.getenv().getOrDefault("DB_PASSWORD", "");
			con=DriverManager.getConnection(url, username, password);
			//System.out.println("Connection created");
			//con.close();
			//System.out.println("Connection closed");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}

}
