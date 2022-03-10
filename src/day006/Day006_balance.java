package day006;

import java.util.Scanner;

public class Day006_balance {

	public static void main(String[] args) {

		/*
		 * ===문제===
		 * 1. 잔액은 0으로 시작
		 * 2. [1]입금 :: 고객의 잔액을 증가. 입금할 금액은 사용자에게 입력받는다.
		 *    [2]출금 :: 고객의 잔액을 감소. 출금할 금액은 사용자에게 입력받는다. 
	 	 *              단, 출금할 금액이 잔액보다 큰 경우 출금되지 않고 '잔액이 부족합니다.' 출력
		 *    [3]잔고 :: 고객의 현재 잔액을 출력
		 *    [4]종료 :: 프로그램 종료
		 * 3. 입금, 출금 기능 수행 후에 고객의 잔액이 얼마인지 출력
		 */
		
		Scanner scan = new Scanner(System.in);
		int myBalance = 0;
		boolean run = true;
		
		while(run){
			System.out.println("\n============================");
			System.out.println("1.입금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("============================");
			System.out.print("메뉴선택 >> ");
			int menuSel = scan.nextInt();
			
			if(menuSel==1) {
				System.out.println("[입금]");
				System.out.print("입금액 >> ");
				int deposit = scan.nextInt();
				myBalance = myBalance + deposit;
//				System.out.println("현재 잔액은 " + myBalance + "입니다.");
			} else if(menuSel==2) {
				System.out.println("[출금]");
				System.out.print("출금액 >> ");
				int withdraw = scan.nextInt();
				if (myBalance>=withdraw) {
					myBalance = myBalance - withdraw;				
				} else {
					System.out.println("잔액이 부족합니다.");
				}
//				System.out.println("현재 잔액은 " + myBalance + "입니다.");
			} else if(menuSel==3) {
				System.out.println("[잔고]");
//				System.out.println("현재 잔액은 " + myBalance + "입니다.");
			} else if(menuSel==4) {
				System.out.println("프로그램 종료");
				run = false;
			} else {
				System.out.println("잘못 입력하였습니다.");
			}
			
			if(menuSel>=1 && menuSel<=3) {
				System.out.println("현재 잔액은 " + myBalance + "입니다.");
			}
		}
	}

}

//			switch(menuSel) {
//			case 1:
//				System.out.println("[입금]");
//				System.out.print("입금액 >> ");
//				money = scan.nextInt();
//				balance = balance + money;
//				System.out.println("현재 잔액은 " + balance + "입니다.");
//				break;
//			case 2:
//				System.out.println("[출금]");
//				System.out.print("출금액 >> ");
//				money = scan.nextInt();
//				if (balance>=money) {
//					balance = balance - money;				
//				} else {
//					System.out.println("잔액이 부족합니다.");
//				}
//				System.out.println("현재 잔액은 " + balance + "입니다.");
//				break;
//			case 3:
//				System.out.println("[잔고]");
//				System.out.println("현재 잔액은 " + balance + "입니다.");
//				break;
//			case 4:
//				System.out.println("[종료]");
//				run = false;
//				break;
//			default:
//				System.out.println("잘못 입력하였습니다.");
//				break;
//			}