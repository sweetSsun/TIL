package day015_1;

public class ExtendsMain {

	public static void main(String[] args) {

		Student stu1 = new Student();
		// 기본 정보 저장
		stu1.name = "김지선";
		stu1.address = "인천";
		stu1.age = 32;
		stu1.strNum = 174097;
		stu1.major = "상속";
		
		Student stu2 = new Student("ICIA", "인천", 20, 1002, "자바");
		System.out.println("stu2 이름 : " + stu2.name);
		
		System.out.println("People 객체 생성");
		People pp1 = new People();
		pp1.name = "AA";
		pp1.address = "부천";
		pp1.age = 30;
		
		People pp2 = new People("BB", "서울", 25);
				
		
	}

}
