package day007;

public class Day007_ArraySearch {

	public static void main(String[] args) {

		int[] scores = { 10, 30, 40, 5, 15 };
		
		// 5가 저장되어 있는 위치 찾기
		int index = -1; // 원하는 값이 있는 인덱스가 없을 경우 확인하기 위함. 인덱스 번호를 저장할 변수
		int target = 15;
		for (int i = 0; i < scores.length; i++) {
			if(scores[i] == target) {
				index = i;
			}
		}
		
		if (index != -1) {
			System.out.println("숫자 " + target + "는 [" + index + "] 인덱스에 있습니다.");
		} else {
			System.out.println("숫자 " + target + "을 찾을 수 없습니다.");
		}
		
		
		
		
//		for (int i = 0; i < scores.length; i++) {
//			if(scores[i] == 5) {
//				System.out.println("5가 저장되어 있는 곳은 [" + i + "] 입니다.");
//			}
//		}
		
		
		
		
	}

}
