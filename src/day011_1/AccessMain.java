package day011_1;

public class AccessMain {

	public static void main(String[] args) {

		Access access = new Access();
		
		// publicVal1 필드값을 출력
		System.out.println(access.publicVal1);
		
		// privateVal1 필드값을 출력
//		System.out.println(access.privateVal1);
		
		// protectedVal1 필드에 값을 저장
		access.protectedVal1 = "protected";
		
		// defaultVal1 필드에 값을 저장
		access.defaultVal1 = "default";
		
		// 각 접근제한자가 사용된 method 호출
		access.publicMethod1();
//		access.privateMethod1();
		access.protectedMethod1();
		access.defaultMethod1();
		
		
	}

}
