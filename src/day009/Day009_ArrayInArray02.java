package day009;

public class Day009_ArrayInArray02 {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3 };
		
		
		int[][] array1 = { {10, 20, 30}, {40, 50, 60} };
		// | 10 | 20 | 30 |
		// | 40 | 50 | 60 |
	
		int[][] array2 = { {10, 20, 30}, {40, 50, 60, 70} };
		// | 10 | 20 | 30 |		 >> [0]행의 [3]열 자체는 존재하지 않는 것
		// | 40 | 50 | 60 | 70 |
		System.out.println("\n===배열의 모든 값===");
		for(int i = 0; i < array2.length; i++) { // 행 반복
			System.out.print(i + "행 : ");
			for(int j = 0; j < array2[i].length; j++) { // 열 반복
				System.out.print(array2[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}

}
