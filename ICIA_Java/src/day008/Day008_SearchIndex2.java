package day008;

import java.util.Scanner;

public class Day008_SearchIndex2 {

	public static void main(String[] args) {

		/*
		 * 1. 1. 1~10 의 숫자들이 저장되어 있는 배열
		 * 2. 사용자는 숫자를 입력
		 * 3. 사용자가 입력한 숫자가 배열에 있으면 그 숫자를 0으로 변경
		 * 4. 2~3번의 과정을 반복 수행
		 * 5. 배열의 모든 숫자가 0이 되면 반복 종료
		 */
		
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		int[] numbers = { 4, 8, 1, 3, 2, 7, 5, 10, 6, 9 };
		
		while(run) {
			boolean check = true;
			
			System.out.print("\n[");
			for(int i = 0; i < numbers.length; i++) {
				System.out.print(numbers[i] + " ");
				
				if (numbers[i]>0) {
					check = false;
				}
			}
			System.out.println("]");
			
			if(check) {
				run = false;
				System.out.println("배열이 모두 0이 되어서 종료");
				continue;
			}
				
			System.out.print("숫자입력 >> ");
			int target = scan.nextInt();
			
			for(int i = 0; i<numbers.length; i++) {
				if (target == numbers[i]) {
					numbers[i]=0;
				}	
				
			}
			
			
		}
		
		
	}

}
