package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {

	public static Connection makeConn() {
		String url = "jdbc:mysql://localhost/bookrental?";
		Connection con = null;
		String id ="root";
		String pw = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pw);


		} catch (Exception e) {

			e.printStackTrace();
		}
		return con;
	}


}
