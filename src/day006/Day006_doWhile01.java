package day006;

public class Day006_doWhile01 {

	public static void main(String[] args) {

//		do {
//			반복실행되는 부분
//		} while(반복조건) 
		
//		while문은 조건을 보고 실행여부 판단
//	    do-while문은 일단 한 번 실행하고나서 조건을 확인하여 반복실행여부 판단

		
		//whilt문
		int num1 = 5;
		System.out.println("while문 시작");
		while(num1 > 10) {
			System.out.println("실행");
		}
		System.out.println("while문 종료");
		
		// do-while문
		System.out.println("do-while문 시작");
		do {
			System.out.println("실행");
		} while(num1 > 10);
		System.out.println("do-while문 종료");
	}

}
