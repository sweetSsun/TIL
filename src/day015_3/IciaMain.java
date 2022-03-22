package day015_3;

public class IciaMain {

	public static void main(String[] args) {

		IciaStudent stu1 = IciaStudent.getInstance();
		stu1.name = "A";
		stu1.tel = "010-";
		System.out.println(IciaStudent.academy);
		System.out.println(stu1.name);
		System.out.println(stu1.tel);
		
		IciaStudent stu2 = IciaStudent.getInstance();
		System.out.println(IciaStudent.academy);
		System.out.println(stu2.name);
		System.out.println(stu2.tel);
		System.out.println(stu2.number);
//		stu2.number = 20;
		
		final int num = 10;
//		num = 20;
		
	}

}
