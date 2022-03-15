package day010_1;

public class PhoneMain {

	public static void main(String[] args) {

		Phone ph1 = new Phone();
		
		int num;
//		System.out.println(num);
		// 변수는 선언만 해두면 만들 예정일 뿐 자리가 생기진 X
		num = 10;
		System.out.println(num);
		
		System.out.println("===ph1===");
		System.out.println(ph1.model);
		// 필드는 클래스에서 값을 넣지 않고 선언만 해두어도 자리가 만들어져있음.
		ph1.model = "갤럭시";
		ph1.price = 1000000;;
		ph1.company = "삼성";
		System.out.println(ph1.model);
		System.out.println(ph1.price);
		System.out.println(ph1.company);
		
		System.out.println("===ph2===");
		Phone ph2 = new Phone();
		System.out.println(ph2.model);
		System.out.println(ph2.price);
		System.out.println(ph2.company);
		
		
		
		Phone[] phoneList = new Phone[3];
		phoneList[0] = ph1;
		phoneList[1] = ph2;
	
		System.out.println(phoneList[0].model);
		System.out.println(phoneList[1].model);
	}

}
