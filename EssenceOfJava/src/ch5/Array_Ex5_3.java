package ch5;

public class Array_Ex5_3 {

	public static void main(String[] args) {
		
		// 배열의 요소 중에서 제일 큰 값과 제일 작은 값을 찾는다.
		
		int[] score = {79, 88, 91, 33, 100, 55, 96};
		
		int max = score[0]; // 배열의 첫번째 값으로 최대값 초기화
		int min = score[0]; // 배열의 첫번째 값으로 최소값 초기화
		
		for(int i = 1; i < score.length; i++) {
			if(score[i] > max) {
				max = score[i];
			} else if(score[i] < min) {
				min = score[i];
			}
		}
		
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
	}
}
