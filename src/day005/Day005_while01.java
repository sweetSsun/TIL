package day005;

public class Day005_while01 {

	public static void main(String[] args) {

		/*
		 * while (반복조건) {
		 * 조건이 true일 경우 실행되는 부분
		 * }
		 */

		// 1~5까지 출력
		System.out.println("==일반적인 반복조건==");
		int i = 1;
		while (i <= 5) {
			System.out.print(i + " ");
			i++;
		}
		
		System.out.println("\n==break를 넣은 while==");
		int j = 1;
		while (true) {
			System.out.print(j + " ");
			j++;
			if(j>5) {
				break;
			}
		}
		
		System.out.println("\n==boolean값을 변경한 while==");
		int z = 1;
		boolean run = true;
		while (run) {
			System.out.print(z + " ");
			z++;
			if(z>5) {
				run = false;
			}
		}
		
		// 1~10 출력, 1~10까지의 총합
		System.out.println("\n==1~10 출력==");
		int k = 1;
		int sum = 0;
		while ( k < 11) {
			System.out.print(k + " ");
			sum = sum + k;
			k++;
		}
		System.out.println("\n총합은 " + sum);
	}

}
