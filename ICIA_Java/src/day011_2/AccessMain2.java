package day011_2;

import day011_1.Access;

public class AccessMain2 {

	public static void main(String[] args) {

		Access access2 = new Access();
		
		// publicVal1 필드값을 출력
		System.out.println(access2.publicVal1);
		
		// privateVal1 필드값을 출력
//		System.out.println(access2.privateVal1);
		
		// protectedVal1 필드에 값을 저장
//		access2.protectedVal1 = "protected";
		
		// defaultVal1 필드에 값을 저장
//		access2.defaultVal1 = "default";
		
		// 각 접근제한자가 사용된 method 호출
		access2.publicMethod1();
//		access2.privateMethod1();
//		access2.protectedMethod1();
//		access2.defaultMethod1();
		
	}

}
