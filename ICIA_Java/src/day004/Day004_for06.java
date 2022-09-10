package day004;

import java.util.Scanner;

public class Day004_for06 {

	public static void main(String[] args) {

		/*
		 * ===문제===
		 * 시작할 숫자, 마지막 숫자를 사용자로부터 입력받고
		 * 그 범위의 숫자들 중 짝수들의 합과 홀수들의 합을 각각 출력
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("시작할 숫자를 입력 >> ");
		int firstNum = sc.nextInt();
		System.out.print("마지막 숫자를 입력 >> ");
		int lastNum = sc.nextInt();
		
		int evenSum = 0;
		int oddSum = 0;
		for (int i = firstNum; i<=lastNum; i++) {
			if (i % 2 == 0) {
				evenSum = evenSum + i;
			} else {
				oddSum = oddSum + i;
			}
		}
		System.out.println("짝수들의 합 : "+evenSum);
		System.out.println("홀수들의 합 : "+oddSum);
		
		
	}

}
