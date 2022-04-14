package jdbc5_Movies;

public class Movies {

	private String mvcode;	//영화코드
	private String mvname;	//영화이름
	private String mvpd;	//영화감독
	private String mvactor; //배우
	private String mvgenre; //장르
	private int mvage;		//연령
	private int mvtime;		//시간
	private String mvopen;	//개봉일
	private int reservationCount;	//예매횟수
	private double reservationRate; //예매율
	
	public int getReservationCount() {
		return reservationCount;
	}
	public void setReservationCount(int reservationCount) {
		this.reservationCount = reservationCount;
	}
	
	public double getReservationRate() {
		return reservationRate;
	}
	public void setReservationRate(double mvsalerate) {
		this.reservationRate = mvsalerate;
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
	public String getMvpd() {
		return mvpd;
	}
	public void setMvpd(String mvpd) {
		this.mvpd = mvpd;
	}
	public String getMvactor() {
		return mvactor;
	}
	public void setMvactor(String mvactor) {
		this.mvactor = mvactor;
	}
	public String getMvgenre() {
		return mvgenre;
	}
	public void setMvgenre(String mvgenre) {
		this.mvgenre = mvgenre;
	}
	public int getMvage() {
		return mvage;
	}
	public void setMvage(int mvage) {
		this.mvage = mvage;
	}
	public int getMvtime() {
		return mvtime;
	}
	public void setMvtime(int mvtime) {
		this.mvtime = mvtime;
	}
	public String getMvopen() {
		return mvopen;
	}
	public void setMvopen(String mvopen) {
		this.mvopen = mvopen;
	}
	
	
	
}
