package jdbc4_Goods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		String sql = "SELECT MID, MNAME, TO_CHAR(MBIRTH,'YYYY/MM/DD'), MGENDER, MTEL, MADDR"
				+ " FROM MEMBERS WHERE MID = ?";
		Members member = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Members();
				member.setMid(rs.getString(1));
				member.setMname(rs.getString("MNAME"));
				member.setMbirth(rs.getString("TO_CHAR(MBIRTH,'YYYY/MM/DD')"));
				member.setMgender(rs.getString("MGENDER"));
				member.setMtel(rs.getString("MTEL"));
				member.setMaddr(rs.getString("MADDR"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
	
	// 판매중인 상품 목록 SELECT
	public ArrayList<Goods> saleGoodsList() {
		String sql = "SELECT GNUM, GNAME FROM GOODS"
				+ " WHERE GSTATE = 1 AND GAMOUNT > 0 ORDER BY GNUM";
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Goods goodInfo = new Goods();
				goodInfo.setGnum(rs.getInt(1));
				goodInfo.setGname(rs.getString(2));
				goodsList.add(goodInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goodsList;
	}

	// 주문코드 자동생성
	public String getMaxOdnum() {
		String sql = "SELECT NVL( MAX(ODCODE), 'OD000' ) FROM ORDERINFO";
		String maxOdcode = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				maxOdcode = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maxOdcode;
	}
	
	// 주문정보 ORDERINFO에 INSERT
	public int insertOrderInfo(OrderInfo odInfo) {
		String sql = "INSERT INTO ORDERINFO(ODCODE, ODGNUM, ODAMOUNT, ODMID, ODDATE)"
				+ "VALUES (?,?,?,?,SYSDATE)";
		int insertResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, odInfo.getOdcode());
			pstmt.setInt(2, odInfo.getOdgnum());
			pstmt.setInt(3, odInfo.getOdamount());
			pstmt.setString(4, odInfo.getOdmid());
			insertResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return insertResult;
	}

	// 로그인 된 아이디로 주문내역 확인
	public ArrayList<OrderInfo> getMyOrderList(String loginId) {
		String sql = "SELECT * FROM ORDERINFO WHERE ODMID = ?";
		ArrayList<OrderInfo> odList = new ArrayList<OrderInfo>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OrderInfo order = new OrderInfo();
				order.setOdcode(rs.getString(1));
				order.setOdgnum(rs.getInt(2));
				order.setOdamount(rs.getInt(3));
				order.setOdmid(rs.getString(4));
				order.setOddate(rs.getString(5));
				odList.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return odList;
	}

	// 상품 재고 수정
	public int updateGoodsAmount(OrderInfo odInfo) {
		String sql = "UPDATE GOODS SET GAMOUNT = GAMOUNT - ? WHERE GNUM =?";
		int updateResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, odInfo.getOdamount());
			pstmt.setInt(2, odInfo.getOdgnum());
			updateResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return updateResult;
	}
	
	
	

}
