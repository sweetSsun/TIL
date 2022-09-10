package jdbc1_Phonebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PhoneBookDao {
	
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@//localhost:1521/xe","KJS2","1111"); 
		return con;
	}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	// Statement는 sql 변수에 담아주는 쿼리문 자체에 value값이 들어가야함(예전에 사용하던 버전)
	ResultSet rs = null;
	// 테이블의 값(표의 형태)를 저장해두는 필드
	
	public PhoneBookDao() {
		try {
			con = getConnection();
			System.out.println("DB연결 성공!");
		} catch (Exception e) {
			System.out.println("DB연결 실패...");
			e.printStackTrace();
		}
	}

	// 연락처 입력 기능 (insert)
	public int insertPhoneBook(PhoneBook pb) {
		String sql = "INSERT INTO PHONEBOOK(PB_NAME, PB_TEL) VALUES(?,?)";

		int insertResult = 0;
		
		try {
			pstmt = con.prepareStatement(sql); // INSERT INTO PHONEBOOK(PB_NAME, PB_TEL) VALUES(1,2)
			// DB에서 f9키 누르기 직전, (?,?)값이 담겨있는 상태
			pstmt.setString(1, pb.getPb_name()); // INSERT INTO PHONEBOOK(PB_NAME, PB_TEL) VALUES(pb_name,?)
			// 첫번째 ? = pb객체의 name필드 값을 pstmt에 set
			pstmt.setString(2, pb.getPb_tel()); // INSERT INTO PHONEBOOK(PB_NAME, PB_TEL) VALUES(pb_name,pb_tel)
			// 두번째 ? = pb객체의 tel필드 값을 pstmt에 set
			insertResult = pstmt.executeUpdate(); // 몇 개의 행이 변화했는지 갯수를 반환
			// DB에서 f9키를 누르는 역할(자동커밋됨)			
			/*
			 * executeUpdate() : insert, update, delete문
			 * executeQuery() : select문
			 */
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insertResult;
	}

	// 전체 연락처 조회 기능 (select)
	public ArrayList<PhoneBook> selectPhoneBook(){
		String sql = "SELECT * FROM PHONEBOOK";
		// select문 실행 >> 결과값을 리턴 >> 리턴받은 값을 ArryList 변환
		ArrayList<PhoneBook> pbList = new ArrayList<PhoneBook>();
		PhoneBook pb = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pb = new PhoneBook();
				pb.setPb_name(rs.getString(1)); // 첫번째 컬럼 
				pb.setPb_tel(rs.getString("PB_TEL")); // 컬럼명 직접 명시
				// rs. 뒤에 붙는 형식은 해당 컬럼의 데이터타입에 따름
				pbList.add(pb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pbList;
	}

	// 연락처 삭제 기능 (delete)
	public int deletePhoneBook(String delName) {
		String sql = "DELETE FROM PHONEBOOK WHERE PB_NAME = ?";
		
		int deleteResult = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, delName);
			deleteResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deleteResult;
	}

	public int updatePhoneBook(String pbName, String newPbTel) {
		String sql = "UPDATE PHONEBOOK SET PB_TEL = ? WHERE PB_NAME = ?";
		
		int updateResult = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newPbTel);
			pstmt.setString(2, pbName);
			updateResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateResult;
	}

	
	
	
	
	
}
