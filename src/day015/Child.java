package day015;

public class Child extends Parent{

	int childIntVal1;
	
	@Override
	void defaultMethod() {
		System.out.println("자식클래스에서 재정의된 defaultMethod() 호출");
		System.out.println("childIntVal1 : " + childIntVal1);
		super.defaultMethod();
	}

	@Override
	public void publicMethod() {
		System.out.println("자식클래스의 childIntVal1 : " + childIntVal1);
	}

	public Child() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Child(int parentIntVal1, int parentPublicVal2, int parentPrivateVal3, int parenProtectedVal4, int childIntVal1) {
		super(parentIntVal1, parentPublicVal2, parentPrivateVal3, parenProtectedVal4 );
		this.childIntVal1 = childIntVal1;
	}


	
	
	
	
}
