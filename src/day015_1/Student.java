package day015_1;

public class Student extends People {
	
	int strNum;		// 학번
	String major;	// 전공
	
	
	public Student(String name, String address, int age, int strNum, String major) {
//		super(); 
//		this.name = name;
//		this.address = address;
//		this.age = age;
//		this.strNum = strNum;
//		this.major = major;
		
//		super(name, address, age);
//		this.strNum = strNum;
//		this.major = major;

		super(name, address); // 부모클래스 생성자 상속
		this.age = age;
		this.strNum = strNum;
		this.major = major;
	}
	
	public Student() {
		super();
	}
	

}
