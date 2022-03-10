package day002;

import java.util.Scanner;

public class Day002_Scanner {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int menu1 = 5000;
		System.out.println("현재 소지한 금액을 입력하시오");
		int num = scan.nextInt();
		
//		System.out.println(num);
		if (num >= menu1) {
			System.out.println("menu1을 사먹는다");
		} else {
			System.out.println("강제 다이어트");
		}
	}

}
