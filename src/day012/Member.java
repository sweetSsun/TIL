package day012;

public class Member {

	// 필드
	private String mid; 	// 아이디
	private String mpw; 	// 비밀번호
	private String mname; 	// 이름
	private String memail; 	// 이메일
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	
	public void showInfo() {
		System.out.println("[아이디]" + mid + " [비밀번호]" + mpw + " [이름]" + mname + " [이메일]" + memail);
	}
	
}
