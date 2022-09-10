package day006;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		// 사용자로부터 양의 정수를 하나 입력받은 다음, 그 수만큼 3의 배수를 출력
		System.out.println("몇의 배수가 필요하신가요? >> ");
		int mutiple = scan.nextInt();
		System.out.print("몇 개 출력할까요? >> ");
		int selNum = scan.nextInt();
		
		for(int i = 1; i<=selNum; i++) {
			System.out.print((mutiple*i) + " ");
		}
		
		// 사용자로부터 입력 받은 숫자에 해당하는 구구단을 역순으로 출력
		System.out.print("\n보고자 하는 구구단 >> ");
		int table = scan.nextInt();
		int i = 9;
		while(i>0) {
			System.out.println(table + " * " + i + " = " + i*table);
			i--;
		}
	}
}
