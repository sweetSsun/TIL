package day010_1;

public class Phone {

	// 1. 필드 field : 데이터를 저장하는 공간
	String model; 	// 모델명
	int price; 		// 가격
	String company; // 제조사명
	
//	Day09 day; 객체도 필드에 선언 가능

	// 2. 생성자 constructor : 객체를 만들 때 따라야하는 규칙.
	// >> 생성자의 이름은 클래스명과 동일하게
	
	// 매개변수가 없는 기본 생성자
	public Phone() {
		
	}
	// 매개변수가 있는 생성자

	public Phone(String model) {
		super();
		this.model = model;
	}
	
	
}
