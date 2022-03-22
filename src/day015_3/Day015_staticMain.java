package day015_3;

public class Day015_staticMain {

	public static void main(String[] args) {

		System.out.println(Day015_static.number1);
		
		Day015_static st1 = new Day015_static();
		st1.number2 = 100;
		st1.str1 = "A";
		st1.number1 = 222;
		System.out.println("st1.number2 : " + st1.number2);
		System.out.println("st1.str1 : " + st1.str1);
		System.out.println(st1.number1);
		
		Day015_static st2 = new Day015_static();
		st2.number2 = 200;
		st2.str1 = "B";
		System.out.println("st2.number2 : " + st2.number2);
		System.out.println("st2.str1 : " + st2.str1);
		System.out.println(st2.number1);
		
		Day015_static.number1 = 333;
		System.out.println(Day015_static.number1);
		System.out.println(st1.number1);
		System.out.println(st2.number1);
		
		
	}
	
	
	

}
