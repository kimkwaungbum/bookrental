package detail.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.Connector;
import list.ListFrame;

public class DetailRepo {
	ListFrame lf = new ListFrame();

	public String[] detail(String title) {

		Connection conn = Connector.makeConn();
		String[] bookInfo = new String[10];
		String sql = "select * from book where title =?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {

				String bookTitle = rs.getString(2);
				String category = rs.getString(3);
				String writter = rs.getString(4);
				String company = rs.getString(5);
				String price = String.valueOf(rs.getInt(6));
				String status = rs.getString(7);
				String rentalUser = rs.getString(8);
				String returnDay = rs.getString(9);
				String rentalDay = rs.getString(10);
				String rentalPrice = String.valueOf(rs.getInt(11));


				bookInfo[0]= bookTitle;
				bookInfo[1]=category;
				bookInfo[2]=writter;
				bookInfo[3]=company;
				bookInfo[4]=price;
				bookInfo[5]=status;
				bookInfo[6]=rentalUser;
				bookInfo[7]=returnDay;
				bookInfo[8]=rentalDay;
				bookInfo[9]=rentalPrice;



			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return bookInfo;

	}
//	public static void main(String[] args) {
//		DetailRepo dp = new DetailRepo();
//
//	}
}
