package detail.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.Connector;

public class DeleteRepo {

		public boolean delete(String title) {
			boolean isSuccess = false;

			Connection conn = Connector.makeConn();
			String sql =("DELETE FROM `book` WHERE title = ? ");

			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, title);

				int result = ps.executeUpdate();
	            if(result>0) {
	    			isSuccess = true;
	    		}
			} catch (SQLException e) {

				e.printStackTrace();
			}
			return isSuccess;
		}




}
