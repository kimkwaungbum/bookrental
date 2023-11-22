package login.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.Connector;

public class LoginRepo {

	public boolean login(String id,String password) {

		boolean	loginFlag = false;

		Connection conn = Connector.makeConn();

		String sql = "select * from admininfo where id =? and password =?";

		try{
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();

		int count = 0;
		while(rs.next()) {
			count++;
		}
		if(count>0) {
			loginFlag = true;
		}

		} catch(SQLException e) {
			e.printStackTrace();
		}
		return loginFlag;
	}

}