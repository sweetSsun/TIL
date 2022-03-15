package day010_1;

public class PhoneMain2 {

	public static void main(String[] args) {

		Phone ph1 = new Phone(); // 매개변수가 없는 기본 생성자를 호출
		System.out.println("ph1.model : " + ph1.model);
		
		Phone ph2 = new Phone("아이폰"); // 매개변수가 있는 생성자를 호출
		System.out.println("ph2.model : " + ph2.model);
		
		Phone ph3 = new Phone("갤럭시"); 
		System.out.println("ph3.model : " + ph3.model);
		
		
		
		
		
		
	}

}
