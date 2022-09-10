package day003;

import java.util.Scanner;

public class Day003_elseif02 {

	public static void main(String[] args) {
		/*
		 * 현재 갖고 있는 돈 >> 사용자로부터 입력받아 사용
		 * 메뉴 가격 : 바닐라라떼 5000원, 카페라떼 4000원, 아메리카노 3000원
		 * 돈이 5000원 이상이라면 '바닐라라떼를 마신다.' 출력
		 * 5000원 이상은 아니지만 4000원 이상이면 '카페라떼를 마신다.' 출력
		 * 4000원 이상은 아니지만 3000원 이상이면 '아메리카노를 마신다.' 출력
		 * 갖고있는 돈이 3000원 미만이라면 '아무것도 마시지 않는다.' 출력
		 * 메뉴를 구매 후 남은 현재 잔액을 출력
		 */

		Scanner scan = new Scanner(System.in);
		System.out.print("현재 갖고 있는 돈을 입력하시오.");
		int money = scan.nextInt();
		int vanillalatte = 5000;
		int cafelatte = 4000;
		int americano = 3000;

		if (money >= vanillalatte) {
			System.out.println("바닐라라떼를 마신다.");
			money = money - vanillalatte;
		} else if (money >= cafelatte) {
			System.out.println("카페라떼를 마신다.");
			money = money - cafelatte;
		} else if (money >= americano) {
			System.out.println("아메리카노를 마신다.");
			money = money - americano;
		} else {
			System.out.println("아무것도 마시지 않는다.");
		}
				
		System.out.println("현재 잔액은 "+ money +"원 입니다.");
	}

}
