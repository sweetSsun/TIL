package day010;

public class Calculator {

	// 메뉴출력 기능 메소드
	public void showMenu() {
		System.out.println("=============================================");
		System.out.println("1.덧셈 | 2.뺄셈 | 3.곱셈 | 4.나눗셈 | 5.총합 | 6.평균");
		System.out.println("=============================================");
		System.out.print("메뉴선택 >> ");
	}
	
	// 연산 기능 메소드
	// 덧셈기능 메소드
	public int plus(int num1, int num2) {
		return num1+num2;
	}
	// 뺄셈기능 메소드
	public int minus(int num1, int num2) {
		return num1-num2;
	}
	// 곱셈기능 메소드
	public int multiple(int num1, int num2) {
		return num1*num2;
	}
	// 나눗셈기능 메소드
	public int divide(int num1, int num2) {
		return num1/num2;
	}
	
	// int타입 배열의 총합을 구하는 메소드
	public int sum_arr(int[] scores) {
		int sum = 0;
		for (int i = 0; i < scores.length; i++) {
			sum = sum + scores[i];
		}
		return sum;
	}
	
	// int타입 배열의 평균을 구하는 메소드
	public int avg_arr(int[] scores) {
		int sum = sum_arr(scores);
		return sum/scores.length;
	}
	
	


}
