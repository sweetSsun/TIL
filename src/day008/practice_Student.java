package day008;

import java.util.Scanner;

public class practice_Student {

	public static void main(String[] args) {

		// 사용자의 점수 입력값을 배열에 저장하여 원하는 값을 출력
		// 다만 학생수가 먼저 입력되지 않으면 작동하지 않도록 한다.
		
		Scanner scan = new Scanner(System.in);
		
		int[] scores = null;
		
		boolean run = true;
		boolean check = false;
		
		while(run) {
			System.out.println("===메뉴===");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수목록 | 4.점수분석 | 5.종료");
			System.out.print("메뉴선택 >> ");
			int menuSel = scan.nextInt();
			
			switch(menuSel) {
			case 1:
				System.out.print("학생수 입력 >>");
				int stuNum = scan.nextInt();
				scores = new int[stuNum];
				System.out.println("학생수는 " + stuNum + "명 입니다.");
				check = false;
				break;
				
			case 2:
				if(scores == null) {
					System.out.println("[1.학생수]를 입력해주세요.");
				} else {
					for(int i=0; i<scores.length; i++) {
						System.out.print((i+1) + "번 학생의 점수 입력 >>");
						scores[i] = scan.nextInt();
						check = true;
					}
					System.out.println("점수가 입력되었습니다.");
				}
				break;
				
			case 3:
				if(scores == null) {
					System.out.println("[1.학생수]를 입력해주세요.");
				} else {
					if(check) {
						for(int i=0; i<scores.length; i++) {
							System.out.println((i+1) + "번 학생의 점수 " + scores[i] +"점");
						}
					} else {
						System.out.println("[2.점수입력]이 되지 않았습니다.");
					}
						
				}
				break;
				
			case 4:
				if(scores == null) {
					System.out.println("[1.학생수]를 입력해주세요.");
				} else {
					if(check) {
						int max = scores[0];
						int min = scores[0];
						int sum = 0;
						for(int i=0; i<scores.length; i++) {
							if(max < scores[i]) {
								max = scores[i];
							}
							if(min > scores[i]) {
								min = scores[i];
							}
							sum = sum + scores[i];
						}
						System.out.println("최고 점수는 " + max +"점");
						System.out.println("최저 점수는 " + min +"점");
						System.out.println("평균 점수는 " + (sum/scores.length) + "점 입니다.");
					} else {
						System.out.println("[2.점수입력]이 되지 않았습니다.");
					}
				}
				break;
				
			case 5:
				System.out.println("프로그램 종료");
				run = false;
				break;
				
			}
			
		}
		
	}

}
