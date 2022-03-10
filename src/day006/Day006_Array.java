package day006;

public class Day006_Array {

	public static void main(String[] args) {

		// 변수 선언
		// 타입 변수명 = 값;
		int num1 = 20;
		int num2;
		num2 = 10;
		
		// 배열 선언 
		// 타입[] 배열명 = {[0], [1], ......} 
		int[] numArr1 = {10, 20, 30};
//		int numArr1[] = {10, 20, 30}; // 윗줄과 동일한 코드
//		numArr1 배열은 인덱스가 총 3개, 배열의 크기 3
//		[0인덱스] [1인덱스] [2인덱스]
//		  10      20      30
		System.out.println(numArr1[0]);
		
		int[] numArr2 = new int[3]; // int타입의 데이터를 3개 저장
//		numArr2
//		[ ] [ ] [ ]
		numArr2[0] = 10;
		numArr2[1] = 20;
		numArr2[2] = 30;
//		만약 3개의 배열 속에서 2개의 데이터만 저장한다면 나머지 자리는 0으로 차지함
		
		int[] numArr3;
		numArr3 = new int[] {10, 20, 30};
		
		
		
	}

}
