package jdbc2_Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@//localhost:1521/xe","KJS2","1111"); 
		return con;
	}
	
	public MemberDao() {
		try {
			con = getConnection();
			System.out.println("DB연결 성공!");
		} catch (Exception e) {
			System.out.println("DB연결 실패...");
			e.printStackTrace();
		}
	}

	// 회원가입(insert)
	public int memberJoin(Member mb) {
		int joinResult = 0;
		String sql = "INSERT INTO MEMBER(MID, MPW, MNAME, MEMAIL) VALUES (?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mb.getMid());
			pstmt.setString(2, mb.getMpw());
			pstmt.setString(3, mb.getMname());
			pstmt.setString(4, mb.getMemail());
			joinResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return joinResult;
	}

	// 로그인(select)
	public ArrayList<Member> memberLogin(String loginId, String loginPw) {
		ArrayList<Member> mbList = new ArrayList<Member>();		
		String sql = "SELECT * FROM MEMBER WHERE MID = ? AND MPW = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			pstmt.setString(2, loginPw);
			ResultSet rs = pstmt.executeQuery();			
			while(rs.next()) {
				Member mb = new Member();
				mb.setMid(rs.getString("MID"));
				mb.setMpw(rs.getString("MPW"));
				mb.setMname(rs.getString("MNAME"));
				mb.setMemail(rs.getString("MEMAIL"));
				mbList.add(mb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mbList;
	}
	
	
	
}
