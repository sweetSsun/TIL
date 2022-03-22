package day015_3;

public class IciaStudent {
	
	// static을 통해 class 메모리에 저장
	static String academy = "인천일보아카데미";
	
	// 자기 자신의 객체를 필드로 선언 - 싱글톤을 위함
	static IciaStudent icia = new IciaStudent(); 
	
	
	String name;
	String tel;
	
	final int number = 10;
	
	// 외부에서 생성자를 호출할 수 없도록 private으로 설정
	private IciaStudent() {
		
	}
	
	// 싱글톤 :: 클래스를 바탕으로 객체를 만들 때 딱 한 번만 만들어 짐.
	// 인스턴스를 무한대로 만들 수 없음
	// getInstance라는 이름으로 쓰기로 약속
	public static IciaStudent getInstance() {
		return icia;
	}
	

}
