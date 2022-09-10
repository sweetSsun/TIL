package day005;

public class Day005_while02 {

	public static void main(String[] args) {

		/*
		 * ===문제===
		 * 1~6까지의 눈을 갖는 주사위가 있다.
		 * 주사위를 던졌을 때 나오는 눈의 값을 출력하고
		 * 주사위의 눈이 5일 때 종료가 되는 프로그램을 작성.
		 * 주사위의 눈이 5가 나올 때 까지 주사위를 몇 번 던졌는지 출력
		 */
		
		System.out.println("==5 나올 때까지 주사위 던지기==");
		int count = 0;
		while (true) {
			int dice = (int)(Math.random() * 6) + 1;
			System.out.println("주사위의 눈은 " + dice + "입니다.");
			count++;
			if (dice == 5) {
				break;
			}
		}
		System.out.println("주사위는 " + count + "번 던졌습니다.");
		
		
		System.out.println("==주사위 2개가 같은 값이 나올 때까지 던지기==");
		while (true) {
			int dice1 = (int)(Math.random() * 6) + 1;
			int dice2 = (int)(Math.random() * 6) + 1;
			System.out.println("주사위를 던집니다.");
			System.out.println("[" + dice1 + "," + dice2 + "]");
			if (dice1 == dice2) {
				System.out.println("같은 값이므로 종료");
				break;
			}
		}
		
		
	}

}
