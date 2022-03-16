package day011_1;

public class StudentMain {

	public static void main(String[] args) {

		Student stu1 = new Student();
		
		// name 필드에 "김지선" 저장
		// setter
		String myName = "김지선";
		stu1.setName(myName);
		
		// name 필드의 값을 출력
		// getter
		String name = stu1.getName();
		System.out.println(name);
		
		// stu1 객체의 age 필드에 나이 저장
		int age = 32;
		stu1.setAge(age);
		// stu1 객체의 age 필드값 출력
		System.out.println(stu1.getAge());
		
		// stu1 객체의 tel 필드에 나이 저장
		stu1.setTel("010-1111-1111");
		System.out.println(stu1.getTel());
	}

}
