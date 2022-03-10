package day002;

public class Day002_Operator1 {
	
	public static void main(String[] args) {

		// 연산자 ( +, -, *, /, % )
		int num1 = 10;
		int num2 = 3;

		System.out.println("+ 연산자");
		int result1 = num1 + num2;
		System.out.println(result1);
		System.out.println("num1 + num2 = " + result1);
		System.out.println(num1 + " + " + num2 +
				" = " + result1);
		System.out.println(result1 + 10);

		System.out.println("- 연산자");
		int result2 = num1 - num2;
		System.out.println(result2);

		System.out.println("* 연산자");
		int result3 = num1 * num2;
		System.out.println(result3);

		System.out.println("/ 연산자");
		int result4 = num1 / num2;
		System.out.println(result4);

		System.out.println("/ 연산자를 실수형으로 형 변환");
		double result5 = (double) num1 / num2;
		System.out.println(result5);
//		System.out.println((double)num1 / num2);

		System.out.println("% 연산자");
		int result6 = num1 % num2;
		System.out.println(result6);

		// 숫자, 문자열 결합
		String str1 = "ABC";
		String str2 = "chocolate";
		System.out.println(str1 + str2);
		System.out.println(num1 + str1);
		System.out.println(num1 + num2 + str1);
		System.out.println(num1 + str1 + num2);

		String str3 = num1 + ""; // 숫자형을 문자형으로 cast
		int num3 = Integer.parseInt(str3); // 문자형을 숫자형으로 cast

	}

}
