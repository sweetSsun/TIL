package ch5;

import java.util.Arrays;

public class Array_Ex5_6 {

	public static void main(String[] args) {
		
		//랜덤 메서드를 통해 가위바위보 게임
		
		String[] strArr = {"가위", "바위", "보"};
		System.out.println(Arrays.toString(strArr));
		
		for(int i = 0; i < 10; i++) {
			int tmp = (int)(Math.random()*3); // 0~2
			System.out.println(strArr[tmp]);
		}
		
	}
}
