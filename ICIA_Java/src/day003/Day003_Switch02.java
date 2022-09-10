package day003;

import java.util.Scanner;

public class Day003_Switch02 {

	public static void main(String[] args) {

		// if문과 switch문에서의 String 변수 비교
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름 입력 >>");
		String str1 = scan.next();
		
		System.out.println(str1);
		if (str1.equals("김지선")) {
			System.out.println("if-true");
		} else {
			System.out.println("if-false");
		}
		
		
		switch(str1) {
		case "김지선":
			System.out.println("switch-true");
			break;
		default:
			System.out.println("switch-false");
		}
	}


}
