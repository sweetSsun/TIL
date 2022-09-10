package day004;

import java.util.Scanner;

public class Day004_for08 {

	public static void main(String[] args) {
	
		/*
		 * 시작 숫자, 마지막 숫자, 원하는 배수값을 입력받고
		 * 그 범위의 숫자들 중 원하는 배수의 갯수와 총합을 각각 출력
		 */
		
		Scanner scan = new Scanner(System.in);
		System.out.print("시작 숫자 >> ");
		int startNum = scan.nextInt();
		System.out.print("마지막 숫자 >> ");
		int lastNum = scan.nextInt();
		System.out.print("배수 >> ");
		int multi = scan.nextInt();
		
		int count2 = 0;
		int sum2 = 0;
		String resultText="";

//		System.out.println(startNum+"에서 "+lastNum+"까지의 숫자들 중");
//		System.out.print(multi + "의 배수는");
		for(int i = startNum; i<=lastNum; i++) {
			if (i % multi == 0) {
				sum2 = sum2 + i;
				count2++;
				resultText = resultText + i + " ";
//				System.out.print(i + " ");
			}
		}
		System.out.println(startNum + "에서 " + lastNum + "까지의 숫자들 중");
		System.out.println(multi + "의 배수는 " + resultText);
		System.out.println(multi + "의 배수는 " + count2 + "개");
		System.out.println(multi + "의 배수의 총합은 " + sum2 + "입니다.");
		
	}

}
