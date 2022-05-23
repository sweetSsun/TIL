package jdbcTest;

import java.util.Scanner;

public class PartTime_Pay {

	// 주휴수당 계산 메소드
	public static double holidayPay(double weekTime, int hourlyWage) {
		double holipay = weekTime * hourlyWage * 0.2;
		return holipay;
	}
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("====급여 계산 프로그램====");
		int hourlyWage = 9160; // 최저시급
		System.out.println("최저시급 : 9160원");
		System.out.print("시급을 입력하시겠습니까? >> 1.예 | 2.아니오 ");
		int selMenu = scan.nextInt();
		if(selMenu == 1) {
			hourlyWage = scan.nextInt(); // 입력할 경우 시급 변경
		}
		
		double totalTime = 0; // 총 근무시간
		double holipay = 0; // 총 주휴수당
		
		for (int i = 0; i < 5; i++) {
			double weekTime = 0;
			System.out.print( (i+1) + "주차 근무시간 입력 >> ");
			weekTime += scan.nextDouble();
			weekTime += scan.nextDouble();
			if (weekTime >= 15) { // 15시간 이상일 경우 주휴수당 메소드 실행
				double weekholipay = holidayPay(weekTime, hourlyWage);
				System.out.println((i+1) + "주차 주휴수당 발생 : " + weekholipay);
				holipay += weekholipay; // 주휴수당 누적
			}
			totalTime += weekTime; // 주 근무시간 누적
		}
		
		double totalPay = hourlyWage * totalTime + holipay; // 총 급여
		
		System.out.println("총 근무시간 : " + totalTime);
		System.out.println("주휴수당 : " + holipay);
		System.out.println("총 급여 : " + totalPay);
	}
}
