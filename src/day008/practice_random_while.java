package day008;

public class practice_random_while {

	public static void main(String[] args) {

		// 만들어진 랜덤숫자가 중복되지 않게 배열에 들어가도록 작성
		
		int[] numList = new int[10];
		
		for (int i = 0; i < numList.length; i++) {
			
			int randomNum = (int) (Math.random() * 10) + 1;
			
			int j = 0;
			boolean check = true;
			while(j < i) {
				if(randomNum==numList[j]) {
					check = false;
					break;
				} 
				j++;
			}
			
			if(check) {
				numList[i] =  randomNum;
			} else {
				i--;
			}
			
		}
		
		for (int i =0; i < numList.length; i++) {
			System.out.print(numList[i] + " ");
		}
		
	}

}
