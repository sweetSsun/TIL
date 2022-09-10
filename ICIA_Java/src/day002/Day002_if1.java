package day002;

public class Day002_if1 {

	public static void main(String[] args) {

		// 제어문 - 조건문, 반복문
		// 조건문 : if문, switch-case문
		// 반복문 : for문, while문
		
//		if(조건식) {
//			조건식이 true면 실행되는 부분
//		} else {
//			조건식이 false면 실행되는 부분
//		}
		
		int money = 3000;
		int menu1 = 2000;
		int menu2 = 8000;
		
		if (money >= menu2) {
			System.out.println("조건식이 true일 경우 실행");
			System.out.println("menu2을 사먹는다");
		} else {
			System.out.println("조건식이 false일 경우 실행");
			System.out.println("강제 다이어트");
		}
		
		boolean condition = 4000 <= 5000;
		if (condition) {
			System.out.println("boolean값을 입력한 if문 실행");
		}
	}

}
