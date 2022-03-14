package day009_Class;

public class Day009 {
	
	// 1. 필드 field
	// >> 데이터를 저장하는 공간
	int num;
	public int num2;
	
	// 2. 생성자 constructor 
	// >> 객체를 만들 때 따라야 하는 규칙
	// >> 생성자의 이름은 class명과 동일하게
	public Day009() {
		
	}
	
	// 3. 메소드 method
	// >> 특정한 기능을 정의하는 블럭
	// >> 메소드가 호출되면 블럭에 정의된 기능을 수행
	public void printOne() {
		System.out.println("printOne() 호출");
		System.out.println("1");
	}
	public void plus(int number1, int number2) {
		System.out.println("number1 : " + number1);
		System.out.println("number2 : " + number2);
		System.out.println(number1 + number2);
	}
	public void plus2(String str1, String str2) {
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
	}
	public void plus3(String str1, int number1) {
		System.out.println("str1 : " + str1);
		System.out.println("number1 : " + number1);
	}
	public int sub(int num1, int num2) {
		int result = num1 - num2;
		return result;
	}
	
	// 객체 object
	
	
	// Scanner라는 class 정보를 가지고 있는 scan이라는 객체를 만듦.
	// Scanner class의 Scanner라는 생성자를 이용
}
