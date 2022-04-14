package jdbc5_Movies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	// 회원정보 입력
	public int memberJoin(Members member) {
		String sql = "INSERT INTO MEMBERS(MID, MPW, MNAME, MBIRTH, MGENDER, MTEL, MADDR)"
				+ " VALUES (?,?,?,TO_DATE(?,'YYYY/MM/DD'),?,?,?)";
		int insertResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMid());
			pstmt.setString(2, member.getMpw());
			pstmt.setString(3, member.getMname());
			pstmt.setString(4, member.getMbirth());
			pstmt.setString(5, member.getMgender());;
			pstmt.setString(6, member.getMtel());
			pstmt.setString(7, member.getMaddr());
			insertResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insertResult;
	}

	// 아이디 중복 체크
	public String overlapCheck(String mid) {
		String sql = "SELECT MID FROM MEMBERS WHERE MID = ?";
		String checkId = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				checkId = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return checkId;
	}
	
	// 로그인
	public String memberLogin(String mid, String mpw) {
		String sql = "SELECT MID FROM MEMBERS WHERE MID = ? AND MPW = ?";
		String loginId = "";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, mpw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				loginId = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return loginId;
	}

	// 예매율과 Movie테이블 JOIN하여 영화목록 출력
	public ArrayList<Movies> getMoviesList() {
		String sql = "SELECT MVCODE,MVNAME,MVPD,MVACTOR,MVGENRE,MVAGE,MVTIME,TO_CHAR(MVOPEN,'YYYY/MM/DD'), NVL(SALERATE,0) "
				+ "FROM MOVIES M LEFT OUTER JOIN "
				+ "		(SELECT SCMVCODE, (COUNT(SCMVCODE)/(SELECT COUNT(*) FROM RESERVATION))*100 AS SALERATE FROM SCHEDULES "
				+ "		WHERE (SCROOM, SCDATE, SCTHCODE) IN (SELECT RESCROOM, RESCDATE, RESCTHCODE FROM RESERVATION) "
				+ "		GROUP BY SCMVCODE)RE "
				+ "ON M.MVCODE = RE.SCMVCODE "
				+ "ORDER BY NVL(SALERATE,0) DESC";
		ArrayList<Movies> mvList = new ArrayList<Movies>();
		Movies movie = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				movie = new Movies();
				movie.setMvcode(rs.getString(1));
				movie.setMvname(rs.getString(2));
				movie.setMvpd(rs.getString(3));
				movie.setMvactor(rs.getString(4));
				movie.setMvgenre(rs.getString(5));
				movie.setMvage(rs.getInt(6));
				movie.setMvtime(rs.getInt(7));
				movie.setMvopen(rs.getString(8));
				movie.setReservationRate(rs.getDouble(9));
				mvList.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mvList;
	}
	
	// 예매횟수와 Movie테이블 JOIN하여 영화목록 출력
	public ArrayList<Movies> getMoviesList2() {
		String sql = "SELECT MVCODE,MVNAME,MVPD,MVACTOR,MVGENRE,MVAGE,MVTIME,TO_CHAR(MVOPEN,'YYYY/MM/DD') AS MVOPEN, NVL(COUNT,0) AS RECOUNT"
				+ " FROM MOVIES M LEFT OUTER JOIN"
				+ "    (SELECT SCMVCODE, COUNT(SCMVCODE) AS COUNT"
				+ "    FROM SCHEDULES"
				+ "    WHERE (SCROOM, SCDATE, SCTHCODE) IN (SELECT RESCROOM, RESCDATE, RESCTHCODE FROM RESERVATION)"
				+ "    GROUP BY SCMVCODE)RE"
				+ " ON M.MVCODE = RE.SCMVCODE"
				+ " ORDER BY NVL(COUNT,0) DESC";
		ArrayList<Movies> mvList = new ArrayList<Movies>();
		Movies movie = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				movie = new Movies();
				movie.setMvcode(rs.getString(1));
				movie.setMvname(rs.getString(2));
				movie.setMvpd(rs.getString(3));
				movie.setMvactor(rs.getString(4));
				movie.setMvgenre(rs.getString(5));
				movie.setMvage(rs.getInt(6));
				movie.setMvtime(rs.getInt(7));
				movie.setMvopen(rs.getString(8));
				movie.setReservationCount(rs.getInt(9));
				mvList.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mvList;
	}

	// 극장 목록
	public ArrayList<Theaters> getTheatersList() {
		String sql = "SELECT THCODE,THNAME,THADDR,THTEL FROM THEATERS";
		ArrayList<Theaters> thList = new ArrayList<Theaters>();
		Theaters theater = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				theater = new Theaters();
				theater.setThcode(rs.getString(1));
				theater.setThname(rs.getString(2));
				theater.setThaddr(rs.getString(3));
				theater.setThtel(rs.getString(4));
				thList.add(theater);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return thList;
	}

	// 영화 검색
	public ArrayList<Movies> searchMovie(String mvname) {
		/* mvname1 = "모비" */
		String sql1 = "SELECT * FROM MOVEIS WHERE MVNAME LIKE %?%";
		// sql1 DB전송 >> SELECT * FROM MOVIES WHERE MVNAME LIKE '%'모비'%' >> 오류
		String sql2 = "SELECT * FROM MOVIES WHERE MVNAME LIKE '%" + mvname +"%'";
		// sql2 DB전송 >> SELECT * FROM MOVIES WHERE MVNAME LIKE '%모비%' >> 정상작동
		String sql3 = "SELECT * FROM MOVIES WHERE MVNAME LIKE '%'||?||'%'";
		// sql3 DB전송 >> SELECT * FROM MOVIES WHERE MVNAME LIKE '%모비%' >> 정상작동
		
		/* mvname2 = "%" + "모비" + "%" */
		mvname = "%" + mvname + "%";
		String sql4 = "SELECT * FROM MOVEIS WHERE MVNAME LIKE ?";
		// sql4 DB전송 >> SELECT * FROM MOVIES WHERE MVNAME LIKE '%모비%' >> 정상작동

		ArrayList<Movies> searchList = new ArrayList<Movies>();
		Movies movie = null;
		try {
			pstmt = con.prepareStatement(sql3);
			pstmt.setString(1, mvname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				movie = new Movies();
				movie.setMvcode(rs.getString(1));
				movie.setMvname(rs.getString(2));
				movie.setMvpd(rs.getString(3));
				movie.setMvactor(rs.getString(4));
				movie.setMvgenre(rs.getString(5));
				movie.setMvage(rs.getInt(6));
				movie.setMvtime(rs.getInt(7));
				movie.setMvopen(rs.getString(8));
				searchList.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return searchList;
	}

	// 상영 중 영화목록
	public ArrayList<Movies> getScmvList() {
		String sql = "SELECT MVCODE, MVNAME, MVAGE FROM MOVIES "
				+ "WHERE MVCODE IN (SELECT SCMVCODE FROM SCHEDULES)";
		ArrayList<Movies> scmvList = new ArrayList<Movies>();
		Movies scmovie = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				scmovie = new Movies();
				scmovie.setMvcode(rs.getString(1));
				scmovie.setMvname(rs.getString(2));
				scmovie.setMvage(rs.getInt(3));
				scmvList.add(scmovie);
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return scmvList;
	}

	// 상영 영화관 목록
	public ArrayList<Theaters> getScthList(String mvcode) {
		String sql = "SELECT THCODE, THNAME FROM THEATERS "
				+ "WHERE THCODE IN (SELECT SCTHCODE FROM SCHEDULES WHERE SCMVCODE = ?)";
		ArrayList<Theaters> scthList = new ArrayList<Theaters>();
		Theaters theater = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvcode);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				theater = new Theaters();
				theater.setThcode(rs.getString(1));
				theater.setThname(rs.getString(2));
				scthList.add(theater);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return scthList;
	}
	
	// 해당 영화 상영일
	public ArrayList<Schedules> getScdate(String mvcode, String thcode) {
		String sql = "SELECT TO_CHAR(SCDATE,'YY/MM/DD') FROM SCHEDULES "
				+ "WHERE SCTHCODE = ? AND SCMVCODE = ? "
				+ "GROUP BY TO_CHAR(SCDATE,'YY/MM/DD') "
				+ "ORDER BY TO_CHAR(SCDATE,'YY/MM/DD')";
		ArrayList<Schedules> scdateList = new ArrayList<Schedules>();
		Schedules date = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, thcode);
			pstmt.setString(2, mvcode);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				date = new Schedules();
				date.setScdate(rs.getString(1));
				scdateList.add(date);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return scdateList;
	}

	// 해당 영화 상영관, 상영시간
	public ArrayList<Schedules> getSctime(String mvcode, String thcode, String date) {
		String sql = "SELECT SCROOM, TO_CHAR(SCDATE, 'HH24:MI') FROM SCHEDULES "
				+ "WHERE SCTHCODE = ? AND SCMVCODE = ? AND TO_CHAR(SCDATE,'YY/MM/DD') = ?";
		ArrayList<Schedules> sctimeList = new ArrayList<Schedules>();
		Schedules time = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, thcode);
			pstmt.setString(2, mvcode);
			pstmt.setString(3, date);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				time = new Schedules();
				time.setScroom(rs.getString(1));
				time.setScdate(rs.getString(2));
				sctimeList.add(time);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sctimeList;
	}

	// 예매코드 불러오기
	public String getMaxRecode() {
		String sql = "SELECT NVL(MAX(RECODE),'RE00') FROM RESERVATION";
		String maxRecode = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				maxRecode = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maxRecode;
	}

	// Reservation 테이블 INSERT
	public int insertReservaiton(Reservation reservation) {
		String sql = "INSERT INTO RESERVATION VALUES(?,?,?,?,TO_DATE(?,'YY/MM/DD HH24:MI'),?)";
		int insertResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, reservation.getRecode());
			pstmt.setString(2, reservation.getRemid());
			pstmt.setString(3, reservation.getRescthcode());
			pstmt.setString(4, reservation.getRescroom());
			pstmt.setString(5, reservation.getRescdate());
			pstmt.setInt(6, reservation.getReamount());
			insertResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insertResult;
	}

	// 예매 내역 확인
	public ArrayList<Reservation> getMyRreservation(String loginId) {
		String sql = "SELECT RE.RECODE, MV.MVNAME, TH.THNAME, SC.SCROOM, SC.SCDATE, RE.REAMOUNT"
				+ " FROM RESERVATION RE, MOVIES MV, THEATERS TH, SCHEDULES SC"
				+ " WHERE REMID = ?"
				+ " AND RE.RESCTHCODE = SC.SCTHCODE AND RE.RESCROOM = SC.SCROOM AND RE.RESCDATE = SC.SCDATE"
				+ " AND SC.SCMVCODE = MV.MVCODE AND SC.SCTHCODE = TH.THCODE";
		ArrayList<Reservation> myReList = new ArrayList<Reservation>();
		Reservation myRe = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				myRe = new Reservation();
				myRe.setRecode(rs.getString(1));
				myRe.setMvname(rs.getString(2));
				myRe.setThname(rs.getString(3));
				myRe.setRescroom(rs.getString(4));
				myRe.setRescdate(rs.getString(5));
				myRe.setReamount(rs.getInt(6));
				myReList.add(myRe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myReList;
	}
	
	// 추천 영화 코드 불러오기
	public String getMvcode(String recode, String remid) {
		String sql = "SELECT SCMVCODE"
				+ " FROM SCHEDULES"
				+ " WHERE (SCTHCODE, SCROOM, SCDATE)"
				+ "    IN (SELECT RESCTHCODE, RESCROOM, RESCDATE"
				+ "    FROM RESERVATION"
				+ "    WHERE RECODE = ? AND REMID = ?)";
		String mvcode = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, recode);
			pstmt.setString(2, remid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mvcode = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mvcode;
	}
	
	// 추천했던 영화인지 확인
	public int checkRecommend(String recode) {
		String sql = "SELECT * FROM RECOMMEND WHERE RCRECODE = ?";
		int selectResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, recode);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				selectResult++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return selectResult;
	}
	
	
	// Recommend 테이블에 영화 추천 INSERT
	public int insertRecommend(Recommend recommend) {
		String sql = "INSERT INTO RECOMMEND(RCRECODE, RCMVCODE, RCMID) VALUES(?,?,?)";
		int insertResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, recommend.getRcrecode());
			pstmt.setString(2, recommend.getRcmvcode());
			pstmt.setString(3, recommend.getRcmid());
			insertResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insertResult;
	}

	// 예매 취소
	public int cancelReservation(String cancelRecode) {
		String sql = "DELETE FROM RESERVATION WHERE RECODE = ?";
		int deleteResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cancelRecode);
			deleteResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deleteResult;
	}

	
}


