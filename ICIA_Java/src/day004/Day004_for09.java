package day004;

import java.util.Scanner;

public class Day004_for09 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
//		System.out.print("몇 번 반복 >>");
//		int loopCount = scan.nextInt();
//		for(int i = 0; i < loopCount; i++) {
//			System.out.println("하루종일 for문 하는 중");
//		}
		
		System.out.print("학생 수 입력 >> ");
		int stuNum = scan.nextInt();
		
		String resultList = "";
				
		for (int i = 0; i < stuNum; i++) {
			System.out.print((i+1)+"학생의 점수 입력 >> ");
			int score = scan.nextInt();
			resultList = resultList + (i+1) + "번 학생 점수 " + score + "점 ";
			
			if (score >= 60) {
//				System.out.println("합격");
				resultList = resultList + " - 합격\n";
			} else {
//				System.out.println("불합격");
				resultList = resultList + " - 불합격\n";
			}
		}
		System.out.println(resultList);
		
		
	}

}
