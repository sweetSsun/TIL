package jdbc3_Bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankDao {
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@//localhost:1521/xe","KJS2","1111"); 
		return con;
	}
	
	public BankDao() {
		try {
			con = getConnection();
			System.out.println("DB연결 성공!");
		} catch (Exception e) {
			System.out.println("DB연결 실패...");
			e.printStackTrace();
		}
	}
	
	// 고객번호 최대값 검색 기능
	public int getMaxClientNumber() {
		String sql = "SELECT NVL(MAX(CLIENTNUMBER), 0) FROM BANKINFO";
		int maxClientNumber = 0;		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				maxClientNumber = rs.getInt(1);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return maxClientNumber;
	}
	
	// 계좌번호 최대값 검색 기능
	public String getMaxAccountNumber() {
		String sql = "SELECT NVL( MAX(ACCOUNTNUMBER), '01-000') FROM BANKINFO";
		String maxAccountNumber = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				maxAccountNumber = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maxAccountNumber;
	}
	
	
	// 계좌생성 기능
	public int createAccount(BankInfo newAccount) {
		String sql = "INSERT INTO BANKINFO(CLIENTNUMBER, CLIENTNAME, ACCOUNTNUMBER, BALANCE)"
				+ " VALUES (?,?,?,?)";
		int insertResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, newAccount.getClientNumber());
			pstmt.setString(2, newAccount.getClientName());
			pstmt.setString(3, newAccount.getAccountNumber());
			pstmt.setInt(4, newAccount.getBalance());
			insertResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insertResult;
	}




}
