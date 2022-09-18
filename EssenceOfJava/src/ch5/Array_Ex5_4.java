package ch5;

import java.util.Arrays;

public class Array_Ex5_4 {

	public static void main(String[] args) {
		
		// 배열의 요소의 순서를 반복해서 바꾼다.(숫자 섞기, 로또번호 생성)
		
		int[] numArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(Arrays.toString(numArr));
		
		for(int i = 1; i < 100; i++) {
			int n = (int)(Math.random() * 10); // 0~9중의 한 값을 임의로 얻는다.(인덱스)
			// numArr[0]과 numArr[n]의 값을 서로 바꾼다.
			int tmp = numArr[0];
			numArr[0] = numArr[n];
			numArr[n] = tmp;
		}
		
		System.out.println(Arrays.toString(numArr));
	}
}
