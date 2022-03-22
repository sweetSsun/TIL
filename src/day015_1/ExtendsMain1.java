package day015_1;

public class ExtendsMain1 {

	public static void main(String[] args) {

		Student1 stu1 = new Student1();
		// 기본 정보 저장
		stu1.name = "김지선";
		stu1.address = "인천";
		stu1.age = 32;
		stu1.stuNum = 174097;
		stu1.major = "상속";
		
		Student1 stu2 = new Student1("ICIA", "인천", 20, 1002, "자바");
		System.out.println("stu2 이름 : " + stu2.name);
		
		System.out.println("People 객체 생성");
		People1 pp1 = new People1();
		pp1.name = "AA";
		pp1.address = "부천";
		pp1.age = 30;
		
		People1 pp2 = new People1("BB", "서울", 25);
				
		Student1 stu3 = new Student1("인천일보", "인천", 22, "010-4844-3944", 1003, "오라클");
		
		
	}

}
