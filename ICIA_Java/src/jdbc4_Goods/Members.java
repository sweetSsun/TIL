package jdbc4_Goods;

public class Members {

	private String mid;		//아이디
	private String mpw;		//비밀번호
	private String mname;	//이름
	private String mbirth;	//생년월일
	private String mgender; //성별
	private String mtel;	//전화번호
	private String maddr;	//주소
	
	private int odcount;	//주문수
	private int totalPrice; //주문총액
	
	
	public int getOdcount() {
		return odcount;
	}
	public void setOdcount(int odcount) {
		this.odcount = odcount;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
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
	public String getMbirth() {
		return mbirth;
	}
	public void setMbirth(String mbirth) {
		this.mbirth = mbirth;
	}
	public String getMgender() {
		return mgender;
	}
	public void setMgender(String mgender) {
		this.mgender = mgender;
	}
	public String getMtel() {
		return mtel;
	}
	public void setMtel(String mtel) {
		this.mtel = mtel;
	}
	public String getMaddr() {
		return maddr;
	}
	public void setMaddr(String maddr) {
		this.maddr = maddr;
	}
	
}
