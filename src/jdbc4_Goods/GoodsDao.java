package jdbc4_Goods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GoodsDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@//localhost:1521/xe","KJS2","1111"); 
		return con;
	}
	
	public GoodsDao() {
		try {
			con = getConnection();
			System.out.println("DB연결 성공!");
		} catch (Exception e) {
			System.out.println("DB연결 실패...");
			e.printStackTrace();
		}
	}

	// 등록된 상품번호 최대값 조회
	public int maxGnum() {
		String sql = "SELECT NVL( MAX (GNUM),0 ) FROM GOODS";
		int maxGnumResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				maxGnumResult = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return maxGnumResult;
	}

	// 상품종류 조회
	public ArrayList<String> selectGtypeList() {
		String sql = "SELECT GTYPE FROM GOODS GROUP BY GTYPE";
		ArrayList<String> gtypeList = new ArrayList<String>();
		gtypeList.add("직접입력");
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				gtypeList.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gtypeList;
	}
	
	// 상품 등록
	public int registGoods(Goods goods) {
		String sql = "INSERT INTO GOODS VALUES (?,?,?,?,?)";
		int registResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, goods.getGnum());
			pstmt.setString(2, goods.getGname());
			pstmt.setInt(3, goods.getGprice());
			pstmt.setInt(4, goods.getGamount());
			pstmt.setString(5, goods.getGtype());
			registResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return registResult;
	}

	// 상품목록 조회
	public ArrayList<Goods> selectGoodsList() {
		String sql = "SELECT * FROM GOODS ORDER BY GNUM";
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Goods goods = new Goods();
				goods.setGnum(rs.getInt(1));
				goods.setGname(rs.getString(2));
				goods.setGprice(rs.getInt(3));
				goods.setGamount(rs.getInt(4));
				goods.setGtype(rs.getString(5));
				goodsList.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goodsList;
	}

	
	

}
