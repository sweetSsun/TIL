package day007;

public class Day007_Array01 {

	public static void main(String[] args) {

		
		// 배열(Array)
		// 같은 타입의 데이터를 하나의 공간에 저장하는 구조
		
		// 타입[] 배열이름 or 타입 배열이름[]
		int[] NumArr1;
		
		// 배열을 선언하면서 데이터 저장
		int[] arr1 = {1,2,3};
		// arr1 >> | 1 | 2 | 3 |
		// index >   0   1   2
		
		// 배열이름[index]
		System.out.println(arr1[0]);
		System.out.println(arr1[1]);
		System.out.println(arr1[2]);
//		System.out.println(arr1[3]);
		
		
		System.out.println("===arr[0]===");
		// 배열을 선언하면서 배열의 크기(저장할 데이터의 갯수)만 지정
		int[] arr2 = new int[5];
		// arr2 >> |   |   |   |   |   |
		// index >   0   1   2   3   4
		System.out.println(arr2[0]);
		// arr2 [0]인덱스에 정수 10을 저장
		arr2[0] = 10;
		System.out.println(arr2[0]);
		// arr2[1] ~ arr2[4] >> 20, 30, 40, 50
		arr2[1] = 20;
		arr2[2] = 30;
		arr2[3] = 40;
		arr2[4] = 50;
		
		System.out.println("arr2[0] = " + arr2[0]);
		System.out.println("arr2[1] = " + arr2[1]);
		System.out.println("arr2[2] = " + arr2[2]);
		System.out.println("arr2[3] = " + arr2[3]);
		System.out.println("arr2[4] = " + arr2[4]);
		
		
		// String 타입의 배열을 선언, 배열의 크기는 3
		// 배열에 이름, 나이, 전화번호를 저장
		// 배열에 저장된 데이터를 출력
		String[] strArr = new String[3];
		strArr[0] = "김지선";
		strArr[1] = "32";
		strArr[2] = "010-4846-5904";
		System.out.println(strArr[0]);
		System.out.println(strArr[1]);
		System.out.println(strArr[2]);
		
		
		
//		System.out.println("===week===");
//		String[] week = new String[7];
//		week[0] = "일요일";
//		week[1] = "월요일";
//		week[2] = "화요일";
//		week[3] = "수요일";
//		week[4] = "목요일";
//		week[5] = "금요일";
//		week[6] = "토요일";
//		System.out.println(week.length);
//		System.out.println(week[3].length());
//		
//		week[6] = "공휴일";
//		System.out.println(week[6]);
	}

}
