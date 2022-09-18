package ch5;

import java.util.Arrays;

public class Array_Ex5_5 {

	public static void main(String[] args) {
		
		// index : 0~44
		int[] ball = new int[45];
		
		// 배열의 각 요소에 1~45의 값을 저장
		for(int i = 0; i < ball.length; i++)
			ball[i] = i+1;
		
		int tmp = 0;	// 두 값을 바꾸는데 사용할 임시변
		int j = 0;		// 임의의 값을 얻어서 저장할 변수
		
		// 배열의 i번째 요소와 임의의 요소에 저장된 값을 서로 바꿔서 값을 저장
		// 0번째부터 5번째 요소까지 모두 6개만 바꾼다.
		for(int i = 0; i < 6; i++) {
			j = (int)(Math.random() * 45); // 0~44 범위의 난수
			tmp = ball[i];
			ball[i] = ball[j];
			ball[j] = tmp;
		}
	
		// 배열의 앞에서 6개의 요소만 출력
		for(int i = 0; i < 6; i++) {
			System.out.print(ball[i] + ",");
		}
	}
}
