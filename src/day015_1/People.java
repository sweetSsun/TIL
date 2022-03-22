package day015_1;

public class People {
	
	String name; 	// 이름
	String address; // 주소
	int age;		// 나이
	
	public People(String name, String address, int age) {
		this.name = name;
		this.address = address;
		this.age = age;
	}

	public People(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public People() {
	
	}
}
