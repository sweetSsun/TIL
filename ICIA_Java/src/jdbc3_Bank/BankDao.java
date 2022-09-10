package jdbc3_Bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	// 고객리스트 출력 기능
	public ArrayList<BankInfo> selectClientList() {
		String sql = "SELECT * FROM BANKINFO ORDER BY CLIENTNUMBER";
		ArrayList<BankInfo> clientList = new ArrayList<BankInfo>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BankInfo client = new BankInfo();
				client.setClientNumber(rs.getInt("CLIENTNUMBER"));
				client.setClientName(rs.getString("CLIENTNAME"));
				client.setAccountNumber(rs.getString("ACCOUNTNUMBER"));
				client.setBalance(rs.getInt("BALANCE"));
				clientList.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientList;
	}

	// 계좌번호 유무 확인 기능
	public BankInfo checkAccount(String accountNumber) {
		String sql = "SELECT * FROM BANKINFO WHERE ACCOUNTNUMBER = ?";
		BankInfo client = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, accountNumber);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				client = new BankInfo();
				client.setClientNumber(rs.getInt(1));
				client.setClientName(rs.getString(2));
				client.setAccountNumber(rs.getString(3));
				client.setBalance(rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}

	// 입금 기능
	public int updateDeposit(BankInfo client, int deposit) {
		String sql = "UPDATE BANKINFO SET BALANCE = ? WHERE ACCOUNTNUMBER = ?";
		int depositResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, client.getBalance() + deposit);
			pstmt.setString(2, client.getAccountNumber());
			depositResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return depositResult;
	}

	// 출금 기능
	public int updateWithdraw(BankInfo client, int withdraw) {
		String sql = "UPDATE BANKINFO SET BALANCE = ? WHERE ACCOUNTNUMBER = ?";
		int withdrawResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, client.getBalance() - withdraw);
			pstmt.setString(2, client.getAccountNumber());
			withdrawResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return withdrawResult;
	}
	
	// 입출금 기능을 합친 것 (입금 check1, 출금 check0)
	public int update(BankInfo client, int money, int check) {
		String sql1 = "UPDATE BANKINFO SET BALANCE = BALANCE + ? WHERE ACCOUNTNUMBER = ?";
		String sql2 = "UPDATE BANKINFO SET BALANCE = BALANCE - ? WHERE ACCOUNTNUMBER = ?";
		int updateResult = 0;
		try {
			if (check == 1) {
				pstmt = con.prepareStatement(sql1);
				pstmt.setInt(1, money);
				pstmt.setString(2, client.getAccountNumber());
				updateResult = pstmt.executeUpdate();
			} else {
				pstmt = con.prepareStatement(sql2);
				pstmt.setInt(1, money);
				pstmt.setString(2, client.getAccountNumber());
				updateResult = pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateResult;
	}

}
