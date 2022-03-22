package day015;

public class ExtendsMain {

	public static void main(String[] args) {

		Parent pa = new Parent();
		
		pa.parentIntVal1 = 10;
		pa.parentPublicVal2 = 20;
		pa.setParantPrivateVal3(30);
		pa.parenProtectedVal4 = 40;
		
		Child ch = new Child();
		ch.parentIntVal1 = 100;
		ch.parentPublicVal2 = 200;
		ch.setParantPrivateVal3(300);
		ch.parenProtectedVal4 = 400;
		
		System.out.println("===pa===");
		System.out.print(pa.parentIntVal1 + " ");
		System.out.print(pa.parentPublicVal2 + " ");
		System.out.print(pa.getParantPrivateVal3() + " ");
		System.out.print(pa.parenProtectedVal4 + "\n");
		
		System.out.println("===ch===");
		System.out.print(ch.parentIntVal1 + " ");
		System.out.print(ch.parentPublicVal2 + " ");
		System.out.print(ch.getParantPrivateVal3() + " ");
		System.out.print(ch.parenProtectedVal4 + "\n");
		
		System.out.println("===pa 메소드===");
		pa.defaultMethod();
//		pa.publicMethod();
		
		System.out.println("===ch 메소드===");
		ch.defaultMethod();
//		ch.publicMethod();]
		ch.childIntVal1 = 5000;
		
		System.out.println("================================");
		// 부모클래스 타입의 객체 생성 >> 생성자 매개변수가 4개
		
		Parent pa2 = new Parent( 11, 21, 31, 41 );
		System.out.print(pa2.parentIntVal1 + " ");
		System.out.print(pa2.parentPublicVal2 + " ");
		System.out.print(pa2.getParantPrivateVal3() + " ");
		System.out.print(pa2.parenProtectedVal4 + "\n");
		
		Child ch2 = new Child( 111, 211, 311, 411, 511);
		System.out.print(ch2.parentIntVal1 + " ");
		System.out.print(ch2.parentPublicVal2 + " ");
		System.out.print(ch2.getParantPrivateVal3() + " ");
		System.out.print(ch2.parenProtectedVal4 + " ");
		System.out.print(ch2.childIntVal1 + "\n");
	}

}
