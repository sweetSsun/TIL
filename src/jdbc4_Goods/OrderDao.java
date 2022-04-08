package jdbc4_Goods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDao {
	
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@//localhost:1521/xe","KJS2","1111"); 
		return con;
	}
	
	public OrderDao() {
		try {
			con = getConnection();
			System.out.println("DB연결 성공!");
		} catch (Exception e) {
			System.out.println("DB연결 실패...");
			e.printStackTrace();
		}
	}
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// 회원가입 기능
	public int memberJoin(Members member) {
		String sql = "INSERT INTO MEMBERS (MID, MPW, MNAME, MBIRTH, MGENDER, MTEL, MADDR)"
				+ "VALUES(?,?,?,TO_DATE(?,'YYYY/MM/DD'),?,?,?)";
		int insertResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMid());
			pstmt.setString(2, member.getMpw());
			pstmt.setString(3, member.getMname());
			pstmt.setString(4, member.getMbirth());
			pstmt.setString(5, member.getMgender());
			pstmt.setString(6, member.getMtel());
			pstmt.setString(7, member.getMaddr());
			insertResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insertResult;
	}

	public String memberLogin(String mid, String mpw) {
		String sql = "SELECT * FROM MEMBERS WHERE MID = ? AND MPW = ?";	
		String loginId = "";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, mpw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				loginId = rs.getString("MID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loginId;
	}

	// 내정보 기능
	public Members getMyInfo(String loginId) {
		String sql = "SELECT * FROM MEMBERS WHERE MID = ?";
		Members memberInfo = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberInfo = new Members();
				memberInfo.setMid(rs.getString(1));
				memberInfo.setMname(rs.getString("MNAME"));
				memberInfo.setMbirth(rs.getString("MBIRTH"));
				memberInfo.setMgender(rs.getString("MGENDER"));
				memberInfo.setMtel(rs.getString("MTEL"));
				memberInfo.setMaddr(rs.getString("MADDR"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberInfo;
	}


	
	

}
