package jdbc4_Goods;

public class Goods {

	/*
	GNUM NUMBER CONSTRAINT PK_GNUM PRIMARY KEY, --상품번호
    GNAME NVARCHAR2(10) NOT NULL,               --상품이름
    GPRICE NUMBER NOT NULL,                     --상품가격
    GAMOUNT NUMBER,                             --상품수량
    GTYPE NVARCHAR2(10)                         --상품종류
	 */
	private int gnum;		//상품번호
	private String gname;	//상품이름
	private int gprice;		//상품가격
	private int gamount;	//상품수량
	private String gtype;	//상품종류
	private int gstate;		//상품상태 1:판매가능, 0:판매중지
	
	public int getGstate() {
		return gstate;
	}
	public void setGstate(int gstate) {
		this.gstate = gstate;
	}
	public int getGnum() {
		return gnum;
	}
	public void setGnum(int gnum) {
		this.gnum = gnum;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public int getGprice() {
		return gprice;
	}
	public void setGprice(int gprice) {
		this.gprice = gprice;
	}
	public int getGamount() {
		return gamount;
	}
	public void setGamount(int gamount) {
		this.gamount = gamount;
	}
	public String getGtype() {
		return gtype;
	}
	public void setGtype(String gtype) {
		this.gtype = gtype;
	}
	
	
}
