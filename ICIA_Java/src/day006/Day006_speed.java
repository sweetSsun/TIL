package day006;

import java.util.Scanner;

public class Day006_speed {

	public static void main(String[] args) {

		/*
		 * speed 변수의 초기 값은 0
		 * [1] 증가 :: speed 변수의 값을 1만큼 증가
		 * [2] 감소 :: speed 변수의 값을 1만큼 감소
		 * [3] 종료 :: 즉시 프로그램 종료
		 * 
		 * [1] ~ [3] 이외의 메뉴 선택일 경우 :: '없는 메뉴입니다.' 출력
		 * 
		 * speed 변수 값이 +5, -5가 되면 종료
		 */
		
		Scanner scan = new Scanner(System.in);
		int speed = 0;
		boolean run = true;
		
		while(run) {
			System.out.println("====================");
			System.out.println("1.증가 | 2.감소 | 3.종료");
			System.out.println("====================");
			System.out.print("메뉴선택 >> ");
			int menuSel = scan.nextInt();
//			===if문으로 구성===
//			if(menuSel == 1) {
//				speed++;
//			} else if(menuSel == 2){
//				speed--;
//			} else if(menuSel == 3) {
//				break;
//			} else {
//				System.out.println("없는 메뉴입니다.");
//			}
			
//			===switch문으로 구성===
			switch (menuSel) {
			case 1:
				speed++;
				System.out.println("현재 속도는 " + speed + "입니다.\n");
			 	break;
			case 2:
				speed--;
				System.out.println("현재 속도는 " + speed + "입니다.\n");
				break;
			case 3:
				System.out.println("프로그램 종료");
				run = false;
				break;
			default:
				System.out.println("없는 메뉴입니다.");
			}			 
			 
			
			if(speed>=5 || speed<=-5) {
				System.out.println("속도가 " + speed + "이므로 프로그램이 종료됩니다.");
				run = false;
			}
		}
		
	}

}
