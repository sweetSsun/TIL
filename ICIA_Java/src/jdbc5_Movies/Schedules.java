package jdbc5_Movies;

public class Schedules {

	private String scroom;		//상영관
	private String scdate;		//날짜 및 시간
	private String scthcode;	//극장코드(FK)
	private String scmvcode;	//영화코드(FK)
	
	public String getScroom() {
		return scroom;
	}
	public void setScroom(String scroom) {
		this.scroom = scroom;
	}
	public String getScdate() {
		return scdate;
	}
	public void setScdate(String scdate) {
		this.scdate = scdate;
	}
	public String getScthcode() {
		return scthcode;
	}
	public void setScthcode(String scthcode) {
		this.scthcode = scthcode;
	}
	public String getScmvcode() {
		return scmvcode;
	}
	public void setScmvcode(String scmvcode) {
		this.scmvcode = scmvcode;
	}
	
	
	
}
