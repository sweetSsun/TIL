package day015_2;

public class Student2 extends People2 {
	
	private int stuNum;		// 학번
	private String major;	// 전공
	
	public Student2(int stuNum, String major) {
		this.stuNum = stuNum;
		this.major = major;
	}
	
	public Student2(String name, String address, int age, String tel, int stuNum, String major) {
		super(name, address, age, tel);
		this.stuNum = stuNum;
		this.major = major;
	}
	
	public Student2() {
		
	}
	
	@Override
	void showInfo() {
		super.showInfo();
		System.out.println("학번 : " + stuNum);
		System.out.println("전공 : " + major);
	}
	
	
	

	
}
