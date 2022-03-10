package day003;

import java.util.Scanner;

public class Day003_Switch03 {

	public static void main(String[] args) {
		/*
		 * ===문제===
		 * 현재 몇월인지 사용자에게 입력받는다.
		 * 3~5월일 경우 '봄입니다.' 출력
		 * 6~8월일 경우 여름입니다.' 출력
		 * 9~11월일 경우 '가을입니다.' 출력
		 * 12~2월일 경우 '겨울입니다.' 출력
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("현재 몇 월입니까?");
		int month = sc.nextInt();
		
		System.out.println("===if===");
//		if (month >= 3 && month <= 5) {
//			System.out.println("봄입니다.");
//		} else if (month >= 6 && month <= 8) {
//			System.out.println("여름입니다.");
//		} else if (month >= 9 && month <= 11) {
//			System.out.println("가을입니다.");
//		} else if (month == 12 || month == 1 || month == 2) {
//			System.out.println("겨울입니다.");
//		} else {
//			System.out.println("잘못 입력하였습니다.");
//		}
		if (month >=1 && month <=12) {
			if (month >= 3 && month <= 5) {
				System.out.println("봄입니다.");
			} else if (month >= 6 && month <= 8) {
				System.out.println("여름입니다.");
			} else if (month >= 9 && month <= 11) {
				System.out.println("가을입니다.");
			} else {
				System.out.println("겨울입니다.");
			} 
		} else {
				System.out.println("잘못 입력하였습니다.");
		}
		
		
		System.out.println("===switch===");
		switch(month) {
		case 3:
//			System.out.println("봄입니다.");
//			break;
		case 4:
//			System.out.println("봄입니다.");
//			break;
		case 5:
			System.out.println("봄입니다.");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("여름입니다.");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("가을입니다.");
			break;
		case 12:
		case 1:
		case 2:
			System.out.println("겨울입니다.");
			break;
		default:
			System.out.println("잘못 입력하였습니다.");
		}
	}

}
