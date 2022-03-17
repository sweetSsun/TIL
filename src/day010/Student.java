package day010;

public class Student {

	// 필드
	String name;
	int age;
	String tel;
	
	// 기본생성자
	public Student() {
		
	}
	// 이름을 매개변수로 하는 생성자
	public Student(String name) {
		this.name = name;
	}
	// 이름,나이,전화번호를 매개변수로 하는 생성자
	public Student(String name, int age, String phone) {
		this.name = name;
		this.age = age;
		this.tel = phone;
	}
	
	// 모든 필드값을 출력하는 메소드
	public void showInfo() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("전화번호 : " + tel);
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", tel=" + tel + "]";
	}

}
