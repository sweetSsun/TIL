package day004;

public class Day004_for02 {

	public static void main(String[] args) {

		/* ===문제===
		 * 1~10까지의 숫자를 출력
		 * 짝수만 출력 > 나누었을 떄 몫이 0인 것
		 */
		System.out.println("===for===");
		for (int i=1; i<11; i++) {
			if ( i % 2 == 0) {
				System.out.println("i = " + i);
			}
		}
		
		System.out.println("===i가 4일 때 break===");
		for (int i=1; i<11; i++) {
			System.out.println(i);
			if (i==4) {
				break;
			}
		}

		System.out.println("===i가 4일 때 continue===");
		for (int i=1; i<11; i++) {
			if (i==4) {
				continue;
			}
			System.out.println(i);
		}
		
		// 1~10까지의 숫자를 3의 배수를 제외하고 출력
		System.out.println("===continue 사용===");
		for (int i=1; i<11; i++) {
			if (i % 3 == 0) {
				continue;
			}
			System.out.println(i);
		}
		
		System.out.println("===if문만 사용===");
		for (int i=1; i<11; i++) {
			if (i % 3 != 0) {
			System.out.println(i);
			}
		}
		
	}

}
