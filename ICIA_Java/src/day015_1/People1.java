package day015_1;

public class People1 {
	
	String name; 		// 이름
	String address; 	// 주소
	int age;			// 나이
	
	private String tel; // 전화번호
	
	public People1(String name, String address, int age, String tel) {
		this.name = name;
		this.address = address;
		this.age = age;
		this.tel = tel;
	}
	
	public People1(String name, String address, int age) {
		this.name = name;
		this.address = address;
		this.age = age;
	}

	public People1(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public People1() {
	
	}
}
