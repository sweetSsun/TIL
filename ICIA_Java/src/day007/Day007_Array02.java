package day007;

public class Day007_Array02 {

	public static void main(String[] args) {

		String[] myInfo = new String[3];
		myInfo[0] = "김지선";
		myInfo[1] = "32";
		myInfo[2] = "010-4846-5904";
		
		// 배열의 길이, 크기 확인
		System.out.println(myInfo.length);
		
		
//		for(int i=0; i<3; i++) {
//			System.out.println(myInfo[i]);
//		}
		for(int i=0; i<myInfo.length; i++) {
			System.out.println(myInfo[i]);
		}
		
		
//		크기가 5인 int 타입의 배열을 선언하고
//		1~5까지 숫자를 배열에 저장
//		배열에 저장된 값을 모두 출력
	
//		int num = 1;
		int[] numArr = new int[5];
		for(int i = 0; i<numArr.length; i++) {
			numArr[i] = i+1;
//			numArr[i] = num;
//			num++;
			System.out.println(numArr[i]);
		}
	
				
//		numArr 배열에 저장된 모든 값들의 총합 출력
		int sum = 0;
		for(int i = 0; i<numArr.length; i++) {
			sum = sum + numArr[i];
		}
		System.out.println(sum);
		System.out.println(sum/numArr.length); // 평균값
	}

}
