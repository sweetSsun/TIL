package day004;

public class Day004_for01 {

	public static void main(String[] args) {

		// 반복문 - for
//		for (초기화식; 조건식; 증감식) {
//			반복 수행을 할 코드	
//		}
		
		// 1~5까지의 숫자를 화면에 출력
		System.out.println("===for===");
		for(int i=1; i<6; i++) {
			System.out.println(i);
		}
		
		System.out.println("===while===");
		int i=1;
		while(i<6) {
			System.out.println(i);
			i++;
		}
		
		// 3~8까지의 숫자를 출력
		System.out.println("===for 문제===");
		for(int k=3; k<=8; k++) {
			System.out.println(k);
		}
		
		
		
	}

}
