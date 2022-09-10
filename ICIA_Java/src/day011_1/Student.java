package day011_1;

public class Student {

	// 필드 선언
	// 이름, 나이, 전화번호
	// 접근제한자 private으로
	
	private String name;
	private int age;
	private String tel;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		int length = name.length();
		if(length > 5) {
			System.out.println("이름이 5글자 이상입니다.");
		} else {
			this.name = name;
		}
	}
	
	// age
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age>0) {
			this.age = age;
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	// tel
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
