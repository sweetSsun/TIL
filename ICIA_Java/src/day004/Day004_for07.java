package day004;

import java.util.Scanner;

public class Day004_for07 {

	public static void main(String[] args) {

		// 범위 안에서 원하는 숫자의 갯수 세기
		
		Scanner scan = new Scanner(System.in);
		System.out.print("시작 숫자 >> ");
		int startNum = scan.nextInt();
		System.out.print("마지막 숫자 >> ");
		int lastNum = scan.nextInt();
//		
//		int count = 0;
//		for (int i = startNum; i<=lastNum; i++) {
//			System.out.print(i+" ");
//			if(i % 3 == 0) {
//				count++;
//			}
//		}
//		System.out.println("\n3의 배수는 총 " + count + "개입니다.");

		
		/* 시작할 숫자와 마지막 숫자를 사용자로부터 입력받고
		 * 그 범위의 숫자들 중 짝수/홀수들의 합을 각각 출력
		 * 짝수/홀수의 개수를 각각 출력
		 */
		int evenSum = 0;
		int oddSum = 0;
		int evenCount = 0;
		int oddCount = 0;
		for(int i = startNum; i<=lastNum; i++) {
			if (i % 2 == 0) {
				evenSum = evenSum + i;
				evenCount++;
			} else {
				oddSum = oddSum + i;
				oddCount++;
			}
		}
		System.out.println("짝수의 합은 " + evenSum + "입니다.");
		System.out.println("홀수의 합은 " + oddSum + "입니다.");
		System.out.println("짝수의 총 개수는 " + evenCount + "입니다.");
		System.out.println("홀수의 총 개수는 " + oddCount + "입니다.");
		

		
		
	}

}
