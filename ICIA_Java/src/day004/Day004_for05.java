package day004;

public class Day004_for05 {

	public static void main(String[] args) {

		/*
		 * ===문제===
		 * 1~10까지의 숫자들 중 4의 배수를 제외한 숫자들의 합
		 */
		int sum = 0;
		System.out.println("===continue 사용===");
		for(int i=1; i<11; i++) {
			if(i % 4 == 0) {
				continue;
			}
			sum = sum + i;
		}
		System.out.println("1~10 중 4의 배수를 제외한 합 : " +sum);

		System.out.println("===if문만 사용===");
		sum = 0;
		for(int i=1; i<11; i++) {
			if(i%4 !=0) {
				sum=sum+i;
			}
		}
		System.out.println("1~10 중 4의 배수를 제외한 합 : " + sum);
		
		/*
		 * ===문제2===
		 * 1~20까지의 숫자들 중 3의 배수들의 합
		 */
		sum = 0;
		System.out.println("===continue 사용===");
		for(int i=1; i<21; i++) {
			if(i % 3 != 0) {
				continue;
			}
			sum = sum + i;
		}
		System.out.println("1~20 중 3의 배수들의 합 : " +sum);
		
		System.out.println("===if문만 사용===");
		sum = 0;
		for(int i=1; i<21; i++) {
			if(i % 3 == 0) {
				sum = sum + i;
			}
		}
		System.out.println("1~20 중 3의 배수들의 합 : " +sum);
	}

}
