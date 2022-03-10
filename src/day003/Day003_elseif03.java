package day003;

import java.util.Scanner;

public class Day003_elseif03 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("현재 갖고 있는 돈 >> ");
		int money = scan.nextInt();

		System.out.println("==================================");
		System.out.println("1. 바닐라라떼 | 2. 카페라떼 | 3. 아메리카노");
		System.out.println("==================================");
		System.out.print("원하는 메뉴 번호 선택 >> ");
		int menuSel = scan.nextInt();
		int price; // 메뉴 가격을 저장할 변수
		// 변수의 초기값을 설정하지 않을 경우 else에서도 price값을 초기화해주어야.
		if (menuSel == 1) { // 5000원
			System.out.println("바닐라라떼를 선택하셨습니다.");
			price = 5000;
		} else if (menuSel == 2) { // 4000원
			System.out.println("카페라떼를 선택하셨습니다.");
			price = 4000;
		} else if (menuSel == 3) { // 3000원
			System.out.println("아메리카노를 선택하셨습니다.");
			price = 3000;
		} else {
			System.out.println("없는 메뉴입니다.");
			price = 0;
		}
		
		if(menuSel >= 1 && menuSel <= 3) {
			System.out.println("선택한 메뉴의 가격은 " + price + "원입니다.");
			if (money >= price) {
				System.out.println("결제되었습니다.");
				money = money - price;
			} else {
				System.out.println("잔액이 부족합니다.");
			}
		System.out.println("현재 잔액은 " + money + "원 입니다.");
		}
		
	}

}
