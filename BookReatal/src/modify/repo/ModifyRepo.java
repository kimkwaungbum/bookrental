package modify.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.Connector;

public class ModifyRepo {
	public boolean modify(String title, String category, String writter,
			String company, int price, String status ,String rental_user,
			String return_day,String rental_day,int rental_price,int no) {
		boolean isSuccess = false;

		Connection conn = Connector.makeConn();

		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE `book` ");
		sql.append("SET ");
		sql.append("`title` = ?,");
		sql.append("`category` = ?,");
		sql.append("`writter` = ?,");
		sql.append("`company` = ?,");
		sql.append("`price` = ?,");
		sql.append("`status` = ?,");
		sql.append("`rental_user` = ?,");
		sql.append("`return_day` = ?,");
		sql.append("`rental_day` = ?,");
		sql.append("`rental_price` = ?");
		sql.append(" where ");
		sql.append("`no` = ?");

		try {
			//카테고리 0:만화책, 1:소설 ,2 잡지
			// 상태 : 0 대여가능 1:대여중 ,2:분실
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, title);
			ps.setString(2, category);
			ps.setString(3, writter);
			ps.setString(4, company);
			ps.setInt(5, price);
			ps.setString(6, status);
			ps.setString(7, rental_user);
			ps.setString(8, return_day);
			ps.setString(9, rental_day);
			ps.setInt(10, rental_price);
			ps.setInt(11, no);


            int result = ps.executeUpdate();


            if(result>0) {
    			isSuccess = true;
    		}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return isSuccess;
	}
	 public int getNoByTitle(String title) {
	        Connection conn = Connector.makeConn();
	        int no = -1;

	        try {
	            String sql = "SELECT `no` FROM `book` WHERE `title` = ?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, title);

	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                no = rs.getInt("no");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return no;
	    }


}


