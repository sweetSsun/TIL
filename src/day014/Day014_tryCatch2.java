package day014;

public class Day014_tryCatch2 {

	public static void main(String[] args) {

		// try - catch
		
		int[] numbers = new int[3];
		numbers[0] = 10;
		numbers[1] = 20;
		numbers[2] = 30;

		System.out.println("모든 값 출력");
		try {
			for ( int i = 0; i <= numbers.length; i++ ) {
				System.out.println("numbers[" + i + "] = " + numbers[i]);
			}
			
			String str1 = "1234hh";
			int num = Integer.parseInt(str1);
			System.out.println(num);
					
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 범위 예외!!!");
			e.printStackTrace();			
		} catch (NumberFormatException e) {
			System.out.println("숫자 형태 예외!!!");
		}
		System.out.println("배열의 평균");
		
		System.out.println("===finally===");
		try {
			int num = 5/0;
			System.out.println(num);
		} catch (ArithmeticException e) {
			e.printStackTrace();
		} finally {
			System.out.println("finally");
			System.out.println("무조건 실행!!");
		}
		
		System.out.println("try-catch-finally 끝");
		
		
		int number = 10;
		String str1 = number + "";
		
		
		
	}

}
