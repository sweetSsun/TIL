package day007;

import java.util.Scanner;

public class Day007_Array04 {

	public static void main(String[] args) {

		/*
		 * ===문제===
		 * 1. 학생 수를 입력받고,
		 * 2. 입력받은 학생 수 만큼의 시험점수를 저장할 수 있는 배열을 선언
		 * 3. 각각 학생의 점수를 입력하여 배열에 저장
		 * 4. 모든 학생의 점수를 출력
		 */
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("학생 수 입력 >> ");
		int stuNum = scan.nextInt();
		int[] scores = new int[stuNum];
		
		for(int i = 0; i < scores.length; i++) {
			System.out.print((i+1) + "번 학생의 점수 >> ");
			scores[i] = scan.nextInt();
		}
		for(int i = 0; i < scores.length; i++) {
			System.out.println((i+1) + "번 학생 " + scores[i] + "점");
		}
		
		// 점수들의 총합, 평균을 출력
		int scrSum = 0;
		for(int i = 0; i < scores.length; i++) {
			scrSum = scrSum + scores[i];
		}
		int avg = scrSum/scores.length;
		System.out.println("학생들 점수의 총합 : " + scrSum + "점");
		System.out.println("학생들 점수의 평균 : " + avg + "점");
		
		// 학생의 점수가 60점 이상이면 '합격', 60점 미만이면 '불합격'
		// '1번 학생 - 합격'과 같은 형태로 출력
		for(int i=0; i < scores.length; i++) {
			if (scores[i] >= 60) {
				System.out.println((i+1) + "번 학생 - 합격");
			} else {
				System.out.println((i+1) + "번 학생 - 불합격");
			}
		}
		
		// 평균 점수보다 같거나 높은 점수는 몇 명인지 출력
		int count = 0;
		for(int i = 0; i < scores.length; i++) {
			if (scores[i]>=avg) {
				count++;
			}
		}
		System.out.println("평균 점수 이상인 학생은 총 " + count + "명 입니다.");
		
		// 최고 점수, 최저 점수를 출력
		int max = scores[0];
		int min = 100;
		for(int i = 0; i < scores.length; i++) {
			if(max < scores[i]) {
				max = scores[i];
			}
			if(min > scores[i]) {
				min = scores[i];
			}
		}
		System.out.println("최고 점수 : " + max + "점");
		System.out.println("최저 점수 : " + min + "점");
		
		// 최고 점수의 위치를 출력
		int index = -1;
		for (int i = 0; i < scores.length; i++) {
			if (max == scores[i]) {
				index = i;
			}
		}
		System.out.println("최고 점수는 " + (index+1) + "번 학생입니다.");
	}

}
