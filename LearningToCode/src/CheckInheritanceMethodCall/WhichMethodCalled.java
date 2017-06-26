package CheckInheritanceMethodCall;

public class WhichMethodCalled {

	public static void main(String[] args) {
		
		Actor act = new hero();
		act.dance();
		act.act();
		//act.fuck();  can't call this
		System.out.println();
		
		Actor act2 = new Actor();
		act2.dance();
		act2.act();
		//act2.fuck(); // still can't call
		System.out.println();
		
		hero act3 = new hero();
		act3.dance();
		act3.act();
		act3.fuck(); // can call now 
	}

}
