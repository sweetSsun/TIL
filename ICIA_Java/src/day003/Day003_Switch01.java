package day003;

import java.util.Scanner;

public class Day003_Switch01 {

	public static void main(String[] args) {

		// switch - case
		
//		switch (조건변수) {
//		
//		case 변수값1:
//			조건변수에 저장된 값이 변수값1일 경우에 실행
//			break;
//		case 변수값2:
//			조건변수에 저장된 값이 변수값2일 경우에 실행
//			break;
//		
//		default:
//			어떤 조건도 맞지 않은 경우에 실행
//		}
		
		int num = 2;
		switch (num) {
		
		case 1:
			System.out.println("1입니다.");
			break;
		case 2:
			System.out.println("2입니다");
			break;
		case 10:
			System.out.println("10입니다");
			break;
		default:
			System.out.println("case에 없습니다.");
		}
		
		// switch-case문으로 메뉴선택 구성 
		Scanner scan = new Scanner(System.in);

		System.out.println("==================================");
		System.out.println("1. 바닐라라떼 | 2. 카페라떼 | 3. 아메리카노");
		System.out.println("==================================");
		System.out.print("원하는 메뉴 번호 선택 >> ");
		int menuSel = scan.nextInt();
		
		switch (menuSel) {
		case 1:
			System.out.println("바닐라라떼를 선택하셨습니다.");
			break;
		case 2:
			System.out.println("카페라떼를 선택하셨습니다.");
			break;
		case 3:
			System.out.println("아메리카노를 선택하셨습니다.");
			break;
		default:
			System.out.println("없는 메뉴입니다.");
		}
	}

}
