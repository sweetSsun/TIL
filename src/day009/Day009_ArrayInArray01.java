package day009;

public class Day009_ArrayInArray01 {

	public static void main(String[] args) {

		int[] arr= new int[3];
		// |  |  |  |
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		// arr의 크기, 길이 length
		System.out.println(arr.length);
		
		// 2차원 배열 선언
		int[][] array1 = new int[2][3];
		//  [0]  [1]  [2]번 열
		// |    |    |    |  >> [0]번 행
		// |    |    |    |  >> [1]번 행
		array1[0][0] = 10;
		array1[0][1] = 20;
		array1[0][2] = 30;
		array1[1][0] = 40;
		array1[1][1] = 50;
		array1[1][2] = 60;
		// | 10 | 20 | 30 |
		// | 40 | 50 | 60 |
		
		// 2차원 배열의 행의 개수
		System.out.println("array1.length = " + array1.length);
		// 2차원 배열의 [0]행의 길이
		System.out.println("array1[0].length = " + array1[0].length);
		
		//[0]행의 모든 값 출력
		System.out.println("===[0]행===");
		for(int i = 0; i < array1[0].length; i++) {
			System.out.print(array1[0][i] + " ");
		}
		// [1]행의 모든 값 출력
		System.out.println("\n===[1]행===");
		for(int i = 0; i < array1[1].length; i++) {
			System.out.print(array1[1][i] + " ");
		}
		
		// array1의 모든 값 출력
		System.out.println("\n===배열의 모든 값===");
		for(int i = 0; i < array1.length; i++) { // 행 반복
			for(int j = 0; j < array1[i].length; j++) { // 열 반복
				System.out.print(array1[i][j] + " ");
			}
		}
		
	}

}
