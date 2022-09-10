package day009;

public class Day009_ArrayInArray04 {

	public static void main(String[] args) {

		int[][] scores = {
				{ 88, 78, 98 },
				{ 70, 80, 90 },
				{ 67, 88, 94 },
				{ 87, 74, 85 }
				};
		
		// 각 행의 모든 값의 총합, 평균값 출력
		// scores 배열의 모든 값의 총합, 평균값 출력
		
		
		int totalSum = 0; // 배열의 총 데이터값을 더하기 위한 변수 
		int count = 0; // 배열의 총 데이터 갯수을 구하기 위한 변수
		for(int i = 0; i<scores.length; i++) {
			int rowSum = 0; // 각 행의 데이터값을 더하기 위한 변수
			for(int j = 0; j<scores[i].length; j++) {
				rowSum = rowSum + scores[i][j];
				count++;
			}
			totalSum = totalSum + rowSum;
			System.out.println(i + "행의 총합 : " + rowSum);
			System.out.println(i + "행의 평균 : " + rowSum/scores[i].length);
		}
		System.out.println("scores 배열의 총합은 " + totalSum + "입니다.");
		System.out.println("scores 배열의 총합은 " + totalSum/count + "입니다.");
	}

}
