package day005;

public class Day005_random {

	public static void main(String[] args) {

		while (true) {
			int randomNum = (int) (Math.random() * 6) + 2;
			System.out.println(randomNum);

			if (randomNum == 7) {
				break;
			}
		}
		/*
		 * Math.random() >> 0.0 ~ 0.9
		 * * 10 >> 0.0 ~ 9.0 (몇 개를 나오도록 할 것인지)
		 * (int) >> 0 ~ 9
		 * +1 >> 1 ~ 10 (숫자 몇 부터 나오게 할 것인지)
		 */

	}

}
