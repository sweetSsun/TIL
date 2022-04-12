package jdbc5_Movies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReservationDao {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@//121.65.47.77:7777/xe","KJS_GOODS","1111"); 
		return con;
	}
	
	public ReservationDao() {
		try {
			con = getConnection();
			System.out.println("DB연결 성공!");
		} catch (Exception e) {
			System.out.println("DB연결 실패...");
			e.printStackTrace();
		}
	}
}
