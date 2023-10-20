package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {
	public static  Connection connectDb() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://SONGTUE\\SQLEXPRESS:1433;databaseName=store;integratedSecurity=false;encrypt=true;trustServerCertificate=true";
			String userName = "sa";
			String password = "123456";
			
			Connection connect = DriverManager.getConnection(url, userName, password);
			return connect;
			
		}catch(Exception e) {		
			e.printStackTrace();
		}
		return null;
		
	}
}
