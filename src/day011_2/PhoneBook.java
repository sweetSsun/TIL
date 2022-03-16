package day011_2;

public class PhoneBook {
	
	// 이름, 전화번호
	private String name;
	private String tel;
	
	// getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return "PhoneBook [name=" + name + ", tel=" + tel + "]";
	}

}
