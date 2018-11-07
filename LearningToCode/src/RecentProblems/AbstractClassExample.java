package RecentProblems;

public class AbstractClassExample {

	public static void main(String[] args) {
		AbstractClass obj = new NormalClass();
		obj.add(5,4);
		obj.add(5,4);
		obj.add(5, 4);
		//obj.methodOfNormalClass(); can't call with this reference
		
		NormalClass obj2 = new NormalClass();
		obj2.add(5,4);
		obj2.add(5,4);
		obj2.add(5, 4);
		obj2.methodOfNormalClass();  // call this now
		

		// AbstractClass obj3 = new AbstractClass(); // not possible to make a object of a abstract class
		
		
	}
}
