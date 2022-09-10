package day010;

import java.util.Scanner;

public class CalculatorMain {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Calculator calc = new Calculator();
		
		// 계산 기능 메뉴 출력
		// 1.덧셈 2.뺄셈 3.곱셈 4.나눗셈

		// 메뉴출력 기능 메소드 호출
		calc.showMenu();
		int menuSel = scan.nextInt();

		
		
		int num1;
		int num2;
		int result = 0;
		int[] scores = { 70, 80, 90, 100 };
	
		switch(menuSel) {
		case 1:
			System.out.print("첫번째 숫자 입력 >> ");
			num1 = scan.nextInt();
			System.out.print("두번째 숫자 입력 >> ");
			num2 = scan.nextInt();
			result = calc.plus(num1, num2);
			break;
		case 2:
			System.out.print("첫번째 숫자 입력 >> ");
			num1 = scan.nextInt();
			System.out.print("두번째 숫자 입력 >> ");
			num2 = scan.nextInt();
			result = calc.minus(num1, num2);
			break;
		case 3:
			System.out.print("첫번째 숫자 입력 >> ");
			num1 = scan.nextInt();
			System.out.print("두번째 숫자 입력 >> ");
			num2 = scan.nextInt();
			result = calc.multiple(num1, num2);
			break;
		case 4:
			System.out.print("첫번째 숫자 입력 >> ");
			num1 = scan.nextInt();
			System.out.print("두번째 숫자 입력 >> ");
			num2 = scan.nextInt();
			result = calc.divide(num1, num2);
			break;
		case 5:
			result = calc.sum_arr(scores);
			break;
		case 6:
			result = calc.avg_arr(scores);
			break;
		}

		System.out.println("결과는 " + result );
		
		
	}

}
