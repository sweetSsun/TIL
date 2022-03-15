package day009_1;

public class CalculatorMain {

	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		
		calc.plus(10, 20);
		int num = calc.plus2(10, 34);
		System.out.println("합 : " + num);
		
		int number1 = 20;
		int number2 = 10;
		
		// number1에서 number2를 뺀 결과를 출력
		// Calculator 클래스에 sub 메소드를 정의
		// sub 메소드는 int타입 매개변수 2개
		// sub 메소드는 매개변수1-매개변수2 결과값이 양수인지 음수인지 판별하여 리턴하는 메소드
		String number3 = calc.sub(number1, number2);
		System.out.println(number3);
		
		calc.showMenu();
	}

}
