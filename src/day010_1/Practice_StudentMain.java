package day010_1;

import java.util.Scanner;

public class Practice_StudentMain {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Student[] stuList = new Student[2];
		Student stu;
		for(int i = 0; i < stuList.length; i++) {
			stu = new Student();
//			System.out.print("이름 입력 >> ");
//			stuList[i].name = scan.next();
//			System.out.print("나이 입력 >> ");
//			stuList[i].age = scan.nextInt();
//			System.out.print("전화번호 입력 >> ");
//			stuList[i].tel = scan.next();
			System.out.print("이름 입력 >> ");
			String name = scan.next();
			System.out.print("나이 입력 >> ");
			int age = scan.nextInt();
			System.out.print("전화번호 입력 >> ");
			String tel = scan.next();
			stu.name = name;
			stu.age = age;
			stu.tel = tel;
			stuList[i] = stu;
		}
		
		for(int i = 0; i < stuList.length; i++) {
			System.out.println("\n" + (i+1) + "번 학생의 정보");
			System.out.print(stuList[i]);
		}
		
		
	}

}
