package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Dbconn {


	public static Connection dbconnection() {
		String url = "jdbc:mysql://localhost/contacts?serverTimezone=Asia/Seoul";
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "");


		} catch (Exception e) {

			e.printStackTrace();
		}
		return con;


	}
	public void dataInsert(String name,String phone,String email) {
		Connection con = dbconnection();
		String sql = "INSERT INTO person (name ,phone, email) VALUES( ? , ? , ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, phone);
			ps.setString(3, email);


			int result = ps.executeUpdate();
			if(result == 0) {
				System.out.println("데이터 등록 실패");
			}else
				System.out.println("데이터 등록 성공");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}




	public  int dateUpdate(String name, String phone, String email) {

		Connection conn = dbconnection();

		String sql;


		try {

			PreparedStatement ps = null;

			if (name == null && email == null) {
				throw new IllegalArgumentException();
			} else if (name == null) {
				sql = "update person set email = ?  where phone = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, email);
				ps.setString(2, phone);
			} else if(email == null) {
				sql = "update person set name = ?  where phone = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, phone);
			} else {
				sql = "update person set name = ?, email = ?  where phone = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, email);
				ps.setString(3, phone);
			}

			int result = ps.executeUpdate();
			if(result == 0) {
				System.out.println("갱신 실패");
			}else
				System.out.println("갱신 성공");


		} catch (IllegalArgumentException e) {

			e.printStackTrace();
			System.out.println("email, name이 동시에 null은 입력 불가입니다.");

		} catch (Exception e) {

			e.printStackTrace();
		}

		return 0;

    }

	public void SELECT() {
		Connection conn = dbconnection();

		String sql = "SELECT * FROM person";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				System.out.print("*name : " + result.getString(1));
				System.out.print(" *phone : " + result.getString(2));
				System.out.print(" *email : " + result.getString(3));
				System.out.println();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
//	public static void main(String[] args) {
//		try {
//
//
//
//
//
//			String sql = "select * from person";
//
//
////			Statement stmt = con.createStatement();
//
//			//String sql = "INSERT INTO person (name ,phone, email) VALUES('임꺽정' , '010-2222-4444','lee@gmail.com')";
//
////			String sql = "delete from person where name= 'lim";
////			String sql = "update person set name = 'kim' where name = 'lim'";
//			ResultSet result = ps.executeQuery(sql);
//			while(result.next()){
//			 System.out.println("이름 : " + result.getString("name"));
//			 System.out.println("전화번호 : " + result.getString("phone"));
//			 System.out.println("메일 : " + result.getString("email"));
//			 System.out.println();
//			}
//
//
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//
//	}
//
//}
