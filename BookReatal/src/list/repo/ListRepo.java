package list.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.Connector;

public class ListRepo {
	public String[][] list() {

		 Connection conn = Connector.makeConn();

	        String sql = "SELECT * FROM `book`";

	        try {
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            
	            List<String[]> resultList = new ArrayList<String[]>();
//	    		"책 ","출판사","카테고리","저자","대여상태"
	            while (rs.next()) {
	                
	                String title = rs.getString(2);
	                String company = rs.getString(5);
	                String category = rs.getString(3);
	                String writer = rs.getString(4);
	                String status = rs.getString(7);
	                
	                String[] row = {title, company, category, writer, status};
	                resultList.add(row);
	                
	            }
	            return resultList.toArray(new String[0][0]);
	        } catch (SQLException e) {
	            e.printStackTrace();

	        }
			return null;
	    }
	



}
