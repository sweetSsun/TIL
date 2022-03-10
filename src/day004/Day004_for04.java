package day004;

public class Day004_for04 {

	public static void main(String[] args) {

		// 1~10 숫자의 총합을 출력
		int sum = 0;
		/*
		 * sum = sum+1; // sum==1
		 * sum = sum+2; // sum==3
		 * sum = sum+3; // sum==6
		 * ...
		 * sum = sum+10; // sum==55
		 */
		System.out.println("1~10까지의 총합");
		for (int i=1; i<11; i++) {
			sum = sum + i;
		}
		System.out.println("총합은 " + sum + "입니다.");	
		
		// 1~10 숫자의 짝수/홀수들의 총합을 출력
		System.out.println("1~10까지의 숫자들 중 짝수/홀수들의 총합");
		int evensum = 0; // 짝수의 총합을 저장할 변수
		int oddsum = 0; // 홀수의 총합을 저장할 변수
		for (int i=1; i<11; i++) {
			if (i % 2 == 0) {
				evensum = evensum + i;
			} else {
				oddsum = oddsum + i;
			}
		}
		System.out.println("짝수의 총합은 " + evensum + "입니다.");
		System.out.println("홀수의 총합은 " + oddsum + "입니다.");
		System.out.println("홀수의 총합은 " + (sum-evensum) + "입니다.");
		
	}

}
