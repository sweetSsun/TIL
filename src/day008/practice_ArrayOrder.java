package day008;

import java.util.Scanner;

public class practice_ArrayOrder {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String[] menuList = {"아메리카노", "카페라떼", "바닐라라떼", "자몽에이드"};
		int[] priceList = {2000, 3000, 3500, 4000};
		int[] orderList = new int[menuList.length];
		int totalPrice = 0;
		
		boolean run = true;
		
		while(run) {
			System.out.println("\n=== 메뉴 ===");
			for(int i = 0; i < menuList.length; i++) {
				System.out.print((i+1) + "." + menuList[i] + " ");
				
			}
			System.out.print("\n메뉴 선택 >> ");
			int menuSel = scan.nextInt() - 1;
			
			if(menuSel >= 0 && menuSel < menuList.length) {
				System.out.println("["+menuList[menuSel]+" 선택]");
				System.out.println("가격은 " + priceList[menuSel] + "원입니다.");
				System.out.print("주문하시겠습니까? 1.예 2.아니오 >> ");
				int select = scan.nextInt();
				if (select == 1) {
					System.out.print("수량 >> ");
					select = scan.nextInt();
					
					System.out.println(menuList[menuSel] + " " + select + "잔 주문되었습니다.");
					orderList[menuSel] = orderList[menuSel] + select;
				} else {
					System.out.println("취소되었습니다.");
				}
			} else { 
				System.out.println("없는 메뉴입니다.");
			}
			
			System.out.print("추가주문 하시겠습니까? 1.예 2.아니오 >>");
			int select = scan.nextInt();
			if (select == 2) {
				run = false;
				System.out.println("주믄을 종료합니다.");
			}
			
		}
		
		System.out.print("\n주문하신 메뉴는 ");
		for (int i = 0; i < menuList.length; i++) {
			if(orderList[i] > 0) {
				System.out.print("[" + menuList[i] + " " + orderList[i] + "잔]");
				totalPrice += priceList[i] * orderList[i];
			}
		}
		
		System.out.println("이고,");
		System.out.println("총 주문 금액은 " + totalPrice + "원입니다.");
		
		
		
	}
	
	
}
