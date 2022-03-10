package day002;

public class Day002_Operator3 {
	
	public static void main(String[] args) {

		// 대입 연산자
		// +=, -=, *=, /=, %=
		int num1 = 2;
		num1 = num1 + 5; // num1 = 2+5
		System.out.println(num1);
		
		int num2 = 2;
		num2 += 5;  // num2 = 2+5
		System.out.println(num2);
		
		int num3 = 2;
		num3 -= 3;  // num3 = 2-3
		System.out.println(num3);
		
		int num4 = 2;
		num4 *= 2;  // num4 = 2*2
		System.out.println(num4);
		
		int num5 = 2;
		num5 /= 2;  // num5 = 2/2
		System.out.println(num5);

		int num6 = 10;
		num6 %= 4;  // num6 = 10%4
		System.out.println(num6);
		
		System.out.println("===증감 연산자===");
		// 증감 연산자 ++, --
		int i = 1;
		System.out.println(i);
		i++; // i += 1; // i = i + 1;
		System.out.println(i);
		i--;
		System.out.println(i);
		
		System.out.println("======");
		int x = 10;
		int y = 5;
		int z;
		z = x++ + --y;
		/*
		y = y-1
		z = x+y
		X = x+1
		 */
		System.out.println(z);
		System.out.println(x);
		System.out.println(y);
		
	}

}
