package ConceptOfStatic2;

public class Child extends Parent {

	@Override
	void hello() {
		System.out.println("Hello Child");
	}
	
	
	 static void helloFromStaticMethod() {
		System.out.println("Hello child static method");
	}

}
