package day003;

public class Day003_elseif01 {

	public static void main(String[] args) {

//		if (조건식1) {
//			조건식1이 true면 실행되는 부분
//		} else if (조건식2) {
//			조건식1이 false면서 조건식2가 true면 실행되는 부분
//		} else {
//			모든 조건식이 false면 실행되는 부분
//		}

		int money = 5500;
		
		if (money >= 5000) {
			System.out.println("5000원 이상입니다.");
		} else if (money >= 4000) {
			System.out.println("4000원 이상입니다.");
		} else if (money >=3000) {
			System.out.println("3000원 이상입니다.");
		} else {
			System.out.println("3000원 미만입니다.");
		}
		
		
	}

}
