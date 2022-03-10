package day005;

import java.util.Scanner;

public class Day005_vendingMachine {

	public static void main(String[] args) {
		/*
		 * ===커피자판기 문제===
		 * 1. 판매하는 커피의 재고는 10개 
		 * 2. 커피 한 잔의 가격은 300원 
		 * 3. 구매자는 자판기에 돈을 넣는다.
		 * 4. 구매자가 넣은 돈에 따라 
		 *    구매자의 돈과 커피의 가격이 같은 경우 '커피를 준다.' 
		 *    구매자의 돈이 커피의 가격보다 많은 경우 '거스름돈 -원', '커피를 준다.'
		 *    구매자의 돈이 커피의 가격보다 적은 경우 돈을 그대로 반환 '구매자의 돈을 돌려주고 커피를 주지 않는다.' 
		 * 5. 커피 재고가 모두 소진되었을 경우 프로그램 종료 '커피 재고가 모두 소진되었습니다.'
		 */
		Scanner scan = new Scanner(System.in);
		int coffeeInven = 10;
		int coffeePrice = 300;

		while (coffeeInven > 0) {
			System.out.print("돈을 넣어주세요 >> ");
			int money = scan.nextInt();
			if (money == coffeePrice) {
				System.out.println("커피를 준다.");
				--coffeeInven;
				System.out.println("커피 재고는 " + coffeeInven + "개 입니다.");
			} else if (money > coffeePrice) {
				System.out.println("커피를 준다.");
				System.out.println("거스름돈은 " + (money - coffeePrice) + "원 입니다.");
				--coffeeInven;
				System.out.println("커피 재고는 " + coffeeInven + "개 입니다.");
			} else {
				System.out.println("커피 가격은 300원입니다.");
				System.out.println(money + "원을 반환합니다.");
				System.out.println("커피 재고는 " + coffeeInven + "개 입니다.");
			}
		}
		System.out.println("커피 재고가 모두 소진되었습니다.");
	}
}

