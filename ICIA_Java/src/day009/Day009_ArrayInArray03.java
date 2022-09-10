package day009;

public class Day009_ArrayInArray03 {

	public static void main(String[] args) {

		int[][] array1 = new int[2][3];
		System.out.println("array1.length : " + array1.length);
		System.out.println("array1[0].length : " + array1[0].length);
	
		// 행만 선언하고 열은 선언하지 않은 배열
		int[][] array2 = new int[3][];
		// [0]행
		// [1]행
		// [2]행
		System.out.println("array2.length : " + array2.length);
//		System.out.println("array2[0].length : " + array2[0].length);
		
		array2[0] = new int[3]; // [0]행 >> |   |   |   |
		array2[1] = new int[5]; // [1]행 >> |   |   |   |   |   |
		array2[2] = new int[4]; // [2]행 >> |   |   |   |   |

		
		
	}

}
