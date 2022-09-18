package ch5;

public class Array_Ex5_9 {

	public static void main(String[] args) {

		int[][] score = {
				{100, 90, 85},
				{20, 28, 12},
				{30, 20, 65},
				{40, 10, 40},
				{50, 80, 45}
		};
		// 과목별 총점
		int korTotal = 0, engTotal = 0, mathTotal = 0;
		
		System.out.println("번호  국어  영어  수학  총점  평균");
		System.out.println("================================");
		
		for(int i=0; i < score.length; i++) {
			int sum = 0;		// 개인별 총점
			float avg = 0.0f; 	// 개인별 평균
			
			korTotal += score[i][0];
			engTotal += score[i][1];
			mathTotal += score[i][2];
			System.out.printf("%3d", i+1);
			
			for(int j=0; j< score[i].length; j++) {
				sum += score[i][j];
				System.out.printf("%5d", score[i][j]);
			}
			
			avg = sum / (float)score[i].length; // 평균 계산
			System.out.printf("%5d  %1.1f%n", sum, avg);
		}
	
	}

}
