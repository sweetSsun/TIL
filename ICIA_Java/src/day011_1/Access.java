package day011_1;

public class Access {

	// 필드, 생성자, 메소드
	/*
	 * 접근제한자
	 * 
	 * 1. public
	 *   - 클래스, 필드, 생성자, 메소드
	 *   - 모든 패키지, 모든 클래스에서 접근 가능
	 * 
	 * 2. private
	 *   - 필드, 생성자, 메소드
	 *   - 다른 클래스에서는 접근이 불가능
	 * 
	 * 3. protected
	 *   - 필드, 생성자, 메소드
	 *   - 다른 패키지에 있는 클래스에서는 접근이 불가능
	 *   - 단, 자식클래스는 접근이 가능
	 * 
	 * 4. default
	 *   - 클래스, 필드, 생성자, 메소드
	 *   - 다른 패키지에 있는 클래스에서는 접근이 불가능
	 */
	
	public int publicVal1;	
	private int privateVal1;
	protected String protectedVal1;
	String defaultVal1; // default
	
	public void publicMethod1() {
		System.out.println("publicMethod1");
	}
	private void privateMethod1() {
		System.out.println("privateMethod1");
	}
	protected void protectedMethod1() {
		System.out.println("protectedMethod1");
	}
	void defaultMethod1() {
		System.out.println("defaultMethod1");
	}
	
	
}
