package day002;

public class Day002_Operator2 {
	public static void main(String[] args) {

		int num1 = 10;
		int num2 = 5;
		int num3 = 10;
		boolean result;
		
		// 비교 연산자
		// <, >, ==, <=, >=, !=
		result = num1 < num2; // 10 < 5
		System.out.println("num1 < num2 = "+result);
		
		result = num1 > num2; // 10 > 5
		System.out.println("num1 > num2 = "+result);
		
		result = num1 == num2; // 10 == 5
		System.out.println("num1 == num2 = "+result);
		
		result = num1 != num2;
		System.out.println("num1 != num2 = "+result);

		result = num1 <= num2; // 10 <= 5
		System.out.println("num1 <= num2 = "+result);
		
		result = num1 >= num2; // 10 >= 5
		System.out.println("num1 >= num2 = "+result);
		
		// 논리 연산자
		// && : and,    || : or
		// &, | 하나씩 쓰는건 비트연산자, 비트 단위로 연산하는 것
		System.out.println(num1 > num2 && num1 == num3);
		System.out.println(num1 < num2 && num1 == num3);
		System.out.println(num1 < num2 || num1 == num3);
		System.out.println("=======================");
		System.out.println(true && true);  // true
		System.out.println(true && false);  // false
		System.out.println(false && true);  // false
		System.out.println(false && false);  // false
		System.out.println("=======================");
		System.out.println(true || true);  // true
		System.out.println(true || false);  // true
		System.out.println(false || true);  // true
		System.out.println(false || false);  // false
		System.out.println("=======================");
		
		// 문자 비교
		System.out.println("Java" == "Java"); // 같은 공간에 저장되었는지 확인
		
		String str1 = "java";
		System.out.println(str1.equals("java")); // 동일한 문자열인지 확인
	}

}
