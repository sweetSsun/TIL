package day003;

public class Day003_elseif04 {

	public static void main(String[] args) {

		int money = 4200;
		
		if (money >= 5000) {
//			System.out.println("5000원 이상입니다.");
			if (money >= 5500) {
				System.out.println("5500원 이상입니다.");
			} else {
				System.out.println("5000원 이상 5500원 미만입니다.");
			}
		} else if (money >= 4000) {
//			System.out.println("4000원 이상입니다.");
			if (money >= 4500) {
				System.out.println("4500원 이상입니다.");
			} else {
				System.out.println("4000원 이상 4500원 미만입니다.");
			}
		} else if (money >=3000) {
			System.out.println("3000원 이상입니다.");
		} else {
			System.out.println("3000원 미만입니다.");
		}
		
		
	}

}
