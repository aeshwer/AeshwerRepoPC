package ConceptOfStatic2;

public class Main {

	public static void main(String[] args) {
		
		Parent obj1 = new Child();
		obj1.hello();// overriding in case of non static method
		obj1.helloFromStaticMethod(); // no overriding
		
		System.out.println("-------------------------------------------------");
		
		Child obj2 = new Child();
		obj2.hello();
		obj2.helloFromStaticMethod();
				
	}
}
