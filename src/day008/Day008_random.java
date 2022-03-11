package day008;

public class Day008_random {

	public static void main(String[] args) {

		// 만들어진 랜덤숫자가 중복되지 않게 배열에 들어가도록 작성

		int[] numberList = new int[10];
		
		for(int i = 0; i < numberList.length; i++) {
			int randomNum = (int)(Math.random()*10 + 1);
				
			boolean check = true;
			for(int j = 0; j < numberList.length; j++) {
				if(randomNum == numberList[j]) {
					check = false;
				}
			} 					
				
			if(check) {
				numberList[i] = randomNum;
			} else {
				i--;
			}
		}
		
		for(int i = 0; i < numberList.length; i++) {
			System.out.print(numberList[i] + " ");
		}
		
	}

}
