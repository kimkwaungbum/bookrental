package db;

public class DbTest {

	public static void main(String[] args) {

		Dbconn dbconn = new Dbconn();
		//dbconn.dataInsert("park","010-2333-5555","park@gmail.com");
		//dbconn.dateUpdate(null , "010-2333-5555", "park1@gmail.com");
		dbconn.SELECT();
	}

}
