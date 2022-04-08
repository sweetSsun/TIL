package jdbc4_Goods;

public class OrderInfo {
	
	private String odcode;		// 주문코드 PK -- OD001, OD002
	private int odgnum;			// 상품번호 FK :: GOODS-GNUM
	private int odamount;		// 주문수량
	private String odmid;		// 구매자아이디 FK :: MEMBERS-MID
	private String oddate;		// 주문일
	
	public String getOdcode() {
		return odcode;
	}
	public void setOdcode(String odcode) {
		this.odcode = odcode;
	}
	public int getOdgnum() {
		return odgnum;
	}
	public void setOdgnum(int odgnum) {
		this.odgnum = odgnum;
	}
	public int getOdamount() {
		return odamount;
	}
	public void setOdamount(int odamount) {
		this.odamount = odamount;
	}
	public String getOdmid() {
		return odmid;
	}
	public void setOdmid(String odmid) {
		this.odmid = odmid;
	}
	public String getOddate() {
		return oddate;
	}
	public void setOddate(String oddate) {
		this.oddate = oddate;
	}
}
