package day004;

import java.util.Scanner;

public class Day004_for03 {

	public static void main(String[] args) {

		// 원하는 숫자를 입력받아 출력		
		Scanner scan = new Scanner(System.in);
		System.out.print("출력하고 싶은 시작 숫자 입력 >> ");
		int startNum = scan.nextInt();
		System.out.print("출력하고 싶은 마지막 숫자 입력 >> ");
		int lastNum = scan.nextInt();
		
		for (int i = startNum; i <= lastNum; i++) {
			System.out.println("i = " + i);
		}
		
		
		
		
	}

}
