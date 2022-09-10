package day003;

import java.util.Scanner;

public class Day003_elseif05 {

	public static void main(String[] args) {

		/*
		 * ===문제===
		 * 1. 과목의 점수 : 사용자로부터 입력받아서 사용
		 * 2. 입력받은 점수가 95점 이상이면 'A+' 출력
		 *               90점 이상 95점 미만이면 'A' 출력
		 *               85점 이상 90점 미만이면 'B+' 출력
		 *               80점 이상 85점 미만이면 'B' 출력
		 *               75점 이상 80점 미만이면 'C+' 출력
		 *               70점 이상 75점 미만이면 'C' 출력
		 *               그 이하일 경우 'D' 출력
		 */
		
		Scanner scan = new Scanner(System.in);
		System.out.print("과목 점수를 입력하시오 >> ");
		int score = scan.nextInt();
		
		if (score >= 90) {
			if (score >= 95) {
				System.out.println("A+");
			} else {
				System.out.println("A");
			}
		} else if (score >= 80) {
			if (score >= 85) {
				System.out.println("B+");
			} else {
				System.out.println("B");
			}			
		} else if (score >= 70) {
			if (score >= 75) {
				System.out.println("C+");
			} else {
				System.out.println("C");
			}		
		} else {
			System.out.println("D");
		}
		
	}

}
