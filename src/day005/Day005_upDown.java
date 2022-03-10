package day005;

import java.util.Scanner;

public class Day005_upDown {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("1~50 Up & Down");
		int answer = (int) (Math.random() * 50) + 1;
		int count = 0;
		while(true) {
			System.out.print("숫자를 입력해주세요 >> ");
			int inputNum = scan.nextInt();
			count++; // 입력 시도 횟수 +1
			
			// answer, inputNum 비교 판별
			if (answer == inputNum) {
				System.out.println("정답입니다!");
				System.out.println("당신은 " + count + "번의 시도를 했습니다.");
				break;
			} else if (answer < inputNum) {
				System.out.println(inputNum + "보다 작은 숫자입니다.");
			} else {
				System.out.println(inputNum + "보다 큰 숫자입니다.");
			}
		}
		
		
		
		
	}

}
