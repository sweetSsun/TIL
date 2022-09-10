package day008;

import java.util.Scanner;

public class Day008_ArrayOrder {

	public static void main(String[] args) {

		// 카페 주문 코드를 배열을 이용하여 작성

		Scanner scan = new Scanner(System.in);
		
		int orderConfirm;
		String[] menuList = { "바닐라라떼", "카페라떼", "아이스티", "아메리카노" };
		int[] priceList = { 4500, 3500, 3000, 2500 };
		
		// 주문내역을 저장
		int[] orderList = new int[menuList.length];
		// orderList >> |  |  |  |  |
		
		
		while(true) {
			System.out.println("\n==== 메뉴 ====");
			for(int i = 0; i < menuList.length; i++ ) {
				System.out.print((i+1) + "." + menuList[i] + " ");
			}
			
			System.out.print("\n메뉴선택 >> ");
			int menuSel = scan.nextInt() -1 ;
			// 사용자가 보기엔 1번이 [0]이기 때문에 -1
			
			if(menuSel >= 0 && menuSel < menuList.length) {
				System.out.println("[" + menuList[menuSel] + " 선택]");
				System.out.println("가격은 " + priceList[menuSel] + "원 입니다.");
				System.out.print("주문하시겠습니까? 1.예 2.아니오 >> ");
				// menuSel은 인덱스 번호로 사용하고 있기 때문에 중복사용하면 안됨
				orderConfirm = scan.nextInt();
				if (orderConfirm == 1) {
					System.out.println("주문되었습니다.");
					orderList[menuSel]++;
				} else {
					System.out.println("취소되었습니다.");
				}
			} else {
				System.out.println("없는 메뉴입니다.");
			}
			System.out.print("추가주문하시겠습니까? 1.예 2.아니오 >> ");
			orderConfirm = scan.nextInt();
			if(orderConfirm == 2) {
				System.out.println("주문을 종료합니다.\n");
				break;
			}
		}
		
		int totalPrice = 0; // 총 주문 금액을 저장할 변수
		System.out.print("주문하신 메뉴는 ");
		for(int i = 0; i < menuList.length; i++) {
			if (orderList[i] > 0) { // 주문하지 않은 메뉴의 출력을 방지
				totalPrice = totalPrice + (priceList[i] * orderList[i]);
				System.out.print("[" + menuList[i] + " "+ orderList[i] + "잔]");
			}
		}
		System.out.println("이고,");
		System.out.print("총 주문 금액은 " + totalPrice + "원 입니다.");
		
	}

}
