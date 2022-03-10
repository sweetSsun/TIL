package day007;

public class Day007_ArrayMax {

	public static void main(String[] args) {

		int[] scores = { 10, 30, 40, 5, 15 };
		
		for (int i = 0; i < scores.length; i++) {
			System.out.println(scores[i]);
		}
		
		int max = 0; // 최대값을 저장할 변수
		int min = 100; // 최소값을 저장할 변수
		
		for (int i = 0; i < scores.length; i++) {
			if (max < scores[i]) {
				max = scores[i];
			}
			if (min > scores[i]) {
				min = scores[i];
			}
		}
		
		System.out.println("최대값은 " + max + "입니다.");
		System.out.println("최소값은 " + min + "입니다.");
		
	}

}
