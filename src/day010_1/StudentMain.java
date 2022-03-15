package day010_1;

public class StudentMain {

	public static void main(String[] args) {

		// Student 클래스의 객체
		// 학생의 이름, 나이, 전화번호를 저장
		
		// 1. (학생1) 기본생성자로 객체를 생성하고 이름, 나이, 전화번호를 저장
		// 2. (학생2) 이름을 매개변수로 하는 생성자로 객체를 생성하고 나이, 전화번호를 저장
		// 3. (학생3) 이름, 나이, 전화번호를 매개변수로 하는 생성자로 객체를 생성
		// 학생1, 학생2, 학생3의 정보를 출력
		
		Student stu1 = new Student();
		stu1.name = "김지선";
		stu1.age = 32;
		stu1.tel = "010-4846-5904";
		
		Student stu2 = new Student("최정훈");
		stu2.age = 31;
		stu2.tel = "010-4473-1122";
		
		Student stu3 = new Student("김도형", 30, "010-2115-5666");

		stu1.showInfo();
		stu2.showInfo();
		stu3.showInfo();
		
		System.out.println(stu1); // toString override
		
		// stuList : 3명 학생의 정보
		Student[] stuList = new Student[3];
		stuList[0] = stu1;
		stuList[1] = stu2;
		stuList[2] = stu3;
				
		// 전체 학생정보 중에 이름이 최정훈인 학생의 전화번호만 출력
		String searchName = "최정훈";
		System.out.println("찾을 이름 : " + searchName);
		for (int i = 0; i < stuList.length ; i++) {
			if (searchName.equals(stuList[i].name )) {
				System.out.println(stuList[i].tel);
			}
		}
		
		
		
		
		
	}

}
