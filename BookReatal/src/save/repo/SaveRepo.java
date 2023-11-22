package save.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.Connector;

public class SaveRepo {
	public boolean save(String title, String category, String writer,
			String company, int price, String status ,int rentalPrice) {
		boolean isSuccess = false;

		Connection conn = Connector.makeConn();
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO `book` ");
		sql.append("(`title`, `category`, `writter`, `company`, `price`, `status`, `rental_user`, `return_day`, `rental_day`, `rental_price`) ");
		sql.append("VALUES");
		sql.append("(?, ?, ?, ?, ?, ?, NULL, NULL, NULL, ?);");

		try {
			//카테고리 0:만화책, 1:소설 ,2 잡지
			// 상태 : 0 대여가능 1:대여중 ,2:분실
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			 ps.setString(1, title);
	            ps.setString(2, category);
	            ps.setString(3, writer);
	            ps.setString(4, company);
	            ps.setInt(5, price);
	            ps.setString(6, status);
	            ps.setInt(7, rentalPrice);

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
	public static void main(String[] args) {
		SaveRepo sp = new SaveRepo();
		sp.save("임꺽정", "1", "김인식","대국 출판사",15000,"0", 600);
	}
}
