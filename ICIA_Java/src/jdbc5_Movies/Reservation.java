package jdbc5_Movies;

public class Reservation {
/*
    RECODE NVARCHAR2(4),      -- 예매코드 (PK) - RE001
    REMID NVARCHAR2(10),      -- 예매자아이디 (FK - MEMBERS MID)
    RESCTHCODE NVARCHAR2(4),  -- 극장코드 
    RESCROOM NVARCHAR2(10),   -- 상영관
    RESCDATE DATE,            -- 날짜및시간  (FK)  SCHEDULES(SCTHCODE,SCROOM,SCDATE)
    REAMOUNT NUMBER           -- 예매인원
 */
	
	private String recode;
	private String remid;
	private String rescthcode;
	private String rescroom;
	private String rescdate;
	private int reamount;
	
	private String mvname;
	private String thname;
	private String mvcode;
	private String rccheck;
	
	public String getRccheck() {
		return rccheck;
	}
	public void setRccheck(String rccheck) {
		this.rccheck = rccheck;
	}
	public String getMvcode() {
		return mvcode;
	}
	public void setMvcode(String mvcode) {
		this.mvcode = mvcode;
	}
	
	public String getMvname() {
		return mvname;
	}
	public void setMvname(String mvname) {
		this.mvname = mvname;
	}
	public String getThname() {
		return thname;
	}
	public void setThname(String thname) {
		this.thname = thname;
	}
	
	
	public String getRecode() {
		return recode;
	}
	public void setRecode(String recode) {
		this.recode = recode;
	}
	public String getRemid() {
		return remid;
	}
	public void setRemid(String remid) {
		this.remid = remid;
	}
	public String getRescthcode() {
		return rescthcode;
	}
	public void setRescthcode(String rescthcode) {
		this.rescthcode = rescthcode;
	}
	public String getRescroom() {
		return rescroom;
	}
	public void setRescroom(String rescroom) {
		this.rescroom = rescroom;
	}
	public String getRescdate() {
		return rescdate;
	}
	public void setRescdate(String rescdate) {
		this.rescdate = rescdate;
	}
	public int getReamount() {
		return reamount;
	}
	public void setReamount(int reamount) {
		this.reamount = reamount;
	}
}
