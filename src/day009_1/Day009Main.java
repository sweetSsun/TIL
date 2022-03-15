package day009_1;

public class Day009Main {

	public static void main(String[] args) {

		Day009 day = new Day009();
		day.printOne();
		day.plus(60, 26);
		day.plus2("Jisun", "Sleeping");
		day.plus3("Jisun", 32);
		
		int num1 = 10;
		int num2 = 3;
		int num3 = day.sub(num1, num2);
		System.out.println(num3);
		
	}

}
