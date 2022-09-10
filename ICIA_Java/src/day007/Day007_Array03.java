package day007;

import java.util.Scanner;

public class Day007_Array03 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		// 크기가 5인 int 타입의 배열을 선언
		// 배열의 [0]~[4] 숫자를 저장
		// 사용자에게 입력을 받아서 사용
		
//		int[] arr = new int[5];
//		for(int i = 0; i<arr.length; i++) {
//			System.out.print("[" + i + "]에 저장할 숫자 입력 >> ");
//			arr[i] = scan.nextInt();
//		}
//		for(int i=0; i<arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}
		
	
		System.out.print("배열의 크기를 입력 >> ");
		int size = scan.nextInt();
		int[] arr2 = new int[size];
		System.out.println(arr2.length);
		
		for(int j = 0; j<arr2.length; j++) {
			System.out.print("[" + j + "]에 저장할 숫자 입력 >> ");
			arr2[j] = scan.nextInt();
		}
		
		
	}

}
