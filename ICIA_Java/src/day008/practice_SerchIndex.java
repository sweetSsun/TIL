package day008;

import java.util.Scanner;

public class practice_SerchIndex {

	public static void main(String[] args) {
		
		/*
		 * 1. 1. 1~10 의 숫자들이 저장되어 있는 배열
		 * 2. 사용자는 숫자를 입력
		 * 3. 사용자가 입력한 숫자가 배열에 있으면 그 숫자를 0으로 변경
		 * 4. 2~3번의 과정을 반복 수행
		 * 5. 배열의 모든 숫자가 0이 되면 반복 종료
		 */
		
		Scanner scan = new Scanner(System.in);
		
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		boolean run = true;
		
		while(run) {
			boolean check = true;
			
			for(int i=0; i<arr.length; i++) {
				System.out.print(arr[i] + " ");
				if (arr[i]>0) {
					check = false;
				}
			}
			
			if(check) {
				System.out.println("\n모든 배열이 0이 되어 종료");
				run = false;
				continue;
			}
			
			System.out.print("\n숫자 입력 >> ");
			int num = scan.nextInt();
			
			for(int i=0; i<arr.length; i++) {
				if(num == arr[i]) {
					arr[i] = 0;
				}
			}
			
			
		}
		
		
	}

}
