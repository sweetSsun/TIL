package day015_1;

public class Student1 extends People1 {
	
	int stuNum;		// 학번
	String major;	// 전공
	
	
	public Student1(String name, String address, int age, int stuNum, String major) {
//		super(); 
//		this.name = name;
//		this.address = address;
//		this.age = age;
//		this.strNum = strNum;
//		this.major = major;
		
//		super(name, address, age);
//		this.stuNum = stuNum;
//		this.major = major;

		super(name, address); // 부모클래스 생성자 상속
		this.age = age;
		this.stuNum = stuNum;
		this.major = major;
	}
	
	public Student1() {
	}

	public Student1(String name, String address, int age, String tel, int stuNum, String major) {
		super(name, address, age, tel);
		this.stuNum = stuNum;
		this.major = major;
	}
	
	void showInfo() {
		System.out.println(name);
		System.out.println(address);
		System.out.println(age);
//		System.out.println(tel);
		System.out.println(stuNum);
		System.out.println(major);
	}
	
	

}
