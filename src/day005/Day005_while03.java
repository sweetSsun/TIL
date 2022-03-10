package day005;

import java.util.Scanner;

public class Day005_while03 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
			System.out.print("숫자 입력(종료:0) >> ");
			int inputNum = scan.nextInt();
			System.out.println("입력한 숫자 : " + inputNum);
			if (inputNum == 0) {
				run = false;
				// break를 쓴다면 즉시 중지되기 때문에 짝홀수 판별과 break의 if문을 나누어야
			} else if (inputNum % 2 == 0 ) {
				System.out.println("짝수입니다.");
			} else {
				System.out.println("홀수입니다.");
			} 
		}
		System.out.println("종료");
		
		
	}

}
