package day008;

public class Day008_random {

	public static void main(String[] args) {

		int[] numberList = new int[10];
		
		for(int i = 0; i < numberList.length; i++) {
			int randomNum = (int)(Math.random()*10 + 1);
				
				// 만들어진 랜덤숫자가 numberList에 있는지 없는지 비교해보고 없으면 사용하는 코드 입력

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
