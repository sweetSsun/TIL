package day003;

public class Day003_Value {

	public static void main(String[] args) {
		/*
		 * 변수
		 * 1. 변수는 중괄호 {} 블럭 내에서 선언되고 사용
		 * 2. 변수는 자신이 선언된 위치에서 자신이 속한 블럭 내부에서만 사용
		 */

		int num1 = 5;
		
		if(num1 > 3) {
			System.out.println("if-num1 = " + num1);
			int num2 = 100;
			System.out.println("if-num2 = " + num2);
			num1 = num1 + num2;
		}
		System.out.println("num1 = " + num1);
//		System.out.println("num2 = " + num2);
	}

}
