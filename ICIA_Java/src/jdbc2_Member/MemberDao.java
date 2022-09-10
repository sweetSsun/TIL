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
	ResultSet rs = null;
	
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

	// 회원가입(INSERT)
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
	
	// 전체 회원정보 조회(SELECT *)
	public ArrayList<Member> memberInfo() {
		String sql = "SELECT * FROM MEMBER";
		ArrayList<Member> mbList = new ArrayList<Member>();
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Member mb = new Member();
				mb.setMid(rs.getString("MID"));
				mb.setMname(rs.getString("MNAME"));
				mb.setMemail(rs.getString("MEMAIL"));
				mbList.add(mb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mbList;
	}
	
	// 내정보 조회(SELECT *)
	public Member myInfo(String loginId) {
		String sql = "SELECT * FROM MEMBER WHERE MID = ?";
		Member mb = new Member();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mb.setMid(rs.getString(1));
				mb.setMpw(rs.getString(2));
				mb.setMname(rs.getString(3));
				mb.setMemail(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mb;
	}

	// 로그인(SELECT MID)	
	public String memberLogin(String loginId, String loginPw) {
		String sql = "SELECT MID FROM MEMBER WHERE MID = ? AND MPW = ?";
		String mid = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			pstmt.setString(2, loginPw);
			rs = pstmt.executeQuery();	
			if(rs.next()) {
				mid = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mid;
	}
	
	

	
	// 이메일 수정 (UPDATE)
	public int updateMemail(String loginId, String mpw, String newEmail) {
		int updateResult = 0;
		String sql = "UPDATE MEMBER SET MEMAIL = ? WHERE MID = ? AND MPW = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(2, loginId);
			pstmt.setString(3, mpw);
			pstmt.setString(1, newEmail);
			updateResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateResult;
	}

	// 회원탈퇴(DELETE)
	public int deleteMember(String loginId, String mpw) {
		int deleteResult = 0;
		String sql = "DELETE FROM MEMBER WHERE MID = ? AND MPW = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			pstmt.setString(2, mpw);
			deleteResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deleteResult;
	}

	
	
	
	
}
