package day006;

import java.util.Scanner;

public class Day006_order2 {

	public static void main(String[] args) {

		/*
		 * ===메뉴 주문 프로그램===
		 * 1. 메뉴 가격
		 *  [1]바닐라라떼 :: 4500원
		 *  [2]카페라떼 :: 3500원
		 *  [3]아메리카노 :: 2500원
		 * 2. 메뉴를 선택하면 선택한 메뉴의 이름과 가격을 안내
		 * 3. 주문을 할 것인지 확인
		 * 4. 추가로 주문할 것인지 확인
		 *    추가 주문을 한다면 1~3의 과정을 반복		 * 
		 * 5. 추가 주문을 하지 않으면 위 과정으로 주문한 모든 메뉴의 이름과 가격의 총합을 안내
		 */
		
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		int vanillalatte = 4500;
		int cafelatte = 3500;
		int americano = 2500;
		int totalPrice = 0;
		String orderList = "";
		int order;
		
		while(run) {
			System.out.println("\n==================================");
			System.out.println("[1]바닐라라떼 | [2]카페라떼 | [3]아메리카노");
			System.out.println("==================================");
			System.out.print("메뉴선택 >> ");
			int menuSel = scan.nextInt();
			
			if (menuSel==1) {
				System.out.println("[바닐라라떼 선택]");
				System.out.println("가격은 " + vanillalatte + "입니다.");
				System.out.print("주문하시겠습니까? [1]예 [2]아니오 >> ");
				order = scan.nextInt();
				if (order==1) {
					System.out.println("주문되었습니다.");
					totalPrice = totalPrice + vanillalatte;
					orderList = orderList + "[바닐라라떼]";
				} else {
					System.out.println("취소되었습니다.");
				}
			} else if (menuSel==2) {
				System.out.println("[카페라뗴 선택]");
				System.out.println("가격은 " + cafelatte + "입니다.");
				System.out.print("주문하시겠습니까? [1]예 [2]아니오 >> ");
				order = scan.nextInt();
				if (order==1) {
					System.out.println("주문되었습니다.");
					totalPrice = totalPrice + cafelatte;
					orderList = orderList + "[카페라뗴]";
				} else {
					System.out.println("취소되었습니다.");
				}
			} else if (menuSel==3 ) {
				System.out.println("[아메리카노 선택]");
				System.out.println("가격은 " + americano + "입니다.");
				System.out.print("주문하시겠습니까? [1]예 [2]아니오 >> ");
				order = scan.nextInt();
				if (order==1) {
					System.out.println("주문되었습니다.");
					totalPrice = totalPrice + americano;
					orderList = orderList + "[아메리카노]";
				} else {
					System.out.println("취소되었습니다.");
				}
			} else {
				System.out.println("없는 메뉴입니다.");
				continue;
			}
			
			System.out.print("추가 주문 하시겠습니까? [1]예 [2]아니오 >> ");
			order = scan.nextInt();
			if (order == 2) {
				System.out.println("주문을 종료합니다.");
				run = false;
			}
		}
		System.out.println("\n주문하신 메뉴는 " + orderList + "이고,");
		System.out.println("총 주문 금액은 " + totalPrice + "원 입니다.");
		

		
		
		
		
	}

}
