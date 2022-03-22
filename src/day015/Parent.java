package day015;

public class Parent {

	int parentIntVal1;
	
	public int parentPublicVal2;
	
	private int parentPrivateVal3;
	
	protected int parenProtectedVal4;
	
	public Parent () {
		
	}
	
	public Parent (int parentIntVal1, int parentPublicVal2, int parentPrivateVal3, int parenProtectedVal4) {
		this.parentIntVal1 = parentIntVal1;
		this.parentPublicVal2 = parentPublicVal2;
		this.parentPrivateVal3 = parentPrivateVal3;
		this.parenProtectedVal4 = parenProtectedVal4;
	}
	
	void defaultMethod() {
		System.out.println("부모클래스에 정의된 defaultMethod() 호출");
		System.out.println("parentIntVal1 : " + parentIntVal1);
	}
	public void publicMethod() {
		System.out.println("부모클래스의 parantPublicVal2 : " + parentPublicVal2);
	}
	public int getParantPrivateVal3() {
		return parentPrivateVal3;
	}
	public void setParantPrivateVal3(int parantPrivateVal3) {
		this.parentPrivateVal3 = parantPrivateVal3;
	}
	
	
	
}
