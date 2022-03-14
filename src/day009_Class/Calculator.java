package day009_Class;

public class Calculator {

	// 메소드(method)
	// 1) 리턴값이 없는 메소드
	public void plus(int number1, int number2) {
		int result = number1 + number2;
		System.out.println("두 수의 합은 : " + result);
	}
	// 2) 리턴값이 있는 메소드
	public int plus2(int number1, int number2) {
		int result = number1 + number2;
		return result;
	}
		
	
	public String sub(int number1, int number2) {
		int result = number1 - number2;
		if (result > 0) {
			return "양수입니다.";
		} else {
			return "음수입니다.";
		}
	}
	
	public void showMenu() {
		System.out.println("===============");
		System.out.println(" 1.덧셈 | 2.뺄셈 ");
		System.out.println("===============");
	}
	
	
	// 오버로딩(동일한 메소드명, 다른 매개변수)
	public int testMethod(int num1) {
		return num1 + 10;
	}
	public int testMethod(String str1) {
		return 10;
	}
	
	
}
