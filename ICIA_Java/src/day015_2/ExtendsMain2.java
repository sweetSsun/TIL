package day015_2;

public class ExtendsMain2 {

	public static void main(String[] args) {

		People2 pp1 = new People2();
		People2 pp2 = new People2("AA", "구월동", 30, "3854-3205");
		
		Student2 stu1 = new Student2();
		Student2 stu2 = new Student2(1001, "자바");
		Student2 stu3 = new Student2("BB", "주안동", 25, "5233-2002", 1002, "오라클");
		
		System.out.println("pp2.showInfo() 호출");
		pp2.showInfo();
		System.out.println("\nstu3.showInfo() 호출");
		stu3.showInfo();
	}

}
