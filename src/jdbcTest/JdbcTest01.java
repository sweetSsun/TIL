package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;

public class JdbcTest01 {

	public static void main(String[] args) {

		try {
			Connection con = getConnection();
			System.out.println("DB연결 성공!");
		} catch (Exception e) {
			System.out.println("DB연결 실패!");
			e.printStackTrace();
		}
		
	}
	

	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@//localhost:1521/xe","KJS2","1111"); 
		return con;
	}

}
