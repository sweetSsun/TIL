package day014;

public class Day014_tryCatch1 {

	public static void main(String[] args) {

		int[] numbers = new int[3];
		
		try {
			
			System.out.println("numbers[0] 실행");
			numbers[0] = 10;
			System.out.println("numbers[1] 실행");
			numbers[1] = 20;
			System.out.println("numbers[2] 실행");
			numbers[2] = 30;
			System.out.println("numbers[3] 실행");
			numbers[3] = 40;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println(numbers[0]);
		System.out.println(numbers[1]);
		
		
	}

}
