package day002;

public class Day002_Boolean {
	
	public static void main(String[] args) {
		
		int num1 = 10;
		int num2 = 20;
		
		// true, false
		boolean boolValue1 = true;
		boolean boolValue2 = false;
		System.out.println(boolValue1);
		System.out.println(boolValue2);
		
		boolean boolValue3 = 3>4;
		System.out.println(boolValue3);
		
		boolean boolValue4 = 10>4;
		System.out.println(boolValue4);
		
		boolean boolValue5 = num1 > num2;
		System.out.println(boolValue5);
		
		int money = 7000; // 현재 소지하고 있는 돈
		int price = 5000; // 음식 가격
		boolean result = money > price; // 현재 돈으로 음식을 사먹을 수 있는지 비교
		System.out.println(result);
		
		if(money > price) {
			System.out.println("사먹는다");
		} else {
			System.out.println("못먹는다");
		}
	}

}
