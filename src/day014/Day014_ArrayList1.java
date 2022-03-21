package day014;

import java.util.ArrayList;

public class Day014_ArrayList1 {

	public static void main(String[] args) {
		// Array
		String[] names = new String[3];
//		names[0] = "A";
		names[1] = "B";
		names[2] = "C";
		//names[3] = "D";
		System.out.println("names.[0] = " + names[0]);
		System.out.println("names.length = " + names.length);
		
		
		// ArrayList
		System.out.println("===ArrayList===");
		ArrayList<String> nameList = new ArrayList<String>(3);
		nameList.add("A"); // 0 인덱스 "A" 저장
		nameList.add("B"); // 1 인덱스 "B" 저장
		nameList.add("C"); // 2 인덱스 "C" 저장
		System.out.println("3 nameList.size() = " + nameList.size());
		// | A | B | C |
		nameList.add(1, "D"); // 1 인덱스 "D"를 저장하고 기존 인덱스값을 옆으로 밀어냄
		// | A | D | B | C |
		System.out.println(nameList.get(0));
		System.out.println(nameList.get(1));
		System.out.println(nameList.get(2));
		System.out.println(nameList.get(3));
		
		// size() >> ArrayList에 저장된 데이터 수
		System.out.println("5 nameList.size() = " + nameList.size());
		
		// 데이터 삭제
		System.out.println("===ArrayList2===");
		ArrayList<String> nameList2 = new ArrayList<String>();
		nameList2.add("JAVA");
		nameList2.add("PYTHON");
		nameList2.add("ORACLE");
		nameList2.add("HTML");
		nameList2.add("HTML");
		System.out.println("nameList2.size() = " + nameList2.size());
		System.out.println(nameList2.get(0));
		System.out.println(nameList2.get(1));
		System.out.println(nameList2.get(2));
		System.out.println(nameList2.get(3));
		System.out.println(nameList2.get(4));
		
		nameList2.remove(2);
		System.out.println("nameList2.size() = " + nameList2.size());
		System.out.println(nameList2.get(0));
		System.out.println(nameList2.get(1));
		System.out.println(nameList2.get(2));
		System.out.println(nameList2.get(3));
//		System.out.println(nameList2.get(4));
		
		nameList2.remove("HTML");
		System.out.println("nameList2.size() = " + nameList2.size());
		System.out.println(nameList2.get(0));
		System.out.println(nameList2.get(1));
		System.out.println(nameList2.get(2));
//		System.out.println(nameList2.get(3));
		
	}
	
	
}
