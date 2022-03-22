package day015_2;

public class People2 {
	
	private String name;	// 이름
	private String address;	// 주소
	private int age;		// 나이
	private String tel;		// 전화번호
	
	public People2(String name, String address, int age, String tel) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
		this.tel = tel;
	}

	public People2() {
		
	}
	
	void showInfo() {
		System.out.println("이름 : " + name );
		System.out.println("주소 : " + address );
		System.out.println("나이 : " + age );
		System.out.println("전화번호 : " + tel );
	}
}
