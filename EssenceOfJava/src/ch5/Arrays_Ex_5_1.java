package ch5;

import java.util.Arrays;

public class Arrays_Ex_5_1 {

	public static void main(String[] args) {
		int[] arr = {0,1,2,3,4};
		int[][] arr2D = {{11,12}, {21,22}};

//		System.out.println(Arrays.toString(arr)); // [0,1,2,3,4] 
//		System.out.println(Arrays.deepToString(arr2D)); // [[11,12], [21,22]] 
		
		String[][] str2D = {{"aaa", "bbb"}, {"AAA", "BBB"}};
		String[][] str2D2 = {{"aaa", "bbb"}, {"AAA", "BBB"}};
		String[][] str2D3 = {{"ccc", "bbb"}, {"AAA", "BBB"}};

//		System.out.println(str2D==str2D2);      			   // false 참조변수값 비교
//		System.out.println(Arrays.equals(str2D, str2D2));      // false 
//		System.out.println(Arrays.deepEquals(str2D, str2D2));  // true
//		System.out.println(Arrays.deepEquals(str2D2, str2D3)); // false
		
		int[] arr2 = Arrays.copyOf(arr, arr.length);  // arr2 = [0,1,2,3,4]
		int[] arr3 = Arrays.copyOf(arr, 3);           // arr2 = [0,1,2]
		int[] arr4 = Arrays.copyOf(arr, 7);           // arr2 = [0,1,2,3,4,0,0]
		int[] arr5 = Arrays.copyOfRange(arr, 2, 4);   // arr2 = [2,3]
		int[] arr6 = Arrays.copyOfRange(arr, 0, 7);   // arr2 = [0,1,2,3,4,0,0]
//		System.out.println(Arrays.toString(arr5));
		
		int[] sortArr = {3,4,1,0,2};
		System.out.println(Arrays.toString(sortArr));
		Arrays.sort(sortArr);
		System.out.println(Arrays.toString(sortArr));
	}

}
