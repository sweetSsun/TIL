package day005;

import java.util.Scanner;

public class Day005_while04 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int count = 0;
		int sum = 0;
		
		while(true) {
			System.out.print("숫자 입력(종료:0) >> ");
			int inputNum = scan.nextInt();
			if (inputNum == 0) {
				break;
			} else {
				sum = sum + inputNum;
				count++;
			}
		}
		System.out.println("입력한 숫자는 " + count + "개 입니다.");
		System.out.println("입력한 숫자들의 총합은 " + sum + "입니다.");
		
		
	}

}
